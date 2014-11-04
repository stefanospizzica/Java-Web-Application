package it.stefano.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Livedata
 */
@WebServlet("/Livedata")
public class Livedata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Livedata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log("doGET Livedata");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] rrdtoolreport = new String[6];
		response.setContentType("application/json");
	    PrintWriter out = response.getWriter();
	    
		try {		
			Runtime r =Runtime.getRuntime();
			String cmd = "sudo /usr/bin/rrdtool lastupdate /home/pi/powertemp.rrd";
			String resp;
			Process p = r.exec(cmd);
			p.waitFor();
			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			while ((resp = stdError.readLine()) != null) {
				rrdtoolreport[0] = resp; 
			}
			BufferedReader stdOut = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((resp = stdOut.readLine()) != null) {
				rrdtoolreport[1] = resp;
			}
			p.destroy();
			//
			// rrdtoolreport[1] contiene la stringa restituira dal comando rrdtool last update nel formato:
			// datetime: watt temp
			// Viene aggiunta l'ora attuale in fondo al report per poter calcolare l'eta dei dati
			//
			long unixcurrenttimestamp = System.currentTimeMillis()/1000;		
			rrdtoolreport[1] += (" " + Long.toString(unixcurrenttimestamp));
			
			formatCC128data(rrdtoolreport);
			
		} catch(Exception e) {
			rrdtoolreport[2]=e.toString();
		}
		
		Gson rrdtoolreportjson = new Gson();
		out.write(rrdtoolreportjson.toJson(rrdtoolreport));
	}
	
	private void formatCC128data(String report[]) {
		String fields[] = report[1].split(" ");
		String subfields0 = fields[0].substring(0, fields[0].length()-1);
		
		fields[0] = new java.util.Date((long)Long.parseLong(subfields0)*1000).toString();
		fields[1] = String.valueOf(Integer.parseInt(fields[1]));
		fields[2] = String.valueOf(Float.parseFloat(fields[2]));
		fields[3] = String.valueOf(Long.parseLong(fields[3]) - Long.parseLong(subfields0));
		report[1] = fields[0] + "-" + fields[1] + "-" + fields[2] + "-" + fields[3];
	}
}

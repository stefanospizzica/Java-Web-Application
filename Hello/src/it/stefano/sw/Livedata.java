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
		log("Chiamata doPost in Livedata");
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
				log(rrdtoolreport[0]);
			}
			BufferedReader stdOut = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((resp = stdOut.readLine()) != null) {
				rrdtoolreport[1] = resp;
				log(rrdtoolreport[1]);
			}
			p.destroy();
		} catch(Exception e) {
			rrdtoolreport[2]=e.toString();
			log(rrdtoolreport[2]);
		}
		
		rrdtoolreport[1] = "1414010470: 00330 24.2";

		Gson rrdtoolreportjson = new Gson();
		out.write(rrdtoolreportjson.toJson(rrdtoolreport));
	}

}

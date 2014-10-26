package it.stefano.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
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
		String sErr = null;
		String sOut = null;
		log("Chiamata doPost in Livedata");
		
		request.setAttribute("retval", "fanculo");
		
		/**
		try {		
			Runtime r =Runtime.getRuntime();
			String cmd = "sudo /home/pi/rrdtool lastupdate /home/pi/powertemp.rrd";
			Process p = r.exec(cmd);
			p.waitFor();
			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			while ((sErr = stdError.readLine()) != null) {
				request.setAttribute("retval", sErr);
				log(sErr);
			}
			BufferedReader stdOut = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((sOut = stdOut.readLine()) != null) {
				request.setAttribute("retval", sOut);
				log(sOut);
			}
			p.destroy();
		} catch(Exception e) {
			log(e.toString());
			request.setAttribute("retval", e.toString());
		}
		*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/livedata.jsp");
		dispatcher.forward(request, response);
	}

}

package it.stefano.sw;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemorizzaClima
 */
@WebServlet("/MemorizzaClima")
public class MemorizzaClima extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemorizzaClima() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;  
		PreparedStatement ps = null;
		int rsq;
		String temperatura= request.getParameter("temp");
		String umidita = request.getParameter("umidita");
		System.out.println(temperatura);
		System.out.println(umidita);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection ("jdbc:mysql://stesim.no-ip.org:3306/cronotermostato","stefano","spo1460simo");
			ps = con.prepareStatement("INSERT INTO daticlima (id, temperatura, umidita) VALUES (null, ?, ?)");
			ps.setFloat(1,Float.parseFloat(temperatura));
			ps.setFloat(2,Float.parseFloat(umidita));
						
			log("DOGET: Aggiorno dati climatici...");
			rsq = ps.executeUpdate();
			log("DOGET: Esito scrittura: " + rsq);
		}
		catch (SQLException e) {
				throw new ServletException("Servlet Could not update records.", e);
		  	} 
		catch (ClassNotFoundException e) {
			  throw new ServletException("JDBC Driver not found.", e);
		  } 
		finally {
			try {
			  if(ps!= null) {
				  ps.close();
				  ps= null;
			  }
			  if(con != null) {
				  con.close();
				  con = null;
			  }
			} 
			catch (SQLException e) {}
		}
	}
}

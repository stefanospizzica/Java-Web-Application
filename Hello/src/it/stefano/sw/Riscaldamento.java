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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Riscaldamento
 */
@WebServlet("/Riscaldamento")
public class Riscaldamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Temporizzazione Tlunedi =   			new Temporizzazione("", "", "", "", "", "", "", "");
	private Temporizzazione Tmartedi=   			new Temporizzazione("", "", "", "", "", "", "", "");
	private Temporizzazione Tmercoledi= 			new Temporizzazione("", "", "", "", "", "", "", "");
	private Temporizzazione Tgiovedi =  			new Temporizzazione("", "", "", "", "", "", "", "");
	private Temporizzazione Tvenerdi=   			new Temporizzazione("", "", "", "", "", "", "", "");
	private Temporizzazione Tsabato=    			new Temporizzazione("", "", "", "", "", "", "", "");
	private Temporizzazione Tdomenica=  			new Temporizzazione("", "", "", "", "", "", "", "");
	private String 			giorno = 				"LU";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Riscaldamento() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;  
		ResultSet rs = null;
		PreparedStatement ps = null;
		String statocronotermostato=null;
		float temperaturaminima=0f;
		float temperaturamassima=0f;
		float temperaturasicurezza=0f;
		float isteresi=0;
		String ultimamodifica=null;
		
		HttpSession session=request.getSession(true);
		
		String nome = (String) session.getAttribute("CURRENT_LOGGED_USER");
		if (nome == null) {
			response.sendRedirect("/admin/login.jsp");
		}
			
		log("DOGET START: Setto gli attributi di inizializzazione interrogando il database");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection ("jdbc:mysql://stesim.no-ip.org:3306/cronotermostato","stefano","spo1460simo");
			ps = con.prepareStatement("SELECT * FROM Cronotermo WHERE Giorno=?");
			ps.setString(1,giorno);			
			rs = ps.executeQuery();
			while(rs.next()){
				statocronotermostato 	= rs.getString("Stato");
				temperaturaminima 		= Float.parseFloat(rs.getString("Tmin")); 
				temperaturamassima 		= Float.parseFloat(rs.getString("Tmax"));		
				temperaturasicurezza 	= Float.parseFloat(rs.getString("Tsafe"));		
				isteresi 				= Float.parseFloat(rs.getString("Hyst"));
				ultimamodifica			= rs.getString("Variazione");
				if("LU".equals(giorno)){
					Tlunedi.SetStart1(rs.getString("Start1"));
					Tlunedi.SetEnd1(rs.getString("End1"));
					Tlunedi.SetStart2(rs.getString("Start2"));
					Tlunedi.SetEnd2(rs.getString("End2"));
					Tlunedi.SetStart3(rs.getString("Start3"));
					Tlunedi.SetEnd3(rs.getString("End3"));
					Tlunedi.SetStart4(rs.getString("Start4"));
					Tlunedi.SetEnd4(rs.getString("End4"));
				} else if("MA".equals(giorno)){
					Tmartedi.SetStart1(rs.getString("Start1"));
					Tmartedi.SetEnd1(rs.getString("End1"));
					Tmartedi.SetStart2(rs.getString("Start2"));
					Tmartedi.SetEnd2(rs.getString("End2"));
					Tmartedi.SetStart3(rs.getString("Start3"));
					Tmartedi.SetEnd3(rs.getString("End3"));
					Tmartedi.SetStart4(rs.getString("Start4"));
					Tmartedi.SetEnd4(rs.getString("End4"));
				} else if("ME".equals(giorno)){
					Tmercoledi.SetStart1(rs.getString("Start1"));
					Tmercoledi.SetEnd1(rs.getString("End1"));
					Tmercoledi.SetStart2(rs.getString("Start2"));
					Tmercoledi.SetEnd2(rs.getString("End2"));
					Tmercoledi.SetStart3(rs.getString("Start3"));
					Tmercoledi.SetEnd3(rs.getString("End3"));
					Tmercoledi.SetStart4(rs.getString("Start4"));
					Tmercoledi.SetEnd4(rs.getString("End4"));
				} else if("GI".equals(giorno)){
					Tgiovedi.SetStart1(rs.getString("Start1"));
					Tgiovedi.SetEnd1(rs.getString("End1"));
					Tgiovedi.SetStart2(rs.getString("Start2"));
					Tgiovedi.SetEnd2(rs.getString("End2"));
					Tgiovedi.SetStart3(rs.getString("Start3"));
					Tgiovedi.SetEnd3(rs.getString("End3"));
					Tgiovedi.SetStart4(rs.getString("Start4"));
					Tgiovedi.SetEnd4(rs.getString("End4"));
				} else if("VE".equals(giorno)){
					Tvenerdi.SetStart1(rs.getString("Start1"));
					Tvenerdi.SetEnd1(rs.getString("End1"));
					Tvenerdi.SetStart2(rs.getString("Start2"));
					Tvenerdi.SetEnd2(rs.getString("End2"));
					Tvenerdi.SetStart3(rs.getString("Start3"));
					Tvenerdi.SetEnd3(rs.getString("End3"));
					Tvenerdi.SetStart4(rs.getString("Start4"));
					Tvenerdi.SetEnd4(rs.getString("End4"));
				} else if("SA".equals(giorno)){
					Tsabato.SetStart1(rs.getString("Start1"));
					Tsabato.SetEnd1(rs.getString("End1"));
					Tsabato.SetStart2(rs.getString("Start2"));
					Tsabato.SetEnd2(rs.getString("End2"));
					Tsabato.SetStart3(rs.getString("Start3"));
					Tsabato.SetEnd3(rs.getString("End3"));
					Tsabato.SetStart4(rs.getString("Start4"));
					Tsabato.SetEnd4(rs.getString("End4"));
				} else if("DO".equals(giorno)){
					Tdomenica.SetStart1(rs.getString("Start1"));
					Tdomenica.SetEnd1(rs.getString("End1"));
					Tdomenica.SetStart2(rs.getString("Start2"));
					Tdomenica.SetEnd2(rs.getString("End2"));
					Tdomenica.SetStart3(rs.getString("Start3"));
					Tdomenica.SetEnd3(rs.getString("End3"));
					Tdomenica.SetStart4(rs.getString("Start4"));
					Tdomenica.SetEnd4(rs.getString("End4"));
				} 
			}
		}
		catch (SQLException e) {
				throw new ServletException("Servlet Could not display records.", e);
		  	} 
		catch (ClassNotFoundException e) {
			  throw new ServletException("JDBC Driver not found.", e);
		  } 
		finally {
			try {
			  if(rs != null) {
				  rs.close();
				  rs = null;
			  }
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

		session.setAttribute("TEMPERATURA_MINIMA", temperaturaminima);
		session.setAttribute("TEMPERATURA_MASSIMA", temperaturamassima);		
		session.setAttribute("TEMPERATURA_SICUREZZA", temperaturasicurezza);		
		session.setAttribute("ISTERESI", isteresi);
		session.setAttribute("STATOCRONOTERMOSTATO", statocronotermostato);
		session.setAttribute("ULTIMAMODIFICA", ultimamodifica);
		
		if(null == session.getAttribute("GIORNO")){
			session.setAttribute("GIORNO", giorno);
		}
		if(null == session.getAttribute("ORARI")){
			session.setAttribute("ORARI", Tlunedi);
		}
		
		log("DOGET END: Invoco la pagina riscaldamento.jsp per il giorno " + giorno);
		request.getRequestDispatcher("/admin/riscaldamento.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;  
		ResultSet rs = null;
		int	rsq = 0;
		PreparedStatement ps = null;
		String statocronotermostato;
		float temperaturaminima=0f;
		float temperaturamassima=0f;
		float temperaturasicurezza=0f;
		float isteresi=0;

		HttpSession session=request.getSession(true);
		
		String azione = (String) request.getParameter("azione");
		log("DOPOST START: Hai postato "+azione);
		
		if("cambiogiorno".equals(azione)) {
			giorno = (String) request.getParameter("dayselected");	
			log("Giorno: " + giorno);
			if("LU".equals(giorno)){
				session.setAttribute("GIORNO", "LU");
				session.setAttribute("ORARI", Tlunedi);		
			} else if("MA".equals(giorno)){
				session.setAttribute("GIORNO", "MA");
				session.setAttribute("ORARI", Tmartedi);		
			} else if("ME".equals(giorno)){
				session.setAttribute("GIORNO", "ME");
				session.setAttribute("ORARI", Tmercoledi);		
			} else if("GI".equals(giorno)){
				session.setAttribute("GIORNO", "GI");
				session.setAttribute("ORARI", Tgiovedi);		
			} else if("VE".equals(giorno)){
				session.setAttribute("GIORNO", "VE");
				session.setAttribute("ORARI", Tvenerdi);		
			} else if("SA".equals(giorno)){
				session.setAttribute("GIORNO", "SA");
				session.setAttribute("ORARI", Tsabato);		
			} else if("DO".equals(giorno)){
				session.setAttribute("GIORNO", "DO");
				session.setAttribute("ORARI", Tdomenica);		
			} 
			
			log("DOPOST END: ReInvoco la pagina riscaldamento.jsp");
			request.getRequestDispatcher("/admin/riscaldamento.jsp").forward(request, response);
		}
				
		if("conferma".equals(azione)) {
			statocronotermostato = (String) request.getParameter("ct");
			temperaturamassima = Float.parseFloat(request.getParameter("ht"));
			temperaturaminima = Float.parseFloat(request.getParameter("lt"));
			temperaturasicurezza = Float.parseFloat(request.getParameter("st"));
			isteresi=Float.parseFloat(request.getParameter("hyt"));
			giorno = (String) request.getParameter("g");
			if("LU".equals(giorno)){
				Tlunedi.SetStart1((String)request.getParameter("t1on"));
				Tlunedi.SetStart2((String)request.getParameter("t2on"));
				Tlunedi.SetStart3((String)request.getParameter("t3on"));
				Tlunedi.SetStart4((String)request.getParameter("t4on"));
				Tlunedi.SetEnd1  ((String)request.getParameter("t1off"));
				Tlunedi.SetEnd2  ((String)request.getParameter("t2off"));
				Tlunedi.SetEnd3  ((String)request.getParameter("t3off"));
				Tlunedi.SetEnd4  ((String)request.getParameter("t4off"));				
			} else if("MA".equals(giorno)){
				Tmartedi.SetStart1((String)request.getParameter("t1on"));
				Tmartedi.SetStart2((String)request.getParameter("t2on"));
				Tmartedi.SetStart3((String)request.getParameter("t3on"));
				Tmartedi.SetStart4((String)request.getParameter("t4on"));
				Tmartedi.SetEnd1  ((String)request.getParameter("t1off"));
				Tmartedi.SetEnd2  ((String)request.getParameter("t2off"));
				Tmartedi.SetEnd3  ((String)request.getParameter("t3off"));
				Tmartedi.SetEnd4  ((String)request.getParameter("t4off"));				
			} else if("ME".equals(giorno)){
				Tmercoledi.SetStart1((String)request.getParameter("t1on"));
				Tmercoledi.SetStart2((String)request.getParameter("t2on"));
				Tmercoledi.SetStart3((String)request.getParameter("t3on"));
				Tmercoledi.SetStart4((String)request.getParameter("t4on"));
				Tmercoledi.SetEnd1  ((String)request.getParameter("t1off"));
				Tmercoledi.SetEnd2  ((String)request.getParameter("t2off"));
				Tmercoledi.SetEnd3  ((String)request.getParameter("t3off"));
				Tmercoledi.SetEnd4  ((String)request.getParameter("t4off"));				
			} else if("GI".equals(giorno)){
				Tgiovedi.SetStart1((String)request.getParameter("t1on"));
				Tgiovedi.SetStart2((String)request.getParameter("t2on"));
				Tgiovedi.SetStart3((String)request.getParameter("t3on"));
				Tgiovedi.SetStart4((String)request.getParameter("t4on"));
				Tgiovedi.SetEnd1  ((String)request.getParameter("t1off"));
				Tgiovedi.SetEnd2  ((String)request.getParameter("t2off"));
				Tgiovedi.SetEnd3  ((String)request.getParameter("t3off"));
				Tgiovedi.SetEnd4  ((String)request.getParameter("t4off"));				
			} else if("VE".equals(giorno)){
				Tvenerdi.SetStart1((String)request.getParameter("t1on"));
				Tvenerdi.SetStart2((String)request.getParameter("t2on"));
				Tvenerdi.SetStart3((String)request.getParameter("t3on"));
				Tvenerdi.SetStart4((String)request.getParameter("t4on"));
				Tvenerdi.SetEnd1  ((String)request.getParameter("t1off"));
				Tvenerdi.SetEnd2  ((String)request.getParameter("t2off"));
				Tvenerdi.SetEnd3  ((String)request.getParameter("t3off"));
				Tvenerdi.SetEnd4  ((String)request.getParameter("t4off"));				
			} else if("SA".equals(giorno)){
				Tsabato.SetStart1((String)request.getParameter("t1on"));
				Tsabato.SetStart2((String)request.getParameter("t2on"));
				Tsabato.SetStart3((String)request.getParameter("t3on"));
				Tsabato.SetStart4((String)request.getParameter("t4on"));
				Tsabato.SetEnd1  ((String)request.getParameter("t1off"));
				Tsabato.SetEnd2  ((String)request.getParameter("t2off"));
				Tsabato.SetEnd3  ((String)request.getParameter("t3off"));
				Tsabato.SetEnd4  ((String)request.getParameter("t4off"));				
			} else if("DO".equals(giorno)){
				Tdomenica.SetStart1((String)request.getParameter("t1on"));
				Tdomenica.SetStart2((String)request.getParameter("t2on"));
				Tdomenica.SetStart3((String)request.getParameter("t3on"));
				Tdomenica.SetStart4((String)request.getParameter("t4on"));
				Tdomenica.SetEnd1  ((String)request.getParameter("t1off"));
				Tdomenica.SetEnd2  ((String)request.getParameter("t2off"));
				Tdomenica.SetEnd3  ((String)request.getParameter("t3off"));
				Tdomenica.SetEnd4  ((String)request.getParameter("t4off"));				
			} 
			
			log("DOPOST: Stato cronotermostato: "+statocronotermostato);
			log("DOPOST: Temperatura massima: "+temperaturamassima);
			log("DOPOST: Temperatura minima: "+temperaturaminima);
			log("DOPOST: Temperatura sicurezza: "+temperaturasicurezza);
			log("DOPOST: Temperatura isteresi: "+ isteresi);
			log("DOPOST: Giorno selezionato: "+ giorno);

			try {
				Class.forName("com.mysql.jdbc.Driver");
				con =DriverManager.getConnection ("jdbc:mysql://stesim.no-ip.org:3306/cronotermostato","stefano","spo1460simo");
				ps = con.prepareStatement("UPDATE Cronotermo SET Stato=?,Tmin=?,Tmax=?,Tsafe=?,Hyst=?,Start1=?,End1=?,Start2=?,End2=?,Start3=?,End3=?,Start4=?,End4=? WHERE	Giorno=?");
				ps.setString(1,statocronotermostato);
				ps.setFloat(2,temperaturaminima);
				ps.setFloat(3,temperaturamassima);
				ps.setFloat(4,temperaturasicurezza);
				ps.setFloat(5,isteresi);
				ps.setString(6, request.getParameter("t1on"));
				ps.setString(7, request.getParameter("t1off"));
				ps.setString(8, request.getParameter("t2on"));
				ps.setString(9, request.getParameter("t2off"));
				ps.setString(10, request.getParameter("t3on"));
				ps.setString(11, request.getParameter("t3off"));
				ps.setString(12, request.getParameter("t4on"));
				ps.setString(13, request.getParameter("t4off"));
				ps.setString(14, giorno);
				
				log("DOPOST: Scrittura su database...");
				rsq = ps.executeUpdate();
				log("DOPOST END: Esito scrittura: " + rsq);
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
			log("DOPOST END: ReInvoco la pagina riscaldamento.jsp");
			request.getRequestDispatcher("/admin/riscaldamento.jsp").forward(request, response);
		}
	}

}

package it.stefano.sw;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("fld_username");
		String password = request.getParameter("fld_password");

		HttpSession session=request.getSession(true);			
		session.setAttribute("CURRENT_LOGGED_USER", null);

		if ("pippo".equals(username) && "pluto".equals(password)) {

			session.setAttribute("CURRENT_LOGGED_USER", username.toUpperCase());
			RequestDispatcher rd = request.getRequestDispatcher("/admin/principale.jsp");
			rd.forward(request, response);
			return;
		}

		RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");
		String error = "Attenzione username o password non validi!";
		session.setAttribute("LOGIN_ERROR", error);
		session.setAttribute("CURR_USER_NAME", username);
		rd.include(request, response);
	}

}

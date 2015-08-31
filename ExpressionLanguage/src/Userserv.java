

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Userserv")
public class Userserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Userserv() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = "Victoria";
		String lastName = "Lee";
		String email = "vlee93@gmail.com";
		String streetaddress = "36 Woodbine Rd";
		String city = "Florham Park";
		String state = "New Jersey";
		String ZIP = "07932";
		Address address = new Address(streetaddress, city, state, ZIP);
		User user = new User(firstName, lastName, email, address);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Hello.jsp");
		dispatcher.forward(request, response);
		
	}

}

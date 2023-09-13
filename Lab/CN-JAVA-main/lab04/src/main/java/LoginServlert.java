

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class LoginServlert
 */
public class LoginServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public HashMap<String, String> userHashMap = new HashMap<String, String>();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlert() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
		userHashMap.put("admin","162534");
		userHashMap.put("user","615243");
		userHashMap.put("user1","user1");
		userHashMap.put("user2","user2");
		userHashMap.put("user3","user3");
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter printWriter = response.getWriter();
		if(userHashMap.get(username).equals(password)) {
			printWriter.print("Name / Password match");
		} else {
			printWriter.print("Name / Password does not match");
		}
	}

}

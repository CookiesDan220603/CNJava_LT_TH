

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Servlet implementation class ImageServlet1
 */
public class ImageServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		FileInputStream fin = new FileInputStream(getServletContext().getRealPath("/images/img1.jpg"));
		BufferedInputStream bin = new BufferedInputStream(fin);  
		BufferedOutputStream bout = new BufferedOutputStream(out);
		int ch = 0;
		while((ch = bin.read()) != -1) {
			bout.write(ch);
		}
		
		bin.close();
		fin.close();
		bout.close();
		out.close();
	}

}

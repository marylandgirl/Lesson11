

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Course;
import model.DbCourse;

/**
 * Servlet implementation class ShowCourse
 */
@WebServlet("/ShowCourse")
public class ShowCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int courseId = Integer.parseInt(request.getParameter("id"));
		
		Course course = DbCourse.getCourse(courseId);
		request.setAttribute("course", course);
		request.getRequestDispatcher("/show.jsp").forward(request, response);
	}

}

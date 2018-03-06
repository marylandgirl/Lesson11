

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import model.DbCourse;

/**
 * Servlet implementation class ListCourse
 */
@WebServlet("/ListCourses")
public class ListCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		/*ArrayList<Course> courses = (ArrayList<Course>) DbCourse.getAllCourses();*/
		System.out.println("Diplaying all courses");
		ArrayList<Course> courses = new ArrayList<Course>();
		Course newCourse = new Course();
		newCourse.setCredit(3);
		newCourse.setInstructor("Mr. Smith");
		newCourse.setTitle("Programming");
		courses.add(newCourse);
		request.setAttribute("courses", courses);
		request.getRequestDispatcher("/list.jsp").forward(request, response);
	}

}



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Course;
import model.DbCourse;

/**
 * Servlet implementation class SaveCourse
 */
@WebServlet("/SaveCourse")
public class SaveCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCourse() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = 0;
		if ( request.getParameter("id") != null && !request.getParameter("id").isEmpty()){
			id = Integer.parseInt(request.getParameter("id"));
		}
		
		String title = request.getParameter("title");
		String instructor = request.getParameter("instructor");
		Integer credit = Integer.parseInt(request.getParameter("credit"));
		
		Course course;
		//based on the id, either update or insert
		if ( id==0){
			course = new Course();
			course.setTitle(title);
			course.setInstructor(instructor);
			course.setCredit(credit);
			DbCourse.insert(course);
		}else{
			course=DbCourse.getCourse(id);
			course.setTitle(title);
			course.setInstructor(instructor);
			course.setCredit(credit);
			DbCourse.update(course);
		}
		
		request.setAttribute("course", course);
		request.getRequestDispatcher("/show.jsp").forward(request, response);
	}

}

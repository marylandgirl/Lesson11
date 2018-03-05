package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Course;


public class DbCourse {
	
	public static Course getCourse(long courseId) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		Course course = em.find(Course.class, courseId);
		return course;
	}
	
	public static List<Course> getAllCourses(){
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String qString = "select c from Course c";
		
		ArrayList<Course> courses = new ArrayList<Course>();
		try {
			Query query = em.createQuery(qString);
			List<Course> results = query.getResultList();
			//courses = (ArrayList<Course> results;
			for (Course item: results){
				courses.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			em.close();
		}
		return courses;
	}
	
	public static void insert(Course course){
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(course);
			trans.commit();
		} catch (Exception e){
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static void update(Course course){
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(course);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static void delete(Course course){
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(course));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
}

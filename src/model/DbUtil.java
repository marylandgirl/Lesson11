package model;

//import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class DbUtil {


private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("unofficialGuides");
	
	public static EntityManagerFactory getEmFactory(){
		return factory;
	}
}

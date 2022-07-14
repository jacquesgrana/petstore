package fr.diginamic.javaFS2022.tpPetStore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_petstore");
    	EntityManager em = emf.createEntityManager();
    	System.out.println("connection ok : " + em);
    	
    	em.getTransaction().begin();
    	
    	em.getTransaction().commit();
    	
    	em.close();
    	emf.close();
    }
}

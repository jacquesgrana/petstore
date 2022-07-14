package fr.diginamic.javaFS2022.tpPetStore;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.javaFS2022.tpPetStore.bo.Adress;
import fr.diginamic.javaFS2022.tpPetStore.bo.Animal;
import fr.diginamic.javaFS2022.tpPetStore.bo.Cat;
import fr.diginamic.javaFS2022.tpPetStore.bo.Fish;
import fr.diginamic.javaFS2022.tpPetStore.bo.FishLivEnv;
import fr.diginamic.javaFS2022.tpPetStore.bo.PetStore;
import fr.diginamic.javaFS2022.tpPetStore.bo.ProdType;
import fr.diginamic.javaFS2022.tpPetStore.bo.Product;

/**
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_petstore");
    	EntityManager em = emf.createEntityManager();
    	System.out.println("connection ok : " + em);
    	
    	em.getTransaction().begin();
    	
    	Fish fish1 = new Fish(LocalDate.of(2022, 03, 12), "red", FishLivEnv.FRESH_WATER);
    	Fish fish2 = new Fish(LocalDate.of(2022, 05, 27), "yellow", FishLivEnv.FRESH_WATER);
    	Fish fish3 = new Fish(LocalDate.of(2022, 02, 03), "white", FishLivEnv.SEA_WATER);
    	
    	em.persist(fish1);
    	em.persist(fish2);
    	em.persist(fish3);
    	
    	Cat cat1 = new Cat(LocalDate.of(2021, 06, 18), "orange", "bad cat");
    	Cat cat2 = new Cat(LocalDate.of(2020, 12, 29), "white", "good cat");
    	Cat cat3 = new Cat(LocalDate.of(2022, 02, 11), "black and white", "average cat");
    	
    	em.persist(cat1);
    	em.persist(cat2);
    	em.persist(cat3);
    	
    	Adress adress1 = new Adress("122", "elm street", "NJ452", "Springfield");
    	Adress adress2 = new Adress("1", "wall street", "NY842", "New York");
    	Adress adress3 = new Adress("7458", "hollywood bvd", "CA471", "Los Angeles");
    	
    	em.persist(adress1);
    	em.persist(adress2);
    	em.persist(adress3);
    	
    	Product product1 = new Product("K54002", "Fish Brush", ProdType.ACCESSORY, 530d);
    	Product product2 = new Product("F44771", "Cat Food", ProdType.FOOD, 15.25d);
    	Product product3 = new Product("P55328", "Cat Hammer", ProdType.ACCESSORY, 225d);
    	
    	em.persist(product1);
    	em.persist(product2);
    	em.persist(product3);
    	
    	PetStore petStore1 = new PetStore("Good Hope Center", "H. Simpson", adress1);
    	PetStore petStore2 = new PetStore("Tesla Kitten and Fish Shelter", "E. Musk", adress3);
    	PetStore petStore3 = new PetStore("America First Animal Fundation", "D. Trump Jr.", adress2);
    	
    	petStore1.getAnimals().add(fish1);
    	petStore1.getAnimals().add(fish2);
    	
    	petStore2.getAnimals().add(fish3);
    	petStore2.getAnimals().add(cat1);
    	
    	petStore3.getAnimals().add(cat2);
    	petStore3.getAnimals().add(cat3);
    	
    	petStore1.getProducts().add(product1);
    	petStore1.getProducts().add(product2);
    	petStore1.getProducts().add(product3);
    	
    	petStore2.getProducts().add(product1);
    	petStore2.getProducts().add(product2);
    	
    	petStore3.getProducts().add(product2);
    	petStore3.getProducts().add(product3);
    	
    	em.persist(petStore1);
    	em.persist(petStore2);
    	em.persist(petStore3);
    	
    	em.getTransaction().commit();
    	
    	PetStore petStoreToTest = em.find(PetStore.class, 15L);
    	
    	System.out.println("PetStore : " + petStoreToTest.toString());
    	
    	for(Animal animal : petStoreToTest.getAnimals()) {
    		System.out.println(animal.toString());
    	}
    	
    	em.close();
    	emf.close();
    }
}

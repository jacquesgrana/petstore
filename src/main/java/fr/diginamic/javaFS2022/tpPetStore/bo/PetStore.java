package fr.diginamic.javaFS2022.tpPetStore.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class PetStore {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String managerName;
	
	@OneToOne
	private Adress adress;
	
	@OneToMany(mappedBy = "petStore", cascade = CascadeType.PERSIST)
	private Set<Animal> animals = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name="Have",
	joinColumns= @JoinColumn(name="id_petStore", referencedColumnName="id"),
	inverseJoinColumns= @JoinColumn(name="id_product", referencedColumnName="id"))
	private Set<Product> products = new HashSet<>();

	public PetStore() {}

	/**
	 * @param name
	 * @param managerName
	 */
	public PetStore(String name, String managerName) {
		this.name = name;
		this.managerName = managerName;
	}
	
	/**
	 * @param name
	 * @param managerName
	 * @param adress
	 */
	public PetStore(String name, String managerName, Adress adress) {
		super();
		this.name = name;
		this.managerName = managerName;
		this.adress = adress;
	}
	
	public void addAnimal (Animal animal) {
		animal.addPetStore(this);
	}
	
	public void addProduct (Product product) {
		product.addPetStore(this);
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the managerName
	 */
	public String getManagerName() {
		return managerName;
	}

	/**
	 * @param managerName the managerName to set
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	/**
	 * @return the adress
	 */
	public Adress getAdress() {
		return adress;
	}

	/**
	 * @param adress the adress to set
	 */
	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	/**
	 * @return the animals
	 */
	public Set<Animal> getAnimals() {
		return animals;
	}

	/**
	 * @param animals the animals to set
	 */
	public void setAnimals(Set<Animal> animals) {
		this.animals = animals;
	}

	/**
	 * @return the products
	 */
	public Set<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PetStore [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", managerName=");
		builder.append(managerName);
		builder.append(", adress=");
		builder.append(adress);
		builder.append("]");
		return builder.toString();
	}

}

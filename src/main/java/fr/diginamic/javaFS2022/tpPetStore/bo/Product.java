package fr.diginamic.javaFS2022.tpPetStore.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String code;
	
	@Column
	private String label;
	
	@Enumerated(EnumType.ORDINAL)
	private ProdType type;
	
	@Column
	private Double price;
	
	@ManyToMany(mappedBy="products")
	private Set<PetStore> petStores = new HashSet<>();
	
	public Product() {}

	/**
	 * @param code
	 * @param label
	 * @param type
	 * @param price
	 */
	public Product(String code, String label, ProdType type, Double price) {
		super();
		this.code = code;
		this.label = label;
		this.type = type;
		this.price = price;
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the type
	 */
	public ProdType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ProdType type) {
		this.type = type;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the petStores
	 */
	public Set<PetStore> getPetStores() {
		return petStores;
	}

	/**
	 * @param petStores the petStores to set
	 */
	public void setPetStores(Set<PetStore> petStores) {
		this.petStores = petStores;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append(", label=");
		builder.append(label);
		builder.append(", type=");
		builder.append(type);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}

}

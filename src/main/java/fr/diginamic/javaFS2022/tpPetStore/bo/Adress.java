package fr.diginamic.javaFS2022.tpPetStore.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Adress {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String number;
	
	@Column
	private String street;
	
	@Column
	private String zipCode;
	
	@Column
	private String city;
	
	@OneToOne
	private PetStore petStore;

	public Adress() {}

	/**
	 * @param number
	 * @param street
	 * @param zipCode
	 * @param city
	 */
	public Adress(String number, String street, String zipCode, String city) {
		super();
		this.number = number;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
	}
	
	

	/**
	 * @param number
	 * @param street
	 * @param zipCode
	 * @param city
	 * @param petStore
	 */
	public Adress(String number, String street, String zipCode, String city, PetStore petStore) {
		super();
		this.number = number;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
		this.petStore = petStore;
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
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the petStore
	 */
	public PetStore getPetStore() {
		return petStore;
	}

	/**
	 * @param petStore the petStore to set
	 */
	public void setPetStore(PetStore petStore) {
		this.petStore = petStore;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Adress [id=");
		builder.append(id);
		builder.append(", number=");
		builder.append(number);
		builder.append(", street=");
		builder.append(street);
		builder.append(", zipCode=");
		builder.append(zipCode);
		builder.append(", city=");
		builder.append(city);
		builder.append("]");
		return builder.toString();
	}

}

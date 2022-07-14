package fr.diginamic.javaFS2022.tpPetStore.bo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private LocalDate birth;
	
	@Column(nullable = false)
	private String color;
	
	@ManyToOne
	private PetStore petStore;
	
	public Animal() {}

	/**
	 * @param id
	 * @param birth
	 * @param color
	 */
	public Animal(LocalDate birth, String color) {
		super();
		this.birth = birth;
		this.color = color;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the birth
	 */
	public LocalDate getBirth() {
		return this.birth;
	}

	/**
	 * @param birth the birth to set
	 */
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
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
		builder.append("Animal [id=");
		builder.append(id);
		builder.append(", birth=");
		builder.append(birth);
		builder.append(", color=");
		builder.append(color);
		builder.append(", petStore=");
		builder.append(petStore);
		builder.append("]");
		return builder.toString();
	}

}

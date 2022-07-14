package fr.diginamic.javaFS2022.tpPetStore.bo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cat extends Animal {
	
	@Column
	private String chipId;

	public Cat() {
		super();
	}

	/**
	 * @param chipId
	 */
	public Cat(LocalDate birth, String color, String chipId) {
		super(birth, color);
		this.chipId = chipId;
	}

	/**
	 * @return the chipId
	 */
	public String getChipId() {
		return this.chipId;
	}

	/**
	 * @param chipId the chipId to set
	 */
	public void setChipId(String chipId) {
		this.chipId = chipId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(" / Cat [chipId=");
		builder.append(this.chipId);
		builder.append("]");
		return builder.toString();
	}
	
	

}

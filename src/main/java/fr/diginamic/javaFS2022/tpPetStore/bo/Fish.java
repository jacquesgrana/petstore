package fr.diginamic.javaFS2022.tpPetStore.bo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Fish extends Animal {
	
	@Enumerated(EnumType.STRING)
	private FishLivEnv livingEnv;

	public Fish() {}

	public Fish(LocalDate birth, String color, FishLivEnv livingEnv) {
		super(birth, color);
		this.livingEnv = livingEnv;
	}

	/**
	 * @return the livingEnv
	 */
	public FishLivEnv getLivingEnv() {
		return this.livingEnv;
	}

	/**
	 * @param livingEnv the livingEnv to set
	 */
	public void setLivingEnv(FishLivEnv livingEnv) {
		this.livingEnv = livingEnv;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(" / Fish [livingEnv=");
		builder.append(this.livingEnv);
		builder.append("]");
		return builder.toString();
	}
	
	

}

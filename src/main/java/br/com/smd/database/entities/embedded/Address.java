package br.com.smd.database.entities.embedded;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Address {

	private String publicPlace;
	
	private String complement;
	
	private Integer number;
}

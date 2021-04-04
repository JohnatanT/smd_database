package br.com.smd.database.entities.embedded;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Contact {

	private String number;
	
	private String ddd;
}

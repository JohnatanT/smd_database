package br.com.smd.database.dtos.outputs;

import javax.persistence.Embedded;

import br.com.smd.database.entities.embedded.Contact;
import lombok.Data;

@Data
public class ManagerOutputDTO {

	private Long id;
	
	private String name;
	
	private String cpf;
	
	@Embedded
	private Contact contact;
	
	private AgencyOutputDTO agency;
}

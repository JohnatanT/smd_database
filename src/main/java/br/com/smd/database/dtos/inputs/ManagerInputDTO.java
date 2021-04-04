package br.com.smd.database.dtos.inputs;

import javax.persistence.Embedded;

import br.com.smd.database.entities.embedded.Contact;
import lombok.Data;

@Data
public class ManagerInputDTO {
	
	private String name;
	
	private String cpf;
	
	@Embedded
	private Contact contact;
	
	private Long agencyId;
}

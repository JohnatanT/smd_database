package br.com.smd.database.dtos.inputs;

import javax.persistence.Embedded;

import br.com.smd.database.entities.embedded.Address;
import lombok.Data;

@Data
public class BankInputDTO {

	private String name;
	
	private String cnpj;
	
	@Embedded
	private Address address;
}

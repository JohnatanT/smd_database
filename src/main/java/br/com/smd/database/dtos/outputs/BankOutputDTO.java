package br.com.smd.database.dtos.outputs;

import javax.persistence.Embedded;

import br.com.smd.database.entities.embedded.Address;
import lombok.Data;

@Data
public class BankOutputDTO {

	private Long id;
	
	private String name;
	
	private String cnpj;
	
	@Embedded
	private Address address;
}

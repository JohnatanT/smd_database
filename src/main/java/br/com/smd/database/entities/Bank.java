package br.com.smd.database.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.com.smd.database.entities.embedded.Address;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class Bank {

	@Id
	@Getter
	@GeneratedValue(generator = "bank_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "bank_seq", sequenceName = "bank_seq", allocationSize=1)
	private Long id;
	
	private String name;
	
	private String cnpj;
	
	@Embedded
	private Address address;
}

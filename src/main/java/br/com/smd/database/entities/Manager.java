package br.com.smd.database.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.com.smd.database.entities.embedded.Contact;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class Manager {

	@Id
	@Getter
	@GeneratedValue(generator = "manager_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "manager_seq", sequenceName = "manager_seq", allocationSize=1)
	private Long id;
	
	private String name;
	
	private String cpf;
	
	@Embedded
	private Contact contact;
	
	@ManyToOne
	private Agency agency;
}

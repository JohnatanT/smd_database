package br.com.smd.database.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class Agency {

	@Id
	@Getter
	@GeneratedValue(generator = "agency_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "agency_seq", sequenceName = "agency_seq", allocationSize=1)
	private Long id;
	
	private String name;
	
	private String number;
	
	@ManyToOne
	private Bank bank;
}

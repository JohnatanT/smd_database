package br.com.smd.database.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
public class Account {

	@Id
	@Getter
	@GeneratedValue(generator = "account_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "account_seq", sequenceName = "account_seq", allocationSize=1)
	private Long id;
	
	private String number;
	
	private BigDecimal amount;
	
	private LocalDateTime createdAt;
	
	@ManyToOne
	private Client client;
}

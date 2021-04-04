package br.com.smd.database.dtos.outputs;

import lombok.Data;

@Data
public class AgencyOutputDTO {

	private Long id;
	
	private String name;
	
	private String number;
	
	private BankOutputDTO bank;
}

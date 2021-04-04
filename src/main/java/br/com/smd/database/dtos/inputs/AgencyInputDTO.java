package br.com.smd.database.dtos.inputs;

import lombok.Data;

@Data
public class AgencyInputDTO {
	
	private String name;
	
	private String number;
	
	private Long bankId;
}

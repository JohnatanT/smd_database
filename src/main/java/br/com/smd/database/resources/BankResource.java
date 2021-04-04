package br.com.smd.database.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.smd.database.dtos.inputs.BankInputDTO;
import br.com.smd.database.dtos.outputs.BankOutputDTO;
import br.com.smd.database.services.BankService;

@RestController
@RequestMapping(value = "banks")
public class BankResource {
	
	@Autowired
	private BankService bankService;

	@PostMapping
	@ResponseBody
	public ResponseEntity<BankOutputDTO> create(@RequestBody BankInputDTO bankInputDTO) {
		BankOutputDTO bank = bankService.create(bankInputDTO);
		
		return new ResponseEntity<BankOutputDTO>(bank, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "{cnpj}")
	@ResponseBody
	public ResponseEntity<BankOutputDTO> getBankByCnpj(@PathVariable(name = "cnpj") String cnpj) {
		BankOutputDTO bank = bankService.getBankByCnpj(cnpj);
		
		if (bank != null)
			return new ResponseEntity<BankOutputDTO>(bank, HttpStatus.OK);
		
		return new ResponseEntity<BankOutputDTO>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "{id}")
	@ResponseBody
	public ResponseEntity<BankOutputDTO> getBankById(@PathVariable(name = "id") Long id) {
		BankOutputDTO bank = bankService.getBankById(id);
		
		if (bank != null)
			return new ResponseEntity<BankOutputDTO>(bank, HttpStatus.OK);
		
		return new ResponseEntity<BankOutputDTO>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<BankOutputDTO> updateBank(@PathVariable(name = "id") Long id, @RequestBody BankInputDTO bankInputDTO) throws Exception {
		BankOutputDTO bank = bankService.update(id, bankInputDTO);
		
		return new ResponseEntity<BankOutputDTO>(bank, HttpStatus.OK);
	}
}

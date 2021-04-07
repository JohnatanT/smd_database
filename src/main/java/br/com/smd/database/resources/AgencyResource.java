package br.com.smd.database.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.smd.database.dtos.inputs.AgencyInputDTO;
import br.com.smd.database.dtos.outputs.AgencyOutputDTO;
import br.com.smd.database.services.AgencyService;

@RestController
@RequestMapping(value = "agencies")
public class AgencyResource {

	@Autowired
	private AgencyService agencyService;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<AgencyOutputDTO> create(@RequestBody AgencyInputDTO agencyInput) throws Exception {
		AgencyOutputDTO agency = agencyService.create(agencyInput);
		
		return new ResponseEntity<AgencyOutputDTO>(agency, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "number/{number}")
	@ResponseBody
	public ResponseEntity<AgencyOutputDTO> getBankByCnpj(@PathVariable(name = "number") String number) {
		AgencyOutputDTO agency = agencyService.getAgencyByNumber(number);
		
		if (agency != null)
			return new ResponseEntity<AgencyOutputDTO>(agency, HttpStatus.OK);
		
		return new ResponseEntity<AgencyOutputDTO>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "id/{id}")
	@ResponseBody
	public ResponseEntity<AgencyOutputDTO> getBankByCnpj(@PathVariable(name = "id") Long id) {
		AgencyOutputDTO agency = agencyService.getAgencyById(id);
		
		if (agency != null)
			return new ResponseEntity<AgencyOutputDTO>(agency, HttpStatus.OK);
		
		return new ResponseEntity<AgencyOutputDTO>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "{id}")
	@ResponseBody
	public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) throws Exception {
		agencyService.deleteById(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value = "{id}")
	@ResponseBody
	public ResponseEntity<AgencyOutputDTO> update(@PathVariable(name = "id") Long id, @RequestBody AgencyInputDTO agencyInput) throws Exception {
		AgencyOutputDTO agency = agencyService.update(id, agencyInput);
		
		return new ResponseEntity<AgencyOutputDTO>(agency, HttpStatus.OK);
	}
}

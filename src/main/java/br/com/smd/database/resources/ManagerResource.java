package br.com.smd.database.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.smd.database.dtos.inputs.ManagerInputDTO;
import br.com.smd.database.dtos.outputs.ManagerOutputDTO;
import br.com.smd.database.services.ManagerService;

@RestController
@RequestMapping(value = "managers")
public class ManagerResource {
	
	@Autowired
	private ManagerService managerService;

	@PostMapping
	@ResponseBody
	public ResponseEntity<ManagerOutputDTO> create(@RequestBody ManagerInputDTO  managerInput) throws Exception {
		ManagerOutputDTO manager = managerService.create(managerInput);
		
		return new ResponseEntity<ManagerOutputDTO>(manager, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "id/{id}")
	@ResponseBody
	public ResponseEntity<ManagerOutputDTO> getBankByCnpj(@PathVariable(name = "id") Long id) {
		ManagerOutputDTO manager = managerService.getManagerById(id);
		
		if (manager != null)
			return new ResponseEntity<ManagerOutputDTO>(manager, HttpStatus.OK);
		
		return new ResponseEntity<ManagerOutputDTO>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "{id}")
	@ResponseBody
	public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) throws Exception {
		managerService.deleteById(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}

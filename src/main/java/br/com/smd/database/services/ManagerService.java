package br.com.smd.database.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.smd.database.dtos.inputs.ManagerInputDTO;
import br.com.smd.database.dtos.outputs.ManagerOutputDTO;
import br.com.smd.database.entities.Agency;
import br.com.smd.database.entities.Manager;
import br.com.smd.database.repositories.ManagerRepository;

@Service
public class ManagerService {

	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	private AgencyService agencyService;
	
	public ManagerOutputDTO create(ManagerInputDTO  managerInput) throws Exception {
		Manager entity = new Manager();
		Optional<Agency> agency = agencyService.findAgencyById(managerInput.getAgencyId());
		if (agency.isEmpty())
			throw new Exception("Agency not found withc id: " + managerInput.getAgencyId());
		
		BeanUtils.copyProperties(managerInput, entity);
		entity.setAgency(agency.get());
		Manager manager = managerRepository.save(entity);
		ManagerOutputDTO managerOutputDTO = new ManagerOutputDTO();
		BeanUtils.copyProperties(manager, managerOutputDTO);
		
		return managerOutputDTO;
	}
	
	public ManagerOutputDTO getManagerById(Long id) {
		Optional<Manager> manager = managerRepository.findById(id);
		if (manager.isEmpty())
			return null;
		
		ManagerOutputDTO managerOutputDTO = new ManagerOutputDTO();
		BeanUtils.copyProperties(manager, managerOutputDTO);
		
		return managerOutputDTO;
	}
	public void deleteById(Long id) throws Exception {
		Optional<Manager> manager = managerRepository.findById(id);
		if (manager.isEmpty())
			throw new Exception("Manager not found withc id: " + id);
		
		managerRepository.delete(manager.get());
	}
}

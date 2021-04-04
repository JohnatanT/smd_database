package br.com.smd.database.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.smd.database.dtos.inputs.AgencyInputDTO;
import br.com.smd.database.dtos.outputs.AgencyOutputDTO;
import br.com.smd.database.dtos.outputs.BankOutputDTO;
import br.com.smd.database.entities.Agency;
import br.com.smd.database.entities.Bank;
import br.com.smd.database.repositories.AgencyRepository;

@Service
public class AgencyService {

	@Autowired
	private AgencyRepository agencyRepository;
	
	@Autowired
	private BankService bankService;
	
	public AgencyOutputDTO create(AgencyInputDTO agencyInput) throws Exception {
		Agency entity = new Agency();
		BeanUtils.copyProperties(agencyInput, entity);
		
		Optional<Bank> bank = bankService.findBankById(agencyInput.getBankId());
		if (bank.isEmpty())
			throw new Exception("Bank not found with id: " + agencyInput.getBankId());
		
		entity.setBank(bank.get());
		Agency agency = agencyRepository.save(entity);
		AgencyOutputDTO agencyOutput = new AgencyOutputDTO();
		BankOutputDTO bankOutputDTO = new BankOutputDTO();
		
		BeanUtils.copyProperties(agency, agencyOutput);
		BeanUtils.copyProperties(bank.get(), bankOutputDTO);
		agencyOutput.setBank(bankOutputDTO);
		
		return agencyOutput;
	}
	
	public AgencyOutputDTO getAgencyByNumber(String number) {
		Agency agency = agencyRepository.findByNumber(number);
		if (agency == null)
			return null;
		
		AgencyOutputDTO agencyOutput = new AgencyOutputDTO();
		BankOutputDTO bankOutputDTO = new BankOutputDTO();
		BeanUtils.copyProperties(agency, agencyOutput);
		BeanUtils.copyProperties(agency.getBank(), bankOutputDTO);
		agencyOutput.setBank(bankOutputDTO);
		
		return agencyOutput;
	}
	
	public AgencyOutputDTO getAgencyById(Long id) {
		Optional<Agency> agency = agencyRepository.findById(id);
		if (agency.isEmpty())
			return null;
		
		AgencyOutputDTO agencyOutput = new AgencyOutputDTO();
		BankOutputDTO bankOutputDTO = new BankOutputDTO();
		BeanUtils.copyProperties(agency.get(), agencyOutput);
		BeanUtils.copyProperties(agency.get().getBank(), bankOutputDTO);
		agencyOutput.setBank(bankOutputDTO);
		
		return agencyOutput;
	}
	
	public void deleteById(Long id) throws Exception {
		Optional<Agency> agency = agencyRepository.findById(id);
		if (agency.isEmpty())
			throw new Exception("Agency not found with id: " + id);
		
		agencyRepository.delete(agency.get());
	}
	
	public AgencyOutputDTO update(Long id, AgencyInputDTO agencyInput) throws Exception {
		Optional<Agency> agency = agencyRepository.findById(id);
		if (agency.isEmpty())
			throw new Exception("Agency not found with id: " + id);
		
		BeanUtils.copyProperties(agencyInput, agency.get());
		Agency entity = agencyRepository.save(agency.get());
		
		AgencyOutputDTO agencyOutput = new AgencyOutputDTO();
		BeanUtils.copyProperties(entity, agencyOutput);
		
		return agencyOutput;
	}
	
	public Optional<Agency> findAgencyById(Long id) {
		return agencyRepository.findById(id);
	}
}

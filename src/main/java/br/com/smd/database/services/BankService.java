package br.com.smd.database.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.smd.database.dtos.inputs.BankInputDTO;
import br.com.smd.database.dtos.outputs.BankOutputDTO;
import br.com.smd.database.entities.Bank;
import br.com.smd.database.repositories.BankRepository;

@Service
public class BankService {

	@Autowired
	private BankRepository bankRepository;
	
	public BankOutputDTO create(BankInputDTO bankInput) {
		Bank entity = new Bank();
		BeanUtils.copyProperties(bankInput, entity);
		
		Bank bank = bankRepository.save(entity);
		BankOutputDTO bankOutput = new BankOutputDTO();
		
		BeanUtils.copyProperties(bank, bankOutput);
		
		return bankOutput;
	}
	
	public BankOutputDTO getBankByCnpj(String cnpj) {
		Bank bank = bankRepository.findByCnpj(cnpj);
		if (bank == null)
			return null;
		
		BankOutputDTO bankOutput = new BankOutputDTO();
		BeanUtils.copyProperties(bank, bankOutput);
		
		return bankOutput;
	}
	
	public BankOutputDTO getBankById(Long id) {
		Optional<Bank> bank = bankRepository.findById(id);
		if (bank.isEmpty())
			return null;
		
		BankOutputDTO bankOutput = new BankOutputDTO();
		BeanUtils.copyProperties(bank.get(), bankOutput);
		
		return bankOutput;
	}
	
	public Optional<Bank> findBankById(Long id) {
		return bankRepository.findById(id);
	}
	
	public BankOutputDTO update(Long id, BankInputDTO bankInputDTO) throws Exception {
		Optional<Bank> entity = bankRepository.findById(id);
		
		if (entity.isEmpty())
			throw new Exception("Bank not found with id: " + id);
		
		BeanUtils.copyProperties(bankInputDTO, entity.get());
		
		Bank bank = bankRepository.save(entity.get());
		
		BankOutputDTO bankOutput = new BankOutputDTO();
		BeanUtils.copyProperties(bank, bankOutput);
		
		return bankOutput;
	}
}

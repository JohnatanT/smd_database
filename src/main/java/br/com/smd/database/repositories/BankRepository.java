package br.com.smd.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.smd.database.entities.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

	Bank findByCnpj(String cnpj);
}

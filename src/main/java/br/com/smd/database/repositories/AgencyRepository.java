package br.com.smd.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.smd.database.entities.Agency;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {

	Agency findByNumber(String number);
}

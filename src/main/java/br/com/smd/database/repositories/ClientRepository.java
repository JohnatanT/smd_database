package br.com.smd.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.smd.database.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}

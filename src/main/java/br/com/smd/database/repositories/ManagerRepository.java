package br.com.smd.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.smd.database.entities.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

}

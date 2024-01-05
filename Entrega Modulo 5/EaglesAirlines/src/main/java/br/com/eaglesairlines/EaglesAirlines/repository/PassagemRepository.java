package br.com.eaglesairlines.EaglesAirlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eaglesairlines.EaglesAirlines.model.Passagem;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Long> { 

}

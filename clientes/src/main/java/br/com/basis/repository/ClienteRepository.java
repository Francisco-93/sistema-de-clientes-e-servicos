package br.com.basis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.basis.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}

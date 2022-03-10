package br.com.mergulhoAPI.mergulho.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mergulhoAPI.mergulho.domain.model.Cliente;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	List<Cliente> findByNome(String nome);
	List<Cliente> findByNomeContaining(String string);
	Optional<Cliente> findByEmail(String email);
}

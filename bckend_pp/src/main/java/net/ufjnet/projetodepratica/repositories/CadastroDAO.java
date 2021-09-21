package net.ufjnet.projetodepratica.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ufjnet.projetodepratica.models.Cadastro;

public interface CadastroDAO extends JpaRepository<Cadastro, Integer>{
	public Optional<Cadastro> findByNome(String nome);
	public Optional<Cadastro> findByEmail(String email);
}

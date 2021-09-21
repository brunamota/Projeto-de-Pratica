package net.ufjnet.projetodepratica.services;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import net.ufjnet.projetodepratica.dtos.CadastroDTO;
import net.ufjnet.projetodepratica.exceptions.BusinessException;
import net.ufjnet.projetodepratica.models.Cadastro;
import net.ufjnet.projetodepratica.repositories.CadastroDAO;

@AllArgsConstructor
@Service
public class GestaoCadastro {
	
	private CadastroDAO cadastroDAO;
	
	@Transactional(readOnly = true)
	public Page<CadastroDTO> findAll(Pageable pageable){
		Page<Cadastro> result = cadastroDAO.findAll(pageable);
		return result.map(obj-> new CadastroDTO(obj));
	}
	
	@Transactional(readOnly = true)
	public CadastroDTO findById(Integer id) {
		Cadastro result = cadastroDAO.findById(id).
				orElseThrow(()-> new BusinessException("ID não encontrado"));
		
		return  new CadastroDTO(result);
		
	}
	
	@Transactional(readOnly = true)
	public CadastroDTO findByNome(String nome) {
		Cadastro result = cadastroDAO.findByNome(nome).
				orElseThrow(()-> new BusinessException("Nome não encontrado"));
		
		return  new CadastroDTO(result);
		
	}
	
	@Transactional(readOnly = true)
	public CadastroDTO findByEmail(String email) {
		Cadastro result = cadastroDAO.findByEmail(email).
				orElseThrow(()-> new BusinessException("E-mail não encontrado"));
		
		return  new CadastroDTO(result);
	}
	
	@Transactional
	public CadastroDTO save(@Valid CadastroDTO obj) {
		Cadastro entityCadastro = new Cadastro(obj.getId(), obj.getNome(),obj.getEmail());
		
		
		boolean emailExists = cadastroDAO.findByEmail(entityCadastro.getEmail())
				.stream()
				.anyMatch(objResult -> !objResult.equals(entityCadastro));
		
		if(emailExists) {
			throw new BusinessException("Email já cadastrado!");
		}
		
		return new CadastroDTO(cadastroDAO.save(entityCadastro));
	}
	
	@Transactional
	public void deleteById(Integer id) {
		cadastroDAO.deleteById(id);
	}
	
	public boolean existById(Integer id) {
		return cadastroDAO.existsById(id);
	}
	
}

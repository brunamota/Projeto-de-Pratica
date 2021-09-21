package net.ufjnet.projetodepratica.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.ufjnet.projetodepratica.dtos.CadastroDTO;
import net.ufjnet.projetodepratica.services.GestaoCadastro;

@RestController
@RequestMapping("v1/pp/cadastros")
public class CadastroController {
	
	@Autowired
	private GestaoCadastro service;
	
	@GetMapping
	public ResponseEntity<CollectionModel<CadastroDTO>> buscarTodos(
			@RequestParam(value ="page", defaultValue ="0") int page,
			@RequestParam(value ="limit", defaultValue ="12") int limit,
			@RequestParam(value ="direction", defaultValue ="asc") String direction){
		
		Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection,"nome"));
		
		Page<CadastroDTO> pages = service.findAll(pageable);		
		
		pages.stream()
			 .forEach(c->c.add(
					 linkTo(methodOn(CadastroController.class).buscarUm(c.getId())).withSelfRel()
					 )
			);
		return ResponseEntity.ok(CollectionModel.of(pages));
	}
		@GetMapping("/{id}")
		public ResponseEntity<CadastroDTO>buscarUm(@PathVariable Integer id){
			CadastroDTO objDTO = service.findById(id);
			objDTO.add(linkTo(methodOn(CadastroController.class).buscarUm(id)).withSelfRel());
			
			return ResponseEntity.ok(objDTO);
		}
		
		@GetMapping("/nome/{nome}")
		public ResponseEntity<CadastroDTO>buscarNome(@PathVariable String nome){
			CadastroDTO objDTO = service.findByNome(nome);
			objDTO.add(linkTo(methodOn(CadastroController.class).buscarNome(nome)).withSelfRel());
			
			return ResponseEntity.ok(objDTO);
			
		}
		
				
	@GetMapping("/email/{email}")
	public ResponseEntity<CadastroDTO>buscarEmail(@PathVariable String email){
		CadastroDTO objDTO = service.findByEmail(email);
		objDTO.add(linkTo(methodOn(CadastroController.class).buscarEmail(email)).withSelfRel());
		
		return ResponseEntity.ok(objDTO);
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<CadastroDTO> incluir(@RequestBody @Valid CadastroDTO objBody){
		CadastroDTO objDTO = service.save(objBody);
		objDTO.add(linkTo(methodOn(CadastroController.class).buscarUm(objDTO.getId())).withSelfRel());
		
		return ResponseEntity.ok(objDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		if (!service.existById(id)) {
			return ResponseEntity.notFound().build();
		}

		service.deleteById(id);

		return ResponseEntity.noContent().build();

	}
	

}

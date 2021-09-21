package net.ufjnet.projetodepratica.dtos;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ufjnet.projetodepratica.models.Cadastro;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@JsonPropertyOrder({"codigo_cadastro","nome_cadastro","email_cadastro"})	
public class CadastroDTO extends RepresentationModel<CadastroDTO> implements Serializable{
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@JsonProperty("codigo_cadastro")
	private Integer id;
	
	@Size(max=60)
	@NotBlank
	@JsonProperty("nome_cadastro")
	private String nome;
	
	@Email
	@NotBlank
	@JsonProperty("email_cadastro")
	private String email;
	
	public CadastroDTO(Cadastro obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
	}
}

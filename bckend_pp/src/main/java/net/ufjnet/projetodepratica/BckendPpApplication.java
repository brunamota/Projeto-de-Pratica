package net.ufjnet.projetodepratica;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import net.ufjnet.projetodepratica.models.Cadastro;
import net.ufjnet.projetodepratica.repositories.CadastroDAO;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class BckendPpApplication implements CommandLineRunner{
	
	@Autowired
	private CadastroDAO cadastroDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(BckendPpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	Cadastro cadastro01 = new Cadastro(1, "Bruna", "bruna@projetodepratica");	
	Cadastro cadastro02 = new Cadastro(2, "Gabriela", "gabriela@projetodepratica");	
	Cadastro cadastro03 = new Cadastro(3, "Pedro", "pedro@projetodepratica");	
		
	cadastroDAO.saveAll(Arrays.asList(cadastro01,cadastro02, cadastro03));
	
	}

}

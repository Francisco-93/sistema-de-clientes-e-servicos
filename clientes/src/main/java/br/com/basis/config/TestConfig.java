package br.com.basis.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.basis.model.Cliente;
import br.com.basis.repository.ClienteRepository;

@Configuration
@Profile(value = "dev")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Cliente c1 = new Cliente(null, "Francisco", "037.148.491-06", LocalDate.now());
		Cliente c2 = new Cliente(null, "Miriã", "037.148.491-06", null);
		clienteRepository.save(c1);
		clienteRepository.save(c2);
	}

}

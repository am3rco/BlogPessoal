package com.generation.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.blogpessoal.model.Usuario;

// Indica que é uma classe de teste
// "environment" configura automaticamente a porta que não seja a mesma da aplicação
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeAll
	void start() {

		// Deleta os usuarios da memoria
		usuarioRepository.deleteAll();

		// Cria novos usuarios para o teste
		usuarioRepository.save(
				new Usuario(0L, "João da Silva", "joao@email.com.br", "12345678", "https://i.imgur.com/FETvs20.jpg"));

		usuarioRepository.save(new Usuario(0L, "Ednaldo Pereira da Silva", "deus@email.com.br", "12345678",
				"https://i.imgur.com/NtyGneo.jpg"));

		usuarioRepository.save(new Usuario(0L, "Manuela Oliveira da Silva", "manuela@email.com.br", "12345678",
				"https://i.imgur.com/mB3VM2N.jpg"));

		usuarioRepository.save(new Usuario(0L, "Manuel Gomes", "canetaazul@email.com.br", "12345678",
				"https://i.imgur.com/JR7kUFU.jpg"));

	}

	@Test // O metodo vai executar um teste
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {

		Optional<Usuario> usuario = usuarioRepository.findByUsuario("joao@email.com.br");
		// O metodo assertTrue() procura o valor passado no .equals, caso for igual o teste será concluido. Caso contrário, vai falhar
		assertTrue(usuario.get().getUsuario().equals("joao@email.com.br")); 
																			

	}

	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {

		// Recebe o resultado do metodo findAllByNome...
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");

		// Verifica se o tamanho da lista corresponde com a quantidade de nomes que tem "Silva"
		assertEquals(3, listaDeUsuarios.size());

		// Verica se os usuários da lista foram cadastrados nessa sequencia
		assertTrue(listaDeUsuarios.get(0).getNome().equals("João da Silva"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Ednaldo Pereira da Silva"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Manuela Oliveira da Silva"));
	}

	@AfterAll
	public void end() {

		// Deleta os usuarios da memoria após o teste
		usuarioRepository.deleteAll();
	}

}

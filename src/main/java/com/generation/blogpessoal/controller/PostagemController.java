package com.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;

@RestController // Define que a classe é do tipo RestController e receberá requisições 
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*") // Permite o recebimento de requisições realizadas fora do dominio
public class PostagemController {

	@Autowired // Injeção de Dependência, aplicando a Inversão de Controle
	private PostagemRepository postagemRepository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll(){
		return ResponseEntity.ok(postagemRepository.findAll());
	}
	
}

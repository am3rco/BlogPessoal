package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity // Cria uma Entidade, para transformar a classe numa tabela
@Table(name = "tb_postagens") // Cria uma tabela chamada tb_postagens
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // O valor da ID será auto_incrementada
	private Long id;
	
	@NotBlank(message = "O atributo título é Obrigatório!") // Titulo = " " - Não aceita; Titulo = vazio - Não aceita
	@Size(min = 3, max = 100) // Determina o minimo e o maximo de caracteres(armazenamento)
	private String titulo;
	
	@NotBlank(message = "O atributo texto é Obrigatório!") // Titulo = " " - Não aceita; Titulo = vazio - Não aceita
	@Size(min = 10, max = 1000) // Determina o minimo e o maximo de caracteres(armazenamento)
	private String texto;
	
	@UpdateTimestamp // Cria uma variavel que atualiza o horário
	private LocalDateTime data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	
	
	
}

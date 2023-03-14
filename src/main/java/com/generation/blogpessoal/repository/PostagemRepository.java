package com.generation.blogpessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogpessoal.model.Postagem;

@Repository // Indica que ela é responsável pela interação com o Banco de Dados atráves dos Métodos Padrão
public interface PostagemRepository extends JpaRepository<Postagem, Long>{

}

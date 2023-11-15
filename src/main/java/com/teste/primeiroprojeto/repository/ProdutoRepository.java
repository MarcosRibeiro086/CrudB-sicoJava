package com.teste.primeiroprojeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.primeiroprojeto.model.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

//uma interface que herda de outra interface genérica do jpa, recebe dois parâmetros, o model e o tipo do Id desse objeto
}

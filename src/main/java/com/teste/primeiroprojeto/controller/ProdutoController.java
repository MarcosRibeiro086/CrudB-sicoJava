package com.teste.primeiroprojeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.primeiroprojeto.model.Produto;
import com.teste.primeiroprojeto.services.ProdutoService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController//informa ao spring que é um controller
@RequestMapping("/api/produtos")//rota da url

public class ProdutoController {
    
    
    @Autowired //tomar controle do repositorio
    private ProdutoService produtoService;


    @GetMapping//quando alguem fizer um get chame o método obter todos
    public List<Produto> obtertodos(){
        return produtoService.obterTodos();
    }
    @GetMapping("/{id}")
    public Optional<Produto> obterPorid(@PathVariable Integer id)/* pega o parâmetro e tenta transformar em inteiro */{
        return produtoService.obterPorId(id);
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){
        return produtoService.adicionar(produto);
    }
    
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
        produtoService.deletar(id);
        return "produto com id " + id+" foi deletado com sucesso!";
    }
    @PutMapping("/{id}")
    public Produto atualizar(@RequestBody Produto produto, @PathVariable Integer id){
        return produtoService.atualizar(id, produto);
    }
    
}

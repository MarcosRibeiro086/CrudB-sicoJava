package com.teste.primeiroprojeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiroprojeto.model.Produto;
import com.teste.primeiroprojeto.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    /**
     * metodo para retornar uma lista de produtos
     * @return lista de produtos
     */
    public List<Produto> obterTodos(){
        //colocar regra de negócio caso tenha uma
        return produtoRepository.obterTodos();
    }
    /**
     * Método para obter produto por id
     * @param id
     * @return
    */
    public Optional<Produto> obterPorId(Integer id){
        
        return produtoRepository.obterPorId(id);
    }
    /**
     * Método para adicionar novos produtos
     * @param produto
     * @return
     */
    public Produto adicionar(Produto produto){
        return produtoRepository.adicionar(produto);
    }
    /**
     * Método para deletar produtos de uma lista
     * @param id
     */
    public void deletar(Integer id){
        produtoRepository.deletar(id);
    }
    /**
     * Método para atualizar produto 
     * @param id
     * @param produto
     * @return
     */
    public Produto atualizar(Integer id,Produto produto){
        
        //poderia ter alguma validação no ID
        produto.setId(id);

        return produtoRepository.atualizar(produto);

    }
}

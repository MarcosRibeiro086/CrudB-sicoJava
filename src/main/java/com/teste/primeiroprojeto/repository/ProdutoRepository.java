package com.teste.primeiroprojeto.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.primeiroprojeto.model.Produto;


//dizendo pro spring que isso é um repositório
@Repository
public class ProdutoRepository {
    
    /**
     *
     */
    private List<Produto> produtos= new ArrayList<Produto>();
    private Integer ultimoId=0;


    /**
     * método para retornar uma lista de produtos
     * @return lista de produtos.
     */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /**
     * Verifica e retorna o primeiro produto dentro do array que tem o mesmo id que eu passei como parâmetro do método.
     * Optional:Classe para retornar um null caso n tenha id no array.
     * @param id do produto que será localizado.
     * @return retorna um produto caso seja encontrado.
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtos.stream()
        .filter(produto ->produto.getId()==id)
        .findFirst();
    }


    /**
     * Método para adicionar produto na lista.
     * @param produto que será adicionado.
     * @return Retorna o produto que foi adicionado.
     */
    public Produto adicionar(Produto produto){
        
        ultimoId++;

        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }
    /**
     * Método para deletar produto por id.
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){
        produtos.removeIf(produto->produto.getId()==id);//remove se o id do produto for igual a algum produto que está dentro do array
    }

    /**
     * Método para atualizar produto na lista.
     * @param produto Produto atualizado.
     * @return Retorna produto atualizado na lista.
     */
    public Produto atualizar(Produto produto){
        //Encontrar produto
        Optional <Produto> pencontrado=obterPorId(ultimoId);
        //se não encontrar
        if(pencontrado.isEmpty()){
            throw new InputMismatchException("Produto não encontrado!!! ");
        }
        //remover o antigo produto
        deletar(produto.getId());

        //adicionar o novo produto.
        produtos.add(produto);
        return produto;

    }
}

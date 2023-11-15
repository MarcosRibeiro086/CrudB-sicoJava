package com.teste.primeiroprojeto.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiroprojeto.model.Produto;
import com.teste.primeiroprojeto.model.exception.ResourceNotFoundException;
import com.teste.primeiroprojeto.repository.ProdutoRepository;
import com.teste.primeiroprojeto.shared.ProdutoDTO;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    /**
     * Repositorio retorna para mim dentro de uma lista de produtos e pra cada produto converta ele para produto.dto
     * varre todo o objeto e os atributos iguais são alocados na classe ProdutoDTO 
     * @return lista de produtos
     */
    public List<ProdutoDTO> obterTodos(){
    
        List<Produto>produtos =produtoRepository.findAll();
        return produtos.stream().map(produto-> new ModelMapper().map(produto,ProdutoDTO.class)).collect(Collectors.toList());
    }
    /**
     * Método para obter produto por id
     * @param id
     * @return
    */
    public Optional<ProdutoDTO> obterPorId(Integer id){
        //obtendo optional de produto pelo id
        Optional<Produto>produto= produtoRepository.findById(id);
        //se n encontrar lança exception
        if(produto.isEmpty()){
            throw new ResourceNotFoundException("Produto com id "+ id +" não encontrado");
        }
        //convertendo o meu optional de produto em produtoDTO
        ProdutoDTO dto=new ModelMapper().map(produto.get(),ProdutoDTO.class);
        //criando e retornando um optional de produtoDTO
        return Optional.of(dto);
    }
    /**
     * Método para adicionar novos produtos
     * @param produto
     * @return
     */
    public ProdutoDTO adicionar(ProdutoDTO produtoDto){
        //removendo o id para conseguir fazer o cadastro
        produtoDto.setId(null);
        //criar um objeto de mapeamento
        ModelMapper mapper =new ModelMapper();
        //converter o produtoDTO em um produto
        Produto produto =mapper.map(produtoDto, Produto.class);
        //salvar o produto no banco
        produto=produtoRepository.save(produto);
        produtoDto.setId(produto.getId());
        //retornar produtodto atualizado
        return produtoDto;
    }
    /**
     * Método para deletar produtos de uma lista
     * @param id
     */
    public void deletar(Integer id){

        //verificar se o produto existe
        Optional<Produto> produto= produtoRepository.findById(id);
        if (produto.isEmpty()){
            throw new ResourceNotFoundException("Não foi possível deletar o produto com o id: " + id+ " , produto não existe");
        }
        
        produtoRepository.deleteById(id);
    
    
    }
    /**
     * Método para atualizar produto 
     * @param id
     * @param produto
     * @return
     */
    public ProdutoDTO atualizar(Integer id,ProdutoDTO produtoDto){
    
        //passar o id para o produto dto
        produtoDto.setId(id);

        //criar um objeto de mapeamento
        ModelMapper mapper=new ModelMapper();
        
        //converter o produtoDTO em um produto.
        Produto produto=mapper.map(produtoDto,Produto.class);

        //Atualizar o produto no banco de dados
        produtoRepository.save(produto);

        //retornar o produtoDTO atualizado
        return produtoDto;

    }
}

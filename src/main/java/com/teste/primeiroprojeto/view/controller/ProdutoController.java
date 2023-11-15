package com.teste.primeiroprojeto.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.primeiroprojeto.model.Produto;
import com.teste.primeiroprojeto.services.ProdutoService;
import com.teste.primeiroprojeto.shared.ProdutoDTO;
import com.teste.primeiroprojeto.view.models.ProdutoRequest;
import com.teste.primeiroprojeto.view.models.ProdutoResponse;

import org.springframework.web.bind.annotation.PutMapping;


@RestController//informa ao spring que é um controller
@RequestMapping("/api/produtos")//rota da url

public class ProdutoController {
    
    
    @Autowired //tomar controle do repositorio
    private ProdutoService produtoService;


    @GetMapping//quando alguem fizer um get chame o método obter todos
    public  ResponseEntity <List<ProdutoResponse>> obtertodos(){
        List<ProdutoDTO> produtos= produtoService.obterTodos();
        ModelMapper mapper =new ModelMapper();
        List<ProdutoResponse> resposta=produtos.stream().map(produtoDTO -> mapper.map(produtoDTO,ProdutoResponse.class))
        .collect(Collectors.toList());
        //retorna uma lista de produto response dentro de um responseEntity com status OK ou 200
        return new ResponseEntity<>(resposta,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProdutoResponse>> obterPorid(@PathVariable Integer id)/* pega o parâmetro e tenta transformar em inteiro */{
        Optional<ProdutoDTO> dto = produtoService.obterPorId(id);
        ProdutoResponse produto=new ModelMapper().map(dto.get(),ProdutoResponse.class);
        return new ResponseEntity<>(Optional.of(produto),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse >adicionar(@RequestBody ProdutoRequest produtoReq){
        ModelMapper mapper=new ModelMapper();

        ProdutoDTO produtoDto=mapper.map(produtoReq,ProdutoDTO.class);
        produtoDto=produtoService.adicionar((produtoDto));

        
        
        return new ResponseEntity<>(mapper.map(produtoDto,ProdutoResponse.class),HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        produtoService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizar(@RequestBody ProdutoRequest produtoReq, @PathVariable Integer id){
        ModelMapper mapper=new ModelMapper();
        ProdutoDTO produtoDto=mapper.map(produtoReq,ProdutoDTO.class);
        produtoDto=produtoService.atualizar(id, produtoDto);
        
        
        return new ResponseEntity<>(mapper.map(produtoDto, ProdutoResponse.class),HttpStatus.OK);
    }
    
}

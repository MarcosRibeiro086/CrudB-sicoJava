//O que eu quero que seja devolvido, lo

package com.teste.primeiroprojeto.view.models;

import lombok.Data;

@Data
public class ProdutoResponse {
    private Integer id;

    private String nome;

    private  Integer quantidade;

    private double valor;

   //o atributo em questão foi comentado pois eu n quero que ele seja retornado private String observacao;
}

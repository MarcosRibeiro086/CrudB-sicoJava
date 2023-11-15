package com.teste.primeiroprojeto.view.models;
//oq eu quero receber
import lombok.Data;

@Data
public class ProdutoRequest {
    

    private String nome;

    private  Integer quantidade;

    private double valor;

    private String observacao;
    //#endregion
    
}

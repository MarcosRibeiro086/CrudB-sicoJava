package com.teste.primeiroprojeto.model;

import lombok.Data;



//getters e setters automáticos pelo lombok
@Data
public class Produto {
    
    //notação para região dos atributos
    //#region AtributosSSS
    private Integer id;

    private String nome;

    private  Integer quantidade;

    private double valor;

    private String observacao;
    //#endregion
}

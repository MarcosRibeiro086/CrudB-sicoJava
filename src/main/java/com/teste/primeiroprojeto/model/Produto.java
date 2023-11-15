package com.teste.primeiroprojeto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

//anotação para 
@Entity
@Data
public class Produto {
    
    //notação para região dos atributos
    //#region AtributosSSS

    //se transforma em chave primária
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String nome;

    private  Integer quantidade;

    private double valor;

    private String observacao;
    //#endregion

}

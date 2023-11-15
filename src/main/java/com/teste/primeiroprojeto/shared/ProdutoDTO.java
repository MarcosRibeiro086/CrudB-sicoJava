package com.teste.primeiroprojeto.shared;
//oq eu vou usar para transferir dados entre service e controller

import lombok.Data;

@Data
public class ProdutoDTO {
        

    private Integer id;

    private String nome;

    private  Integer quantidade;

    private double valor;

    private String observacao;
    //#endregion

}

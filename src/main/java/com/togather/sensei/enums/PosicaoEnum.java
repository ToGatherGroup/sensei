package com.togather.sensei.enums;

import lombok.Data;


public enum PosicaoEnum {
    PRIMEIRO("Medalha de ouro"),
    SEGUNDO("Medalha de prata"),
    TERCEIRO("Medalha de bronze");

    private final String descricao;


    PosicaoEnum(String descricao) {this.descricao = descricao;}

    public String getDescricao() {
        return descricao;
    }

}
package com.togather.sensei.enums;

import lombok.Getter;

@Getter
public enum PosicaoEnum {

    PARTICIPACAO("Participação"),
    PRIMEIRO("Medalha de ouro"),
    SEGUNDO("Medalha de prata"),
    TERCEIRO("Medalha de bronze");

    private final String descricao;

    PosicaoEnum(String descricao) {
        this.descricao = descricao;
    }

}
package com.togather.sensei.enums;

public enum PosicaoFotoEnum {
    FRENTE("Frente"),
    COSTAS("Costas"),
    PERFIL("Perfil");

    private final String posicao;

    PosicaoFotoEnum(String posicao){
        this.posicao = posicao;
    }

    public String getPosicao(){
        return posicao;
    }
}

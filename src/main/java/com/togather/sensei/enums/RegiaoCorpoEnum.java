package com.togather.sensei.enums;

public enum RegiaoCorpoEnum {
    CABECA_ANTERIOR("Cabeça Anterior"),
    TRONCO_ANTERIOR("Tronco Anterior"),
    MEMBRO_SUPERIOR_ESQUERDO_ANTERIOR("Membro Superior Esquerdo Anterior"),
    MEMBRO_SUPERIOR_DIREITO_ANTERIOR("Membro Superior Direito Anterior"),
    MEMBRO_INFERIOR_ESQUERDO_ANTERIOR("Membro Inferior Esquerdo Anterior"),
    MEMBRO_INFERIOR_DIREITO_ANTERIOR("Membro Inferior Direito Anterior"),

    CABECA_POSTERIOR("Cabeça Posterior"),
    TRONCO_POSTERIOR("Tronco Posterior"),
    MEMBRO_SUPERIOR_ESQUERDO_POSTERIOR("Membro Superior Esquerdo Posterior"),
    MEMBRO_SUPERIOR_DIREITO_POSTERIOR("Membro Superior Direito Posterior"),
    MEMBRO_INFERIOR_ESQUERDO_POSTERIOR("Membro Inferior Esquerdo Posterior"),
    MEMBRO_INFERIOR_DIREITO_POSTERIOR("Membro Inferior Direito Posterior");

    private final String descricao;

    RegiaoCorpoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
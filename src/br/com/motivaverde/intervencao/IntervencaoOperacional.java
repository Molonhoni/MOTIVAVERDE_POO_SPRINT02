package br.com.motivaverde.intervencao;

import br.com.motivaverde.model.TrechoRodovia;

public abstract class IntervencaoOperacional {

    private final String nomeIntervencao;

    public IntervencaoOperacional(String nomeIntervencao) {
        this.nomeIntervencao = nomeIntervencao;
    }

    public String getNomeIntervencao() {
        return nomeIntervencao;
    }

    public abstract void executarServico(TrechoRodovia trecho);
}
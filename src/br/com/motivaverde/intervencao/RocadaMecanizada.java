package br.com.motivaverde.intervencao;

import br.com.motivaverde.model.TrechoRodovia;

public class RocadaMecanizada extends IntervencaoOperacional {

    private static final double ALTURA_APOS_ROCADA = 8.0;

    public RocadaMecanizada() {
        super("Roçada mecanizada");
    }

    @Override
    public void executarServico(TrechoRodovia trecho) {
        System.out.println("Serviço executado: roçada mecanizada no KM " + trecho.getQuilometro());
        trecho.setAlturaVegetacao(ALTURA_APOS_ROCADA);
    }
}
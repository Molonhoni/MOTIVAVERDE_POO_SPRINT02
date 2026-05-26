package br.com.motivaverde.intervencao;

import br.com.motivaverde.model.TrechoRodovia;

public class Pulverizacao extends IntervencaoOperacional {

    private static final double REDUCAO_ESTIMADA_CM = 5.0;

    public Pulverizacao() {
        super("Pulverização");
    }

    @Override
    public void executarServico(TrechoRodovia trecho) {
        System.out.println("Serviço executado: pulverização no KM " + trecho.getQuilometro());

        double novaAltura = trecho.getAlturaVegetacao() - REDUCAO_ESTIMADA_CM;

        if (novaAltura < 0) {
            novaAltura = 0;
        }

        trecho.setAlturaVegetacao(novaAltura);
    }
}
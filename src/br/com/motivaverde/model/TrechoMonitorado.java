package br.com.motivaverde.model;

import br.com.motivaverde.interfaces.MonitoravelViaIoT;

public class TrechoMonitorado extends TrechoRodovia implements MonitoravelViaIoT {

    private String codigoSensor;

    public TrechoMonitorado(int quilometro, double alturaVegetacao,
                            CondicaoCrescimento condicaoCrescimento,
                            EquipeManutencao equipeResponsavel,
                            String codigoSensor) {
        super(quilometro, alturaVegetacao, condicaoCrescimento, equipeResponsavel);
        this.codigoSensor = codigoSensor;
    }

    public String getCodigoSensor() {
        return codigoSensor;
    }

    @Override
    public double transmitirDadosSensor() {
        double novaMedicao = calcularCrescimentoEstimado();
        setAlturaVegetacao(novaMedicao);
        return novaMedicao;
    }

    @Override
    public String exibirResumo() {
        return super.exibirResumo() + " | Sensor IoT: " + codigoSensor;
    }
}
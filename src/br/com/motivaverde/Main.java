package br.com.motivaverde;

import br.com.motivaverde.interfaces.MonitoravelViaIoT;
import br.com.motivaverde.model.CondicaoCrescimento;
import br.com.motivaverde.model.EquipeManutencao;
import br.com.motivaverde.model.TrechoMonitorado;
import br.com.motivaverde.model.TrechoRodovia;
import br.com.motivaverde.service.MotorPrioridade;

public class Main {

    public static void main(String[] args) {

        EquipeManutencao equipeNorte = new EquipeManutencao("Equipe Norte", "Roçada mecanizada");
        EquipeManutencao equipeSul = new EquipeManutencao("Equipe Sul", "Pulverização");

        TrechoRodovia[] trechos = {
                new TrechoRodovia(12, 18.0, CondicaoCrescimento.BAIXO_CRESCIMENTO, equipeNorte),
                new TrechoRodovia(25, 24.0, CondicaoCrescimento.CRESCIMENTO_MODERADO, equipeSul),
                new TrechoMonitorado(38, 22.0, CondicaoCrescimento.CRESCIMENTO_MODERADO, equipeNorte, "SENSOR-IOT-038"),
                new TrechoMonitorado(47, 29.0, CondicaoCrescimento.ALTO_CRESCIMENTO, equipeNorte, "SENSOR-IOT-047"),
                new TrechoRodovia(60, 35.0, CondicaoCrescimento.ALTO_CRESCIMENTO, equipeSul)
        };

        MotorPrioridade motor = new MotorPrioridade();
        motor.gerarRelatorioPrioridade(trechos);

        testarMockMonitoravelViaIoT();

        // Teste conceitual da classe abstrata:
        // A linha abaixo não compila, pois IntervencaoOperacional é abstrata.
        // IntervencaoOperacional teste = new IntervencaoOperacional("Teste");
    }

    private static void testarMockMonitoravelViaIoT() {
        System.out.println("\n===== TESTE MOCK - MONITORAMENTO VIA IOT =====");

        MonitoravelViaIoT mockSensor = new MonitoravelViaIoT() {
            @Override
            public double transmitirDadosSensor() {
                return 32.5;
            }
        };

        double dadoCapturado = mockSensor.transmitirDadosSensor();

        System.out.println("Mock IoT transmitiu altura simulada: " + dadoCapturado + " cm");

        if (dadoCapturado >= 30.0) {
            System.out.println("Resultado do teste: trecho seria classificado como prioridade URGENTE.");
        } else {
            System.out.println("Resultado do teste: trecho não seria classificado como prioridade URGENTE.");
        }
    }
}
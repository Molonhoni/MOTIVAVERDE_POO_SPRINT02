package br.com.motivaverde.model;

public class TrechoRodovia {

    private int quilometro;
    private double alturaVegetacao;
    private CondicaoCrescimento condicaoCrescimento;
    private EquipeManutencao equipeResponsavel;

    public TrechoRodovia(int quilometro, double alturaVegetacao,
                         CondicaoCrescimento condicaoCrescimento,
                         EquipeManutencao equipeResponsavel) {
        this.quilometro = quilometro;
        this.alturaVegetacao = alturaVegetacao;
        this.condicaoCrescimento = condicaoCrescimento;
        this.equipeResponsavel = equipeResponsavel;
    }

    public int getQuilometro() {
        return quilometro;
    }

    public double getAlturaVegetacao() {
        return alturaVegetacao;
    }

    public void setAlturaVegetacao(double alturaVegetacao) {
        this.alturaVegetacao = alturaVegetacao;
    }

    public CondicaoCrescimento getCondicaoCrescimento() {
        return condicaoCrescimento;
    }

    public EquipeManutencao getEquipeResponsavel() {
        return equipeResponsavel;
    }

    public double calcularCrescimentoEstimado() {
        switch (condicaoCrescimento) {
            case ALTO_CRESCIMENTO:
                return alturaVegetacao + 12.0;
            case CRESCIMENTO_MODERADO:
                return alturaVegetacao + 8.0;
            case BAIXO_CRESCIMENTO:
            default:
                return alturaVegetacao + 4.0;
        }
    }

    public String exibirResumo() {
        String equipe = equipeResponsavel != null
                ? equipeResponsavel.exibirResumo()
                : "Nenhuma equipe associada";

        return "KM " + quilometro
                + " | Altura atual: " + alturaVegetacao + " cm"
                + " | Condição de crescimento: " + condicaoCrescimento
                + " | Equipe: " + equipe;
    }
}
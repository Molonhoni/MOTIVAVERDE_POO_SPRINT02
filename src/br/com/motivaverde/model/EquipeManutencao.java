package br.com.motivaverde.model;

public class EquipeManutencao {

    private String nome;
    private String especialidade;

    public EquipeManutencao(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String exibirResumo() {
        return nome + " | Especialidade: " + especialidade;
    }
}
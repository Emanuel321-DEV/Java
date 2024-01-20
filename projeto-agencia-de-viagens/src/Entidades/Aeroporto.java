package Entidades;

import java.io.Serializable;

public class Aeroporto implements Serializable {
    private String nome;
    private Cidade cidade;

    public Aeroporto(String nome, Cidade cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }
    
    public String getNome(){
        return nome;
    }
    
    public Cidade getCidade(){
        return cidade;
    }
    
    @Override
    public String toString(){
        return "Nome: " + this.nome + " - " + "\n    Localizacao: " +  this.cidade.toString();
    }
    
}

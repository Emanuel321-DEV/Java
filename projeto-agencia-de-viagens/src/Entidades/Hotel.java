package Entidades;

import Entidades.Cidade;
import java.io.Serializable;

public class Hotel implements Serializable {
    private String nome;
    private Cidade cidade;
    private int estrelas; 
    private double valorDiaria;

    public Hotel(String nome, Cidade cidade, int estrelas, double valorDiaria) {
        this.nome = nome;
        this.cidade = cidade;
        this.estrelas = estrelas;
        this.valorDiaria = valorDiaria;
    }

    public String getNome() {
        return nome;
    }
    
    public Cidade getCidade(){
        return cidade;
    }
    
    public int getEstrelas(){
        return estrelas;
    }
    
    public double getValorDiaria(){
        return valorDiaria;
    }
    
    @Override
    public String toString(){
        return "Nome: " + this.getNome() + " - " + "\n    Avaliacao: "  + this.estrelas + "\n    Localizacao: " + this.cidade.toString();
    }
}

package Entidades.Produto;

import java.io.Serializable;

public class Produto implements Serializable{

    private double preco;

    public Produto(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }
}
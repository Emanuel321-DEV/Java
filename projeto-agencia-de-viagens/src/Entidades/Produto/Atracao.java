package Entidades.Produto; 

import Entidades.Cidade;
import Entidades.Produto.Produto;
import java.io.Serializable;

public class Atracao extends Produto implements Serializable {
    private Cidade cidade;
    private String nome;

    public Atracao(Cidade cidade, String nome) {
        super(2000);
        this.cidade = cidade;
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    public Cidade getCidade(){
        return cidade;
    }
    
    @Override
    public String toString(){
        return this.nome + "\n    Localizacao: " + this.cidade.toString();
    }
}

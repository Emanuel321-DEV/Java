package Entidades.Produto;

import Entidades.Produto.Produto;
import Entidades.Cidade;
import Entidades.Cidade;
import Entidades.Pessoa.Cliente;
import Entidades.Pessoa.Cliente;
import Entidades.Hotel;
import Entidades.Hotel;
import java.util.ArrayList;

public class Hospedagem extends Produto {
    private String dataInicial, dataFinal;
    private Cidade cidade;
    private int numPessoas;
    private int numQuartos;
    private ArrayList<Cliente> hospedes;
    private Hotel hotel;
    
    public Hospedagem(String dataInicial, String dataFinal, Cidade cidade, int numPessoas, int numQuartos, Hotel hotel){
        super(2000.00);
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.cidade = cidade;
        this.numPessoas = numPessoas;
        this.numQuartos = numQuartos;
        this.hotel = hotel;
    }
    
    public void setClientes(ArrayList<Cliente> clientes){
        hospedes = clientes;
    }
    
     @Override
    public String toString() {
        String result = "Data Inicial: " + dataInicial + "\n" +
                        "Data Final: " + dataFinal + "\n" +
                        "Hotel: " + hotel.getNome() + "\n" +
                        "Hospedes:\n";

        for (Cliente hospede : hospedes) {
            result += "\t" + hospede.getNome() + " - " + hospede.getCpf() + "\n";
        }

        result += "Nro de Quartos: " + numQuartos;
        
        return result;
    }
    
    
}

package Entidades.Produto;

import Entidades.Pessoa.Cliente;
import Entidades.Trecho;

public class Passagem extends Produto {

    private Cliente passageiro;
    private Trecho trecho;
    private boolean paga;

    public Passagem(Cliente passageiro, Trecho trecho) {
        super(trecho.getValorTrecho()); // pra mim faz mais sentido o preco de uma passagem ser definido pelo custo do trecho 
        this.passageiro = passageiro;
        this.trecho = trecho;
    }

    public String emitePassagem() {
        String passagem = "\n"
                + "Passageiro: " + passageiro.getNome() + "\n"
                + "CPF: " + passageiro.getCPF() + "\n"
                + "Data: " + trecho.getData() + "\n"
                + "Horario: " + trecho.getHorario() + "\n"
                + "Aeroporto Embarque: " + trecho.getAeroportoEmbarqueNome() + "\n"
                + "Aeroporto Destino: " + trecho.getAeroportoDestinoNome() + "\n"
                + "Cidade Origem: " + trecho.getCidadeEmbarqueNome() + "\n"
                + "Cidade Destino: " + trecho.getCidadeDestinoNome() + "\n";

        return passagem;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }
    
    @Override
    public String toString(){
        String passagem = "\n"
                + "Passageiro: " + passageiro.getNome() + "\n"
                + "CPF: " + passageiro.getCPF() + "\n"
                + "Data: " + trecho.getData() + "\n"
                + "Horario: " + trecho.getHorario() + "\n"
                + "Aeroporto Embarque: " + trecho.getAeroportoEmbarqueNome() + "\n"
                + "Aeroporto Destino: " + trecho.getAeroportoDestinoNome() + "\n"
                + "Cidade Origem: " + trecho.getCidadeEmbarqueNome() + "\n"
                + "Cidade Destino: " + trecho.getCidadeDestinoNome() + "\n";

        return passagem;
    }
    
    public Trecho getTrecho(){
        return trecho;
    }
    
}

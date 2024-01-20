package Entidades;

import Entidades.Cidade;
import Entidades.Aeroporto;

public class Trecho {

    private Cidade cidadeOrigem;
    private Cidade cidadeDestino;
    private Aeroporto aeroportoOrigem;
    private Aeroporto aeroportoDestino;
    private String data;
    private String horario;
    private double valorTrecho;

    public Trecho(Cidade cidadeOrigem, Cidade cidadeDestino, Aeroporto aeroportoOrigem, Aeroporto aeroportoDestino, String data, String horario) {
        this.cidadeOrigem = cidadeOrigem;
        this.cidadeDestino = cidadeDestino;
        this.aeroportoOrigem = aeroportoOrigem;
        this.aeroportoDestino = aeroportoDestino;
        this.data = data;
        this.horario = horario;
        valorTrecho = 200; // como determinar o valor de um trecho ? Por padrão será esse valor
    }

    public void mostraTrecho() {
        System.out.println("     Data Partida: " + data);
        System.out.println("     Horario Partida: " + horario);

        System.out.println("     Cidade de Origem: " + cidadeOrigem.getNome());
        System.out.println("     Cidade de Origem: " + cidadeDestino.getNome());

        System.out.println("     Aeroporto de Embarque: " + aeroportoOrigem.getNome());
        System.out.println("     Aeroporto de Destino: " + aeroportoDestino.getNome());
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public String getAeroportoEmbarqueNome() {
        return aeroportoOrigem.getNome();
    }

    public String getAeroportoDestinoNome() {
        return aeroportoDestino.getNome();
    }

    public String getCidadeEmbarqueNome() {
        return cidadeOrigem.getNome();
    }

    public String getCidadeDestinoNome() {
        return cidadeDestino.getNome();
    }

    public double getValorTrecho() {
        return valorTrecho;
    }

}

package Repositorios;

import Arquivos.Arquivo;
import Interfaces.IRepositorio;
import Entidades.Produto.Atracao;
import Entidades.Cidade;
import java.util.ArrayList;

public class AtracoesRepositorio implements IRepositorio {

    private ArrayList<Atracao> atracoes = new ArrayList<>();

    public AtracoesRepositorio() {
        atracoes = (ArrayList<Atracao>) new Arquivo().recuperar("atracoes.dat");
    }

    @Override
    public ArrayList<Atracao> getDados() {
        return atracoes;
    }

    @Override
    public boolean setDados(Object obj) {
        try {
            Atracao atracao = (Atracao) obj;
            this.atracoes.add(atracao);
            System.out.println("\n******************** Atracao cadastrada com sucesso! ********************");
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public ArrayList<Atracao> getAtracoesDaCidade(Cidade cidade) {
        ArrayList<Atracao> atracoesCidade = new ArrayList<>();

        for (Atracao atracao : atracoes) {
            if (atracao.getCidade().getNome().equals(cidade.getNome())) {
                atracoesCidade.add(atracao);
            }
        }
        return atracoesCidade;
    }

    @Override
    public void mostraDados() {
        int contador = 1;
        for (Atracao atracao : atracoes) {
            System.out.println(contador + " - " + atracao.toString());
            contador++;
        }
    }

}

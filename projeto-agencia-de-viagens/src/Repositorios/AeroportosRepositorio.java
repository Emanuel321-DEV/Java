package Repositorios;

import Arquivos.Arquivo;
import Interfaces.IRepositorio;
import Entidades.Aeroporto;
import Entidades.Cidade;
import java.util.ArrayList;

public class AeroportosRepositorio implements IRepositorio {

    private ArrayList<Aeroporto> aeroportos = new ArrayList<>();

    public AeroportosRepositorio() {
        aeroportos = (ArrayList<Aeroporto>) new Arquivo().recuperar("aeroportos.dat");
    }

    @Override
    public ArrayList<Aeroporto> getDados() {
        return aeroportos;
    }

    @Override
    public boolean setDados(Object obj) {
        try {
            Aeroporto aeroporto = (Aeroporto) obj;
            this.aeroportos.add(aeroporto);
            System.out.println("\n******************** Aeroporto cadastrado com sucesso! ********************");
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }

    }

    public ArrayList<Aeroporto> getAeroportosDaCidade(Cidade cidade) {
        ArrayList<Aeroporto> aeroportosCidade = new ArrayList<>();
        for (Aeroporto aeroporto : aeroportos) {
            if (aeroporto.getCidade().getNome().equals(cidade.getNome())) {
                aeroportosCidade.add(aeroporto);
            }
        }
        return aeroportosCidade;
    }

    @Override
    public void mostraDados() {
        System.out.println("\nAEROPORTOS CADASTRADOS\n");
        int contador = 1;
        for (Aeroporto aeroporto : aeroportos) {
            System.out.println(contador + " - " + aeroporto.toString());
            contador++;
        }
    }

}

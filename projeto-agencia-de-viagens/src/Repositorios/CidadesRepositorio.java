package Repositorios;

import Arquivos.Arquivo;
import Interfaces.IRepositorio;
import Entidades.Cidade;
import java.util.ArrayList;

public class CidadesRepositorio implements IRepositorio {

    private ArrayList<Cidade> cidades = new ArrayList<>();

    public CidadesRepositorio() {
        cidades = (ArrayList<Cidade>) new Arquivo().recuperar("cidades.dat");
    }

    @Override
    public ArrayList<Cidade> getDados() {
        return cidades;
    }

    @Override
    public boolean setDados(Object obj) {
        try {
            Cidade cidade = (Cidade) obj;
            cidades.add(cidade);
            System.out.println("\n******************** Cidade cadastrada com sucesso! ********************\n");
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    @Override
    public void mostraDados() {
        int contador = 1;
        for (Cidade cidade : cidades) {
            System.out.println(contador + " - " + cidade.toString());
            contador++;
        }
    }
    
    public void mostraDados(Cidade cidade) {
        int contador = 1;
        for (Cidade c : cidades) {
            if(c != cidade) {
                System.out.println(contador + " - " + c.toString());
            }
            contador++;
        }
    }

}

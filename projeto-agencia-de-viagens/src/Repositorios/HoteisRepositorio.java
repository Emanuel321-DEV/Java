package Repositorios;

import Arquivos.Arquivo;
import Interfaces.IRepositorio;
import Entidades.Cidade;
import Entidades.Hotel;
import java.util.ArrayList;

public class HoteisRepositorio implements IRepositorio {

    private ArrayList<Hotel> hoteis = new ArrayList<>();

    public HoteisRepositorio() {
        hoteis = (ArrayList<Hotel>) new Arquivo().recuperar("hoteis.dat");
    }

    @Override
    public ArrayList<Hotel> getDados() {
        return hoteis;
    }

    @Override
    public boolean setDados(Object obj) {
        try {
            Hotel hotel = (Hotel) obj;
            hoteis.add(hotel);
            System.out.println("\n******************** Hotel cadastrado com sucesso! ********************");
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public void mostraDados() {
        int contador = 1;
        for (Hotel hotel : hoteis) {
            System.out.println(contador + " - " + hotel.toString());
            contador++;
        }
    }

    public ArrayList<Hotel> getHoteisDaCidade(Cidade cidade) {
        ArrayList<Hotel> hoteisCidade = new ArrayList<>();

        for (Hotel hotel : hoteis) {
            if (hotel.getCidade().getNome().equals(cidade.getNome())) {
                hoteisCidade.add(hotel);
            }
        }
        return hoteisCidade;
    }

}

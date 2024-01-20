package escola;

import humanos.Filha;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Colegio colegio = new Colegio<>();

        // Declaração do HashMap classe e suas atribuições;
        Map<Integer, Integer> classe = new HashMap<>();
        colegio.add_hash_map(classe, 101, 1);
        colegio.add_hash_map(classe, 102, 1);

        
        // Criação das filhas e inserindo na lista;
        List<Filha> filhas = new ArrayList<>(List.of(
                new Filha("Taina", "Azuis", "Branca", 1.65f, 14, new String[]{"zero"}, false,
                        new ArrayList<>(), new ArrayList<>(), true, new ArrayList<>()),
                new Filha("Janaina", "Castanhos", "Parda", 1.75f, 15, new String[]{"zero"}, false,
                        new ArrayList<>(), new ArrayList<>(), true, new ArrayList<>()),
                new Filha("Talita", "Verdes", "Branca", 1.50f, 15, new String[]{"zero"}, false,
                        new ArrayList<>(), new ArrayList<>(), true, new ArrayList<>()),
                new Filha("Ana", "Castanhos", "Branca", 1.81f, 14, new String[]{"zero"}, false,
                        new ArrayList<>(), new ArrayList<>(), true, new ArrayList<>()),
                new Filha("Maria", "Castanhos", "Parda", 1.72f, 15, new String[]{"zero"}, false,
                        new ArrayList<>(), new ArrayList<>(), true, new ArrayList<>()),
                new Filha("Fernanda", "Castanhos", "Branca", 1.74f, 14, new String[]{"zero"}, false,
                        new ArrayList<>(), new ArrayList<>(), true, new ArrayList<>()),
                new Filha("Leila", "Verdes", "Afro descendente", 1.70f, 14, new String[]{"zero"}, false,
                        new ArrayList<>(), new ArrayList<>(), true, new ArrayList<>())
        ));
        
        // Inserindo as filhas em um HashMap de alunas;
        Map<String, String> alunas = new HashMap<>();
        for (Filha filha : filhas) {
            
            Map<Integer, Integer> classeColegio = colegio.getClasse(classe);
            
            // Primeiro elemento do hashmap
            Map.Entry<Integer, Integer> firstEntry = classeColegio.entrySet().iterator().next();

            Integer andar = firstEntry.getKey();
            Integer sala = firstEntry.getValue();
            
            String nome = filha.getNome();
            String andarESala = "Piso " + andar + "," + "sala " +sala;
            alunas.put(nome, andarESala);
        }
        
        // imprimindo as alunas
        colegio.imprimir(alunas);
        

    }

}

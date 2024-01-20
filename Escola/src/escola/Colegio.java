package escola;
import humanos.Pessoa;
import java.util.HashMap;
import java.util.Map;

public class Colegio <T extends Pessoa> {
    private Map<Integer, Integer> classe;
    private Map<String, String> alunos;

    public Colegio() {
        this.classe = new HashMap<>();
        this.alunos = new HashMap<>();
    }
    
    public <T> void add_hash_map(Map<T, T> map, T key, T value){
        map.put(key, value);
    }
    
    public <T> void imprimir(Map<T, T> map){
        for (Map.Entry<T, T> entry : map.entrySet()) {
            T key = entry.getKey();
            T value = entry.getValue();
            System.out.println(key + ": " + value);
            
        }
    }
    
    public Map<T, T> getClasse(Map<T, T> map) {
        return map;
    }

    public Map<String, String> getAlunos() {
        return alunos;
    }
    
}


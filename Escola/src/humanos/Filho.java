package humanos;

import java.util.List;

public class Filho extends Pai {
    protected boolean estudante; 
    protected List<Float> aulas;
    
    public Filho(String nome, String tipo_olhos, String cor, float altura, int idade, String[] filhos, boolean trabalha, List<String> lista_tarefas,
            List<Float> contas, boolean estudante, List<Float> aulas){
        super(nome, tipo_olhos, cor, altura, idade,  filhos, trabalha,  lista_tarefas,contas);
        this.estudante = estudante;
        this.aulas = aulas;
    }
    
    public void imprimir_horarios_de_aula(){
        for (int i = 0; i < aulas.get(i); i++) {
            System.out.println(i);
        }
    }
    
    public void add_aula(Float aula){
        this.aulas.add(aula);
    }
    
    public boolean isEstudante() {
        return estudante;
    }

    public List<Float> getAulas() {
        return aulas;
    }
    
}

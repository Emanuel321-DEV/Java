package humanos;

import java.util.List;

public class Pai extends Homem {

    protected String[] filhos;
    protected boolean trabalha;
    protected List<String> lista_tarefas;
    protected List<Float> contas;

    public Pai(String nome, String tipo_olhos, String cor, float altura, int idade, String[] filhos, boolean trabalha, List<String> lista_tarefas,
            List<Float> contas) {
        super(nome, tipo_olhos, cor, altura, idade);
        this.filhos = filhos;
        this.trabalha = trabalha;
        this.lista_tarefas = lista_tarefas;
        this.contas = contas;
    }

    public <T> void imprimir(List<T> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    public <T> void imprimir(List<T> lista, String Titulo) {
        System.out.println(Titulo);
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    public void add_tarefa(String tarefa) {
        this.lista_tarefas.add(tarefa);
    }

    public void add_conta(float conta) {
        this.contas.add(conta);
    }

    public String[] getFilhos() {
        return filhos;
    }

    public void setFilhos(String[] filhos) {
        this.filhos = filhos;
    }

    public boolean isTrabalha() {
        return trabalha;
    }

    public void setTrabalha(boolean trabalha) {
        this.trabalha = trabalha;
    }

    public List<String> getLista_tarefas() {
        return lista_tarefas;
    }

    public void setLista_tarefas(List<String> lista_tarefas) {
        this.lista_tarefas = lista_tarefas;
    }

    public List<Float> getContas() {
        return contas;
    }

    public void setContas(List<Float> contas) {
        this.contas = contas;
    }

}

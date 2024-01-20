package humanos;

public class Pessoa {
    protected String nome, tipo_olhos, cor;
    protected float altura;
    protected int idade;
    
    public Pessoa(String nome, String tipo_olhos, String cor, float altura, int idade) {
        this.nome = nome;
        this.tipo_olhos = tipo_olhos;
        this.cor = cor;
        this.altura = altura;
        this.idade = idade;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoOlhos() {
        return tipo_olhos;
    }

    public void setTipoOlhos(String tipo_olhos) {
        this.tipo_olhos = tipo_olhos;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
}

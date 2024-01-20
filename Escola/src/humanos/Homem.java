package humanos;

public class Homem extends Pessoa {
    protected char sexo;
    public Homem(String nome, String tipo_olhos, String cor, float altura, int idade){
        super(nome, tipo_olhos, cor, altura, idade);
        sexo = 'M';
    }
    
   public char getSexo(){
       return sexo;
   }
    
    
}

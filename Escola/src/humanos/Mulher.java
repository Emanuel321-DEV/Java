package humanos;

public class Mulher extends Pessoa{
    protected char sexo;
    public Mulher(String nome, String tipo_olhos, String cor, float altura, int idade){
        super(nome, tipo_olhos, cor, altura, idade);
        sexo = 'F';
    }
    
   public char getSexo(){
       return sexo;
   }
}

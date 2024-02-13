package aula;

public class Aula {

    public static void main(String[] args) {

        Soma s = new Soma();
        Ler l = new Ler(s);

        l.start();
        s.start();
    }

}

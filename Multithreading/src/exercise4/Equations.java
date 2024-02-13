package exercise4;

public class Equations implements Runnable {
    
    private static double a, b, c;
    
    public static double discriminant(){
        return (b * b) - 4 * a * c;
    }
    
    public static String root(double a, double b, double c){
        Equations.a = a;
        Equations.b = b;
        Equations.c = c;
        
        String result = "F(x) = " + a + "x^2 + " + b + "x + " + c;
        double discriminant = discriminant();
        
        if(discriminant < 0.0) return result + "\n  Nao tem raiz real";
        double squareRoot = Math.sqrt(discriminant);
        if(a == 0) {
            return result + "\n Nao eh uma eq. de segundo grau";
        }
        
        double x1 = (-b + (squareRoot))/2*a;
        double x2 = (-b - (squareRoot))/2*a;
        result += "\n    Raiz 1 = " + x1;
        if(squareRoot != 0.00) result += "\n    Raiz 2 = " + x2;
        return result;
    }
    
    @Override
    public void run() {
        System.out.println(root(a, b, c));
    }
}

package exercise3;

import java.util.Random;

public class Spacecraft {
    public String name; 
    public double velocity;
    
    public Spacecraft(String s){
        this.name = s;
        this.velocity = generateRandomValue();
    }
    
    public void showSpacecraft(){
        System.out.println("Spacecraft " + name + "\n" + "Velocity: " + velocity);
    }

    
    public double generateRandomValue(){
        Random random = new Random();
        double valorAleatorio = random.nextDouble();
        double valorFinal = 5 + (valorAleatorio * 5);
        return valorFinal;
    }
    
    public String getName(){
        return name;
    } 
    
    public double getVelocity(){
        return velocity;
    } 
    
    public String showSpaceCraft (){
        if(velocity == 0){
            return "Nave Inoperante";
        }
        
        return "Nave: " + getName() + " " + "\nVelocity: " + " " + getVelocity();
    }
    
    public void stopSpaceCraft(){
        velocity = 0;
    }
    
    public void startSpaceCraft(double velocity){
        this.velocity = velocity;
    }

}

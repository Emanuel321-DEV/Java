package exercise1; 
public class TicketMachine {
    private int price;
    private int quantityInsert;
    private int total;
    
    public TicketMachine(int price){
        this.price = price;
        quantityInsert = 0;
        total = 0;
    }
    
    public String insertMoney(int money){
       if(money != 1 && money != 2){
           return "Desculpe, aceitamos apenas notas de R$ 1 OU R$ 2 ";
       } else {
           int totalInsertByUser = money + quantityInsert;
           if(totalInsertByUser > price){ // Usuario irá extrapolar o saldo, devolva o troco
               total += money;
               quantityInsert = 0; // Passagem paga, deve ter a quantidade inserida zerada.
               int troco = totalInsertByUser - price;
               total -= troco;
               return "Passagem emitida com sucesso! Seu troco eh " + troco;
           } else if(totalInsertByUser == price){ // Usuario pagou  a passagem corretamente
               total += money;
               quantityInsert = 0; // // Passagem paga, deve ter a quantidade inserida zerada.
               return "Passagem emitida com sucesso! ";
           } else {
               quantityInsert += money;
               total += money;
               int valueRestant = price - totalInsertByUser;
               return "Por favor, insira mais R$ " + valueRestant + " para resgatar sua passagem";
           }
       } 
    }

    public int getTotalValue(){
        return total;
    }
    
    public String getPriceTicket(){
        return "R$ " + price;
    }
    
    
}

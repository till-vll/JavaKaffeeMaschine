
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class GeldZaehler {
    HashMap<String, Double> muenzen = new HashMap<>();
    double profit = 0;
    double geldEingegangen = 0;
    public GeldZaehler(){
        muenzen.put("1 Cent",0.01);
        muenzen.put("5 Cent",0.05);
        muenzen.put("10 Cent",0.1);
        muenzen.put("25 Cent",0.25);
        muenzen.put("50 Cent",0.5);
        muenzen.put("1 Euro",1.0);
        muenzen.put("2 Euro",2.0);
    }
    public void bericht(){
        System.out.printf("%.2f Euro Profit!%n",this.profit);
    }
    public void geldZaehlen(){
        System.out.println("Bitte geben sie ihr Geld ein!");
        Scanner input = new Scanner(System.in);
        for (Map.Entry<String, Double> muenze: muenzen.entrySet()
             ) {
            System.out.printf("Wie viele %s Münzen?%n",muenze.getKey());
            Integer anzahl = input.nextInt();
            this.geldEingegangen += anzahl * muenze.getValue();
        }
        System.out.printf("%.2f Euro eingezahlt%n", this.geldEingegangen);
    }
    public boolean kaffeKaufen(double preis){
        this.geldZaehlen();
        if(this.geldEingegangen < preis){
            System.out.println("Nicht genug Geld eingezahlt!");
            return false;
        }
        else{
            this.profit += preis;
            return true;
        }
    }
    public void rueckgeld(boolean gekauft, double preis){
        double rueckgeld;
        if(gekauft){
            rueckgeld = this.geldEingegangen - preis;
        }
        else{
            rueckgeld = this.geldEingegangen;
        }
        this.geldEingegangen = 0;
        System.out.printf("Sie bekommen %.2f Euro Rückgeld%n",rueckgeld);
    }
}

import java.util.Objects;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void kaffeezubereiten(int kaffenummer, KaffeeMaschine kaffeeMaschine,Menu menu,GeldZaehler zaehler){
        kaffenummer -= 1;
        if(zaehler.kaffeeKaufen(menu.menu[kaffenummer].preis)){
            if(kaffeeMaschine.checkZutaten(menu.menu[kaffenummer])){
                kaffeeMaschine.macheKaffee(menu.menu[kaffenummer]);
                zaehler.rueckgeld(true,menu.menu[kaffenummer].preis);
                return;
            }
        }
        zaehler.rueckgeld(false,menu.menu[kaffenummer].preis);
    }
    public static void main(String[] args){

        KaffeeMaschine kaffeMaschine = new KaffeeMaschine();
        Menu auswahl = new Menu();
        GeldZaehler zaehler = new GeldZaehler();
        boolean maschine_an = true;
        Scanner input = new Scanner(System.in);
        while(maschine_an){
            System.out.printf("Was wollen sie trinken: %s%nZum Ausschalten 'aus' schreiben.%n", Menu.getOptionen(auswahl.menu));
            String eingabe = input.nextLine();

            if(eingabe.matches("1|2|3")) {
                Main.kaffeezubereiten(Integer.parseInt(eingabe),kaffeMaschine,auswahl,zaehler);
            }


            else if(Objects.equals(eingabe, "aus")){
                maschine_an = false;
            }
            else if(Objects.equals(eingabe, "Bericht")){
                kaffeMaschine.bericht();
                zaehler.bericht();
            }
            else{
                System.out.println("Falsche Eingabe!");
            }
        }

    }
}

import java.util.Objects;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    //TODO Allgemine Tipps: drück ab und zu STRG+ALT+L für automatische Code Formatiereung und STRG+ALT+O vor dem Pushen,
    // um nicht benutzt Imports zu entfernen.

    //TODO Vielleicht mal in einen Logger einlesen und alle SysOuts mit einem Logger ersetzen.

    public static void kaffeezubereiten(int kaffenummer, KaffeeMaschine kaffeeMaschine, Menu menu, GeldZaehler zaehler) {
        kaffenummer -= 1;
        //TODO Anstatt mit menu.menu wird durch die Encapsulation jetzt mit menu.getMenu() auf die Menüliste zugegriffen.
        //TODO Nestedt if-Statement kann auf eins reduziert werden
        if (zaehler.kaffeeKaufen(menu.getMenu()[kaffenummer].preis)) {
            if (kaffeeMaschine.checkZutaten(menu.getMenu()[kaffenummer])) {
                kaffeeMaschine.macheKaffee(menu.getMenu()[kaffenummer]);
                zaehler.rueckgeld(true, menu.getMenu()[kaffenummer].preis);
                return;
            }
        }
        zaehler.rueckgeld(false, menu.getMenu()[kaffenummer].preis);
    }
    public static void main(String[] args){

        KaffeeMaschine kaffeMaschine = new KaffeeMaschine();
        Menu auswahl = new Menu();
        GeldZaehler zaehler = new GeldZaehler();
        //TODO Java naming conventions ->> https://www.theserverside.com/feature/Java-naming-conventions-explained#:~:text=For%20variables%2C%20the%20Java%20naming,a%20lower%20camel%20case%20syntax.
        boolean maschine_an = true;
        Scanner input = new Scanner(System.in);
        while(maschine_an){
            System.out.printf("Was wollen sie trinken: %s%nZum Ausschalten 'aus' schreiben.%n", Menu.getOptionen(auswahl.getMenu()));
            String eingabe = input.nextLine();

            //TODO Einzelne Chracter sollten mit einer Characterklasse ersetzt werden eg [123]
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

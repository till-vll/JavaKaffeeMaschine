import java.util.HashMap;


public class Menu {

    //TODO Guter Ansatz mit der Inneren Klasse! :)

    //TODO Alle Variablen standardmäßig auf private stellen, wenn du auf sie in einer anderen Klasse zugreifen musst
    // erstelle dafür Getter/Setter nach bedarf. Mit ALT+Einfg kannst du dir Setter, Getter und Constructoren uvm. generieren lassen.

    //TODO in der Klasse GeldZaehler hab ich es vor gemacht, hier kannst du es selbst mal probieren. :)
    class MenuItem{
        String name;
        double preis;
        //TODO Typen Spezifikation muss seit Java 7 nicht mehr im Constructor mitgegben werden und sollte es am besten auch nicht
        // ->> new HashMap<>();
        HashMap<String, Integer> zutaten = new HashMap<String, Integer>();

        public MenuItem(String name, int wasser, int milch, double preis, int kaffee ){
            this.name = name;
            this.preis = preis;
            this.zutaten.put("Wasser", wasser);
            this.zutaten.put("Milch", milch);
            this.zutaten.put("Kaffee", kaffee);

        }
    }

    //TODO Versuch dir gleich schon Encapsulation anzugewöhnen. Greife nur mit Gettern und Settern auf Variablen zu und setze die Originale Variable auf private.
    //  https://www.w3schools.com/java/java_encapsulation.asp

    private MenuItem[] menu = {
            new MenuItem("(1)Latte macchiato",200,150,2.5,24),
            new MenuItem("(2)Espresso",50,0,1.5,18),
            new MenuItem("(3)Capuccino",250,50,3,24)
    };

    public MenuItem[] getMenu() {
        return menu;
    }

    //TODO Schau dir mal einen Stringbuilder an. Das verschönert das ganze ein wenig.
    public static String getOptionen(MenuItem[] menu){
        String optionen = "";
        for(MenuItem item : menu){
            optionen += "|";
            optionen += item.name;
            optionen += " ";
            optionen += item.preis;
            optionen += " Euro";
        }
        optionen += "|";
        return optionen;
    }
}

import java.util.HashMap;


public class Menu {
    class MenuItem{
        String name;
        double preis;
        HashMap<String, Integer> zutaten = new HashMap<String, Integer>();

        public MenuItem(String name, int wasser, int milch, double preis, int kaffee ){
            this.name = name;
            this.preis = preis;
            this.zutaten.put("Wasser", wasser);
            this.zutaten.put("Milch", milch);
            this.zutaten.put("Kaffee", kaffee);

        }
    }
    MenuItem[] menu = {
            new MenuItem("(1)Latte macchiato",200,150,2.5,24),
            new MenuItem("(2)Espresso",50,0,1.5,18),
            new MenuItem("(3)Capuccino",250,50,3,24)
    };
    static String getOptionen(MenuItem[] menu){
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

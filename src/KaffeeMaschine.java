import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class KaffeeMaschine {

    private HashMap<String, Integer> vorrat = new HashMap<>();
    public KaffeeMaschine(){
        vorrat.put("Wasser",300);
        vorrat.put("Milch",200);
        vorrat.put("Kaffee",100);

    }


    public void bericht(){
        System.out.printf("Wasser: %d ml%n",this.vorrat.get("Wasser"));
        System.out.printf("Milch: %d ml%n",this.vorrat.get("Milch"));
        System.out.printf("Kaffee: %d g%n",this.vorrat.get("Kaffee"));
    }

    public boolean checkZutaten(Menu.@NotNull MenuItem kaffee){
        boolean genug = true;
        for (Map.Entry<String, Integer> zutat: kaffee.zutaten.entrySet()
             ) {
            if(zutat.getValue() > vorrat.get(zutat.getKey())){
                genug = false;
                System.out.printf("Nicht genug %s!%n",zutat.getKey());
                return  genug;
            }
        }
        return genug;
    }
    public void macheKaffee(Menu.MenuItem kaffee){
        for (Map.Entry<String, Integer> zutat: kaffee.zutaten.entrySet()
             ) {
            this.vorrat.put(zutat.getKey(), vorrat.get(zutat.getKey()) - zutat.getValue());
        }
        System.out.printf("Hier ist ihr %s!%n",kaffee.name);
    }
}
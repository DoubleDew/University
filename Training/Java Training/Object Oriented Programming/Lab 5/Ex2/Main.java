import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Attraction a1 = new Attraction("Castle 1", "Location 1");
        Attraction a2 = new Attraction("Castle 2", "Location 2");
        Attraction a3 = new Attraction("Castle 3", "Location 3");
        Attraction a4 = new Attraction("Castle 4", "Location 4");
        Attraction a5 = new Attraction("Castle 5", "Location 5");
        Attraction a6 = new Attraction("Castle 6", "Location 6");

        TouristicPackage tp1 = new TouristicPackage("Package 1", 1, 50);
        tp1.addAttraction(a1);
        tp1.addAttraction(a2);
        tp1.addAttraction(a3);
        tp1.addAttraction(a3);

        TouristicPackage tp2 = new TouristicPackage("Package 2", 2, 100);
        tp2.addAttraction(a1);
        tp2.addAttraction(a4);
        tp2.addAttraction(a5);
        tp2.addAttraction(a6);

        TouristicPackage tp3 = new TouristicPackage("Package 3", 3, 200);
        tp3.addAttraction(a1);
        tp3.addAttraction(a3);
        tp3.addAttraction(a6);
        tp3.addAttraction(a5);

        ArrayList<TouristicPackage> tpList = new ArrayList<>();
        tpList.add(tp1);
        tpList.add(tp2);
        tpList.add(tp3);

        Map<Attraction, Integer> boughtAtt = new HashMap<>();
        for(TouristicPackage tp : tpList){
            for(Attraction att : tp.getAttractions()) {
                if(boughtAtt.containsKey(att)){
                    int temp = boughtAtt.get(att);
                    temp++;
                    boughtAtt.put(att, temp);
                }
                else{
                    boughtAtt.put(att, 1);
                }
            }
        }

        System.out.println("Number of occurrences per attractions: ");
        for(Map.Entry<Attraction, Integer> entry: boughtAtt.entrySet()){
            System.out.println("Attraction: " + entry.getKey().getName() + " has the frequency: " + entry.getValue());
        }

        // compute popularity per attraction (frequency / total)
        Map<Attraction, Double> popularity = new HashMap<>();
        int total = 0;
        for(Map.Entry<Attraction, Integer> entry : boughtAtt.entrySet()){
            total += entry.getValue();
        }
        
        System.out.println("Number of attraction visits: " + total);

        for(Map.Entry<Attraction, Integer> entry : boughtAtt.entrySet()){
            if(popularity.containsKey(entry.getKey())){
                Double temp = Double.valueOf(entry.getValue());
                temp = temp / total;
                popularity.put(entry.getKey(), temp);
            }
            else{
                Double temp = Double.valueOf(entry.getValue());
                temp = temp / total;
                popularity.put(entry.getKey(), temp);
            }
        }

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        System.out.println("Popularity: ");
        for(Map.Entry<Attraction, Double> entry : popularity.entrySet()){
            System.out.println("Attraction: " + entry.getKey().getName() + " has the popularity: " + df.format(entry.getValue()));
        }
    }
}

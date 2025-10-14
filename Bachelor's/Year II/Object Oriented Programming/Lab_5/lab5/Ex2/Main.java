package Ex2;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Attraction a1 = new Attraction("Waterpark", "Beach Resort");
        Attraction a2 = new Attraction("Climbing", "City");
        Attraction a3 = new Attraction("Hiking", "Mountain");
        Attraction a4 = new Attraction("Castle", "Mountain");
        Attraction a5 = new Attraction("Amusment park", "Beach Resort");

        TouristicPackage p1 = new TouristicPackage("Package 1", 101, 599);
        p1.addAtraction(a5);
        p1.addAtraction(a3);

        TouristicPackage p2 = new TouristicPackage("Package 2", 102, 779);
        p2.addAtraction(a1);
        p2.addAtraction(a4);
        p2.addAtraction(a3);

        TouristicPackage p3 = new TouristicPackage("Package 3", 103, 359);
        p3.addAtraction(a2);
        p3.addAtraction(a5);

        TouristicPackage p4 = new TouristicPackage("Package 4", 104, 999);
        p4.addAtraction(a4);
        p4.addAtraction(a3);
        p4.addAtraction(a1);

        TouristicPackage p5 = new TouristicPackage("Package 5", 105, 1099);
        p5.addAtraction(a5);
        p5.addAtraction(a2);

        TouristicPackage p6 = new TouristicPackage("Package 6", 106, 649);
        p6.addAtraction(a3);
        p6.addAtraction(a4);

        TouristicPackage p7 = new TouristicPackage("Package 7", 107, 879);
        p7.addAtraction(a3);
        p7.addAtraction(a1);

        TouristicPackage p8 = new TouristicPackage("Package 8", 108, 329);
        p8.addAtraction(a2);
        p8.addAtraction(a4);

        TouristicPackage p9 = new TouristicPackage("Package 9", 109, 199);
        p9.addAtraction(a1);
        p9.addAtraction(a3);

        TouristicPackage p10 = new TouristicPackage("Package 10", 110, 399);
        p10.addAtraction(a5);
        p10.addAtraction(a3);

        LinkedList<TouristicPackage> packages = new LinkedList<TouristicPackage>();
        packages.add(p1);
        packages.add(p2);
        packages.add(p3);
        packages.add(p4);
        packages.add(p5);
        packages.add(p6);
        packages.add(p7);
        packages.add(p8);
        packages.add(p9);
        packages.add(p10);

        Integer counterAtt1 = 0;
        Integer counterAtt2 = 0;
        Integer counterAtt3 = 0;
        Integer counterAtt4 = 0;
        Integer counterAtt5 = 0;

        for(TouristicPackage tp : packages)
        {
            if(tp.getAttractions().contains(a1)) counterAtt1++;
            if(tp.getAttractions().contains(a2)) counterAtt2++;
            if(tp.getAttractions().contains(a3)) counterAtt3++;
            if(tp.getAttractions().contains(a4)) counterAtt4++;
            if(tp.getAttractions().contains(a5)) counterAtt5++;
        }

        Map<Attraction, Integer> att = new HashMap<Attraction, Integer>();
        att.put(a1, counterAtt1);
        att.put(a2, counterAtt2);
        att.put(a3, counterAtt3);
        att.put(a4, counterAtt4);
        att.put(a5, counterAtt5);

        double relPopularity1 = counterAtt1/packages.size();
        double relPopularity2 = counterAtt2/packages.size();
        double relPopularity3 = counterAtt3/packages.size();
        double relPopularity4 = counterAtt4/packages.size();
        double relPopularity5 = counterAtt5/packages.size();

        System.out.println(counterAtt1);
        System.out.println(counterAtt2);
        System.out.println(counterAtt3);
        System.out.println(counterAtt4);
        System.out.println(counterAtt5);
        System.out.println(relPopularity1);
        System.out.println(relPopularity2);
        System.out.println(relPopularity3);
        System.out.println(relPopularity4);
        System.out.println(relPopularity5);

    }
}

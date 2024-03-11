import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class WeatherTest
{
    public static double convert(int tempF)
    {
        return (tempF - 32)/1.8;
    }

    public static void main(String[] args)
    {
        ArrayList<String> weatherList = new ArrayList<String>();
        String currentLine;
        int noOfLines = 0;
        try
        {
            File file = new File("weather.txt");
            Scanner scan = new Scanner(file);
            Scanner inputScan = new Scanner(System.in);

            while(scan.hasNextLine()) {
                weatherList.add(scan.nextLine());
                currentLine = weatherList.get(noOfLines);
                currentLine = currentLine.replaceAll("\\s+", ",");
                weatherList.set(noOfLines, currentLine);
                noOfLines++;
            }

            Weather[] weatherArray = new Weather[noOfLines];

            for(int i = 0; i < noOfLines; i++)
            {
                String line = weatherList.get(i);
                String[] parts = line.split(",");
                weatherArray[i] = new Weather(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]),
                        Integer.parseInt(parts[5]), Integer.parseInt(parts[6]));
            }

            for(int j = 1950; j <= 2001; j++)
            {
                int prec = 0, snow = 0, noOfEntries = 0;
                for(int i = 0; i < noOfLines; i++)
                {
                    if(j == weatherArray[i].getYear())
                    {
                        prec += weatherArray[i].getPrec();
                        snow += weatherArray[i].getSnow();
                        noOfEntries++;
                    }
                }10
                int avgPrec = prec / noOfEntries, avgSnow = snow / noOfEntries;
                System.out.println("Avg snow and precipitation for year " + j + " is " + avgSnow + ", " + avgPrec);
            }

            int month = inputScan.nextInt();
            int year = inputScan.nextInt();
            int highest = 0, lowest = 100;

            for(int i = 0; i < noOfLines; i++)
            {
                if(month == weatherArray[i].getMonth() && year == weatherArray[i].getYear())
                {
                    if(weatherArray[i].getHighTemp() > highest) highest = weatherArray[i].getHighTemp();
                    if(weatherArray[i].getLowTemp() < lowest) lowest = weatherArray[i].getLowTemp();
                }
                else
                {
                    System.out.println("Not good"); 
                }
            }

            System.out.println("For month " + month + " and year " + year + " the highest temperature is " + convert(highest) +
                    " and the lowest is " + convert(lowest));

            scan.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
import java.io.File;
import java.util.Scanner;

public class TestShop
{
    public static void main(String[] args)
    {
        try
        {
            File monitor = new File("Monitoare.txt");
            File videoCard = new File("PlaciVideo.txt");
            Scanner scanMonitor = new Scanner(monitor);
            Scanner scanVideoCard = new Scanner(videoCard);

            HardwareProduct[] products = new HardwareProduct[8];
            int noOfProducts = 0;

            while(scanMonitor.hasNextLine())
            {
                double currentPrice = scanMonitor.nextDouble();
                double score = scanMonitor.nextDouble();

                products[noOfProducts] = new Monitor(currentPrice, score);
                noOfProducts++;
            }

            while(scanVideoCard.hasNextLine())
            {
                double currentPrice = scanVideoCard.nextDouble();
                double score = scanVideoCard.nextDouble();

                products[noOfProducts] = new VideoCard(currentPrice, score);
                noOfProducts++;
            }

            for(int i = 0; i < noOfProducts; i++) 
            {
                products[i].computePerformance();
                products[i].computePriceInLei();
                System.out.println(products[i]);
            }

            scanMonitor.close();
            scanVideoCard.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
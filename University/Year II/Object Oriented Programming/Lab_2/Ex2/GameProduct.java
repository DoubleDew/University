import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GameProduct extends SoftwareProduct
{
    public GameProduct(String n, String p)
    {
        super(n,p);
    }

    @Override
    public boolean CheckCompatibility()
    {
        if(this.getPlatform().equalsIgnoreCase("Windows"))
        {
            System.out.println("OK");
            return true;
        }
        else
        {
            System.out.println("Not OK");
            return false;
        }
    }

    public void store(String file) throws FileNotFoundException
    {
        FileOutputStream outputFile = new FileOutputStream("input.txt");
        OutputStreamWriter outputStream = new OutputStreamWriter(outputFile);
        PrintWriter pw = new PrintWriter(outputStream);
        pw.println(this.toString());
    }

    public void read(String file) throws IOException
    {
        FileInputStream inputFile = new FileInputStream("input.text");
        InputStreamReader read = new InputStreamReader(inputFile);
        BufferedReader br = new BufferedReader(reader);
        String sCurrentLine = "";
        while((sCurrentLine = br.readLine()) != null) 
            System.out.println(sCurrentLine);
    }

    @Override
    public int compareTo(SoftwareProduct sp)
    {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER  = 1;

        if(this == sp) 
            return EQUAL;

        if(super.getPlatform(.compareTo(sp.getPlatform()) != EQUAL)
            return super.getPlatform().compareTo(sp.getPlatform());

        if(this.getName().length() < sp.getName().length()) 
            return BEFORE;

        if(this.getName().length() > sp.getName().length()) 
            return AFTER;    
    }
}

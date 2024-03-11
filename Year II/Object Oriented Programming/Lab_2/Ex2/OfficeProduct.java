import java.io.*;

import main.java.Storable;

public class OfficeProduct extends SoftwareProduct{

    public OfficeProduct(String n, String p)
    {
        super(n, p);
    }

    public boolean checkCompatibility()
    {
        if(this.getPlatform().equalsIgnoreCase("Bimbows"))
        {
            System.out.println("Compatible");
            return true;
        } 
        else 
        {
            System.out.println("Not compatible");
            return false;
        }
    } 
    
    public void store(String file) throws FileNotFoundException
    {
        FileOutputStream outputFile = new FileOutputStream("in.txt");
        OutputStreamWriter outputStream = new OutputStreamWriter(outputFile);
        PrintWriter pw = new PrintWriter(outputStream);
        pw.println(this.toString());
    }

    public void read(String file) throws IOException
    {
        FileInputStream inputFile = new FileInputStream("in.txt");
        InputStreamReader reader = new InputStreamReader(inputFile);
        BufferedReader br = new BufferedReader(reader);
        String sCurrentLine = "";
        while((sCurrentLine = br.readLine()) != null) System.out.println(sCurrentLine);
    }

    @Override
    public int compareTo(SoftwareProduct sp) 
    {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if(this == sp) return EQUAL;

        if(super.getPlatform().compareTo(sp.getPlatform()) != EQUAL) return super.getPlatform().compareTo(sp.getPlatform());
        
        if(this.getName().length() < sp.getName().length()) return BEFORE;
        if(this.getName().length() > sp.getName().length()) return AFTER;

        return 0;
    }
}
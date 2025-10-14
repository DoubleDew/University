import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class GameProduct extends SoftwareProduct{
    public GameProduct(String name, String platform){
        super(name, platform);
    }

    @Override
    public boolean checkCompatibility(){
        if(this.getPlatform().equalsIgnoreCase("Windows")){
            System.out.println(this.getName() + " is compatible with Windows \n");
            return true;
        }
        else{
            System.out.println(this.getName() + " is not compatible with Windows \n");
            return false;
        }
    }

    @Override
    public void store(String file) throws FileNotFoundException {
        FileOutputStream outputFile = new FileOutputStream(file);
        OutputStreamWriter outputStream = new OutputStreamWriter(outputFile);
        PrintWriter pw = new PrintWriter(outputStream);
        pw.println("My game: " + this.toString());
        pw.close();
    }

    @Override
    public void read(String file) throws IOException{
        FileInputStream inputFile = null;
        try{
            inputFile = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(inputFile);
            BufferedReader br = new BufferedReader(reader);
            String sCurrentLine = "";
            while((sCurrentLine = br.readLine()) != null){
                System.out.println(sCurrentLine);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(SoftwareProduct sp){
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if(this == sp){
            return EQUAL;
        }
        if(super.getPlatform().compareTo(sp.getPlatform()) != EQUAL){
            return super.getPlatform().compareTo(sp.getPlatform());
        }
        if(this.getName().length() < sp.getName().length()){
            return BEFORE;
        }
        if(this.getName().length() > sp.getName().length()){
            return AFTER;
        }
        return EQUAL;
    }
}

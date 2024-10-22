import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class DebitCard extends Card{
    public DebitCard(String IBAN, int amount){
        super(IBAN, amount);
    }

    @Override
    public void withdraw(int sum){
        if(this.getAmount() >= sum ){
            System.out.println("Succes!");
            this.setAmount(this.getAmount() - sum);
        }
        else {
            System.out.println("Error!");
        }
    }

    @Override
    public void store(String file) throws FileNotFoundException{
        FileOutputStream outputFile = new FileOutputStream(file);
        OutputStreamWriter outputStream = new OutputStreamWriter(outputFile);
        PrintWriter pw = new PrintWriter(outputStream);
        pw.println(this.toString());
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
    public int compareTo(Card c){
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if(this == c){
            return EQUAL;
        }
        if(super.getIBAN().compareTo(c.getIBAN()) != EQUAL){
            return super.getIBAN().compareTo(c.getIBAN());
        }
        if(super.getAmount() < c.getAmount()){
            return BEFORE;
        }
        if(super.getAmount() > c.getAmount()){
            return AFTER;
        }
        return EQUAL;
    }
}

//import java.util.*;

public class Computer
{
    private int RAM;
    private String CPU;

    public Computer(int ram, String cpu) throws Exception
    {
        this.RAM = ram;
        this.CPU = cpu;
        
        if(ram != 2 && ram != 4 && ram !=8)
            throw new Exception("Bad value for RAM");
        if(!cpu.equalsIgnoreCase("i3") && !cpu.equalsIgnoreCase("i5") && !cpu.equalsIgnoreCase("i7"))
            throw new Exception("Bad CPU");
    }

    public int getRAM() { return RAM; }
    public void setRAM(int ram) { this.RAM = ram; }

    public String getCPU() { return CPU; }
    public void setCPU(String cpu) { this.CPU = cpu; }
}
public class Computer {
    private int RAM;
    private String CPU;

    public Computer(int ram, String cpu) throws Exception{
        this.RAM = ram;
        this.CPU = cpu;

        if(ram != 2 && ram != 4 && ram != 8)
            throw new Exception("Invalid RAM \n");
        if(!cpu.equalsIgnoreCase("i3") && !cpu.equalsIgnoreCase("i5") && !cpu.equalsIgnoreCase("i7"))
            throw new Exception("Invalid CPU \n");
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }
}

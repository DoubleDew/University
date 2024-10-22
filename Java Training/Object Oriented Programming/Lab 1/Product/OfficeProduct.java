public class OfficeProduct extends SoftwareProduct{
    public OfficeProduct(String name, String platform){
        super(name, platform);
    }

    @Override
    public boolean checkCompatibility(){
        if(this.getPlatform().equalsIgnoreCase("Windows") || this.getPlatform().equalsIgnoreCase("MacOS")){
            System.out.println(this.getName() + " is compatible with Windows and MacOS \n");
            return true;
        }
        else{
            System.out.println(this.getName() + " is not compatible with Windows and MacOS \n");
            return false;
        }
    }
    
}

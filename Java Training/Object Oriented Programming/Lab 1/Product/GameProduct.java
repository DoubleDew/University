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
}

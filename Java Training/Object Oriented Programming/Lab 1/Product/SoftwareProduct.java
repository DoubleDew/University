public abstract class SoftwareProduct {
    private String name;
    private String platform;

    public SoftwareProduct(String name, String platform){
        this.name = name;
        this.platform = platform;
    }

    public abstract boolean checkCompatibility();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}

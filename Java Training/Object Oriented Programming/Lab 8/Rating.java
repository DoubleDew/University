public class Rating {
    private int noStars;
    private String description;
    

    public Rating(int noStars, String description) {
        if(noStars <= 5 && noStars >= 0)
            this.noStars = noStars;
        this.description = description;
    }

    public int getNoStars() {
        return noStars;
    }

    public void setNoStars(int noStars) {
        this.noStars = noStars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

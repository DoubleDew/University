class Movie extends Video
{
    private String director;
    private double rating;

    public Movie(String t, String d, double r) 
    {
        super(t);
        this.director = d;
        this.rating = r;
    }

    public Movie(String t, int l, String d, double r)
    {
        super(t, l);
        this.director = d;
        this.rating = r;
    }

    @Override
    public void show()
    {
        super.show();
        System.out.println("Director: " + this.director + ", rating: " + this.director);
    }
}
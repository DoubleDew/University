class MovieTest
{
    public static void main(String args[])
    {
        Video video = new Video("Fast and furious", 120);
        Movie movie = new Movie("Star Wars", 120, "George Lucas", 10);
        
        video.show();
        System.out.println();
        movie.show();
    }
}
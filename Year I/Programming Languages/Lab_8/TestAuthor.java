public class TestAuthor
{
    public static void main(String[] args)
    {
        Author anAuthor= new Author("Author", "Author@upb.ro", 'm');
        anAuthor.getName();
        anAuthor.getEmail();
        anAuthor.getGender();
        System.out.println(anAuthor.toString());
        anAuthor.setEmail("Author@fils.ro");
        System.out.println(anAuthor.toString());
    }
}
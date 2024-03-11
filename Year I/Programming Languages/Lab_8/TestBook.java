public class TestBook
{
    public static void main(String[] args) 
    {
        Author anAuthor = new Author("Student", "student@upb.ro", 'm');
        Book book = new Book("Java for dummies", anAuthor, 19.95, 1000);
        Book anotherBook = new Book("C for dummies", new Author("Teacher", "teacher@upb.ro",'a'), 29.95, 999);
        System.out.println(book.toString());
        System.out.println(anotherBook.toString());
        System.out.println(book.getName());
        System.out.println(anotherBook.getName());
        System.out.println(book.getAuthorName());
        System.out.println(book.getAuthorGender());
        System.out.println(book.getAuthorEmail());
        System.out.println(anotherBook.getAuthorEmail());
        System.out.println(anotherBook.getAuthorName());
        System.out.println(anotherBook.getAuthorGender());
    }
}
import java.util.StringTokenizer;

public class BubbleSort
{
    public static void main(String [] args) 
	{
        String s = "john, bobby, tom, alexander, michael, gabriel, andrew, charles, dan, corey";
        StringTokenizer words = new StringTokenizer(s, ",");
        int count = words.countTokens();
        String str[] = new String[count];
        int k=0;
        while (words.hasMoreTokens()) 
		{
            str[k] = words.nextToken();
            str[k] = str[k].trim();
            k++;
        }
        String temp;
        System.out.println("Strings in sorted order: ");
        for (int j = 0; j < str.length; j++)
		{
            for (int i = j + 1; i < str.length; i++)
			{
                if (str[i].compareTo(str[j]) < 0) 
				{
                    temp = str[j];
                    str[j] = str[i];
                    str[i] = temp;
                }
			}
		System.out.println(str[j]);
		}
    }
}
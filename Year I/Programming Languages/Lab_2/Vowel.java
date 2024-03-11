public class Vowel
{
	public static void main(String[] args)
	{
		int numa=0, nume=0, numi=0, numo=0, numu=0, i;
        String s="i am first year student now";
        for(i=0;i<s.length();i++)
        {
			char t=s.charAt(i);
			switch(t)
			{
				case 'a':numa=numa+1;break;
				case 'e':nume=nume+1;break;
				case 'i':numi=numi+1;break;
				case 'o':numo=numo+1;break;
				case 'u':numu=numu+1;break;

          }
        }
		System.out.println("The letter a appears " + numa + " times");
		System.out.println("The letter e appears " + nume + " times");
		System.out.println("The letter i appears " + numi + " times");
		System.out.println("The letter o appears " + numo + " times");
		System.out.println("The letter u appears " + numu + " times");
	}	
}
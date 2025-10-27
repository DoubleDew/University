package advanced;

public class ex3 {
    public static String reverseVowels(String s){
        char[] chars = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            while(left < right && vowels.indexOf(chars[left]) == -1){
                left++;
            }

            while(left < right && vowels.indexOf(chars[right]) == -1){
                right--;
            }

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        String result = new String(chars);
        return result;
    }

    public static void main(String[] args){
        System.out.println(reverseVowels("IceCreAm"));
        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels("dAnUt"));
    }
}

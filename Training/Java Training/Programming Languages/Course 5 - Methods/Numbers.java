public class Numbers {
    private static int square(int x){
        return x * x;
    }
    
    public static int factorial(int n){
        //recursive function
        if (n == 0)
            return 1;
        else
            return n * factorial(n-1);
        
    }

    public static int fibonacci(int n){
        if (n < 2)
            return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int gcd(int a, int b){
        if (b == 0)
            return a;
        else {
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("a % b = " + a % b);
            System.out.println();
            return gcd(b, a % b);
        }
    }

    public static void main(String args[]){
        for(int i = 0; i <= 10; i++){
            System.out.println(i + " squared = " + square(i));
            System.out.println(i + " factorial = " + factorial(i));
            System.out.println(i + "th term of fibonacci = " + fibonacci(i));
            System.out.println();
        }

        System.out.println("The greatest common divisor of the inputs is " + gcd(14, 21));
    }
}

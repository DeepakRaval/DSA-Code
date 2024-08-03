package recursion;

public class RecursionMain {
    public static void main(String[] args) {
        System.out.println("Recursion Demo !");
        int i = new RecursionMain().m1(10);
        System.out.println(i);
        System.out.println("Factorial : "+factorial(4));
    }

    public static int factorial(int n){
        if(n == 1) return n;
        return n * factorial(n -1);
    }

    public int m1(int n){
        System.out.println("m1");
        n+=1;
        System.out.println(n);
        return m2(n + 1)  + 1;
    }
    public int m2(int n){
        System.out.println("m2");
        n+=1;
        System.out.println(n);
        return m3(n + 1) +1;
    }
    public int m3(int n){
        System.out.println("m3");
        n+=1;
        System.out.println(n);
        return m4(n+1) + 1;
    }
    public int m4(int n){
        System.out.println("m4");
        n+=1;
        System.out.println(n);
        return n + 1;
    }

}

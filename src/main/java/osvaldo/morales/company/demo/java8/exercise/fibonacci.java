package osvaldo.morales.company.demo.java8.exercise;

    public class fibonacci {
        // The formula is
        //, creating the sequence: 1, 1, 2, 3, 5, 8, 13
        public static void main(String args[]){

            System.out.println(fibonacci(9));
        }

        public static int fibonacci(int n) {

            if(n==1 || n==2)
                return 1;
            int n1=1,n2=1;
            int fib=0;
            for (int i=3;i<=n; i++){
                fib=n1+n2;
                n1=n2;
                n2=fib;
            }
            return fib;
        }


   // public static int fibo()
}

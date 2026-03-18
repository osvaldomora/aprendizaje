package osvaldo.morales.company.demo.exercise;

    public class fibonacci {
        public static void main(String args[]){

            System.out.println(fibonacci(9));
        }

        public static int fibonacci(int n) {

            if(n==1 || n==2)
                return 1;
            int n1=1,n2=1;
            int prev=0;
            for (int i=3;i<=n; i++){
                prev=n1+n2;
                n1=n2;
                n2=prev;
            }
            return prev;
        }


   // public static int fibo()
}

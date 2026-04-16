package osvaldo.morales.company.demo.java8.generalexercice;

public class PairSum {
    public static void main(String args[]){
        Integer[] array= new Integer[]{7,1,9,2,11};
        Integer[] array2={1,3};

        System.out.println();
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]+array[j]==9){
                    System.out.printf("%d"+"+"+"%d"+"=%d",array[i],array[j],array[i]+array[j]);
                }

            }

        }

    }
}

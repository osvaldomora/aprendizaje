package osvaldo.morales.company.demo.java8.exercise.matriz;

import java.util.Arrays;
import java.util.stream.Stream;

public class Matriz {
    public static void main(String args[]) {
        //Find the sum of all elements in a matrix
      //  int[][] mz= new int[2][3];
       // mz[0][0]=1;
        System.out.println("Find the sum of all elements in a matrix");
        int[][] m1 = {{1,2,3},{4,6,7}};
   int sum=0;
        for(int i=0;i< m1.length;i++){
            for(int j=0;j< m1[i].length;j++){
              sum+=m1[i][j];
            }
        }
        System.out.println(sum);
sum=0;
        for(int[] row: m1){
            for(int value:row){
                sum+=value;
            }
        }
        System.out.println(sum);


        //using collections

        System.out.println("Print the main diagonal");//falle no lo pude resolver ***
        int m2[][]={ {1, 2, 3},
                     {4, 5, 6},
                     {7, 8, 9}};
        // 00 01 02,
        // 10 11 12,
        // 20 21 22
/*
        int k=0;
        for(int i=0;i<m2.length;i++){
            for(int j=0;j<m2[i].length;j++){
                System.out.println(m2[j][j+1]);
            }
        }*/
        for (int i = 0; i < m2.length; i++) {
            System.out.println(m2[i][i]);}

         System.out.println("Transpose rows to columns");
        int m3[][]={ {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int m3f[][]= new int[m3[0].length][m3.length];

        for(int i=0;i< m3.length;i++){
            for(int j=0;j<m3[i].length;j++){
                m3f[j][i]=m3[i][j];
            }
        }
        for(int i=0;i< m3f.length;i++){
            for(int j=0;j<m3f[i].length;j++){
                System.out.print(m3f[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("4. Find max element");
        int m4[][]={ {1, 20, 3},
                {4, 5, 60},
                {7, 8, 9}};

        int  max=m4[0][0];
        for(int i=0;i< m4.length;i++){
            for(int j=0;j<m4[i].length;j++){
                if(max<m4[i][j]){
                    max=m4[i][j];
                }
            }
        }
        System.out.println(max);

        int count=0;
        System.out.println("Count even numbers");
        for(int i=0;i< m4.length;i++){
            for(int j=0;j<m4[i].length;j++){
                if(m4[i][j]%2==0){
                   count++;
                }
            }
        }        System.out.println(count);

        count=0;
        for (int[] row : m4) {
            for (int num : row) {
                if (num % 2 == 0) count++;
            }
        }        System.out.println(count);

        System.out.println("Print matrix in spiral order");
        int matrix[][]={
                {1, 20, 3},
                {4, 5, 60},
                {7, 8, 9}};

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++)
                System.out.print(matrix[top][i] + " ");
            top++;

            for (int i = top; i <= bottom; i++)
                System.out.print(matrix[i][right] + " ");
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    System.out.print(matrix[bottom][i] + " ");
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    System.out.print(matrix[i][left] + " ");
                left++;
            }
        }


        System.out.println("7. Matrix multiplication");
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};

        int [][] res = new int[a.length][b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < b.length; k++) {
                   // res[i][j] += a[i][k] * b[k][j];
                    res[i][j] = res[i][j] + a[i][k] * b[k][j];
                }
            }
        }








        /*


        int[][] mati= {{1,2,3},{4,5},{6}};

        for(int i=0;i<mati.length;i++){
            for(int j=0;j<mati[i].length;j++){
                System.out.println(mati[i][j]);
            }
        }

        for (int[] fila : mati) { // Extrae cada fila como un arreglo individual
            for (int valor : fila) {         // Recorre cada número dentro de esa fila
                System.out.print(valor + " ");
            }
            System.out.println();
        }*/
    }
}

public class MatrixMultiplication {
    public static void main(String[] args) {
        int matrix1[][]={
            {2,3,1},
            {4,0,2},
            {3,1,5}};
        int matrix2[][]={
            {1,2,0},
            {4,1,3},
            {4,2,1}};
 

        // {2,3,1}, {1,2,0},
        // {4,0,2}, {4,1,3},
        // {3,1,5}};{4,2,1}};' 
         

       int answer[][]=new int[3][3];
       int sum=0;
       for (int K = 0; K <3; K++) {

        for(int i=0;i<3;i++){
            for (int j = 0; j < 3; j++) {
                sum+= matrix1[i][j]*matrix2[j][i];
            }
        }
        answer[K][K]=sum;
        sum=0;
       }

       for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            System.out.print(answer[i][j]+"   ");
        }
        System.out.println("\n");
        
       }


    }
}

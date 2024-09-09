import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        //impoet input
        Scanner sc = new Scanner(System.in);
        //input int
        int N = sc.nextInt();
        int NStart = 1;
        int spaceStart = N;
        sc.close();
        //check odd
        if(N % 2 == 1){
            //row1 (*)
            for(int i = 0 ;i < N ;i++){
                
                //space
                for(int k = 0; k < spaceStart ; k++){
                    System.out.print(" ");
                }
                // colum (*)
                for(int j = 0; j < N+1 ; j++){
                    System.out.print("*");
                }
                //next line lopp 1
                System.out.println();
            }
            spaceStart--;

         }
        //else{
        //     return 0;
        // }

    }
    
}

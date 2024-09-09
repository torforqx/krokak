import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Lab5_2_899{
    public static void main(String[] args){
        LCS a = new LCS();
        a.compute();
        a.back();
    }
}
class LCS{
    private String[] arrx;
    private String[] arry;
    private int [][] ans;
    public LCS(){
        Scanner input = new Scanner(System.in);
        System.out.println("Insert Lenght of first Array");
        int lengthx = input.nextInt();
        arrx = new String[lengthx];
        input.nextLine();
        for(int i = 0;i<lengthx;i++){
            System.out.println("Insert Member "+ (i+1) +" of first Array");
            String a = input.nextLine();
            arrx[i] = a;
        }
        System.out.println(Arrays.toString(arrx));

        System.out.println("Insert Lenght of Second Array");
        int lengthy = input.nextInt();
        arry = new String[lengthy];
        input.nextLine();
        for(int j = 0;j<lengthy;j++){
            System.out.println("Insert Member "+ (j+1) +" of Second Array");
            String b = input.nextLine();
            arry[j] = b;
        }
        System.out.println(Arrays.toString(arry));

        ans = new int[lengthx+1][lengthy+1];
        for(int i = 0;i<lengthy;i++){
            ans[0][i] = 0;
        }
        for(int j = 1;j<lengthx;j++){
            ans[j][0] = 0;
        }
        input.close();
    }
    public void compute(){
        for(int i=1;i<ans.length;i++){
            for(int j =1;j<ans[0].length;j++){
                if(arrx[i-1].equals(arry[j-1])){
                    ans[i][j] = ans[i-1][j-1]+1;
                }
                else{
                    ans[i][j] = (ans[i][j-1]>ans[i-1][j])?ans[i][j-1]:ans[i-1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(ans));
    }
    public void back(){
        Stack final_ans = new Stack<String>();
        int curx = ans.length;
        int cury = ans[0].length;
        while(curx!=0||cury!=0){
                if(ans[curx][cury-1]==ans[curx][cury]){
                    cury-=1;
                }
                else if(ans[curx-1][cury]==ans[curx][cury]){
                    curx-=1;
                }
                else{
                    curx-=1;
                    cury-=1;
                }
                if(arrx[curx].equals(arry[cury])){
                    final_ans.push(arrx[curx]);
                }
        }
        System.out.println(Arrays.toString(final_ans.toArray()));
    }
}
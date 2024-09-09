import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Lab2_899{
    public static void main(String[] args){
        int [] arr = {12,89,32,75, 16, 45, 39, 86, 23, 89};
        BinaryTree bt = new BinaryTree();
        System.out.println(Arrays.toString(bt.MaxMin(arr,arr.length)));
        //--------------------------------------------------//
        quick_sort q = new quick_sort(arr);
    }
}

class BinaryTree{
    public int[] MaxMin(int [] arr,int n){
        int [] ans = new int[2];
        if(n==2){
            if(arr[0]>arr[1]){
                ans[0]=arr[0];
                ans[1]=arr[1];
                return ans;
            }
            else{
                ans[0]=arr[1];
                ans[1]=arr[0];
                return ans;
            }
        }
        else{
            int m = arr.length/2;
            int [] ans2 = new int[2];  
            ans = MaxMin(cutarr(arr,0,m-1),n/2);
            ans2 = MaxMin(cutarr(arr,m,arr.length-1),n/2);
            if(ans[0]<ans2[0]){
                ans[0] = ans2[0];
            }
            if(ans[1]>ans2[1]){
                ans[1] = ans2[1];
            }
            return ans;
        }
    }
    
    private int[] cutarr(int [] arr,int start,int end){
        List<Integer> newarr = new ArrayList<>();
        for(int i = start;i<=end;i++){
            newarr.add(arr[i]);
        }
        int [] ans = new int[newarr.size()];
        ans = newarr.stream().mapToInt(i -> i).toArray();
        return ans;
    }
}

class quick_sort{
    int [] arrq;
    public quick_sort(int [] arr){
        System.out.println("What size of Array:");
        Scanner input = new Scanner(System.in);
        int round = input.nextInt();
        arrq = new int[round];
        for(int i = 0;i<round;i++){
            System.out.println("Enter Number:");
            arrq[i] = input.nextInt();
        }
        // arrq = arr;
        quicksort(arrq,0,arrq.length-1);
        System.out.println(Arrays.toString(arrq));
    }

    private void quicksort(int [] arr,int i,int j){
        if(i<j){
            int p = j;
            int k = partition(arr,i,p);
            quicksort(arr,i,k-1);
            quicksort(arr,k+1,j);
        }
    }

    private int partition(int [] arr,int m,int p){
        int i = m;
        int t = arr[m];
        // System.out.println(t);
        while(i<=p){
            do{
                i = i+1;
            }
            while(arr[i]<t);
            do{
                p = p-1;
            }
            while(arr[p]>t);
            if(i<p){
                swap(arr,i,p);
                // System.out.println(Arrays.toString(arr));
            }
            else{
                swap(arr,m,p);
                // System.out.println(Arrays.toString(arr));
            }
        }
        return p;
    }
    private void swap(int[] arr,int start,int end){
        int s = arr[start];
        arr[start] = arr[end];
        arr[end] = s;
    }
}
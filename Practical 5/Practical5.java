import java.util.Arrays;

public class Practical5 {

    //find the factorial using for loop
    int factorial1(int n){
        int f=1;
        for(int i=1;i<=n;i++){
            f*=i;
        }
        return f;
    }

    //find the factorial using while loop
    int factorial(int n){
        int f=1,i=1;
        while(i<=n){
            f*=i;
            i++;
        }
        return f;
    }

    //find the factorial using recursion
    int factorial2(int n){
        if(n==1){
            return 1;
        }
        return n*factorial2(n-1);
    }

    //this method will calculate the sum of array elements by removing last element
    int arraySum(int arr[]){
        if(arr.length==0){
            return 0;
        }
        int sum=arr[arr.length-1];
        int ar[]=Arrays.copyOfRange(arr, 0, arr.length-1);
        return sum+arraySum(ar);
    }

    //this method will calculate the sum of array elements by removing first element
    int arraySum1(int arr[]){
        final int i=arr.length;
        if(arr.length==0){
            return 0;
        }
        int sum=arr[0];
        int ar[]=Arrays.copyOfRange(arr, arr.length-i+1, arr.length);
        return sum+arraySum(ar);
    }

    //this method uses the external static variable as a method do not allow 
    //declaration of static varibale inside it
    //without using copyOfRange() method
    static int sum=0;
    static int len=0;
    static void arraySum2(int arr[]){
        
        if(len>=arr.length){
            return;
        }
        sum+=arr[len];
        len++;
        arraySum2(arr);
    }
    
    public static void main(String[] args) {
        int arr[]={1,2,2,2,2,3,4,4,4,3};
        Practical5 p=new Practical5();
        System.out.println(p.arraySum1(arr));
    }
}

package Lab_01;

public class lab01 {
    public static int[] copyArray(int[] arr, int l){
        int []x=new int[l];
        for(int i=0; i<l; i++){
            x[i]=arr[i];
        }
        return x;
    }
    public static void printArray(int[]ar){
        for(int i=0; i<ar.length; i++){
            System.out.print(ar[i]+" ");
        }
        System.out.println();
    }
    public static void printReverse(int[] ar){
        for(int i=ar.length-1; i>=0; i--){
            System.out.print(ar[i]+" ");
        }
        System.out.println();
    }
    public static void reverseArray(int[] ar){
        for(int i=0, j=ar.length-1; i<ar.length/2; i++, j--){
            int temp= ar[i];
            ar[i]=ar[j];
            ar[j]=temp;
        }
    }
    public static void shiftLeft(int[] ar, int x){
        for(int i=0; i<x; i++){
            int j=0;
            while(j<ar.length-1){
                ar[j]=ar[j+1];
                j++;
            }
            ar[ar.length-1]=0;
        }
    }
    public static void rotateLeft(int[] ar, int x){
        for(int i=0; i<x; i++){
            int temp=ar[0];
            int j=0;
            while(j<ar.length-1){
                ar[j]=ar[j+1];
                j++;
            }
            ar[ar.length-1]=temp;
        }
    }
    public static void shiftRight(int ar[], int x){
        for(int i=0; i<x; i++){
            int j=ar.length-1;
            while(j>0){
                ar[j]=ar[j-1];
                j--;
            }
            ar[0]=0;
        }
    }
    public static void rotateRight(int ar[], int x){
        for(int i=0; i<x; i++){
            int temp=ar[ar.length-1];
            int j=ar.length-1;
            while(j>0){
                ar[j]=ar[j-1];
                j--;
            }
            ar[0]=temp;
        }
    }
    public static boolean insert(int[] ar, int size, int elem, int index){
        boolean x=false;
        if(index<size){
            int [] n=new int[size+1];
            for(int i=0; i<=index; i++){
                if(i==index){
                    n[i]=elem;
                }
                else{
                    n[i]=ar[i];
                }
            }
            for(int i=index+1; i<n.length; i++){
                n[i]=ar[i-1];
            }
            x=true;
        }
        return x;
    }
    public static boolean removeAll(int[] ar, int elem, int index){
        boolean y= false;
        int in=0;
        for(int i=0; i<ar.length; i++){
            if(ar[i]==elem){
                in=i;
                y=true;
                break;
            }
        }
        if(y){
            int i=index;
            while(i<ar.length-1){
                ar[i]=ar[i+1];
                i++;
            }
        }
        return y;
    }
    public static void main(String [] args){
        int[] a={2, 8, 5, 6, 9};
        int[] b=copyArray(a, a.length);
        //printArray(b);
        //printReverse(a);
        reverseArray(a);
        printArray(a);

    }
}


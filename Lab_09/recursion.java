package Lab_09;
import java.lang.Math;
public class recursion {
    int i=0;
    String s="";
    Node head;
    int count=0;
    public int fact(int n){
        if(n==0){
            return 1;
        }else{
            return n*fact(n-1);
        }
    }
    public int fib(int n){
        if(n<=1){
            return n;
        }else{
            return fib((n-1))+fib((n-2));
        }
    }
    public void printAll(int[]a){
        if(i<a.length){
            System.out.println(a[i]);
            i++;
            printAll(a);
        }
    }
    public String intToBinary(int n){
        if(n==0){
            //s="1"+s;
        }else{
            int a=n%2;
            if(a==1){
                s="1"+s;
            }else{
                s="0"+s;
            }
            intToBinary(n/2);
        }
        return s;
    }
    public int power(int m, int n){
        if(n==0) {
            return 1;
        }else{
            n--;
            return m*power(m, n);
        }
    }
    public int add(Node h){
        if(h!=null){
            return h.val+add(h.next);
        }else{
            return 0;
        }
    }
    public void revPrint(Node h, int size){
        int sz=size;
        if(sz!=0){
            Node n=h;
            int i=1;
            while(i<sz){
                n=n.next;
                i++;
            }
            System.out.println(n.val);
            //count++;
            sz=sz-1;
            revPrint(h, sz);
        }

    }



//    public void revPrint(Node h, int size){
//        Node n=h;
//        int i=0;
//        while(i<size-1){
//            n=n.next;
//            i++;
//        }
//        System.out.println(n.val);
//        if(n==h){
//            System.out.println(h.val);
//        }
//        size=size-1;
//        revPrint(h, size);
//    }
}

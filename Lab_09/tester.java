package Lab_09;

public class tester {
    public static void main(String[] args) {
        recursion r=new recursion();
        int a=5;
        //System.out.println(r.fact(a));
        //System.out.println(r.fib(a));
        int[] n={1, 2, 3, 4, 5};
        //r.printAll(n);
        r.i=0;
        //System.out.println(r.power(2,3));
        //System.out.println(r.intToBinary(15));
        Node n1=new Node(10, null);
        Node n2=new Node(20, null);
        n1.next=n2;
        Node n3=new Node(30, null);
        n2.next=n3;
        //System.out.println(r.add(n1));
        r.revPrint(n1,3);
    }
}

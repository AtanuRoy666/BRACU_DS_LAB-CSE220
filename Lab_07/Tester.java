package Lab_07;

import static java.lang.System.out;
import static java.lang.System.*;
/**
 *
 * @author Arif
 */
public class Tester {
    public static void main(String[] args){
        Queue nus=new ListQueue();
        try{
            out.println("\n ////TEST01////");
            out.println(nus);
            nus.enqueue(10);
            out.println(nus);
            nus.enqueue(20);
            nus.enqueue(30);
            nus.enqueue(40);
            nus.enqueue(50);
            out.println(nus);
            //nus.enqueue(60);

            out.println("\n ////TEST02////");
            out.println(nus.dequeue());
            out.println(nus);
            out.println(nus.dequeue());
            out.println(nus);
            /*
            nus.dequeue();
            out.println(nus);
            nus.dequeue();
            out.println(nus);
            nus.dequeue();
            out.println(nus);
            */

            out.println("\n ////TEST03////");
            out.println(nus.peek());

            out.println("\n ////TEST04////");
            Object[] array=nus.toArray();

            for(Object v:array)
                out.print(v+" ");
            out.println();


            out.println("\n ////TEST05////");
            out.println("30 was found in "+nus.search(30));
            out.println("10 was found in "+nus.search(10));
        }
        catch(Exception e){
            out.println(e);
        }
    }
}







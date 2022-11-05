package Lab_06;

public class ListStack implements Stack{
    int size;
    Node top;


    public ListStack(){
        size = 0;
        top = null;
    }
    public int size(){
        return size;
    }
    public void push(Object e){
        Node n=new Node(e, null);
        //System.out.println(e);
        try{
            if(top!=null){
                n.next=top;
                top=n;
                size++;
            }else{
                top=n;
                size++;
            }
        }catch (Exception x){

        }
    }
    public Object pop() throws StackUnderflowException{
        if(top!=null){
            Object x=top.val;
            top.val=null;
            top=top.next;
            size--;
            return x;
        }else{
            throw new StackUnderflowException();
        }

    }
    public Object peek() throws StackUnderflowException{
        Object x=null;
        if(top!=null){
            x=top.val;
        }else{
            throw new StackUnderflowException();
        }
        return x;
    }
    public boolean isEmpty(){

        if(top==null){
            return true;
        }else{
            return false;
        }
    }
    public String toString(){
        Node h=top;
        String f="";
        while(h!=null){
            Object x=h.val;
            f=f+x;
            h=h.next;
        }
        String fin="["+f+"]";
        return fin;
    }
    public Object[] toArray(){
        Object[]a=new Object[size];
        Node h=top;
        for(int i=0; i<a.length; i++){
            a[i]=h.val;
            if(h.next!=null){
                h=h.next;
            }
        }
        return a;
    }
    public int search(Object e){
        int count=0;
        boolean flag=false;
        Node h=top;
        while(h!=null){
            Object x=h.val;
            if(e.equals(x)){
                flag=true;
                break;
            }else{
                count++;
                h=h.next;
            }
        }
        if(flag){
            return count;
        }
        else{
            return -1;
        }
    }
    public boolean parenthesisCheck(String s, java.util.Stack st){
        boolean flag=true;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{'|| s.charAt(i)=='['){
                st.push(s.charAt(i));
            }else if(s.charAt(i)==')' || s.charAt(i)=='}'|| s.charAt(i)==']'){
                char c1= s.charAt(i);
                char c2=(char)st.pop();
                if((c1==')' && c2=='(') ||((c1=='}' && c2=='{') || (c1==']' && c2=='['))){

                }else{
                    flag=false;
                    break;
                }
            }
        }
        if(flag){
            if(!st.empty()){
                flag=false;
            }
        }
        return flag;
    }

}

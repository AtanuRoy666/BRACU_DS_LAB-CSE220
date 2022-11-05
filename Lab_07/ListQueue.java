package Lab_07;

public class ListQueue implements Queue{
    public Node f;
    public Node r;
    public int size;

    public ListQueue(){
        f=r=null;
        size=0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
    }
    public void enqueue(Object obj) {
        Node n=new Node(obj, null);
        if(size==0){
            f=r=n;

        }else{
            r.next=n;
            r=n;
        }
        size++;
    }
    public Object dequeue() throws QueueUnderflowException{
        if(size==0){
            throw new QueueUnderflowException();
        }else{
            Object ob=f.val;
            Node x=f.next;
            f.val=null;
            f.next=null;
            f=null;
            f=x;
            size--;
            return ob;
        }
    }
    public Object peek() throws QueueUnderflowException{
        if(size==0){
            throw new QueueUnderflowException();
        }else{
            return f.val;
        }
    }
    public String toString(){
        String s="[ ";
        if(f!=null){
            Node h=f;
            while(h!=null){
                s=s+h.val+" ";
                h=h.next;
            }
        }
        s=s+"]";
        return s;
    }
    public Object[] toArray(){
        if(size!=0){
            Object[] ob=new Object[size];
            Node h=f;
            for(int i=0; i<size; i++){
                ob[i]=h.val;
                h=h.next;
            }
            return ob;
        }else{
            return null;
        }
    }
    public int search(Object obj){
        int count=0;
        boolean flag=false;
        Node h=f;
        while(h!=null){
            if(obj.equals(h.val)){
                flag=true;
                break;
            }else{
                count++;
                h=h.next;
            }
        }
        if(flag){
            return count;
        }else{
            return -1;
        }
    }

}

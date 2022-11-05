package Lab_07;

public class ArrayQueue implements Queue{
    public Object[] cir;
    public int f;
    public int r;
    public int size;

    public ArrayQueue(){
        cir=new Object[10];
        f=r=-1;
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
    public void enqueue(Object obj) throws QueueOverflowException{
        if(size==cir.length){
            throw new QueueOverflowException();
        }else{
            if(f==-1){
                f=r=0;
                cir[f]=obj;
                size++;
            }else{
                int x=(r+1)%cir.length;
                cir[x]=obj;
                r=x;
                size++;
            }
        }
    }
    public Object dequeue() throws QueueUnderflowException{
        if(size==0){
            throw new QueueUnderflowException();
        }else{
            Object x=cir[f];
            cir[f]=null;
            f=(f+1)%cir.length;
            size--;
            return x;
        }
    }
    public Object peek() throws QueueUnderflowException{
        if(size==0){
            throw new QueueUnderflowException();
        }else{
            return cir[f];
        }
    }
    public String toString(){
        String s="[ ";
        int st=f;
        if(!isEmpty()){
            for(int i=0; i<size; i++){
                s=s+cir[st]+" ";
                st=(st+1)%cir.length;
            }
        }
        s=s+"]";
        return s;
    }
    public Object[] toArray(){
        Object[] ob=new Object[size];
        for(int i=0, j=f; i<ob.length; i++, j=(j+1)%cir.length){
            ob[i]=cir[j];
        }
        return ob;
    }
    public int search(Object obj){
        int count=0;
        boolean flag=false;
        int st=f;
        for(int i=0; i<size; i++){
            if(obj.equals(cir[st])){
                flag=true;
                break;
            }else{
                st=(st+1)%cir.length;
                count++;
            }
        }
        if(flag){
            return count;
        }else{
            return -1;
        }
    }

}

package Lab_04;

public class LinkedList{
    public Node head;


    /* First Constructor:
     * Creates a linked list using the values from the given array. head will refer
     * to the Node that contains the element from a[0]
     */
    public LinkedList(Object [] a){
        Node n0=new Node(a[0], null);
        head=n0;
        Node tail=n0;
        for(int i=1; i<a.length; i++){
            Node n=new Node(a[i], null);
            tail.next=n;
            tail=n;
        }
    }

    /* Second Constructor:
     * Sets the value of head. head will refer
     * to the given LinkedList
     */
    public LinkedList(Node h){
        head=h;
    }

    /* Counts the number of Nodes in the list */
    public int countNode(){
        Node h=head;
        int count=0;
        while(h!=null){
            count++;
            h=h.next;
        }
        return count; // please remove this line!
    }

    /* prints the elements in the list */
    public void printList(){
        Node h=head;
        int lim=countNode();
        for(int i=0; i<lim; i++){
            System.out.print(h.element+" ");
            h=h.next;
        }
        System.out.println();
    }

    // returns the reference of the Node at the given index. For invalid index return null.
    public Node nodeAt(int idx){
        //Node target=head;
        Node h=head;
        if(idx>countNode()-1 || idx<0){
            h=null;
        }else{
            for(int i=0; i<idx; i++){
                h=h.next;
            }
        }
        return h; // please remove this line!
    }


    // returns the element of the Node at the given index. For invalid idx return null.
    public Object get(int idx){

        Node h=nodeAt(idx);
        return h.element;
    }



    /* updates the element of the Node at the given index.
     * Returns the old element that was replaced. For invalid index return null.
     * parameter: index, new element
     */
    public Object set(int idx, Object elem){
        Node h=nodeAt(idx);
        if(h==null){
            return null;
        }else{
            Object old=h.element;
            h.element=elem;
            return old;
        }
        //return null; // please remove this line!
    }


    /* returns the index of the Node containing the given element.
     if the element does not exist in the List, return -1.
     */
    public int indexOf(Object elem){
        int count=0;
        boolean test=false;
        Node h=head;
        while(h!=null){
            if(h.element.equals(elem)){
                test=true;
                break;
            }
            else{
                count++;
                h=h.next;
            }
        }
        if(test){
            return count;
        }else{
            return -1;
        }

    }

    // returns true if the element exists in the List, return false otherwise.
    public boolean contains(Object elem){
        boolean test=false;
        int x= indexOf(elem);
        if(x!=-1){
            test=true;
        }
        return test; // please remove this line!
    }

    // Makes a duplicate copy of the given List. Returns the reference of the duplicate list.
    public Node copyList(){
        LinkedList L=new LinkedList(head);
        return L.head;
    }

    // Makes a reversed copy of the given List. Returns the head reference of the reversed list.
    public Node reverseList(){
        Object[] oj=new Object[countNode()];
        Node h=head;
        for(int i=oj.length-1; i>=0; i--){
            oj[i]=h.element;
            h=h.next;
        }
        LinkedList L=new LinkedList(oj);
        return L.head; // please remove this line!
    }

    /* inserts Node containing the given element at the given index
     * Check validity of index.
     */
    public void insert(Object elem, int idx){
        Node n=new Node(elem, null);
        Node h=head;
        Node prev=null;
        if(idx>=0 && idx<countNode()){
            if(idx==0){
                n.next=head;
                head=n;
            }else{
                for(int i=0; i<idx-1; i++){
                    h=h.next;
                }
                Node t=h.next;
                n.next=t;
                h.next=n;
            }
        }else if(idx==countNode()){
            while(h.next!=null){
                h=h.next;
            }
            h.next=n;
        }

    }


    /* removes Node at the given index. returns element of the removed node.
     * Check validity of index. return null if index is invalid.
     */
    public Object remove(int index){
        Object old = null;

        if(index>=0 && index<countNode()){
            if(index==0){
                old=head.element;
                Node del=head;
                head=head.next;
                del.next=null;
                del=null;
            }else{
                Node h=head;
                for(int i=0; i<index-1; i++){
                    h=h.next;
                }
                old=h.next.element;
                Node del=h.next;
                Node t=del.next;
                h.next=t;
                del.next=null;
                del=null;
            }

        }


        return old; // please remove this line!
    }

    // Rotates the list to the left by 1 position.
    public void rotateLeft(){
        // TO DO
    }

    // Rotates the list to the right by 1 position.
    public void rotateRight(){
        // TO DO
    }

}

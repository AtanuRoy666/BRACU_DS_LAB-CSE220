package Lab_02;

public class CircularArray {

    private int start;
    private int size;
    private Object[] cir;

    /*
     * if Object [] lin = {10, 20, 30, 40, null}
     * then, CircularArray(lin, 2, 4) will generate
     * Object [] cir = {40, null, 10, 20, 30}
     */
    public CircularArray(Object[] lin, int st, int sz) {
        start = st;
        size = sz;
        cir = new Object[lin.length];
        int str = st;
        for (int i = 0; i < size; i++) {
            cir[str] = lin[i];
            str++;
            //System.out.println(str);
            if (str >= lin.length) {
                str = 0;
            }
        }
    }

    //Prints from index --> 0 to cir.length-1
    public void printFullLinear() {
        for (int i = 0; i < cir.length; i++) {
            //if(cir[i]!=null){
            System.out.print(cir[i] + " ");
            //}
        }
        System.out.println();
    }

    // Starts Printing from index start. Prints a total of size elements
    public void printForward() {
        int str = start;
        for (int i = 0; i < size; i++) {
            System.out.print(cir[str] + " ");
            str++;
            if (str >= cir.length) {
                str = 0;
            }
        }
        System.out.println();
    }

    public void printBackward() {
        int last=(start+size-1)%cir.length;
        for(int i=0; i<size; i++){
            System.out.print(cir[last]+" ");
            last--;
            if(last<0){
                last=cir.length-1;
            }
        }
        System.out.println();
    }

    // With no null cells
    public void linearize() {
        Object[] aba=new Object[size];
        int st=start;
        for (int i = 0; i < size; i++) {

            if(cir[st]!=null){
                aba[i]=cir[st];
            }
            st++;
            if(st>=cir.length){
                st=0;
            }

        }
        cir=aba;
    }

    // Do not change the Start index
    public void resizeStartUnchanged(int newcapacity) {
        Object aba[]=new Object[newcapacity];
        int st1=start, st2=start;

        for(int i=0; i<size; i++){
            aba[st1]=cir[st2];
            st1++;
            st2++;
            if(st1>=aba.length){
                st1=0;
            }
            if(st2>=cir.length){
                st2=0;
            }
        }
        cir=aba;
    }

    // Start index becomes zero
    public void resizeByLinearize(int newcapacity) {
        Object aba[]=new Object[newcapacity];
        int st2=start;

        for(int i=0; i<=size; i++){
            aba[i]=cir[st2];

            st2++;

            if(st2>=cir.length){
                st2=0;
            }
        }
        cir=aba;
    }

    /* pos --> position relative to start. Valid range of pos--> 0 to size.
     * Increase array length by 3 if size==cir.length
     * use resizeStartUnchanged() for resizing.
     */
    public void insertByRightShift(Object elem, int pos) {
        if(size==cir.length){
            resizeStartUnchanged(3+cir.length);
        }
        //System.out.println(cir.length);

        int from=(start+size-1)%cir.length;

        for(int i=from; i>=pos+start; i--){
            if(i<0){
                i=cir.length-1;
            }
            int to=(i+1)%cir.length;
            cir[to]=cir[i];
        }
        //System.out.println(start+pos);
        cir[(start+pos)]=elem;
        size++;
    }

    public void insertByLeftShift(Object elem, int pos) {
        if(size==cir.length){
            resizeStartUnchanged(3+cir.length);
        }
        int from=start;
        //int to=(from-1);
        int nshift=size-pos;
        for(int i=from; i<=pos+start; i++){
            i=i%cir.length;
            int to=(i-1);
            if(to<0){
                to=cir.length-1;
            }
            cir[to]=cir[i];
        }
        cir[start+pos]=elem;
        size++;
        start--;
        //System.out.println(size);
    }

    /* parameter--> pos. pos --> position relative to start.
     * Valid range of pos--> 0 to size-1
     */
    public void removeByLeftShift(int pos) {
        int to=(start+pos)%cir.length;
        int from=(to+1)%cir.length;
        while(from!=start){
            cir[to]=cir[from];
            to=(to+1)%cir.length;
            from=(from+1)%cir.length;
        }
        size--;
    }

    /* parameter--> pos. pos --> position relative to start.
     * Valid range of pos--> 0 to size-1
     */
    public void removeByRightShift(int pos) {
        int to=(start+pos)%cir.length;
//        int from=to-1;
//        if(from<0){
//            from=cir.length-1;
//        }
        while(to!=start){
            int from=to-1;
            if(from<0){
                from=cir.length-1;
            }
            cir[to]=cir[from];
            to--;
            if(to<0){
                to=cir.length-1;
            }
        }
        cir[start]=null;
        start++;
        size--;
    }


    //This method will check whether the array is palindrome or not
    public void palindromeCheck() {
        boolean check=true;
        for(int i=start, j=(start+size-1)%cir.length; i<size; i++, j--){
            i=i%cir.length;
            if(j<0){
                j=cir.length-1;
            }

            if(cir[i]!=cir[j]){
                check=false;
                break;
            }
        }
        if(check){
            System.out.println("This array is a palindrome");
        }
        else{
            System.out.println("This array is not a palindrome");
        }
    }

    //This method will sort the values by keeping the start unchanged
    public void sort() {
        int s=start;
        for(int i=0; i<size; i++){
            //i=i%cir.length;
            Object x=cir[s];
            int n=s;
            int en=(s+1)%cir.length;
            for(int j=(i+1);j<size; j++){

                if((int)x>(int)cir[en]){
                    n=en;
                    x=cir[en];
                }
                en=(en+1)%cir.length;
            }
            Object temp=cir[s];
            cir[s]=cir[n];
            cir[n]=temp;
            s=(s+1)%cir.length;
        }
    }

    //This method will check the given array across the base array and if they are equivalent interms of values return true, or else return false
    public boolean equivalent(CircularArray k) {
        boolean check=true;
        if(this.size==k.size){
            for(int i=this.start, j=k.start; i<size; i++, j++){
                i=i%cir.length;
                j=j%k.cir.length;
                if(!(cir[i].equals(k.cir[j]))){
                    check=false;
                    break;
                }
            }
        }
        else{
            System.out.println("Eshob keno koro bhai....size mile nai toh");
        }

        return check;
    }
}
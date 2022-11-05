package Lab_06;

public class parenCheck {
    public boolean parenthesisCheck(String s, Stack st){
        boolean flag=false;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{'|| s.charAt(i)=='['){
                //st.push(s.charAt(i));
            }
        }
        return flag;
    }
}

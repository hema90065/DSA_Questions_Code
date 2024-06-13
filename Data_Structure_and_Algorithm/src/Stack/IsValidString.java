package Stack;

import java.util.Stack;

public class IsValidString {
    public static  boolean isValid(String str){ // TC = O(N)
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char  ch = str.charAt(i);

            // Opening
            if(ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            } else {
                //closing
              if(s.isEmpty()){
                  return  false;
              }
              if((s.peek() == '(' && ch == ')')
                      || (s.peek() == '[' && ch == ']')
                      || (s.peek() == '{' && ch == '}')){
                  s.pop();
              } else {
                  return false;
              }
            }
        }

        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            //Closing
            if(ch ==')'){
                int count = 0;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }

                if(count<1){
                    return true;
                } else {
                    s.pop();
                }
            } else {
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String args[]){
       // String str = "{([])}";
        String str = "((a+b))";
        System.out.print(isDuplicate(str));
    }
}

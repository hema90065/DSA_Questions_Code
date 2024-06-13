package String;

public class ValidPalindrom {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder b = new StringBuilder();

        for (int i=0; i<s.length(); i++){
            if(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))){
                b.append(s.charAt(i));
            }
        }
        int start = 0;
        int end = b.length()-1;
        while(start < end){
            if(b.charAt(start++) != b.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}

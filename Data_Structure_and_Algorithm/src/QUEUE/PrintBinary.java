package QUEUE;
import java.util.LinkedList;
import java.util.Queue;

public class PrintBinary {
    public static void generatePrintBinary(int n){
        Queue<String> q = new LinkedList<>();
        q.add("1");

        while (n-->0){
            String s1 = q.peek();
            q.remove();
            System.out.print(s1 + " ");
            String s2 = s1;
            q.add(s1+"0");
            q.add(s2 + "1");
        }
    }
    public static void main(String str[]){
        int n = 10;
        generatePrintBinary(n);
    }
}

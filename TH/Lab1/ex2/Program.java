
import  vn.edu.tdtu.ArrayOutput;
import  vn.edu.tdtu.ArrayHandler;
public class Program {
    public static void main(String[] args) {
//        a
        int a[] = {12,2,34,5,6};
        int b[] = {7,1,8,9,22};
//        b
        ArrayOutput.print(a);
        ArrayOutput.print(b);
//        c
        int c[] = ArrayHandler.merge(a,b);
        ArrayHandler.sort(c);
        ArrayOutput.write(c,"output.txt");



    }
}
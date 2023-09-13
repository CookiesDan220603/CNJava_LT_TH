import vn.edu.tdtu.ArrayOutput;
import vn.edu.tdtu.ArrayHandler;
public class Program {
    public static void main(String[] args) {
        int a[] = {4,3,5,6,7};
        ArrayOutput.print(a);
        int b[] = {4,5,8,9};
        int c[] = ArrayHandler.merge(a, b);
        ArrayOutput.print(c);
        ArrayHandler.sort(c);
        ArrayOutput.print(c);
        ArrayOutput.write(c, "output.txt");
    }
}
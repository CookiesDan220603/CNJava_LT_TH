package lab01_51900821.ex02;

import vn.edu.tdtu.ArrayHandler;
import vn.edu.tdtu.ArrayOutput;

public class Program {
    public static void main(String[] args) {
        int[] a = {12, 2, 34, 5, 6};
        int[] b = {13, 27, 89, 3, 99};

        ArrayOutput.print(a);
        ArrayOutput.print(b);

        int[] c = ArrayHandler.merge(a, b);
        ArrayOutput.print(c);

        ArrayHandler.sort(c);
        ArrayOutput.print(c);

        ArrayOutput.write(c, "output.txt");
    }
}

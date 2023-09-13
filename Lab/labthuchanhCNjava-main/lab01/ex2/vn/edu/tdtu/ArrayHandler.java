package vn.edu.tdtu;

public class ArrayHandler {
    public static void sort(int arr[])
    {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++)
        {
            for (int j = i + 1; j < len; j++)
            {
                if (arr[i] > arr[j])
                {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    public static int[] merge(int a[], int b[])
    {
        int c[] = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++)
        {
            c[i] = a[i];
        }
        for (int i = 0; i < b.length; i++)
        {
            c[a.length + i] = b[i];
        }
        return c;
    }
}
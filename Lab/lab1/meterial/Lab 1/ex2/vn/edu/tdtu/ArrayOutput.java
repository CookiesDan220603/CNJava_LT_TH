package vn.edu.tdtu;

import java.io.PrintWriter;
import java.io.File;

public class ArrayOutput {
    

    public static void print(int arr[])
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void write(int arr[], String fileName)
    {
        try {
            PrintWriter writer = new PrintWriter(new File(fileName));
            for (int i = 0; i < arr.length; i++)
            {
                writer.print(arr[i] + " ");
            }
            writer.flush();
            writer.close();
        }catch (Exception e) 
        {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
        
    }


}
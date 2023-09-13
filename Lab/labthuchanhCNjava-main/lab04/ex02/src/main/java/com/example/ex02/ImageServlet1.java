package com.example.ex02;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

@WebServlet(name = "ImageServlet1", value = "/ImageServlet1")
public class ImageServlet1 extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpg");
        ServletOutputStream out;
        out = response.getOutputStream();
        URL res = getClass().getClassLoader().getResource("image1.jpg");
        File file;
        try {
            assert res != null;
            file = Paths.get(res.toURI()).toFile();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        String absolutePath = file.getAbsolutePath();
        FileInputStream fin = new FileInputStream(absolutePath);
        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(out);

        int ch;
        while((ch=bin.read())!=-1)
        {
            // display image
            bout.write(ch);
        }
        bin.close();
        fin.close();
        bout.close();
        out.close();
}
    public void destroy() {
    }
}


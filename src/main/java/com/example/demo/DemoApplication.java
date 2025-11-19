package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.io.*;
import java.nio.charset.StandardCharsets;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println(1111);
        testFileInputStream();
        testFileWriter();

        SpringApplication.run(DemoApplication.class, args);
    }

    private static void testFileInputStream() {
        try{
            FileInputStream fileInputStream = new FileInputStream("practice.txt");
            int i =0;
            while ((i = fileInputStream.read()) != -1) {
                System.out.print((char) i);
            }
            fileInputStream.close();

        }catch (Exception e) {
            System.out.println("testFileInputStream : " + e);
        }


// 예시 1: UTF-8 인코딩 사용
//        try (
//
//            FileInputStream fileInputStream = new FileInputStream("practice.txt");
//            InputStream is = fileInputStream;
//             InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8); // 명시적 인코딩 지정
//             BufferedReader br = new BufferedReader(isr)) {
//
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private static void testFileWriter(){
        try{
            String filename = "practice.txt";
            FileWriter fileWriter = new FileWriter(filename);
            System.out.println("fileWriter :::" + fileWriter );

            String str = "test file writer";
            fileWriter.write(str);
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

package com.example.mypackage;
import java.io.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
File file = new File("data.txt");
    public static void main(String[] args)  throws IOException {

       addUser("Marcin", 30);
        addUser("Kuba", 25);
        addUser("Tom", 40);
        addUser("Anna", 26);
        deleteUser("Tom");
       // deleteUser("Anna 26");
    }

    public static void addUser(String name, int age)  throws IOException{

        try (FileWriter f = new FileWriter("data.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);) {
            p.println(name+" "+age);
        }
        catch (IOException i) {
            i.printStackTrace();
        }

    }

    public static void deleteUser(String name) throws IOException{

        File newFile = new File("data1.txt");
        File file = new File("data.txt");
        FileReader fr= new FileReader("data.txt");
        Scanner scan = new Scanner(fr);
        String curent;
        char[] s=new char[20];
        char[] n=new char[20];

       while (scan.hasNextLine()) {
           curent=scan.nextLine();
           s=curent.toCharArray();
           int j=0;
           while(s[j]!=' '){
               n[j]=s[j];
               j++;
           }
           String currentName=n.toString();
            if (currentName.equals(name)){
                continue;
            }

            try (FileWriter f = new FileWriter("data1.txt", true);
                 BufferedWriter b = new BufferedWriter(f);
                 PrintWriter p = new PrintWriter(b);) {
                p.println(currentName);
            }
            catch (IOException i) {
                i.printStackTrace();
            }
        }

        fr.close();
       file.delete();
       newFile.renameTo(file);

    }
}

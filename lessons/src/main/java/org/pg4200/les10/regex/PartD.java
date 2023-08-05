package org.pg4200.les10.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartD {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("^(exercise)\\s\\d*:\\r?\\n(file:)\\s(ex)\\d+.(txt|java)$", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);


        String[] strings = {"Exercise 5:\nFile: Ex05.txt", "Exercise 3:\nFile: Ex03.java", "Exercise 13:\nFile: Ex13.java", "Exercise no5:\nFile: Ex05.txt", "Exercise 5: File: Ex05.txt",
        "Exercise 5:\nFile: Ex05.pdf", "Exercise 5:\nFile: Ex05", "Exercise 5:\nFile: Ex_something05.txt"};

        for (String string : strings) {
            Matcher m = pattern.matcher(string);
            boolean matches = m.matches();
            System.out.println(matches);
        }


    }




}

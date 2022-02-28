package com.pbansal;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here.



        ArrayList<String> names = new ArrayList<String>();

        while (!(names.equals("Neha"))){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter a name: ");
            String name = scanner.next();
            names.add(name);
            System.out.println(names);
        }







    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_assignment;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author KZ
 */
public class Menu {
    String title;
    ArrayList<String> options;

    public Menu(String title) {
        this.title = title;
        options = new ArrayList<>();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void addOption(String label) {
        options.add(label);
    }

    public void display() {
        System.out.println(title);
        for (int i = 0; i < options.size(); i++) {
            System.out.printf(" [%d] %s\n", i, options.get(i));
        }
        System.out.print("Enter your choice: ");
    }

    public int getInput(Scanner in) {
        int input = in.nextInt();
        return input;
    }
}

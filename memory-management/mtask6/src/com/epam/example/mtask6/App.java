package com.epam.example.mtask6;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        
        while(true) {
            list.add(list.size(), new Object());
        }
    }
}

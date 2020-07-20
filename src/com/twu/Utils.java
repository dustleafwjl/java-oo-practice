package com.twu;

import java.util.Scanner;

public class Utils {
    static public String getDataBySystemIn(Scanner reader, String title) {
        System.out.println(title);
        return reader.next();
    }
}

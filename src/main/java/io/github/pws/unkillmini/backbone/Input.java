package io.github.pws.unkillmini.backbone;

import java.util.Scanner;

public class Input 
{
    public static String line = "";
    public static final Scanner scan = new Scanner(System.in);
    
    public static void check()
    {
        line = scan.nextLine();
    }
    
    public static boolean Is(String word)
    {
        return line.toUpperCase().equals(word.toUpperCase());
    }
    
    public static boolean Contains(String word)
    {
        return line.toUpperCase().contains(word.toUpperCase());
    }
}

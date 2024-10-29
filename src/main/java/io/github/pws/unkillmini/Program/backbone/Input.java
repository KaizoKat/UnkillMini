package io.github.pws.unkillmini.Program.backbone;

import java.util.Scanner;

public class Input 
{
    public static String line = "";
    public static final Scanner scan = new Scanner(System.in);
    
    public static void check()
    {
        line = scan.nextLine();
    }
    
    public static boolean Contains(String word)
    {
        boolean check = false;
        if(line.length() != 0)
            check = word.toUpperCase().contains(line.toUpperCase());
        
        return check;
    }
}

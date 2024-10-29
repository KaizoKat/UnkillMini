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
        for(String part : line.split(" "))
        {
            if(part.length() != 0 && word.toUpperCase().contains(part.toUpperCase()))
                return true;
        }

        
        return false;
    }
}

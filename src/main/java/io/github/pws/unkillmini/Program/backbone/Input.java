package io.github.pws.unkillmini.Program.backbone;

import java.util.Scanner;

public class Input 
{
    public static String line = "";
    public static final Scanner scan = new Scanner(System.in);
    
    public static void scan()
    {
        line = scan.nextLine();
    }
    
    public static boolean check(String word)
    {
        if(line.chars().count() >= 2)
        {
            for(String part : line.split(" "))
            {
                if(part.length() != 0 && word.toUpperCase().contains(part.toUpperCase()))
                    return true;
            }
        }
        return false;
    }
}

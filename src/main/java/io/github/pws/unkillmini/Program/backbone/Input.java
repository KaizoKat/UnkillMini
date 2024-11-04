package io.github.pws.unkillmini.Program.backbone;

import java.util.Scanner;

import java.io.IOException;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;


public class Input 
{
    public static String line = "";
    public static final Scanner scan = new Scanner(System.in);

    public interface CLibrary extends Library 
    {
        CLibrary INSTANCE = Native.load(
            Platform.isWindows() ? "msvcrt" : "c",
            CLibrary.class
        );
        int _kbhit();
        int _getch();
        int getchar();
    }

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

    public static char getPressed() 
    {
        if (CLibrary.INSTANCE._kbhit() != 0)
        {
            int key =  Platform.isWindows() ? 
            CLibrary.INSTANCE._getch() : 
            CLibrary.INSTANCE.getchar();
            return (char)key;
        }

        return (char)-1;
    }
}

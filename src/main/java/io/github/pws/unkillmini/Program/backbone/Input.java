package io.github.pws.unkillmini.Program.backbone;

import java.util.Scanner;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;


public class Input 
{
    public static String line = "";
    public static int inputKey = -1;
    public static final Scanner scan = new Scanner(System.in);

    public static final int TAB = 9;
    public static final int ENTER = 13;
    public static final int ESC= 27;
    public static final int SPACE= 32;
    public static final int UP= 72;
    public static final int LEFT= 75;
    public static final int RIGHT = 77;
    public static final int DOWN = 80;
    public static final int F1 = 59;
    public static final int F2 = 60;
    public static final int F3 = 61;
    public static final int F4 = 62;
    public static final int F5 = 63;
    public static final int F6 = 64;
    public static final int F7 = 65;
    public static final int F8 = 66;
    public static final int F9 = 67;
    public static final int F12 = 134;
    public static final int F10 = 68;
    public static final int F11 = 133;

    private static boolean pressed = false;
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

    public static void scanInput()
    {
        inputKey = assign();
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

    public static char assign() 
    {
        if (CLibrary.INSTANCE._kbhit() != 0)
        {
            int key =  Platform.isWindows() ? 
            CLibrary.INSTANCE._getch() : 
            CLibrary.INSTANCE.getchar();

            if(!pressed) pressed = true;
            return (char)key;
        }
        else if(pressed)
            pressed = false;
        return (char)-1;
    }

    public static char getPressedKey()
    {
        return (char)inputKey;
    }

    public static boolean getPressedKey(String key)
    {
        return MiniUtils.CheckCharCaseless(inputKey, (int)key.charAt(0));
    }

    public static boolean isPressed()
    {
        return pressed;
    }
}

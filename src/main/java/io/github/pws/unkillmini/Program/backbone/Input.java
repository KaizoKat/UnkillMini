package io.github.pws.unkillmini.Program.backbone;

<<<<<<< Updated upstream
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
=======
import java.util.Scanner;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
>>>>>>> Stashed changes

import io.github.pws.unkillmini.Program.rendering.Window;

public class Input 
{
<<<<<<< Updated upstream
    public static KeyStroke line;
=======
    public static String line = "";
    public static final Scanner scan = new Scanner(System.in);
    private static volatile char lastKey = '\0';

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
>>>>>>> Stashed changes

    public static void scan()
    {
        try 
        {
            line = Window.terminal.readInput();
        } 
        catch (Exception e) {}
    }

<<<<<<< Updated upstream
    public static KeyStroke getInput()
    {
        try 
        {
            return Window.terminal.pollInput();
        } 
        catch (Exception e) 
        {
            return null;
        }
    }

    public static boolean isKeyPressed(KeyType keyType)
    {
        KeyStroke key = getInput();
        return key != null && key.getKeyType() == keyType;
    }

    public static boolean isKeyPressed(KeyStroke key,KeyType keyType)
    {
        return key != null && key.getKeyType() == keyType;
=======
    public static void startInputThread() {
        Thread inputThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                if (CLibrary.INSTANCE._kbhit() != 0) {
                    lastKey = (char)(Platform.isWindows() ? 
                        CLibrary.INSTANCE._getch() : 
                        CLibrary.INSTANCE.getchar());
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        inputThread.setDaemon(true);
        inputThread.start();
    }
    
    public static char getPressed() {
        char key = lastKey;
        lastKey = '\0';
        return key;
    }

    public static boolean isPressed(int key)
    {
        return key == getPressed();
    }

    public static boolean isPressed(String key)
    {
        int pressed = getPressed();
        key = key.toUpperCase();
        boolean isPressed = switch(key)
        {
            // Action keys
            case "TAB" ->   pressed == 9;
            case "ENTER" -> pressed == 13;
            case "ESC" ->   pressed == 27;
            case "SPACE" -> pressed == 32;
            // Arrow keys
            case "UP" ->    pressed == 72;
            case "LEFT" ->  pressed == 75;
            case "RIGHT" -> pressed == 77;
            case "DOWN" ->  pressed == 80;
            // Function keys
            case "F1" ->    pressed == 59;
            case "F2" ->    pressed == 60;
            case "F3" ->    pressed == 61;
            case "F4" ->    pressed == 62;
            case "F5" ->    pressed == 63;
            case "F6" ->    pressed == 64;
            case "F7" ->    pressed == 65;
            case "F8" ->    pressed == 66;
            case "F9" ->    pressed == 67;
            case "F10" ->   pressed == 68;
            case "F11" ->   pressed == 133;
            case "F12" ->   pressed == 134;
            default ->      MiniUtils.CheckCharCaseless(pressed, (int)key.charAt(0));
        };
        return isPressed;
>>>>>>> Stashed changes
    }
}

package io.github.pws.unkillmini.Program.backbone;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import io.github.pws.unkillmini.Program.rendering.Window;

public class Input 
{
    public static KeyStroke line;

    public static void scan()
    {
        try 
        {
            line = Window.terminal.readInput();
        } 
        catch (Exception e) {}
    }

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
    }
}

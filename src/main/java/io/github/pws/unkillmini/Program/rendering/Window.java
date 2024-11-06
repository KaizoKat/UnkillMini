package io.github.pws.unkillmini.Program.rendering;

import java.io.IOException;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Window
{
    public static final int width = 120;
    public static final int height = 32;

    public static String[][] pixels;
    public static String[][] pixelsForeground;
    public static String[][] pixelsBackground;
    private static String suffix = "";

    public static Terminal terminal;

    public static final void build() {
        DefaultTerminalFactory factory = new DefaultTerminalFactory()
            .setTerminalEmulatorTitle("Your Game Title")
            .setInitialTerminalSize(new TerminalSize(width, height));
        
        try {
            terminal = factory.createTerminal();
            terminal.enterPrivateMode();
            terminal.setCursorVisible(false);
        } catch (IOException e) {
            System.exit(1);
        }
    }

    public static final int compose()
    {
        pixels = new String[height][width];
        pixelsForeground = new String[height][width];
        pixelsBackground = new String[height][width];
        
        for (int xx = 0; xx < pixels.length; xx++)
        {
            for (int yy = 0; yy < pixels[xx].length; yy++)
            {
                pixels[xx][yy] = "";
                pixelsForeground[xx][yy] = Color.rgb(255, 255, 255);
                pixelsBackground[xx][yy] = Color.rgb(0, 0, 0);
            }
        }
        return 0;
    }

    public static final void populateWithPixels(String[][] populator, int posX, int posY)
    {
        for (int xx = 0; xx < populator.length; xx++)
        {
            for (int yy = 0; yy < populator[xx].length; yy++)
            {
                pixels[posY + xx][posX + yy] = populator[xx][yy];
            }
        }
    }
    
    public static final void setPopulatorForeground(String[][] populator, int posX, int posY, String color)
    {
        for (int xx = 0; xx < populator.length; xx++)
        {
            for (int yy = 0; yy < populator[xx].length; yy++)
            {
                pixelsForeground[posY + xx][posX + yy] = color;
            }
        }
    }
    
    public static final void setPopulatorBackground(String[][] populator, int posX, int posY, String color)
    {
        for (int xx = 0; xx < populator.length; xx++)
        {
            for (int yy = 0; yy < populator[xx].length; yy++)
            {
                pixelsBackground[posY + xx][posX + yy] = color;
            }
        }
    }

    public static final void draw() 
    {
        try {
            terminal.setCursorPosition(0, 0);
            
            for (int xx = 0; xx < pixels.length; xx++) {
                for (int yy = 0; yy < pixels[xx].length; yy++) {
                    terminal.setForegroundColor(TextColor.Factory.fromString(pixelsForeground[xx][yy]));
                    terminal.setBackgroundColor(TextColor.Factory.fromString(pixelsBackground[xx][yy]));
                    // If pixel is empty, use space character
                    terminal.putString(pixels[xx][yy].isEmpty() ? " " : pixels[xx][yy]);
                }
                // Add newline at end of each row
                terminal.putCharacter('\n');
            }
            
            if (!suffix.isEmpty()) {
                terminal.putString(suffix);
            }
            terminal.flush();
            suffix = "";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clear() {
        try {
            terminal.clearScreen();
            terminal.setCursorPosition(0, 0);
            terminal.flush();
        } catch (IOException e) {
            // Clear screen failed
        }
    }
    
    public static void pause() {
        try {
            terminal.putString("Press any key to continue...\n");
            terminal.flush();
            terminal.readInput();
        } catch (IOException e) {
            // Pause operation failed
        }
    }
    public static void print(String _suffix)
    {
        suffix += "\n" + _suffix;
    }
<<<<<<< Updated upstream
=======

    public static void hideCursor() 
    {
        System.out.print("\033[?25l");
    }
    
    public static void showCursor() 
    {
        System.out.print("\033[?25h");
    }

    public static void setWindowsTitle(String title) 
    {
        try { new ProcessBuilder("cmd", "/c", "title " + title).inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {}
    }
>>>>>>> Stashed changes
}

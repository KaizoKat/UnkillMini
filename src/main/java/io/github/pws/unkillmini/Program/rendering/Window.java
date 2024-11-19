package io.github.pws.unkillmini.Program.rendering;

import java.io.IOException;

import io.github.pws.unkillmini.Program.backbone.Sprite;
import io.github.pws.unkillmini.Program.backbone.Vector2;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class Window
{
    public static final int width = 120;
    public static final int height = 32;
    public static final int extend = 4;
    public static final String apkName = "Unkill Mini";
    public static String defaultBackground = Color.rgbBG(15, 0, 3);
    public static String defaultForeground = Color.rgbFG(255, 255, 255);

    public static String[][] pixels;
    public static String[][] pixelsForeground;
    public static String[][] pixelsBackground;
    
    private static String suffix = "";
    private static Terminal terminal;
    private static Vector2 terminalSize = new Vector2();

    /**
     * Creates the Window
     */
    public static void create()
    {
        try {terminal = TerminalBuilder.builder().system(true).build();
        } catch (IOException e) { throw new RuntimeException(e);}

        setWindowsTitle(apkName);
        pixels = new String[height][width];
        pixelsForeground = new String[height][width];
        pixelsBackground = new String[height][width];
    }

    /**
     * Initializes all the 2d pixel arrays with empty strings.
     */
    public static void compose()
    {
        for (int yy = 0; yy < height; yy++)
        {
            for (int xx = 0; xx < width; xx++)
            {
                pixels[yy][xx] = "";
                pixelsForeground[yy][xx] = "";
                pixelsBackground[yy][xx] = "";
            }
        }
    }

    /**
     * A necesary function that needs to be ran at the end before drawing the pixels to the screen.
     * Sets all the remaining values of the pixel arrays to their equivalent empty chacacters.
     */
    public static void fillBlanks()
    {
        for (int yy = 0; yy < height; yy++)
        {
            for (int xx = 0; xx < width; xx++)
            {
                if(pixels[yy][xx].isEmpty()) pixels[yy][xx] = " ";
                if(pixelsForeground[yy][xx].isEmpty()) pixelsForeground[yy][xx] = defaultForeground;
                if(pixelsBackground[yy][xx].isEmpty()) pixelsBackground[yy][xx] = defaultBackground;
            }
        }
    }

    /**
     * Populates the pixel array with the populator at the position
     * @param populator the 2d array that will fill the pixel array
     * @param pos the position offset at which the pixel array will be filled at.
     */
    public static void populateWithPixels(String[][] populator, Vector2 pos)
    {
        for (int yy = 0; yy < populator.length; yy++)
        {
            for (int xx = 0; xx < populator[yy].length; xx++)
            {
                if(pos.x < 0) pos.x = 0;
                if(pos.y < 0) pos.y = 0;
                pixels[pos.y + yy][pos.x + xx] = populator[yy][xx];
            }
        }
    }

    /**
     * Populates the foreground pixel array with the populator at the position
     * @param populator the 2d array that will fill the foreground pixel array
     * @param pos the position offset at which the pixel foreground array will be filled at.
     */
    public static void populateForeground(String[][] populator, Vector2 pos, String color)
    {
        for (int yy = 0; yy < populator.length; yy++)
        {
            for (int xx = 0; xx < populator[yy].length; xx++)
            {
                if(pos.x < 0) pos.x = 0;
                if(pos.y < 0) pos.y = 0;
                pixelsForeground[pos.y + yy][pos.x + xx] = color;
            }
        }
    }

    /**
     * Populates the background pixel array with the populator at the position
     * @param populator the 2d array that will fill the background pixel array
     * @param pos the position offset at which the pixel background array will be filled at.
     */
    public static void populateBackground(String[][] populator, Vector2 pos, String color)
    {
        for (int yy = 0; yy < populator.length; yy++)
        {
            for (int xx = 0; xx < populator[yy].length; xx++)
            {
                if(pos.x < 0) pos.x = 0;
                if(pos.y < 0) pos.y = 0;
                pixelsBackground[pos.y + yy][pos.x + xx] = color;
            }
        }
    }

    /**
     * displays the created window to the terminal
     */
    public static void draw()
    {
        fillBlanks();
        fixConsoleOnResize();

        StringBuilder sb = new StringBuilder();
        System.out.print("\033[0;0H");
        String[][] suffix2D = Sprite.PopulateWith(suffix);

        for (int yy = 0; yy < height + extend; yy++)
        {
            for (int xx = 0; xx < width; xx++)
            {
                if(yy < height)
                {
                    if(pixels[yy][xx] == null) pixels[yy][xx] = "␀";
                    sb.append(pixelsForeground[yy][xx]).append(pixelsBackground[yy][xx]).append(pixels[yy][xx]);
                }
                else
                {
                    sb.append(defaultForeground).append(defaultBackground);
                    if(!suffix.isEmpty() && yy - height < suffix2D.length && xx < suffix2D[yy - height].length)
                    {
                        sb.append(suffix2D[yy - height][xx]);
                    }
                    else
                        sb.append(" ");
                }
            }
            sb.append(Color.RESET);
            
            if(yy != height + extend -1)
                sb.append("\n");
        }

        System.out.print(sb.toString());
        suffix = "";
        System.out.flush();
    }

    /**
     * copletely clears the terminal from its characters.
     */
    public static void clear()
    {
        try { new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ignored) {}
    }

    /**
     * pauses terminal execution until a key is pressed.
     */
    public static void pause()
    {
        try { new ProcessBuilder("cmd", "/c", "PAUSE").inheritIO().start().waitFor();  
        } catch (IOException | InterruptedException ignored) {}
    }

    /**
     * prints like the Syste.out.println to the botton of the screen (gets cleared next frame)
     * @param _suffix the string that will be printed
     */
    public static void print(String _suffix)
    {
        suffix += _suffix + "\n";
    }

    /**
     * hides the terminal cursor.
     */
    public static void hideCursor()
    {
        System.out.print("\033[?25l");
    }

    /**
     * shows the terminal cursor.
     */
    public static void showCursor() 
    {
        System.out.print("\033[?25h");
    }

    /**
     * shows the terminal cursor.
     */
    public static void fixConsoleOnResize()
    {
        if(terminalSize.x != terminal.getWidth() || terminalSize.y != terminal.getHeight())
            clear();

        terminalSize = new Vector2(terminal.getWidth(), terminal.getHeight());
    }

    /**
     * sets the title of the terminal (slow).
     * @param title the string the title will be set to.
     */
    public static void setWindowsTitle(String title) 
    {
        try { new ProcessBuilder("cmd", "/c", "title " + title).inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ignored) {}

    }
}

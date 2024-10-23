package io.github.pws.unkillmini.rendering;

import java.io.IOException;

public class Window
{
    public static final int width = 120;
    public static final int height = 32;

    public static String pixels[][];
    public static String pixelsColor[][];
    public static String pixelsBackground[][];
    
    public static final void compose()
    {
        pixels = new String[height][width];
        pixelsColor = new String[height][width];
        pixelsBackground = new String[height][width];
        
        for (int xx = 0; xx < pixels.length; xx++)
        {
            for (int yy = 0; yy < pixels[xx].length; yy++)
            {
                pixels[xx][yy] = "";
                pixelsColor[xx][yy] = ConsoleColors.Foreground.WHITE;
                pixelsBackground[xx][yy] = ConsoleColors.Background.BLACK;
            }
        }
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
    
    public static final void setPopulatorColor(String[][] populator, int posX, int posY, String color)
    {
        for (int xx = 0; xx < populator.length; xx++)
        {
            for (int yy = 0; yy < populator[xx].length; yy++)
            {
                pixelsColor[posY + xx][posX + yy] = color;
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
    
    public static final void print()
    {
        StringBuilder sb = new StringBuilder();
        for (int xx = 0; xx < pixels.length; xx++)
        {
            for (int yy = 0; yy < pixels[xx].length; yy++)
            {
                sb.append(pixelsColor[xx][yy]).append(pixelsBackground[xx][yy]).append(pixels[xx][yy]).append(ConsoleColors.RESET);
            }
        }
        System.out.println(sb.toString());
        System.out.flush();
    }
    
    public static void clear()
    {
        try { new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {}
    }
    
    public static void pause()
    {
        try { new ProcessBuilder("cmd", "/c", "PAUSE").inheritIO().start().waitFor();  
        } catch (IOException | InterruptedException e) {}
    }
    
    public static void refresh()
    {
        clear();
        print();
    }
}

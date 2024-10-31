package io.github.pws.unkillmini.Program.backbone;

import io.github.pws.unkillmini.Program.rendering.Window;

public class Sprite {
    
    public static String pixels;
    public static int x;
    public static int y;
    public static String background;
    public static String foregorund;
    
    public static void populate()
    {
        String[][] ray = PopulateWith(pixels);
        Window.populateWithPixels(ray, x, y);
        Window.setPopulatorBackground(ray, x, y, background);
        Window.setPopulatorForeground(ray, x, y, foregorund);
    }
    
        public static String[][] PopulateWith(String sprite)
    {
        String[] lines = sprite.split("\n");

        String[][] graphicArray = new String[lines.length][];

        for (int i = 0; i < lines.length; i++) 
        {
            graphicArray[i] = new String[lines[i].length()];
            for (int j = 0; j < lines[i].length(); j++)
            {
                graphicArray[i][j] = String.valueOf(lines[i].charAt(j));
            }
        }
        return graphicArray;
    }
}

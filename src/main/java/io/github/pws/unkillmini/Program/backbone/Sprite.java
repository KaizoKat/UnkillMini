package io.github.pws.unkillmini.Program.backbone;

import io.github.pws.unkillmini.Program.rendering.Color;
import io.github.pws.unkillmini.Program.rendering.Window;

public class Sprite {
    
    public String pixels = "";
    public int x = 0;
    public int y = 0;
    public String background = Color.rgbBG(0, 0, 0);
    public String foregorund = Color.rgbFG(255, 255, 255);
    
    public void populate()
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

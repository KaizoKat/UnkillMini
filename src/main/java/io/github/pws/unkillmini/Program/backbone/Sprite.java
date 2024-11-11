package io.github.pws.unkillmini.Program.backbone;

import io.github.pws.unkillmini.Program.rendering.Color;
import io.github.pws.unkillmini.Program.rendering.Window;

public class Sprite {
    
    public String pixels = "";
    public int x = 0;
    public int y = 0;
    public String background = Color.rgbBG(0, 0, 0);
    public String foreground = Color.rgbFG(255, 255, 255);
    
    public void populate()
    {
        String[][] ray = prepare(PopulateWith(pixels));
        Window.populateWithPixels(ray, x, y);
        Window.setPopulateBackground(ray, x, y, background);
        Window.setPopulateForeground(ray, x, y, foreground);
    }

    public final String[][] prepare(String[][] original)
    {
        String[][] modified =  new String[x < 0 ? original.length - (-1*y) : original.length][y < 0 ? original[0].length - (-1*x) : original[0].length];
        
        for (int yy = 0; yy < modified.length; yy++) 
        {
            for (int xx = 0; xx < modified[yy].length; xx++)
            {
                modified[yy][xx] = original[y < 0 ? yy + (-1*y) : yy][x < 0 ? xx + (-1*x) : xx];
            }
        }

        return modified;
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

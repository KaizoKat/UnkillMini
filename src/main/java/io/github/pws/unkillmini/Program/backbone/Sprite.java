package io.github.pws.unkillmini.Program.backbone;

import io.github.pws.unkillmini.Program.rendering.Color;
import io.github.pws.unkillmini.Program.rendering.Window;

public class Sprite {
    
    public String pixels = "";
    public Vector2 pos = new Vector2();
    public String background = Color.rgbBG(0, 0, 0);
    public String foreground = Color.rgbFG(255, 255, 255);

    /**
     * Populates the Window with the sprite
     */
    public void populate()
    {
        String[][] ray = prepare(PopulateWith(pixels));
        Window.populateWithPixels(ray, pos);
        Window.populateBackground(ray, pos, background);
        Window.populateForeground(ray, pos, foreground);
    }

    private String[][] prepare(String[][] original)
    {
        String[][] modified =  new String[pos.x < 0 ? original.length - (-1*pos.x) : original.length][];
        
        for (int yy = 0; yy < modified.length; yy++)
        {
            modified[yy] = new String[pos.y < 0 ? original[yy].length - (-1*pos.y) : original[yy].length];
            for (int xx = 0; xx < modified[yy].length; xx++)
            {
                modified[yy][xx] = original[pos.y < 0 ? yy + (-1*pos.y) : yy][pos.x < 0 ? xx + (-1*pos.x) : xx];
            }
        }

        return modified;
    }

    /**
     * Takes is a string and returns a string 2d array perfect for populating on screen
     * @param sprite the string that needs transforming
     * @return String[][] of the characters in the string.
     */
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

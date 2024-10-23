package io.github.pws.unkillmini.backbone;

public class SpriteFormatting
{
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

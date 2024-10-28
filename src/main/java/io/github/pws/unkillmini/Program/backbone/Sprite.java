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
        String[][] ray = SpriteFormatting.PopulateWith(pixels);
        Window.populateWithPixels(ray, x, y);
        Window.setPopulatorBackground(ray, x, y, background);
        Window.setPopulatorColor(ray, x, y, foregorund);
    }
}

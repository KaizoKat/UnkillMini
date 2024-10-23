/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pws.unkillmini.backbone;

import io.github.pws.unkillmini.rendering.ConsoleColors;
import io.github.pws.unkillmini.rendering.Window;

/**
 *
 * @author circi
 */
public class Sprite {
    
    public static String pixels;
    public static int x;
    public static int y;
    public static String background;
    public static String foregorund;
    
    public void populate()
    {
        String[][] ray = SpriteFormatting.PopulateWith(pixels);
        Window.populateWithPixels(ray, x, y);
        Window.setPopulatorBackground(ray, x, y, background);
        Window.setPopulatorColor(ray, x, y, foregorund);
    }
}

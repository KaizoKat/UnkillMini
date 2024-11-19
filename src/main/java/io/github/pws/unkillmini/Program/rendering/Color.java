package io.github.pws.unkillmini.Program.rendering;

import io.github.pws.unkillmini.Program.backbone.MiniUtils;
import io.github.pws.unkillmini.Program.backbone.Vector3;

public class Color {
    /**
     * A string representing ANSI reset character.
     */
    public static final String RESET = "\033[0m";

    /**
     * @return A string representing the ANSI character for the inputted rgb color, for the foreground specifically.
     */
    public static String rgbFG(int r, int g, int b) 
    {
        Vector3 col = clampClolors(r,g,b);
        return String.format("\u001B[38;2;%d;%d;%dm", col.x, col.y, col.z);
    }

    /**
     * @return A string representing the ANSI character for the inputted rgb color, for the background specifically.
     */
    public static String rgbBG(int r, int g, int b) 
    {
        Vector3 col = clampClolors(r,g,b);
        return String.format("\u001B[48;2;%d;%d;%dm", col.x, col.y, col.z);
    }

    /**
     * @return the clamped characters between 0 and 255 as a {@link Vector3}.
     */
    public static Vector3 clampClolors(int r, int g, int b)
    {
        r = MiniUtils.ClampInt(r, 0, 255);
        g = MiniUtils.ClampInt(g, 0, 255);
        b = MiniUtils.ClampInt(b, 0, 255);
        return new Vector3(r,g,b);
    }

    /**
     * @return the clamped values of the given {@link Vector3} between 0 and 255 as a Vector3.
     */
    public static Vector3 clampClolors(Vector3 color)
    {
        color.x = MiniUtils.ClampInt(color.x, 0, 255);
        color.y = MiniUtils.ClampInt(color.y, 0, 255);
        color.z = MiniUtils.ClampInt(color.z, 0, 255);
        return color;
    }
}

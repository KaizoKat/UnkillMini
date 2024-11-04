package io.github.pws.unkillmini.Program.rendering;

import com.googlecode.lanterna.TextColor;

public class Color {
    public static final String rgb(int r, int g, int b) 
    {
        return new TextColor.RGB( r, g, b).toString();
    }
}

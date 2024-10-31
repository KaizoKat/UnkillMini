package io.github.pws.unkillmini.Program.rendering;

public class Color {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset
    
    public static String rgbFG(int r, int g, int b) {
        return String.format("\u001B[38;2;%d;%d;%dm", r, g, b);
    }
    public static String rgbBG(int r, int g, int b) {
        return String.format("\u001B[48;2;%d;%d;%dm", r, g, b);
    }
}

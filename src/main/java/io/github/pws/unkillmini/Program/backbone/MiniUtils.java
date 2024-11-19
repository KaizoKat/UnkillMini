package io.github.pws.unkillmini.Program.backbone;

public class MiniUtils 
{

    /**
     * Clamps the given variable between min (inclusive) and max (exclusive).
     * @param var The variable to clamp.
     * @param min The minimun value of the variable.
     * @param max The maximum variable of the variable exclusive (max - 1).
     * @return Returns the clamped variable.
     */
    public static int ClampInt(int var, int min, int max)
    {
        if(var > max -1) 
            var = max -1;
        else if(var < min) 
            var = min;
        
        return var;
    }

    /**
     * Check if two chars independent of weaterh they are upper case or lower case are the same.
     * @param char1 Fitst character
     * @param char2 Second character
     * @return true if both are the same.
     */
    public static boolean CheckCharCaseless(int char1, int char2)
    {
        return String.valueOf((char)char1).equalsIgnoreCase(String.valueOf((char)char2));
    }
}

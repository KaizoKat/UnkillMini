package io.github.pws.unkillmini.Scripts;

public class Helpers 
{
    public static final float clampBetween(float value, float min, float max)
    {
        if (value < min)
        {
            value = min;
        } 
        else if (value > max) 
        {
            value = max;
        } 
        return value;
    }

    public static final int clampBetween(int value, int min, int max)
    {
        if (value < min)
        {
            value = min;
        } 
        else if (value > max) 
        {
            value = max;
        } 
        return value;
    }
}

package io.github.pws.unkillmini.Program.backbone;

public class FPSCounter
{
    private static int frameCount = 0;
    private static int currentFrameCount = 0;
    private static long lastFPSCheck = System.nanoTime();

    public static void countFrame()
    {
        frameCount++;
        if (System.nanoTime() - lastFPSCheck >= 1_000_000_000)
        {
            currentFrameCount = frameCount;
            frameCount = 0;
            lastFPSCheck = System.nanoTime();
        }
    }

    public static int getCurrentFrameCount()
    {
        return currentFrameCount;
    }
}

package io.github.pws.unkillmini.Program.rendering;

import io.github.pws.unkillmini.Program.backbone.ScriptableNode;
import io.github.pws.unkillmini.Scripts.Inventory;

public class UI implements ScriptableNode
{
    protected static boolean open;
    public static String[] prevFocused = new String[10];
    @Override
    public void start() 
    {
        for(int i = 0; i < 10; i++)
            if(prevFocused[i] == null)
                prevFocused[i] = "";
    }

    @Override
    public void update() {}
    
    @Override
    public void end() {}

    public static final void addNewFocus(String focus)
    {
        for(int i = 8; i >= 0; i--)
        {
            prevFocused[i+1] = prevFocused[i];
        }
        
        prevFocused[0] = focus;
        Window.print(prevFocused[0] + ", " + prevFocused[1] + ", " + prevFocused[2] + ", " + prevFocused[3] + ", " +
                     prevFocused[4] + ", " + prevFocused[5] + ", " + prevFocused[6] + ", " + prevFocused[7] + ", " +
                     prevFocused[8] + ", " + prevFocused[9]);
    }
}

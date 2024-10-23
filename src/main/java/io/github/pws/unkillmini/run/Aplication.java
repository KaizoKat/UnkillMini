package io.github.pws.unkillmini.run;

import io.github.pws.unkillmini.Scripts.Inventory;
import io.github.pws.unkillmini.Scripts.MakeBorder;
import io.github.pws.unkillmini.Scripts.MakeDisclaimer;
import io.github.pws.unkillmini.rendering.Window;

public abstract class Aplication
{
    protected static boolean run = true;
    public abstract void start();
    public abstract void update();
    public abstract void end();
    
    public static void main(String[] args)
    {
        MakeDisclaimer disclaimer = new MakeDisclaimer();
        MakeBorder border = new MakeBorder();
        Inventory inv = new Inventory();
        
        
        Window.compose();
        
        disclaimer.start();
        Window.print();
        Window.pause();
        
        border.update();
        inv.update();
        
        while(true)
        {
            if(run)
            {
                border.update();
                inv.update();
            }
            else
            {
                break;
            }
        }
    }
}

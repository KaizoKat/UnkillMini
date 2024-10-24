package io.github.pws.unkillmini.run;

import io.github.pws.unkillmini.Scripts.Help;
import io.github.pws.unkillmini.Scripts.Inventory;
import io.github.pws.unkillmini.Scripts.MakeBorder;
import io.github.pws.unkillmini.Scripts.MakeDisclaimer;
import io.github.pws.unkillmini.backbone.Input;
import io.github.pws.unkillmini.rendering.Window;
        
public abstract class Aplication
{
    protected static boolean run = true;
    public abstract void start();
    public abstract void update();
    public abstract void end();
    
    private static final MakeDisclaimer disclaimer = new MakeDisclaimer();
    private static final MakeBorder border = new MakeBorder();
    private static final Inventory inv = new Inventory();
    private static final Help help = new Help();
    
    public static void main(String[] args)
    {
        Window.compose();
        
        disclaimer.start();
        Window.print();
        
        UPDATE();
        
        while(true)
        {
            if(run)
            {
                UPDATE();
            }
            else
            {
                break;
            }
        }
    }
    
    private static void UPDATE()
    {
        Input.check();
        border.update();
        inv.update();
        help.update();
        Window.refresh();
    }
}

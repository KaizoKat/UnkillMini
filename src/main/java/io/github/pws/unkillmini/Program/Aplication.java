package io.github.pws.unkillmini.Program;

import io.github.pws.unkillmini.Scripts.Equipment;
import io.github.pws.unkillmini.Scripts.Help;
import io.github.pws.unkillmini.Scripts.Inventory;
import io.github.pws.unkillmini.Scripts.MakeBorder;
import io.github.pws.unkillmini.Scripts.MakeDisclaimer;
import io.github.pws.unkillmini.Program.rendering.Window;
        
public class Aplication
{
    public static boolean run = true;
    
    private static final MakeDisclaimer disclaimer = new MakeDisclaimer();
    private static final MakeBorder border = new MakeBorder();
    private static final Inventory inv = new Inventory();
    private static final Equipment equ = new Equipment();
    private static final Help help = new Help();
    
    public static void main(String[] args)
    {
        START();
        
        while(true)
        {
            if(run)
            {
                UPDATE();
            }
            else
            {
                END();
                break;
            }
        }
    }
    
    private static void START()
    {
<<<<<<< Updated upstream
        Window.build();
        Window.compose(); 

=======
        Input.startInputThread();
        Window.compose();
>>>>>>> Stashed changes
        disclaimer.start();
        Window.draw();
<<<<<<< Updated upstream
        Window.pause();
=======
        Window.hideCursor();
        Window.pause();
        Window.clear();
>>>>>>> Stashed changes
    }
    
    private static void UPDATE()
    {
        //Input.scan();

        border.update();
        inv.update();

        Window.draw();
    }
    
    private static void END()
    {
        try {
            Window.terminal.close();
        } catch (Exception e) {}
    }
}

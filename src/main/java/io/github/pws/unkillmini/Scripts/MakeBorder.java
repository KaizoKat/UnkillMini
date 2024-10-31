package io.github.pws.unkillmini.Scripts;

import io.github.pws.unkillmini.Program.rendering.Color;
import io.github.pws.unkillmini.Program.rendering.Window;
import io.github.pws.unkillmini.Program.backbone.ScriptableNode;
import io.github.pws.unkillmini.Program.backbone.Sprite;
public class MakeBorder implements ScriptableNode
{   
        private String border = 
    """
    ########################################################################################################################
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    ########################################################################################################################
    """;
        
    private String mask = 
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      \n"+
    "                                                                                                                      ";
    
    @Override
    public void start()
    {
    }

    @Override
    public void update()
    {
        String[][] borderRay = Sprite.PopulateWith(border);
        Window.populateWithPixels(borderRay, 0, 0);
        Window.setPopulatorBackground(borderRay, 0, 0, Color.rgbBG(126, 167, 168));
        Window.setPopulatorForeground(borderRay, 0, 0, Color.rgbFG(184, 214, 214));
        
        borderRay = Sprite.PopulateWith(mask);
        Window.setPopulatorBackground(borderRay, 1, 1, Color.rgbBG(0, 0, 0));
    }

    @Override
    public void end()
    {
    }
}


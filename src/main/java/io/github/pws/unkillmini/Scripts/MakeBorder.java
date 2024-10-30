package io.github.pws.unkillmini.Scripts;

import io.github.pws.unkillmini.Program.backbone.SpriteFormatting;
import io.github.pws.unkillmini.Program.rendering.ConsoleColors;
import io.github.pws.unkillmini.Program.rendering.Window;
import io.github.pws.unkillmini.Program.backbone.ScriptableNode;
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
        String[][] borderRay = SpriteFormatting.PopulateWith(border);
        Window.populateWithPixels(borderRay, 0, 0);
        Window.setPopulatorBackground(borderRay, 0, 0, ConsoleColors.Background.GREEN);
        Window.setPopulatorColor(borderRay, 0, 0, ConsoleColors.Foreground.BLACK);
        
        borderRay = SpriteFormatting.PopulateWith(mask);
        Window.setPopulatorBackground(borderRay, 1, 1, ConsoleColors.Background.BLACK);
    }

    @Override
    public void end()
    {
    }
}


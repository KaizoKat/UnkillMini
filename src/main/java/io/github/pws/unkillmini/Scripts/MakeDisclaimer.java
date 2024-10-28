package io.github.pws.unkillmini.Scripts;

import io.github.pws.unkillmini.Program.backbone.ScriptableNode;
import io.github.pws.unkillmini.Program.backbone.SpriteFormatting;
import io.github.pws.unkillmini.Program.rendering.ConsoleColors;
import io.github.pws.unkillmini.Program.rendering.Window;

public class MakeDisclaimer extends ScriptableNode
{   
    private String disclaimer = 
    """
    ---------------------------------#######################################################################################
    |   !!      Disclaimer     !!   |#######################################################################################
    | Resize your screen untill this|                                                                                     ##
    | line is properly aligneed.    |                                                                                     ##
    |                               |                                                                                     ##
    |   Continue?   (PRESS ENTER)   |                                                                                     ##
    ---------------------------------                                                                                     ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ##                                                                                                                    ##
    ########################################################################################################################
    ########################################################################################################################
    """;
    
    @Override
    public void start()
    {
        String[][] disclaimerStringses = SpriteFormatting.PopulateWith(disclaimer);
        Window.populateWithPixels(disclaimerStringses, 0, 0);
        Window.setPopulatorBackground(disclaimerStringses, 0, 0, ConsoleColors.Background.RED);
    }

    @Override
    public void update()
    {
    }

    @Override
    public void end()
    {
    }
}

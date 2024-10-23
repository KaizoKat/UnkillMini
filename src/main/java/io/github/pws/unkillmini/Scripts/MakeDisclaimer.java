package io.github.pws.unkillmini.Scripts;

import io.github.pws.unkillmini.backbone.SpriteFormatting;
import io.github.pws.unkillmini.rendering.ConsoleColors;
import io.github.pws.unkillmini.rendering.Window;
import io.github.pws.unkillmini.run.Aplication;
import java.io.IOException;

public class MakeDisclaimer extends Aplication
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

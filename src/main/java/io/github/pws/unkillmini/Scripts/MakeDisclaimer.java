package io.github.pws.unkillmini.Scripts;

import io.github.pws.unkillmini.Program.backbone.ScriptableNode;
import io.github.pws.unkillmini.Program.backbone.Sprite;
import io.github.pws.unkillmini.Program.rendering.Color;
import io.github.pws.unkillmini.Program.rendering.Window;

public class MakeDisclaimer implements ScriptableNode
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
        String[][] disclaimerStringses = Sprite.PopulateWith(disclaimer);
        Window.populateWithPixels(disclaimerStringses, 0, 0);
        Window.setPopulatorForeground(disclaimerStringses, 0, 0, Color.rgb(255, 255, 255));
        Window.setPopulatorBackground(disclaimerStringses, 0, 0, Color.rgb(209, 65, 65));
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

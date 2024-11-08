package io.github.pws.unkillmini.Scripts.UI;

import io.github.pws.unkillmini.Program.backbone.ScriptableNode;
import io.github.pws.unkillmini.Program.backbone.Sprite;
import io.github.pws.unkillmini.Program.rendering.Color;
import io.github.pws.unkillmini.Program.rendering.Window;

public class MakeDisclaimer implements ScriptableNode
{   
    private String disclaimer = 
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
    #                                          ---------------------------------                                           #
    #                                          |   !!      Disclaimer     !!   |                                           #
    #                                          | Resize your screen untill this|                                           #
    #                                          | line is properly aligneed.    |                                           #
    #                                          |                               |                                           #
    #                                          |   Continue?   (PRESS ENTER)   |                                           #
    #                                          ---------------------------------                                           #
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
    
    @Override
    public void start()
    {
        String[][] disclaimerStringses = Sprite.PopulateWith(disclaimer);
        Window.populateWithPixels(disclaimerStringses, 0, 0);
        Window.setPopulatorForeground(disclaimerStringses, 0, 0, Color.rgbFG(255, 255, 255));
        Window.setPopulatorBackground(disclaimerStringses, 0, 0, Color.rgbBG(209, 65, 65));
        Window.draw();
        Window.pause();
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pws.unkillmini.Scripts;

import io.github.pws.unkillmini.backbone.SpriteFormatting;
import io.github.pws.unkillmini.rendering.ConsoleColors;
import io.github.pws.unkillmini.rendering.Window;
import io.github.pws.unkillmini.run.Aplication;

/**
 *
 * @author circi
 */
public class MakeBorder extends Aplication
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


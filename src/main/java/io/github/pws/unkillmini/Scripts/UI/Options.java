package io.github.pws.unkillmini.Scripts.UI;

import io.github.pws.unkillmini.Program.Manager;
import io.github.pws.unkillmini.Program.rendering.Color;
import io.github.pws.unkillmini.Program.rendering.UI;
import io.github.pws.unkillmini.Assets.Sprites.spr_options;

public class Options extends UI
{
    private static spr_options spr = new spr_options();

    public Options()
    {
        Manager.addScript(this);
    }

    @Override
    public void start()
    {

    }

    @Override
    public void update()
    {
        spr.x = 100;
        spr.y = 28;
        spr.background = Color.rgbBG(126, 167, 168);

        if(open)
        {
            spr.pixels = spr_options.border;
            spr.foreground = Color.rgbFG(255, 255, 255);
            spr.populate();
        }
        else 
        {
            spr.pixels = spr_options.border;
            spr.foreground = Color.rgbFG(0, 0, 0);
            spr.populate();
        }
    }

    @Override
    public void end()
    {

    }
}

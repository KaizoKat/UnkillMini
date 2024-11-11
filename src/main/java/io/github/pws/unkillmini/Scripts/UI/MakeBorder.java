package io.github.pws.unkillmini.Scripts.UI;

import io.github.pws.unkillmini.Program.rendering.Color;
import io.github.pws.unkillmini.Program.rendering.Window;
import io.github.pws.unkillmini.Program.Manager;
import io.github.pws.unkillmini.Program.backbone.Script;
public class MakeBorder extends Script
{   
    private String[][] border;
    
    public MakeBorder()
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
        generateBorder(Window.width, Window.height);
        for (int xx = 0; xx < border.length; xx++) 
        {
            for (int yy = 0; yy < border[xx].length; yy++) 
            {
                if(border[xx][yy] == "#")
                {
                    Window.pixels[xx][yy] = "#";
                    Window.pixelsForeground[xx][yy] = Color.rgbFG(184, 214, 214);
                    Window.pixelsBackground[xx][yy] = Color.rgbBG(126, 167, 168);
                }
            }
        }
    }

    @Override
    public void end()
    {
    }

    public final void generateBorder(int width, int height)
    {
        border = new String[height][width];
        for (int yy = 0; yy < height; yy++)
        {
            for (int xx = 0; xx < width; xx++) 
            {
                if(yy > 0 && yy < height-1 && xx > 0 && xx < width -1)
                {
                    border[yy][xx] = " ";
                }
                else
                {
                    border[yy][xx] = "#";
                }
            }
        }
    }
}


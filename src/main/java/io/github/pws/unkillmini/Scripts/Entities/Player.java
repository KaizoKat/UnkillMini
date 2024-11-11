package io.github.pws.unkillmini.Scripts.Entities;

import io.github.pws.unkillmini.Program.Manager;
import io.github.pws.unkillmini.Program.backbone.Script;
import io.github.pws.unkillmini.Program.backbone.Sprite;
import io.github.pws.unkillmini.Program.rendering.Color;

public class Player extends Script
{
    private Sprite transform = new Sprite();
    private String pixel = "ø";

    public Player()
    {
        Manager.addScript(this);
    }
    
    @Override
    public void start() 
    {
        transform.pixels = pixel;
        transform.x = 60;
        transform.y = 12;
        transform.foreground = Color.rgbFG(255, 10, 10);
        transform.background = Color.rgbBG(200, 10, 10);
    }

    @Override
    public void update() 
    {
        transform.populate();
    }

    @Override
    public void end() 
    {
    }
    
}

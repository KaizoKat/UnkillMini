package io.github.pws.unkillmini.Scripts.Items;

import io.github.pws.unkillmini.Program.backbone.Script;
import io.github.pws.unkillmini.Program.rendering.Window;
public class Jumper implements Script
{
    @Override
    public void start()
    {
    }

    @Override
    public void update() 
    {
        Window.print("used Jumper.");
    }

    @Override
    public void end() 
    {
    }
}

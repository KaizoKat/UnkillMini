package io.github.pws.unkillmini.Scripts.Items;

import io.github.pws.unkillmini.Program.backbone.ScriptableNode;
import io.github.pws.unkillmini.Program.rendering.Window;
public class Jumper implements ScriptableNode
{
    @Override
    public void start()
    {
    }

    @Override
    public void update() 
    {
        Window.appendToSuffix("used Jumper.");
    }

    @Override
    public void end() 
    {
    }
}

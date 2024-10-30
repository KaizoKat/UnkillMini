package io.github.pws.unkillmini.Scripts.Items;

import io.github.pws.unkillmini.Program.backbone.ScriptableNode;
import io.github.pws.unkillmini.Program.rendering.Window;
public class Qween implements ScriptableNode
{
    @Override
    public void start()
    {
    }

    @Override
    public void update() 
    {
        Window.appendToSuffix("used Qween.");
    }

    @Override
    public void end() 
    {
    }
}

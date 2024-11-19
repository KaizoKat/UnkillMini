package io.github.pws.unkillmini.Scripts.Tools;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import io.github.pws.unkillmini.Application;
import io.github.pws.unkillmini.Program.Manager;
import io.github.pws.unkillmini.Program.backbone.Input;
import io.github.pws.unkillmini.Program.backbone.Script;

public class DefaultMappings extends Script
{
    public DefaultMappings()
    {
        Manager.addScript(this);
    }

    @Override
    public void start()
    {
        Application.input.addMapping(NativeKeyEvent.VC_W, "Move Forward");
        Application.input.addMapping(NativeKeyEvent.VC_S, "Move Backward");
        Application.input.addMapping(NativeKeyEvent.VC_A, "Move Left");
        Application.input.addMapping(NativeKeyEvent.VC_D, "Move Right");
        Application.input.addMapping(NativeKeyEvent.VC_SHIFT, "Sprint");

        Application.input.addMapping(NativeKeyEvent.VC_UP, "Up");
        Application.input.addMapping(NativeKeyEvent.VC_DOWN, "Down");
        Application.input.addMapping(NativeKeyEvent.VC_LEFT, "Left");
        Application.input.addMapping(NativeKeyEvent.VC_RIGHT, "Right");
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

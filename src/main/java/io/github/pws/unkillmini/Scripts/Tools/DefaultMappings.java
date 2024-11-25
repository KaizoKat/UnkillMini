package io.github.pws.unkillmini.Scripts.Tools;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import io.github.pws.unkillmini.Application;
import io.github.pws.unkillmini.Program.Manager;
import io.github.pws.unkillmini.Program.backbone.Input;
import io.github.pws.unkillmini.Program.backbone.Script;

public class DefaultMappings implements Script
{
    @Override
    public void start()
    {
        Manager.input.addMapping(NativeKeyEvent.VC_W, "Move Forward");
        Manager.input.addMapping(NativeKeyEvent.VC_S, "Move Backward");
        Manager.input.addMapping(NativeKeyEvent.VC_A, "Move Left");
        Manager.input.addMapping(NativeKeyEvent.VC_D, "Move Right");
        Manager.input.addMapping(NativeKeyEvent.VC_SHIFT, "Sprint");

        Manager.input.addMapping(NativeKeyEvent.VC_UP, "Up");
        Manager.input.addMapping(NativeKeyEvent.VC_DOWN, "Down");
        Manager.input.addMapping(NativeKeyEvent.VC_LEFT, "Left");
        Manager.input.addMapping(NativeKeyEvent.VC_RIGHT, "Right");

        Manager.input.addMapping(NativeKeyEvent.VC_P, "testP");
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

package io.github.pws.unkillmini.Program.backbone;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Input implements NativeKeyListener
{
    private final Map<String, List<Integer>> actionMappings = new HashMap<>();
    private final Map<Integer, KeyState> keyStates = new HashMap<>();
    private final Queue<InputEvent> inputQueue = new LinkedList<>();

    enum KeyState
    {
        none,
        pressed,
        held,
        released
    }

    private static class InputEvent
    {
        int keyCode;
        boolean pressed;

        InputEvent(int keyCode, boolean pressed)
        {
            this.keyCode = keyCode;
            this.pressed = pressed;
        }
    }

    public Input()
    {
        // Disable JNativeHook logging
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        logger.setUseParentHandlers(false);

        try
        {
            GlobalScreen.registerNativeHook();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(this);
    }

    /**
     * Add a mapping between a key and an action.
     * Multiple keys can be mapped to the same action.
     */
    public void addMapping(int keyCode, String action)
    {
        actionMappings.computeIfAbsent(action, k -> new ArrayList<>()).add(keyCode);
    }

    /**
     * Check if an action is held (true as long as the key is pressed).
     */
    public boolean isHeld(String action)
    {
        List<Integer> keys = actionMappings.getOrDefault(action, Collections.emptyList());
        for (int key : keys)
        {
            if (keyStates.getOrDefault(key, KeyState.none) == KeyState.held)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if an action is pressed (true once when the key is first pressed).
     */
    public boolean isPressed(String action)
    {
        List<Integer> keys = actionMappings.getOrDefault(action, Collections.emptyList());
        for (int key : keys)
        {
            if (keyStates.getOrDefault(key, KeyState.none) == KeyState.pressed)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if an action is released (true once when the key is first released).
     */
    public boolean isReleased(String action)
    {
        List<Integer> keys = actionMappings.getOrDefault(action, Collections.emptyList());
        for (int key : keys)
        {
            if (keyStates.getOrDefault(key, KeyState.none) == KeyState.released)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Process the input queue and update key states.
     */
    public void processInputQueue()
    {
        while (!inputQueue.isEmpty())
        {
            InputEvent event = inputQueue.poll();
            int keyCode = event.keyCode;

            if (event.pressed)
            {
                if (keyStates.getOrDefault(keyCode, KeyState.none) == KeyState.none)
                {
                    keyStates.put(keyCode, KeyState.pressed);
                }
                else
                {
                    keyStates.put(keyCode, KeyState.held);
                }
            }
            else
            {
                keyStates.put(keyCode, KeyState.released);
            }
        }
    }

    /**
     * Update key states at the end of the frame.
     * Transitions:
     * - pressed -> held
     * - released -> none
     */
    public void updateStates()
    {
        keyStates.replaceAll((key, state) -> {
            if (state == KeyState.pressed)
            {
                return KeyState.held;
            }
            if (state == KeyState.released)
            {
                return KeyState.none;
            }
            return state;
        });
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e)
    {
        int keyCode = e.getKeyCode();
        inputQueue.add(new InputEvent(keyCode, true));
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e)
    {
        int keyCode = e.getKeyCode();
        inputQueue.add(new InputEvent(keyCode, false));
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e)
    {
        // Unhandled
    }
}

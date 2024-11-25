package io.github.pws.unkillmini.Program.backbone;

import io.github.pws.unkillmini.Program.Manager;
import io.github.pws.unkillmini.Program.rendering.Window;

import java.util.*;

public class SceneManager
{
    private static long currentSceneID;
    private static Scene loadedScene = null;
    public static Map<Long, Scene> scenes = new HashMap<>();

    public static void startScene()
    {
        loadedScene.start();
    }

    public static void updateScene()
    {
        loadedScene.update();
    }

    public static void endScene()
    {
        loadedScene.end();
    }

    public static long getCurrentSceneID()
    {
        return currentSceneID;
    }

    public static void setCurrentSceneID(long sceneID)
    {
        currentSceneID = sceneID;
    }

    public static void killProcessOnNoLoadedScene()
    {
        if(loadedScene == null)
        {
            Window.print("Error!     No scene loaded.");
            Window.kill();
            return;
        }
    }

    public static boolean switchSceneOnCurrentChange()
    {
        if(loadedScene.getSceneID() != currentSceneID)
        {
            loadedScene = scenes.get(currentSceneID);
            return true;
        }
        return false;
    }

    public static void setLoadedScene(Scene loadedScene) {
        SceneManager.loadedScene = loadedScene;
    }

    public static Scene getLoadedScene() {
        return loadedScene;
    }
}

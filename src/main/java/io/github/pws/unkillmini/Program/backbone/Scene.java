package io.github.pws.unkillmini.Program.backbone;

import java.util.ArrayList;
import java.util.List;

public class Scene extends SceneManager
{
    private long sceneID = 0;

    public List<Script> scripts = new ArrayList<>();

    public void addScript(Script script)
    {
        this.scripts.add(script);
    }

    public Scene(long id)
    {
        this.sceneID = id;
        if(getLoadedScene() == null) setLoadedScene(this);
        scenes.put(this.sceneID,this);
    }

    public void start()
    {
        for (Script s : this.scripts)
            s.start();
    }

    public void update()
    {
        for (Script s : this.scripts)
            s.update();
    }

    public void end()
    {
        for (Script s : this.scripts)
            s.end();
    }

    public long getSceneID()
    {
        return this.sceneID;
    }

    public void setSceneID(long sceneID)
    {
        this.sceneID = sceneID;
    }
}

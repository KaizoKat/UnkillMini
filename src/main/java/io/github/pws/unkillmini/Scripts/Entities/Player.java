package io.github.pws.unkillmini.Scripts.Entities;

import io.github.pws.unkillmini.Application;
import io.github.pws.unkillmini.Program.Manager;
import io.github.pws.unkillmini.Program.backbone.*;
import io.github.pws.unkillmini.Program.backbone.DataTypes.Matrix2b;
import io.github.pws.unkillmini.Program.backbone.DataTypes.Vector2f;
import io.github.pws.unkillmini.Program.rendering.Window;

public abstract class Player
{
    public Sprite spr;
    public Vector2f globalPosition;
    public float moveSpeed;
    public Matrix2b motionMatrix;
    String collisionMask = "# M D G";
    public Player()
    {
        this.create();
    }

    public void handleCollisions()
    {
        if(this.spr.position.x >= 1 && this.spr.position.y >= 1)
        {
            String[] mask = collisionMask.split(" ");
            this.motionMatrix = Matrix2b.True();

            for (String s : mask) {
                if (Window.pixels[this.spr.position.y - 1][this.spr.position.x] == s.charAt(0))
                    this.motionMatrix.y1 = false;
                if (Window.pixels[this.spr.position.y + 1][this.spr.position.x] == s.charAt(0))
                    this.motionMatrix.y2 = false;
                if (Window.pixels[this.spr.position.y][this.spr.position.x - 1] == s.charAt(0))
                    this.motionMatrix.x1 = false;
                if (Window.pixels[this.spr.position.y][this.spr.position.x + 1] == s.charAt(0))
                    this.motionMatrix.x2 = false;
            }
        }
    }

    public void handleInput()
    {
        float spd = moveSpeed * (float)Manager.time.deltaTime;

        if(Manager.input.isHeld("Sprint")) spd = moveSpeed * 2 * (float)Manager.time.deltaTime;

        if(Manager.input.isHeld("Move Forward")) this.globalPosition.y+= spd;
        if(Manager.input.isHeld("Move Backward")) this.globalPosition.y-= spd;
        if(Manager.input.isHeld("Move Left")) this.globalPosition.x+= spd * 2;
        if(Manager.input.isHeld("Move Right")) this.globalPosition.x-= spd * 2;
    }

    public abstract void create();
}

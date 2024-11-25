package io.github.pws.unkillmini.Scenes;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import io.github.pws.unkillmini.Program.Manager;
import io.github.pws.unkillmini.Program.backbone.*;
import io.github.pws.unkillmini.Program.backbone.DataTypes.Anchor;
import io.github.pws.unkillmini.Program.backbone.DataTypes.Matrix2b;
import io.github.pws.unkillmini.Program.backbone.DataTypes.Vector2;
import io.github.pws.unkillmini.Program.backbone.DataTypes.Vector2f;
import io.github.pws.unkillmini.Program.rendering.Color;
import io.github.pws.unkillmini.Program.rendering.Window;
import io.github.pws.unkillmini.Scripts.Entities.Player;
import io.github.pws.unkillmini.Scripts.Tools.DefaultMappings;
import io.github.pws.unkillmini.Scripts.UI.Equipment;
import io.github.pws.unkillmini.Scripts.UI.Help;
import io.github.pws.unkillmini.Scripts.UI.Inventory;
import io.github.pws.unkillmini.Scripts.UI.Options;
import io.github.pws.unkillmini.Scripts.World.Rooms.MediumRoom;
import io.github.pws.unkillmini.Scripts.World.Rooms.SmallRoom;

import java.util.ArrayList;
import java.util.List;

public class TestScene extends Scene
{
    public List<Room> rooms = new ArrayList<>();
    public List<Player> myPlayers = new ArrayList<>();
    public Vector2 globalPosition = Anchor.center;

    public TestScene(long id)
    {
        super(id);

        addScript(new Script() {
            @Override
            public void start() {
                Player p1 = new Player() {
                    @Override
                    public void create() {
                        this.spr = new Sprite();
                        this.globalPosition = new Vector2f();
                        this.moveSpeed = 10f;
                        this.motionMatrix = new Matrix2b();

                        this.spr.pixels = "M";
                        this.spr.foreground = Color.rgbFG(57, 219, 33);
                        this.spr.background = "";
                    }
                };

                Player p2 = new Player() {
                    @Override
                    public void create() {
                        this.spr = new Sprite();
                        this.globalPosition = new Vector2f(7.0f,5.0f).negate().rest(Anchor.center.toVector2f());
                        this.moveSpeed = 10f;
                        this.motionMatrix = new Matrix2b();

                        this.spr.pixels = "D";
                        this.spr.foreground = Color.rgbFG(232, 82, 82);
                        this.spr.background = "";
                    }
                };

                Player p3 = new Player() {
                    @Override
                    public void create() {
                        this.spr = new Sprite();
                        this.globalPosition = new Vector2f(-5.0f,-5.0f).negate().rest(Anchor.center.toVector2f());
                        this.moveSpeed = 10f;
                        this.motionMatrix = new Matrix2b();

                        this.spr.pixels = "G";
                        this.spr.foreground = Color.rgbFG(217, 48, 205);
                        this.spr.background = "";
                    }
                };

                myPlayers.add(p1);
                myPlayers.add(p2);
                myPlayers.add(p3);

                SmallRoom.generate();
                rooms.add(SmallRoom.room1);

                MediumRoom.generate();
                rooms.add(MediumRoom.room1);
            }

            @Override
            public void update() {
                if(myPlayers.toArray().length == 0)
                {
                    Window.print("Player not provided for the playable area.");
                    return;
                }

                for (int i = 0; i < myPlayers.toArray().length; i++)
                {
                    Player player = myPlayers.get(i);
                    if(i == 0)
                    {
                        player.spr.position = Anchor.center;

                        for(Room r : rooms) {
                            globalPosition = new Vector2(Math.round(player.globalPosition.x), Math.round(player.globalPosition.y));
                            r.globalPosition = globalPosition;
                            r.createRoom();
                        }
                    }
                    else
                    {
                        player.spr.position = globalPosition.add(player.globalPosition.toVector2().negate());
                    }

                    if(i == 1) player.handleInput();

                    player.spr.populate();
                    myPlayers.set(i,player);
                }
            }

            @Override
            public void end() {

            }
        });

        addScript(new DefaultMappings());
        addScript(new Inventory());
        addScript(new Equipment());
        addScript(new Options());
        addScript(new Help());
    }
}

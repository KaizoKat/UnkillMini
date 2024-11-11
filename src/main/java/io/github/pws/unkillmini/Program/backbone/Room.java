package io.github.pws.unkillmini.Program.backbone;

import io.github.pws.unkillmini.Program.rendering.Color;
import io.github.pws.unkillmini.Program.rendering.Window;

import java.util.Arrays;

public class Room
{
    public Sprite transform = new Sprite();
    public char[][] roomMap;
    private int width = 3;
    private int height = 3;
    private String background = Color.rgbBG(0, 0, 0);

    public final void setWidth(int width)
    {
        this.width = Math.max(width,3);
    }

    public final void setHeight(int height)
    {
        this.height = Math.max(height,3);
    }

    public final void setBackground(String color)
    {
        this.background = color;
    }

    public final void createRoom()
    {
        StringBuilder sb = new StringBuilder();

        for (int yy = 0; yy < roomMap.length; yy++)
        {
            if(this.transform.y + yy > Window.height - 2) continue;

            for (int xx = 0; xx < roomMap[yy].length; xx++)
            {
                if(this.transform.x + xx > Window.width - 1) continue;

                if(roomMap[yy][xx] == '#') sb.append("#");
                else if(roomMap[yy][xx] == '.' || roomMap[yy][xx] == ':') sb.append(" ");
                else sb.append(roomMap[yy][xx]);
            }
            sb.append("\n");
        }
        transform.pixels = sb.toString();
        transform.populate();
    }

    public final char[][] merge(Room other)
    {
        char[][] mergedRoom = new char[32][128];

        for (char[] chars : mergedRoom)
        {
            Arrays.fill(chars, ' ');
        }

        for (int yy = 0; yy < this.height; yy++)
            for (int xx = 0; xx < this.width; xx++)
                mergedRoom[yy][xx] = this.roomMap[yy][xx];

        for (int yy = 0; yy < other.height; yy++)
            for (int xx = 0; xx < other.width; xx++)
                mergedRoom[Math.max(yy + other.transform.y, yy)][Math.max(xx + other.transform.x, xx)] = other.roomMap[yy][xx];
        
        for (int yy = 1; yy < 31; yy++)
        {
            for (int xx = 1; xx < 127; xx++)
            {
                int nrDots = 0;
                if(mergedRoom[yy-1][xx] == '.') nrDots++;
                if(mergedRoom[yy+1][xx] == '.') nrDots++;
                if(mergedRoom[yy][xx-1] == '.') nrDots++;
                if(mergedRoom[yy][xx+1] == '.') nrDots++;

                if(nrDots >= 2 && mergedRoom[yy][xx] == '#')
                {
                    mergedRoom[yy][xx] = ':';
                }
            }
        }

        return mergedRoom;
    }

    public final void generateRoomMap()
    {
        roomMap = new char[this.height][this.width];

        for (int yy = 0; yy < this.height; yy++)
        {
            for (int xx = 0; xx < this.width; xx++)
            {
                if(yy > 0 && yy < this.height-1 && xx > 0 && xx < this.width -1)
                {
                    roomMap[yy][xx] = '.';
                }
                else
                {
                    roomMap[yy][xx] = '#';
                }
            }
        }
    }
}

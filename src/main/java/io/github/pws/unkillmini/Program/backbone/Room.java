package io.github.pws.unkillmini.Program.backbone;

import io.github.pws.unkillmini.Program.rendering.Window;

public class Room
{
    public Sprite transform = new Sprite();
    public char[][] roomMap;
    private int width = 3;
    private int height = 3;

    private int maxWallSize = 25;

    public final void setWidth(int width)
    {
        this.width = MiniUtils.ClampInt(width, 3, this.maxWallSize);
    }

    public final void setHeight(int height)
    {
        this.height = MiniUtils.ClampInt(height, 3, this.maxWallSize);
    }

    public final void CreateRoom()
    {
        StringBuilder sb = new StringBuilder();

        for (char[] cs : roomMap)
        {
            for (char c : cs) 
            {
                if(c == '#') sb.append(c);
                else if(c == '.' || c == 'D') sb.append(" ");
                else sb.append(c);
            }
            sb.append("\n");
        }

        transform.pixels = sb.toString();
        transform.populate();
    }

    public final char[][] merge(Room other)
    {
        char[][] mergedRoom = new char[other.transform.x + other.width][other.transform.y + other.height];

        for (int xx = 0; xx < other.transform.x + other.width; xx++)
        {
            for (int yy = 0; yy < other.transform.y + other.height; yy++)
            {   
                mergedRoom[xx][yy] = ' ';
            }
        }

        for (int xx = 0; xx < this.width; xx++)
        {
            for (int yy = 0; yy < this.height; yy++) 
            {   
                this.roomMap[xx][yy] += 0;
                mergedRoom[xx][yy] += 0;
                mergedRoom[xx][yy] = this.roomMap[xx][yy];
            }
        }

        for (int xx = 0; xx < other.width; xx++) 
        {
            for (int yy = 0; yy < other.height; yy++)
            {
                mergedRoom[xx + other.transform.x][yy + other.transform.y] = other.roomMap[xx][yy];
            }
        }
        
        for (int xx = 1; xx < other.transform.x + other.width-1; xx++)
        {
            for (int yy = 1; yy < other.transform.y + other.height-1; yy++)
            {
                int nrDots = 0;
                if(mergedRoom[xx-1][yy] == '.') nrDots++;
                if(mergedRoom[xx+1][yy] == '.') nrDots++; 
                if(mergedRoom[xx][yy-1] == '.') nrDots++;
                if(mergedRoom[xx][yy+1] == '.') nrDots++;

                if(nrDots >= 2 && mergedRoom[xx][yy] == '#')
                {
                    mergedRoom[xx][yy] = 'D';
                }
            }
        }

        return mergedRoom;
    }

    public final char[][] generateRoomMap()
    {
        char[][] room = new char[this.width][this.height];
        for (int xx = 0; xx < this.width; xx++) 
        {
            for (int yy = 0; yy < this.height; yy++) 
            {
                if(xx > 0 && xx < this.width-1 && yy > 0 && yy < this.height -1)
                {
                    room[xx][yy] = '.';
                }
                else
                {
                    room[xx][yy] = '#';
                }
            }
        }
        return room;
    }
}

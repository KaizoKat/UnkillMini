package io.github.pws.unkillmini.Program.backbone.DataTypes;

public class Matrix2b
{
    public boolean x1, y1;
    public boolean x2, y2;

    @Override
    public String toString() {
        return "Matrix2{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }

    public Matrix2b()
    {
        this.x1 = false;
        this.x2 = false;
        this.y1 = false;
        this.y2 = false;
    }

    public Matrix2b(boolean x1, boolean y1, boolean x2, boolean y2)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public static Matrix2b True()
    {
        return new Matrix2b(true,true,true,true);
    }

    public static Matrix2b False()
    {
        return new Matrix2b(false,false,false,false);
    }
}

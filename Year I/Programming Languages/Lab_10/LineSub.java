public class LineSub extends Point 
{
    private Point end;

    public LineSub (int beginX, int beginY, int endX, int endY) 
    {
        super(beginX, beginY);
        this.end = new Point(endX, endY);
    }
    public LineSub (Point begin, Point end)
    {
        super(begin.getX(), begin.getY());
        this.end = end;
    }

    public String toString()
    {
        return "Begin: (" + super.getX() + ", " + super.getY() + "), End: (" + this.end.getX() + ", "
                + this.end.getY() + ")";
    }

    public Point getBegin()
    {
        return new Point(getX(), getY());
    }

    public Point getEnd() 
    {
        return this.end;
    }

    public void setBegin(Point begin)
    {
        super.setX(begin.getX());
        super.setY(begin.getY());
    }

    public void setEnd(Point end) 
    {
        this.end = end;
    }

    public int getBeginX()
    {
        return super.getX();
    }

    public int getBeginY()
    {
        return super.getY();
    }

    public int getEndX()
    {
        return this.end.getX();
    }

    public int getEndY()
    {
        return this.end.getY();
    }

    public void setBeginX(int x)
    {
        super.setX(x);
    }

    public void setBeginY(int y)
    {
        super.setY(y);
    }

    public void setBeginXY(int x, int y)
    {
        setBeginX(x);
        setBeginY(y);
    }

    public void setEndX(int x)
    {
        this.end.setX(x);
    }

    public void setEndY(int y)
    {
        this.end.setY(y);
    }

    public void setEndXY(int x, int y)
    {
        this.end.setXY(x, y);
    }

    public int getLengthSub()
    {
        int xDiff = this.end.getX() - super.getX();
        int yDiff = this.end.getY() - super.getY();

        int length = (int)Math.sqrt(xDiff * xDiff + yDiff * yDiff);
        return length;
    }

    public double getGradientSub()
    {
        double xDiff = this.end.getX() - super.getX();
        double yDiff = this.end.getY() - super.getY();

        double gradient = Math.atan2(yDiff, xDiff);
        return gradient;
    }
}
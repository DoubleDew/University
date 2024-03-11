public class Line 
{
    private Point begin;
    private Point end;

    public Line (Point begin, Point end)
    {
        this.begin = begin;
        this.end = end;
    }

    public Line (int beginX, int beginY, int endX, int endY)
    {
        begin = new Point(beginX, beginY);
        end = new Point(endX, endY);
    }

    @Override
    public String toString() 
    {
        return "Begin: (" + this.begin.getX() + ", " + this.begin.getY() + "), End: (" + this.end.getX() + ", "
                + this.end.getY() + ")";
    }

    public Point getBegin() 
    {
        return begin;
    }

    public Point getEnd() 
    {
        return end;
    }

    public void setBegin(Point begin)
    {
        this.begin = begin;
    }

    public void setEnd(Point end) 
    {
        this.end = end;
    }

    public int getBeginX()
    {
        return this.begin.getX();
    }

    public int getBeginY()
    {
        return this.begin.getY();
    }

    public int getEndX()
    {
        return this.begin.getX();
    }

    public int getEndY()
    {
        return this.begin.getY();
    }

    public void setBeginX(int x)
    {
        this.begin.setX(x);
    }

    public void setBeginY(int y)
    {
        this.begin.setY(y);
    }

    public void setBeginXY(int x, int y)
    {
        this.begin.setXY(x, y);
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

    public int getLength()
    {
        int xDiff = end.getX() - begin.getX();
        int yDiff = end.getY() - begin.getY();

        int length = (int)Math.sqrt(xDiff * xDiff + yDiff * yDiff);
        return length;
    }

    public double getGradient()
    {
        double xDiff = end.getX() - begin.getX();
        double yDiff = end.getY() - begin.getY();

        double gradient = Math.atan2(yDiff, xDiff);
        return gradient;
    }
}
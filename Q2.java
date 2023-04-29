import javafx.geometry.Point2D;

abstract class Shape {
    protected Point2D start;
    
    public Shape(Point2D start) {
        this.start = start;
    }
    
    public Point2D getStart() {
        return start;
    }
    
    public abstract void draw();
}

class Line extends Shape {
    private Point2D end;
    
    public Line(Point2D start, Point2D end) {
        super(start);
        this.end = end;
    }
    
    public Point2D getEnd() {
        return end;
    }
    
    public void draw() {
        System.out.println("Drawing a line from " + start.toString() + " to " + end.toString());
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(Point2D start, double length, double width) {
        super(start);
        this.length = length;
        this.width = width;
    }
    
    public double getLength() {
        return length;
    }
    
    public double getWidth() {
        return width;
    }
    
    public void draw() {
        System.out.println("Drawing a rectangle starting at " + start.toString() + ", with length " + length +
                           ", and width " + width);
    }
}

class Ellipse extends Shape {
    private double majorAxis;
    private double minorAxis;
    
    public Ellipse(Point2D start, double majorAxis, double minorAxis) {
        super(start);
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }
    
    public double getMajorAxis() {
        return majorAxis;
    }
    
    public double getMinorAxis() {
        return minorAxis;
    }
    
    public void draw() {
        System.out.println("Drawing an ellipse starting at " + start.toString() + ", with major axis " +
                           majorAxis + ", and minor axis " + minorAxis);
    }
}

import java.util.ArrayList;
import javafx.geometry.Point2D;

public abstract class Shape {
  
  public static void main(String[] args) {
    Diamond d1 = new Diamond(new Point2D(0, 0), 5, 10);
    Diamond d2 = new Diamond(new Point2D(3, 4), 7, 6);

    System.out.println("Diamond 1:");
    d1.draw();
    System.out.println("Diamond 2:");
    d2.draw();

    d1.move(2, 3);
    System.out.println("Moved Diamond 1:");
    d1.draw();

    int comparison = d1.compareTo(d2);
    if (comparison < 0) {
        System.out.println("Diamond 1 is smaller than Diamond 2.");
    } else if (comparison > 0) {
        System.out.println("Diamond 1 is larger than Diamond 2.");
    } else {
        System.out.println("Diamonds 1 and 2 are the same size.");
    }
}

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

interface Moveable {
    void move(double dx, double dy);
}

class Diamond extends Shape implements Moveable, Comparable<Diamond> {
    private double length;
    private double width;

    public Diamond(Point2D start, double length, double width) {
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
        System.out.println("Drawing a diamond starting at " + start.toString() + ", with length " + length +
                ", and width " + width);
    }

    public void move(double dx, double dy) {
        start = new Point2D(start.getX() + dx, start.getY() + dy);
    }

    public int compareTo(Diamond other) {
        double thisArea = length * width;
        double otherArea = other.getLength() * other.getWidth();
        if (thisArea < otherArea) {
            return -1;
        } else if (thisArea > otherArea) {
            return 1;
        } else {
            return 0;
        }
    }
}

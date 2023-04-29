import java.util.ArrayList;
import javafx.geometry.Point2D;

public class Canvas {
    private ArrayList<Shape> shapes;

    public Canvas() {
        shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    public Shape getClosestShape(Point2D point) {
        double minDistance = Double.MAX_VALUE;
        Shape closestShape = null;
        for (Shape shape : shapes) {
            double distance = shape.getStart().distance(point);
            if (distance < minDistance) {
                minDistance = distance;
                closestShape = shape;
            }
        }
        return closestShape;
    }

    public void drawAll() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public static void main(String[] args) {
        Canvas canvas = new Canvas();

        // Add some shapes to the canvas
        canvas.addShape(new Line(new Point2D(0, 0), new Point2D(10, 10)));
        canvas.addShape(new Rectangle(new Point2D(20, 20), 5, 7));
        canvas.addShape(new Ellipse(new Point2D(-5, -5), 3, 4));

        // Draw all shapes
        canvas.drawAll();

        // Remove a shape and draw all again
        Shape removedShape = canvas.getClosestShape(new Point2D(18, 18));
        System.out.println("Removing closest shape: " + removedShape.getStart().toString());
        canvas.removeShape(removedShape);
        canvas.drawAll();

        // Get the closest shape to a point and print its information
        Point2D testPoint = new Point2D(1, 1);
        Shape closestShape = canvas.getClosestShape(testPoint);
        System.out.println("\nClosest shape to " + testPoint.toString() + ":");
        closestShape.draw();
    }
}

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

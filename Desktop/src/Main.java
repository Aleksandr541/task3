package circle;

import java.util.Scanner;



class Point {
    public static final Point ORIGIN = new Point(0, 0);

    private double x;
    private double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Point(double x) {
        this(x, 0);
    }

    public Point(Point p) {
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;

    }

    double distanceToOrigin() {
        return distanceTo(new Point(ORIGIN));
    }

    double distanceTo(Point p) {
        double dx = p.x - this.x;
        double dy = p.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Circle {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    boolean containsPoint(Point p) {
        double distance = center.distanceTo(p);
        return distance <= radius;
    }
}

class PointList {
    private Point[] points;
    private int size = 0;
    private int index = 0;

    public void ResizingArrayStack(int size) {
        this.size = size;
        points = new Point[size];
    }


    public void add(Point element) {
        if (index == points.length) {
            resize(2 * points.length);
        }
        points[index] = element;
        index++;
    }

    private void resize(int capacity) {
        Point[] copy = new Point[capacity];
        for (int i = 0; i < points.length; i++) {
            copy[i] = points[i];
            points = copy;
        }
    }

    public int size() {
        return points.length;
    }


    public Point get(int index) {
        return points[index];
    }
}

public class Main {
    public static void main(String[] args) {
        Point point = new Point(0,0);
        PointList pointList = new PointList();
        pointList.ResizingArrayStack(3);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter coordinate point X:");
        int pointX = sc.nextInt();
        System.out.println("Enter coordinate point Y:");
        int pointY = sc.nextInt();
        pointList.add(new Point(pointX, pointY));
        int task = 0;
        System.out.println("Do you want to add more points?");
        while (task != 6) {
            System.out.println("Do you want to add more points?");
            int add = sc.nextInt();

            switch (add) {
                case 1:
                    System.out.println("Enter coordinate point X:");
                    int pointAddX = sc.nextInt();
                    System.out.println("Enter coordinate point Y:");
                    int pointAddY = sc.nextInt();
                    pointList.add(new Point(pointAddX, pointAddY));
                    break;
                case 2:
                    System.out.println("Enter the coordinates of the center of the circle");
                    System.out.println("Enter coordinate center X:");
                    int centerX = sc.nextInt();
                    System.out.println("Enter coordinate center Y:");
                    int centerY = sc.nextInt();
                    System.out.println("Enter radius circle:");
                    int radius = sc.nextInt();
                    Circle circle = new Circle(new Point(centerX, centerY), radius);
                    System.out.println(point.distanceToOrigin());
                    for (int i = 0; i < pointList.size(); i++) {
                        pointList.get(i);
                        if (circle.containsPoint(point)) {
                            System.out.println(pointList.get(i));
                            System.out.println("Contains");
                        }else {
                            System.out.println("Not ");
                        }
                    }
                    break;
            }

        }
    }
}



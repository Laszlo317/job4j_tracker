package ru.job4j.strategy;

public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Shape triangle = new Triangle();
        Shape square = new Square();
        Paint paint = new Paint();
        paint.draw(square);
        paint.draw(triangle);
    }
}

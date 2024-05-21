package Assignments.A1Exceptions.Shapes;

import Assignments.A1Exceptions.InvalidShapeParameterException;

/**
 * Represents a Circle shape.
 * Extends the abstract Shape class.
 * 
 * @author Parker Wallace
 */
class Circle extends Shape {
    /**
     * The radius of the circle.
     */
    private Double radius;

    /**
     * Constructs a Circle with the specified radius.
     *
     * @param radius The radius of the circle. Must be greater than 0.
     * @throws InvalidShapeParameterException if the radius is less than or equal to 0.
     */
    public Circle(Double radius) throws InvalidShapeParameterException {
        if (radius <= 0) {
            throw new InvalidShapeParameterException();
        }
        this.radius = radius;
    }

    /**
     * Calculates the area of the circle.
     *
     * @return The area of the circle.
     */
    @Override
    double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    /**
     * Provides a description of the circle including its radius and area.
     *
     * @return A string description of the circle.
     */
    @Override
    String getDescription() {
        return String.format("Circle with radius %.2f and area %.2f", this.radius, this.area());
    }

    /**
     * Gets the radius of the circle.
     *
     * @return The radius of the circle.
     */
    public Double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the circle.
     *
     * @param radius The new radius of the circle.
     */
    public void setRadius(Double radius) {
        this.radius = radius;
    }
}

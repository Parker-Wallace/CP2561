package Assignments.A1Exceptions.Shapes;

/**
 * Represents a Rectangle shape.
 * Extends the abstract Shape class.
 * 
 * @see Shape
 */
class Rectangle extends Shape {
    /**
     * The length of the rectangle.
     */
    private double length;

    /**
     * The width of the rectangle.
     */
    private double width;

    /**
     * Constructs a Rectangle with the specified length and width.
     *
     * @param length The length of the rectangle. Must be greater than 0.
     * @param width The width of the rectangle. Must be greater than 0.
     * @throws InvalidShapeParameterException if either length or width is less than or equal to 0.
     */
    public Rectangle(double length, double width) throws InvalidShapeParameterException {
        if (length <= 0 || width <= 0) {
            throw new InvalidShapeParameterException();
        }
        this.length = length;
        this.width = width;
    }

    /**
     * Calculates the area of the rectangle.
     *
     * @return The area of the rectangle.
     */
    @Override
    double area() {
        return this.length * this.width;
    }

    /**
     * Provides a description of the rectangle including its width, length, and area.
     *
     * @return A string description of the rectangle.
     */
    @Override
    String getDescription() {
        return String.format("Rectangle with width %.2f and length %.2f and area %.2f", this.width, this.length, this.area());
    }

    /**
     * Gets the length of the rectangle.
     *
     * @return The length of the rectangle.
     */
    public double getLength() {
        return length;
    }

    /**
     * Sets the length of the rectangle.
     *
     * @param length The new length of the rectangle.
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Gets the width of the rectangle.
     *
     * @return The width of the rectangle.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the width of the rectangle.
     *
     * @param width The new width of the rectangle.
     */
    public void setWidth(double width) {
        this.width = width;
    }
}

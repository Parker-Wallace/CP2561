package ClassWork.May7thReviewExercise;

class Rectangle extends Shape {
    double length;
    double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return this.length * this.width;
    }

    @Override
    String getDescription() {
        return String.format("Rectanlge with width %.2f and length %.2f and area %.2f", this.width, this.length, this.area());
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}

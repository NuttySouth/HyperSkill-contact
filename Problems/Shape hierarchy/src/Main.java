abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape{
    double sideOne;
    double sideTwo;
    double sideThree;

    public Triangle(double sideOne, double sideTwo, double sideThree){
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.sideThree = sideThree;
    }

    public double getPerimeter(){
        return this.sideOne + this.sideTwo + this.sideThree;
    }

    public double getArea(){
        double s = getPerimeter()/2;
        double area = Math.sqrt(s*(s-this.sideOne)*(s-this.sideTwo)*(s-this.sideThree));
        return area;
    }
}

class Rectangle extends Shape{

    double height;
    double width;

    public Rectangle(double height, double width){
        this.width = width;
        this.height = height;
    }

    public double getPerimeter(){
        return this.height*2 + this.width*2;
    }

    public double getArea(){
        return this.height*this.width;
    }
}

class Circle extends Shape{

    double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double getArea(){
        return this.radius*this.radius* Math.PI;
    }
    public double getPerimeter(){
        return this.radius * Math.PI * 2;
    }
}
import java.util.List;

class Sort {
    public static void sortShapes(Shape[] array,
                                  List<Shape> shapes,
                                  List<Polygon> polygons,
                                  List<Square> squares,
                                  List<Circle> circles) {
        // write your code here
        for(Shape obj: array){
            if(obj.getClass() == Shape.class){
                shapes.add(obj);
            }
            if(obj.getClass() == Polygon.class){
                polygons.add((Polygon) obj);
            }
            if(obj.getClass() == Square.class){
                squares.add((Square) obj);
            }
            if(obj.getClass() == Circle.class){
                circles.add((Circle) obj);
            }
        }
    }
}

//Don't change classes below
class Shape { }
class Polygon extends Shape { }
class Square extends Polygon { }
class Circle extends Shape { }
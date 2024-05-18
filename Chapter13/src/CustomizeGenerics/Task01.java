package CustomizeGenerics;

public class Task01 {
    public static void main(String[] args) {
        Coordinate<String> c1 = new Coordinate<>("北纬38.6", "东经36.8");
        Coordinate<Double> c2 = new Coordinate<>(10.0, 10.0);
        System.out.println(c1);
        System.out.println(c2);
    }
}
class Coordinate<T> {
    private T x;
    private T y;

    public Coordinate(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
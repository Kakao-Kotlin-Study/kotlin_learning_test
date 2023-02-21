package operator;

public class PointPlusJava {
    private final int x;
    private final int y;

    public PointPlusJava(int x, int y){
        this.x = x;
        this.y = y;
    }

    public PointPlusJava plus(PointPlusJava other){
        return new PointPlusJava(this.x + other.x, this.y + other.y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

package Logic;

/**
 * @author JavW11trial
 * @param <X>
 * @param <Y>
 */
public class Coordenadas<X extends Integer,Y extends Integer> {
    private final X x;
    private final Y y;

    Coordenadas(Integer posX, Integer posY) {
        this.x = (X) posX;
        this.y = (Y) posY;
    }
    
    public X getX(){
        return this.x;
    }
    
    public Y getY(){
        return this.y;
    }
}

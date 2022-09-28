import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    protected Position pos;

    Element(Position pos){
        this.pos = pos;
    }

    public Position getPos() {
        return pos;
    }

    public abstract void draw(TextGraphics graphics);
}

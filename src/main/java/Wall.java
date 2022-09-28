import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class Wall {
    private Position pos = new Position(0,0);

    Wall(int x, int y){
        pos.setX(x);
        pos.setY(y);
    }
    public Position getPos(){return pos;}
    public void draw(TextGraphics graphics){
        graphics.setCharacter(pos.getX(), pos.getY(), TextCharacter.fromCharacter(' ')[0]);
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
    }


}

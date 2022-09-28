import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element {

    Wall(Position position){
        super(position);
    }
    public void draw(TextGraphics graphics){
        graphics.setCharacter(pos.getX(), pos.getY(), TextCharacter.fromCharacter(' ')[0]);
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
    }


}

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {

    Monster(Position pos){
        super(pos);
    }

    public void draw(TextGraphics graphics) {
        graphics.setCharacter(pos.getX(), pos.getY(), TextCharacter.fromCharacter('M')[0]);
        graphics.setForegroundColor(TextColor.Factory.fromString("#013220"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(pos.getX(), pos.getY()), "M");
    }

    public void move(){
        Random random = new Random();

        switch (random.nextInt(4)){
            case 0:
                pos.setX(pos.getX() + 1);
                break;
            case 1:
                pos.setX(pos.getX() - 1);
                break;
            case 2:
                pos.setY(pos.getY() + 1);
                break;
            case 3:
                pos.setY(pos.getY() - 1);
                break;
            case 4:
                break;
        }
    }
}

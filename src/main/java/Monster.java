import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import static java.lang.Math.abs;

public class Monster extends Element {

    Monster(Position pos){
        super(pos);
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public void draw(TextGraphics graphics) {
        graphics.setCharacter(pos.getX(), pos.getY(), TextCharacter.fromCharacter('M')[0]);
        graphics.setForegroundColor(TextColor.Factory.fromString("#013220"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(pos.getX(), pos.getY()), "M");
    }

    public void move(Position position){
        if (abs(pos.getX() - position.getX()) >= abs(pos.getY() - position.getY())){
            if (pos.getX() > position.getX()){
                pos.setX(pos.getX() - 1);
            }
            else{
                pos.setX(pos.getX() + 1);
            }
        }
        else {
            System.out.println(pos.getY() + "     " + position.getY());
            if (pos.getY() > position.getY()) {
                pos.setY(pos.getY() - 1);
            }
            else{
                pos.setY(pos.getY() + 1);
            }
        }
    }
}

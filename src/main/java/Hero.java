import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero extends Element {

    Hero(Position position) {
        super(position);
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public void moveHero(Position position) {
        this.setPos(position);
    }

    public Position moveUp() {
        return new Position(pos.getX(), pos.getY() - 1);
    }

    public Position moveDown() {
        return new Position(pos.getX(), pos.getY() + 1);
    }

    public Position moveLeft() {
        return new Position(pos.getX() - 1, pos.getY());
    }

    public Position moveRight() {
        return new Position(pos.getX() + 1, pos.getY());
    }

    public void draw(TextGraphics graphics){
        graphics.setCharacter(pos.getX(), pos.getY(), TextCharacter.fromCharacter('X')[0]);
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(pos.getX(), pos.getY()), "X");
    }

}

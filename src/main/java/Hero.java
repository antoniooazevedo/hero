import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private Position pos;

    Hero(Position position) {
        this.pos = position;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public Position getPos() {
        return pos;
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

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(moveUp());
                break;
            case ArrowDown:
                moveHero(moveDown());
                break;
            case ArrowLeft:
                moveHero(moveLeft());
                break;
            case ArrowRight:
                moveHero(moveRight());
                break;
        }

    }

    public void draw(TextGraphics graphics){
        graphics.setCharacter(pos.getX(), pos.getY(), TextCharacter.fromCharacter('X')[0]);
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(pos.getX(), pos.getY()), "X");
    }

}

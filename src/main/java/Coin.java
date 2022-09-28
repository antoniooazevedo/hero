import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Element {

    Coin(Position pos){
        super(pos);
    }

    public void draw(TextGraphics graphics){
        graphics.setCharacter(pos.getX(), pos.getY(), TextCharacter.fromCharacter('o')[0]);
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(pos.getX(), pos.getY()), "o");
    }

}

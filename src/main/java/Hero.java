import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private Position pos;

    Hero(Position position){
        this.pos = position;
    }
    public void setPos(Position pos) {this.pos = pos;}
    public Position getPos(){return pos;}

    public void moveHero(Position position){
        this.setPos(position);
    }
    public Position moveUp(){
        return new Position(pos.getX(), pos.getY() - 1);
    }
    public Position moveDown(){
        return new Position(pos.getX(), pos.getY() + 1);
    }
    public Position moveLeft(){
        return new Position(pos.getX() - 1, pos.getY());
    }
    public Position moveRight(){
        return new Position(pos.getX() + 1, pos.getY());
    }

    void draw(Screen screen){
        screen.setCharacter(pos.getX(), pos.getY(), TextCharacter.fromCharacter('X')[0]);
    }

}

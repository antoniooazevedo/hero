import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;


    Arena(int w, int h, Hero hero) {
        width = w;
        height = h;
        this.hero = hero;
        this.walls = createWalls();
        this.coins = createCoins();
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for (Coin coin: coins) {
            System.out.println(coin.getPos().getX() + "    " + coin.getPos().getY());
            coin.draw(graphics);
        }
        hero.draw(graphics);
        for (Wall wall: walls)
            wall.draw(graphics);
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(new Position(c, 0)));
            walls.add(new Wall(new Position(c, height - 1)));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(new Position(0, r)));
            walls.add(new Wall(new Position(width - 1, r)));
        }
        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(new Position(random.nextInt(width - 2) + 1,random.nextInt(height - 2) + 1)));

        return coins;
    }



    public boolean canHeroMove(Position position){
        for (Wall wall : walls){
            if (wall.getPos().equals(position)){
                return false;
            }
        }
        return true;
    }

    public void processKey(KeyStroke key) {
        Position pos = hero.getPos();
        switch (key.getKeyType()) {
            case ArrowDown:
                hero.moveHero(hero.moveDown());
                if (!canHeroMove(hero.getPos())){ hero.setPos(pos);}
                break;
            case ArrowUp:
                hero.moveHero(hero.moveUp());
                if (!canHeroMove(hero.getPos())){ hero.setPos(pos);}
                break;
            case ArrowLeft:
                hero.moveHero(hero.moveLeft());
                if (!canHeroMove(hero.getPos())){ hero.setPos(pos);}
                break;
            case ArrowRight:
                hero.moveHero(hero.moveRight());
                if (!canHeroMove(hero.getPos())){ hero.setPos(pos);}
                break;
        }


    }
}

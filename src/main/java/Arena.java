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
    private List<Monster> monsters;

    public boolean check_for_monster_collisions = false;


    Arena(int w, int h, Hero hero) {
        width = w;
        height = h;
        this.hero = hero;
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
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


    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for (Coin coin : coins) {
            coin.draw(graphics);
            if (retrieveCoin(coin)) {
                coins.remove(coin);
                break;
            }

        }
        for (Monster monster : monsters) {
            monster.draw(graphics);
        }
        hero.draw(graphics);
        for (Wall wall : walls)
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
            coins.add(new Coin(new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1)));

        return coins;
    }

    private boolean retrieveCoin(Coin coin) {
        return hero.getPos().equals(coin.getPos());
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            monsters.add(new Monster(new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1)));
        }
        return monsters;
    }

    private void moveMonsters() {
        for (Monster mon : monsters) {
            Position mon_pos = new Position(mon.getPos().getX(), mon.getPos().getY());
            mon.move();
            if (!canMove(mon.getPos())) {
                mon.setPos(mon_pos);
            }

        }
    }

    private boolean verifyMonsterColision(Hero hero){
        for (Monster mon : monsters){
            if(hero.getPos().equals(mon.getPos())){
                return true;
            }
        }
        return false;
    }

    public boolean canMove(Position position){
        for (Wall wall : walls){
            if (wall.getPos().equals(position)){
                return false;
            }
        }
        return true;
    }

    public void processKey(KeyStroke key) {
        Position pos_hero = hero.getPos();
        switch (key.getKeyType()) {
            case ArrowDown:
                hero.moveHero(hero.moveDown());
                if (!canMove(hero.getPos())){ hero.setPos(pos_hero);}
                moveMonsters();
                break;
            case ArrowUp:
                hero.moveHero(hero.moveUp());
                if (!canMove(hero.getPos())){ hero.setPos(pos_hero);}
                moveMonsters();
                break;
            case ArrowLeft:
                hero.moveHero(hero.moveLeft());
                if (!canMove(hero.getPos())){ hero.setPos(pos_hero);}
                moveMonsters();
                break;
            case ArrowRight:
                hero.moveHero(hero.moveRight());
                if (!canMove(hero.getPos())){ hero.setPos(pos_hero);}
                moveMonsters();
                break;
        }
        if (verifyMonsterColision(hero)){
            System.out.println("A monster hit you and you died :(       Game OVER!");
            check_for_monster_collisions = true;
        }
    }
}

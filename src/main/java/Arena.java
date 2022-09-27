import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private int width;
    private int height;
    private Hero hero;

    Arena(int w, int h, Hero hero) {
        width = w;
        height = h;
        this.hero = hero;
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

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp:
                hero.moveHero(hero.moveUp());
                break;
            case ArrowDown:
                hero.moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                hero.moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                hero.moveHero(hero.moveRight());
                break;
        }

    }

    public void draw(Screen screen){
        screen.setCharacter(hero.getPos().getX(), hero.getPos().getY(), TextCharacter.fromCharacter('X')[0]);
    }
}

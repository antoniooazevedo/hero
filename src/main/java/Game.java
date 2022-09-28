import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;


public class Game {
    Screen screen;
    Position pos = new Position(10,10);
    Hero hero = new Hero(pos);
    Arena arena = new Arena (80, 24, hero);

    Game(){
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void draw() throws IOException {
       screen.clear();
       arena.draw(screen.newTextGraphics());
       screen.refresh();

    }

    public void run() throws IOException{
        while (true) {
            draw();
            KeyStroke key = screen.readInput();
            arena.processKey(key);
            if ((key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') || arena.check_for_monster_collisions){
                screen.close();
            }
            if (key.getKeyType() == KeyType.EOF){
                break;
            }
        }
    }
}

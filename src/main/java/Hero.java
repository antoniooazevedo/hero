import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private int x = 0;
    private int y = 0;

    Hero(int ecse, int uai){
        x = ecse;
        y = uai;
    }
    int get_x(){return x;}
    int get_y(){return y;}
    void set_x(int num){x = num;}
    void set_y(int num){y = num;}
    void moveUp(){y--;}
    void moveDown(){y++;}
    void moveRight(){x++;}
    void moveLeft(){x--;}

    void draw(Screen screen){
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
    }
}

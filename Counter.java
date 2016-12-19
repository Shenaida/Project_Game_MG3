import greenfoot.*;
import java.awt.Color;

public class Counter extends Actor
{
    
    public int move = 0;
    
    public Counter() {
        this.updateImage();
    }
    
    public void incrementScore() {
        this.move += 1;
        
        this.updateImage();
    }
    
    private void updateImage() {
        setImage(new GreenfootImage("Moves: " + move, 24, Color.WHITE, Color.BLUE));
    }
    
}
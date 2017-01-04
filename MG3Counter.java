import greenfoot.*;
import java.awt.Color;

public class MG3Counter extends Actor
{
    
    public int move = 25;
    
    public MG3Counter() {
        updateImage();
    }
    
    public void decreaseScore() {
        move -= 1;
        if (move<=0)
                {
                    getWorld().addObject(new TryAgain(), getWorld().getWidth()/2, getWorld().getHeight()/2);
                    //Greenfoot.setWorld(new TegelWorld());

                }
        updateImage();
    }
    
    private void updateImage() {
        setImage(new GreenfootImage("Moves: " + move, 32, Color.WHITE, Color.BLUE));
    }
    
}
import greenfoot.*;
import java.awt.Color;

public class TryAgain extends Actor
{
    String text = " Try again ";
    GreenfootImage inner = new GreenfootImage(text, 300, Color.blue, new Color(255, 255, 255, 255));

    public TryAgain()
    {
      setImage(inner);
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            getWorld().removeObject(this);// remove pop-up when clicked on
            Greenfoot.setWorld(new TegelWorld());
        }

    }
}
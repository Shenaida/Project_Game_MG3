import greenfoot.*;

public class Tegel extends Actor
{
    public boolean Noord;
    public boolean Oost;
    public boolean Zuid;
    public boolean West;
    public boolean IsEind;
    public boolean IsStart;
    
    public Tegel(boolean noord,boolean oost,boolean zuid,boolean west, boolean isStart, boolean isEind, String achtergrondplaatje) {
        Noord=noord;
        Oost=oost;
        Zuid=zuid;
        West=west;
        IsStart=isStart;
        IsEind=isEind;
        
        setImage(achtergrondplaatje);
        getImage().scale(GridWorld.gridSize+120, GridWorld.gridSize+120);
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this)&& !IsStart && !IsEind)
        {   
            turn(-90);
            // boolean oplossing=controlleerOplossing();
        }
    }
    
    public boolean controleerOplossing()
    {
        // GridWorld myWorld = getWorldOfType();
        
        // TegelType[][] level=myWorld.huidiglevel;
        
        
        return false;
    }
}
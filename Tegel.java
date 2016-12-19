import greenfoot.*;
import java.util.HashMap;

public class Tegel extends Actor
{
    public HashMap<Richting, Boolean> Open;
    public boolean IsEind;
    public boolean IsStart;
    
    public Tegel(boolean noord,boolean oost,boolean zuid,boolean west, boolean isStart, boolean isEind, String achtergrondplaatje) {
        Open=new HashMap<Richting,Boolean>(){{
            put(Richting.Noord,noord);
            put(Richting.Oost,oost);
            put(Richting.Zuid,zuid);
            put(Richting.West,west);
        }};
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
            Rotate();
            GridWorld gridWorld = (GridWorld) getWorld();  // get a reference to the world
            gridWorld.getCounter().incrementScore();
            Tegel[][] huidigLevel=gridWorld.getHuidigLevel();
            boolean isOplossing=gridWorld.getGameMaster().ControlleerOplossing(huidigLevel);
            if (isOplossing)
            {
                Greenfoot.stop();
            }
        }
    }
    
    public void Rotate()
    {
        boolean tmp = Open.get(Richting.Noord);
        Open.put(Richting.Noord, Open.get(Richting.Oost));
        Open.put(Richting.Oost, Open.get(Richting.Zuid));
        Open.put(Richting.Zuid, Open.get(Richting.West));
        Open.put(Richting.West, tmp);
    }
}
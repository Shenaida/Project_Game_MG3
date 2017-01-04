import greenfoot.*;
import java.util.HashMap;

public class Tegel extends Actor
{
    private String _droogAfbeelding;
    private String _waterAfbeelding;
    
    public HashMap<Richting, Boolean> Open;
    public boolean IsEind;
    public boolean IsStart;
    public boolean IsRotatable;
    
    
    public Tegel(boolean noord,boolean oost,boolean zuid,boolean west, boolean isStart, boolean isEind, boolean isRotatable, String droogAfbeelding, String waterAfbeelding) {
        Open=new HashMap<Richting,Boolean>(){{
            put(Richting.Noord,noord);
            put(Richting.Oost,oost);
            put(Richting.Zuid,zuid);
            put(Richting.West,west);
        }};
        IsStart=isStart;
        IsEind=isEind;
        IsRotatable=isRotatable;
        
        _droogAfbeelding=droogAfbeelding;
        _waterAfbeelding=waterAfbeelding;
        
        MaakDroog();
    }
    
    public void act()
    {   
        TegelWorld gridWorld = (TegelWorld) getWorld();  // referentie uit de wereld
        MG3Counter counter = gridWorld.getCounter();
        if (Greenfoot.mouseClicked(this)&& IsRotatable && counter.move>0)
        {   
            turn(-90);
            Rotate();
            
            counter.decreaseScore();
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
    
    public void MaakNat()
    {
        TekenPijp(_waterAfbeelding);
        Greenfoot.delay(5);
    }
    
    public void MaakDroog()
    {
        TekenPijp(_droogAfbeelding);
    }
    
    private void TekenPijp(String afbeelding)
    {
        setImage(afbeelding);
        getImage().scale(TegelWorld.gridSize+120, TegelWorld.gridSize+120);
        
    }
}
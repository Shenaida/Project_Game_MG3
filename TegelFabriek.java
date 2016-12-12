import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TegelFabriek here.
 * 
 * @author Shenaida, JaapJan, Max, Bram
 * @version (a version number or a date)
 */
public class TegelFabriek
{

    /**
     * Constructor for objects of class TegelFabriek.
     * 
     */
    public TegelFabriek()
    {    
        
    }
    
    public Tegel MaakTegel(TegelType type)
    {
        if(type==TegelType.Blok)
            return new Tegel(false,false,false,false,false,false,"tegel_blok.png");
        if(type==TegelType.Lange)
            return new Tegel(false,true,false,true,false,false,"tegel_lange.png");
        if(type==TegelType.Hoek)
        return new Tegel(false,true,true,false,false,false,"tegel_hoek.png");
        if(type==TegelType.Start)
        return new Tegel(false,false,true,false,true,false,"tegel_start.png");
        if(type==TegelType.Eind)
        return new Tegel(false,false,true,false,false,true,"tegel_eind.png");
        
        return null;
    }
}

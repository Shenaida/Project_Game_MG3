import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TegelFabriek
{

    /**
     * eigenschap van de tegels 
     * -om het pad van de leidingen aan te geven
     * -plaatje zonder water
     * -plaatje met water
     * 
     */
    public TegelFabriek()
    {    
        
    }
    
    public Tegel MaakTegel(TegelType type)
    {
        if(type==TegelType.Blok_mario)
            return new Tegel(false,false,false,false,false,false,false,"tegel_blok_mario.png","tegel_blok_mario.png");
        if(type==TegelType.Blok)
            return new Tegel(false,false,false,false,false,false, false, "tegel_blok.png", "tegel_blok.png");
        if(type==TegelType.Lange)
            return new Tegel(false,true,false,true,false,false,true,"tegel_lange.png","tegel_lange_water.png");
        if(type==TegelType.Hoek)
        return new Tegel(false,true,true,false,false,false,true, "tegel_hoek.png","tegel_hoek_water.png");
        if(type==TegelType.Start)
        return new Tegel(false,false,true,false,true,false,false, "tegel_start.png","tegel_start_water.png");
        if(type==TegelType.Eind)
        return new Tegel(false,false,true,false,false,true,false, "tegel_eind.png","tegel_eind_water.png");
        
        return null;
    }
}

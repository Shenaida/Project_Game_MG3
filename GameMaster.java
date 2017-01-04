/**
 * de route bepaling van start tegel naar eind tegel
 */
public class GameMaster  
{
    
    /**
     * Constructor for objects of class GameMaster
     */
    public GameMaster()
    {
    
    
    }
    
    public boolean ControlleerOplossing(Tegel[][] level)
        {
            Coordinaat startTegel = VindStartTegel(level);

            return VindRoute(level, startTegel, null);
        }
        
    private Coordinaat VindStartTegel(Tegel[][] level)
        {
            for (int y = 0; y < level.length; y++)
            {
                for (int x = 0; x < level[y].length; x++)
                {
                    if (level[y][x].IsStart)
                        return new Coordinaat(x, y);
                }
            }
            return null;
        }
    
    private boolean VindRoute(Tegel[][] level, Coordinaat locatie, Richting vorigeRichting)
        {
            Tegel huidigeTegel = level[locatie.Y][locatie.X];
            Richting tegengesteldeRichting = null;
            if (vorigeRichting!=null)
            {
                tegengesteldeRichting = BepaalTegenGesteldeRichting(vorigeRichting);
                if (!huidigeTegel.Open.get(tegengesteldeRichting))
                {
                    huidigeTegel.MaakDroog();
                    return false;
                }
            }

            if (huidigeTegel.IsEind)
            {
                huidigeTegel.MaakNat();
                return true;
            }

            for (int richting = 0; richting < 4; richting++)
            {
                Richting huidigeRichting=Richting.values()[richting];
                if ((tegengesteldeRichting != null && huidigeRichting == tegengesteldeRichting)
                    || !huidigeTegel.Open.get(huidigeRichting))
                {
                    continue;
                }
                Coordinaat vector = BepaalVector(huidigeRichting);
                
                boolean mogelijkeOplossing = VindRoute(level, locatie.Plus(vector), huidigeRichting);
                if (mogelijkeOplossing)
                {
                    huidigeTegel.MaakNat();
                    return true;
                }
            }
            
            huidigeTegel.MaakDroog();
            return false;

        }
        
    private Coordinaat BepaalVector(Richting richting)
        {
            int x = 0;
            int y = 0;

            if (richting == Richting.Noord)
                y = -1;
            if (richting == Richting.Oost)
                x = 1;
            if (richting == Richting.West)
                x = -1;
            if (richting == Richting.Zuid)
                y = 1;

            return new Coordinaat(x, y);
        }

    private Richting BepaalTegenGesteldeRichting(Richting richting)
        {
            if (richting == Richting.Noord)
                return Richting.Zuid;
            if (richting == Richting.Oost)
                return Richting.West;
            if (richting == Richting.West)
                return Richting.Oost;
            if (richting == Richting.Zuid)
                return Richting.Noord;

            return Richting.Onbekend;
        }

}

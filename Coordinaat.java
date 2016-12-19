/**
 * Write a description of class Coordinaat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coordinaat  
{
    public int X;
    public int Y;
    
    public Coordinaat(int x, int y)
        {
            X = x;
            Y = y;
        }
        
    public Coordinaat Plus(Coordinaat vector)
        {
            return new Coordinaat(X + vector.X, Y + vector.Y);
        }
        
    public Coordinaat Plus(int x, int y)
    {
        return new Coordinaat(X+x, Y+y);
    }
}


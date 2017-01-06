/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level  
{
    public TegelType[][] Design;
    public int MaxMoves;
    /**
     * Constructor for objects of class Level
     */
    public Level(TegelType[][] design,int maxMoves)
    {
        Design=design;
        MaxMoves=maxMoves;
    }

}

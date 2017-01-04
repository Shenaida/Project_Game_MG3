import greenfoot.*;
import java.util.HashMap;
import java.util.Random;

public class TegelWorld extends World
{
    
    private static final int gridWidth = 42;
    private static final int gridHeight = 32;
    private static Actor[][] grid = new Actor[gridWidth][gridHeight];
    
    
    private MG3Counter the_counter;
    private GameMaster gameMaster;
    public static final int gridSize = 32;
    public Tegel[][] huidigLevel = null;

       
    public TegelWorld()
    {    
        super(gridWidth * gridSize, gridHeight * gridSize, 1);
        
        setPaintOrder( TryAgain.class, MG3Counter.class, MG3Wall.class, Tegel.class);
        the_counter=new MG3Counter();
        addObjectToGrid(the_counter, gridWidth / 2 - 10, 0);
        
        gameMaster=new GameMaster();
        
        for (int x = 0; x < gridWidth; x++) {
            addObjectToGrid(new MG3Wall(), x, 0);
            addObjectToGrid(new MG3Wall(), x, gridHeight - 1);
        }
        
        for (int y = 0; y < gridHeight; y++) {
            addObjectToGrid(new MG3Wall(), 0, y);
            addObjectToGrid(new MG3Wall(), gridWidth - 1, y);
        }
        //eerste level
        TegelType[][] level=getRandomLevel();       
        
        huidigLevel=maakLevel(level);

    }
    
    public MG3Counter getCounter()
        {
            return the_counter;
        
        }
    
    public GameMaster getGameMaster()
    {
        return gameMaster;
    }
    
    public Tegel[][] getHuidigLevel()
    {
        return huidigLevel;
    }
    
        private void addObjectToGrid(Actor actor, int x, int y) {
        int xPos = x * gridSize + actor.getImage().getWidth() / 2;
        int yPos = y * gridSize + actor.getImage().getHeight() / 2;
        super.addObject(actor, xPos, yPos);

        int xRange = actor.getImage().getWidth() / gridSize;
        int yRange = actor.getImage().getHeight() / gridSize;

        for (int j = 0; j < yRange; j++) {
            for (int i = 0; i < xRange; i++) {
                grid[x][y] = actor;
            }
        }
    }
    
    private Tegel[][] maakLevel(TegelType[][] level)
        {
            int space=5;
            TegelFabriek fabriek=new TegelFabriek();
            Tegel gemaaktLevel[][] = new Tegel[8][];
            
            for(int y=0;y<level.length;y++){
                gemaaktLevel[y]=new Tegel[8];
                for(int x=0;x<level[y].length;x++){
                    Tegel tegel=fabriek.MaakTegel(level[y][x]);
                    gemaaktLevel[y][x]=tegel;
                    addObjectToGrid(tegel,x*space+ 1,y*space +1);
                }
            }
                    
            return gemaaktLevel;
        }
        
    private TegelType[][] getRandomLevel()
    {
        HashMap<Integer,TegelType[][]> levels= new HashMap<Integer,TegelType[][]>();
        
        levels.put(1,getLevel1());
        //levels.put(2,getLevel2());
        int numberOfLevels=levels.size();
        Random random = new Random();
        int levelToGet=random.nextInt(numberOfLevels)+1;
        
        return levels.get(levelToGet);
    }
    
    private TegelType[][] getLevel1()
    {
        return new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok_mario, TegelType.Blok_mario},
            {TegelType.Blok,TegelType.Hoek,TegelType.Lange,TegelType.Lange,TegelType.Hoek,TegelType.Hoek, TegelType.Eind, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Lange, TegelType.Hoek, TegelType.Hoek, TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Start,TegelType.Hoek,TegelType.Lange, TegelType.Lange,TegelType.Hoek, TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Lange,TegelType.Lange,TegelType.Lange,TegelType.Hoek, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok}
        };
    }
}
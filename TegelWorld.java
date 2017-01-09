import greenfoot.*;
import java.util.HashMap;
import java.util.Random;

public class TegelWorld extends World
{
    
    private static final int gridWidth = 52;
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
        
        gameMaster=new GameMaster();
        
        for (int x = 0; x < gridWidth; x++) {
            addObjectToGrid(new MG3Wall(), x, 0);
            addObjectToGrid(new MG3Wall(), x, gridHeight - 1);
        }
        
        for (int y = 0; y < gridHeight; y++) {
            addObjectToGrid(new MG3Wall(), 0, y);
            addObjectToGrid(new MG3Wall(), gridWidth - 1, y);
        }
        
        volgendLevel();

    }
    
    public void addCounter(int maxMoves)
    {
        the_counter=new MG3Counter(maxMoves);
        addObjectToGrid(the_counter, gridWidth / 2 - 10, 0);
    }
    
    private void removeCounter()
    {
        super.removeObject(the_counter);
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
    
    private Tegel[][] maakLevel(TegelType[][] levelDesign)
        {
            int space=5;
            TegelFabriek fabriek=new TegelFabriek();
            Tegel gemaaktLevel[][] = new Tegel[levelDesign.length][];
            
            for(int y=0;y<levelDesign.length;y++){
                gemaaktLevel[y]=new Tegel[levelDesign[y].length];
                for(int x=0;x<levelDesign[y].length;x++){
                    Tegel tegel=fabriek.MaakTegel(levelDesign[y][x]);
                    gemaaktLevel[y][x]=tegel;
                    addObjectToGrid(tegel,x*space+ 1,y*space +1);
                }
            }
                    
            return gemaaktLevel;
        }
        
    private Level getRandomLevel()
    {
        HashMap<Integer,Level> levels= new HashMap<Integer,Level>();
        // verschillende levels
        levels.put(1,getLevel1());
        levels.put(2,getLevel2());
        levels.put(3,getLevel3());
        levels.put(4,getLevel4());
        levels.put(5,getLevel5());
        levels.put(6,getLevel6());
        levels.put(7,getLevel7());
        levels.put(8,getLevel8());
        levels.put(9,getLevel9());
        levels.put(10,getLevel10());
        levels.put(11,getLevel11());
        levels.put(12,getLevel12());
        levels.put(13,getLevel13());
        levels.put(14,getLevel14());
        levels.put(15,getLevel15());
        levels.put(16,getLevel16());
        levels.put(17,getLevel17());
        levels.put(18,getLevel18());
        int numberOfLevels=levels.size(); 
        Random random = new Random();
        int levelToGet=random.nextInt(numberOfLevels)+1;
        
        return levels.get(levelToGet);
    }
    
    public void volgendLevel()
    {
        maakVeldLeeg();
        Level level=getRandomLevel();       
        
        huidigLevel=maakLevel(level.Design);
        
        addCounter(level.MaxMoves);
    }
    
    private void maakVeldLeeg()
    {   
        if (huidigLevel==null)
            return;
        
        for(int y=0;y<huidigLevel.length;y++){
            for(int x=0;x<huidigLevel[y].length;x++){
                removeObject(huidigLevel[y][x]);
            }
        }
             
        removeCounter();
    }
    
    private Level getLevel1()
    {
        TegelType[][] design = new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok_mario, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Lange,TegelType.Lange,TegelType.Lange,TegelType.Lange, TegelType.Hoek, TegelType.Eind,TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Lange,TegelType.Lange,TegelType.Lange, TegelType.Hoek, TegelType.Hoek, TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Start,TegelType.Hoek,TegelType.Lange, TegelType.Lange, TegelType.Hoek, TegelType.Lange,TegelType.Hoek, TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Lange,TegelType.Lange,TegelType.Lange,TegelType.Lange,TegelType.Hoek, TegelType.Lange, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok}
        };
        
        return new Level(design,19);
    }
    
    private Level getLevel2()
    {
        TegelType[][] design = new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok,TegelType.Blok, TegelType.Blok_mario, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Lange,TegelType.Lange,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Eind, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Lange, TegelType.Hoek, TegelType.Hoek, TegelType.Hoek,TegelType.Hoek, TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Lange, TegelType.Lange,TegelType.Hoek, TegelType.Hoek, TegelType.Hoek,TegelType.Start,TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Lange,TegelType.Lange,TegelType.Lange,TegelType.Hoek, TegelType.Hoek, TegelType.Hoek, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok}
        };
        
        return new Level(design,33);
    }
    
    private Level getLevel3()
    {
        TegelType[][] design = new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok_mario,TegelType.Blok, TegelType.Blok, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Eind, TegelType.Hoek, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Start,TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Lange, TegelType.Hoek,TegelType.Hoek, TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Lange, TegelType.Lange,TegelType.Hoek, TegelType.Hoek, TegelType.Hoek,TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Lange,TegelType.Lange,TegelType.Hoek, TegelType.Lange, TegelType.Hoek, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok}
        };
        
        return new Level(design,17);
    }
    
    private Level getLevel4()
    {
        TegelType[][] design = new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok_mario,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok},
            {TegelType.Blok,TegelType.Eind,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Lange,TegelType.Lange, TegelType.Hoek, TegelType.Lange, TegelType.Hoek,TegelType.Hoek, TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Start,TegelType.Hoek,TegelType.Hoek, TegelType.Lange,TegelType.Hoek, TegelType.Hoek, TegelType.Hoek,TegelType.Lange,TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Lange,TegelType.Hoek,TegelType.Lange,TegelType.Lange, TegelType.Lange, TegelType.Lange, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok}
        };
        
        return new Level(design,18);
    }
    
    private Level getLevel5()
    {
        TegelType[][] design = new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok_mario,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok},
            {TegelType.Blok,TegelType.Eind,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Lange,TegelType.Hoek, TegelType.Hoek, TegelType.Hoek, TegelType.Hoek,TegelType.Lange, TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Start,TegelType.Hoek, TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Hoek,TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Hoek, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok}
        };
        
        return new Level(design,37);
    }
    
    private Level getLevel6()
    {
        TegelType[][] design = new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok,TegelType.Blok, TegelType.Blok_mario, TegelType.Blok},
            {TegelType.Blok,TegelType.Start,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Lange,TegelType.Hoek, TegelType.Hoek, TegelType.Eind, TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Hoek,TegelType.Hoek, TegelType.Lange, TegelType.Hoek, TegelType.Lange,TegelType.Lange, TegelType.Lange,TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Lange,TegelType.Lange, TegelType.Lange,TegelType.Hoek, TegelType.Lange, TegelType.Hoek,TegelType.Lange,TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Lange, TegelType.Hoek, TegelType.Lange, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok}
        };
        
        return new Level(design,31);
    }
    
    private Level getLevel7()
    {
        TegelType[][] design = new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Lange,TegelType.Lange, TegelType.Hoek, TegelType.Start, TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Hoek, TegelType.Lange,TegelType.Hoek, TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Lange,TegelType.Lange, TegelType.Lange,TegelType.Lange, TegelType.Lange, TegelType.Hoek,TegelType.Eind,TegelType.Blok_mario},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek, TegelType.Lange, TegelType.Lange, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok}
        };
        
        return new Level(design,20);
    }
    
    private Level getLevel8()
    {
        TegelType[][] design = new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Lange, TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Hoek, TegelType.Lange,TegelType.Hoek, TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok_mario,TegelType.Eind,TegelType.Lange,TegelType.Lange, TegelType.Lange,TegelType.Lange, TegelType.Lange, TegelType.Hoek,TegelType.Start,TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek, TegelType.Lange, TegelType.Lange, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok}
        };
        
        return new Level(design,23);
    }
    
    private Level getLevel9()
    {
        TegelType[][] design = new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Lange, TegelType.Blok},
            {TegelType.Blok_mario,TegelType.Eind,TegelType.Lange,TegelType.Lange, TegelType.Hoek, TegelType.Hoek, TegelType.Lange,TegelType.Hoek, TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Lange,TegelType.Lange, TegelType.Lange,TegelType.Lange, TegelType.Lange, TegelType.Hoek,TegelType.Start,TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Lange, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok}
        };
        
        return new Level(design,34);
    }
    
    private Level getLevel10()
    {
        TegelType[][] design = new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok_mario,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok},
            {TegelType.Blok,TegelType.Eind,TegelType.Hoek,TegelType.Hoek,TegelType.Lange,TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Start, TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Hoek,TegelType.Lange, TegelType.Hoek, TegelType.Hoek, TegelType.Lange,TegelType.Lange, TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Lange,TegelType.Lange, TegelType.Lange,TegelType.Lange, TegelType.Lange, TegelType.Hoek,TegelType.Lange,TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Lange, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok}
        };
        
        return new Level(design,20);
    }
    
    private Level getLevel11()
    {
        TegelType[][] design = new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Lange,TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Eind, TegelType.Blok_mario},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Lange, TegelType.Hoek, TegelType.Hoek, TegelType.Hoek,TegelType.Hoek, TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Lange,TegelType.Lange, TegelType.Lange,TegelType.Lange, TegelType.Start, TegelType.Hoek,TegelType.Lange,TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Hoek, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok}
        };
        
        return new Level(design,16);
    }
    
    private Level getLevel12()
    {
        TegelType[][] design = new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok,TegelType.Blok_mario, TegelType.Blok, TegelType.Blok},
            {TegelType.Blok,TegelType.Start,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek, TegelType.Eind, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Lange,TegelType.Lange, TegelType.Hoek, TegelType.Hoek, TegelType.Lange,TegelType.Hoek, TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Lange,TegelType.Lange, TegelType.Lange,TegelType.Lange, TegelType.Hoek, TegelType.Lange,TegelType.Lange,TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Lange, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok}
        };
        
        return new Level(design,16);
    }
    
    private Level getLevel13()
    {
        TegelType[][] design = new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok_mario,TegelType.Blok, TegelType.Blok, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Start,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Eind, TegelType.Hoek, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Lange,TegelType.Lange, TegelType.Hoek, TegelType.Hoek, TegelType.Lange,TegelType.Hoek, TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Lange,TegelType.Hoek, TegelType.Lange,TegelType.Hoek, TegelType.Lange, TegelType.Lange,TegelType.Lange,TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Lange, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok}
        };
        
        return new Level(design,17);
    }
    
    private Level getLevel14()
    {
        TegelType[][] design = new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok_mario, TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Start,TegelType.Hoek,TegelType.Hoek,TegelType.Eind, TegelType.Hoek, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Hoek,TegelType.Hoek, TegelType.Lange, TegelType.Lange, TegelType.Lange,TegelType.Hoek, TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Hoek,TegelType.Hoek, TegelType.Lange,TegelType.Hoek, TegelType.Hoek, TegelType.Hoek,TegelType.Lange,TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek, TegelType.Lange, TegelType.Lange, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok}
        };
        
        return new Level(design,30);
    }
    
    private Level getLevel15()
    {
        TegelType[][] design = new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok_mario, TegelType.Blok, TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Eind,TegelType.Hoek,TegelType.Start, TegelType.Hoek, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Lange,TegelType.Hoek, TegelType.Hoek, TegelType.Lange, TegelType.Lange,TegelType.Hoek, TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Lange,TegelType.Lange, TegelType.Lange,TegelType.Hoek, TegelType.Lange, TegelType.Lange,TegelType.Lange,TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Lange,TegelType.Lange, TegelType.Hoek, TegelType.Lange, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok}
        };
        
        return new Level(design,14);
    }
    
    private Level getLevel16()
    {
        TegelType[][] design = new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok_mario, TegelType.Blok, TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Lange,TegelType.Hoek,TegelType.Eind,TegelType.Hoek,TegelType.Start, TegelType.Hoek, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Lange, TegelType.Lange,TegelType.Hoek, TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Hoek,TegelType.Hoek, TegelType.Lange,TegelType.Hoek, TegelType.Hoek, TegelType.Hoek,TegelType.Lange,TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Lange,TegelType.Hoek, TegelType.Lange, TegelType.Lange, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok}
        };
        
        return new Level(design,21);
    }
    
    private Level getLevel17()
    {
        TegelType[][] design = new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok_mario, TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Start,TegelType.Hoek,TegelType.Hoek,TegelType.Eind, TegelType.Hoek, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Lange, TegelType.Lange,TegelType.Hoek, TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Hoek,TegelType.Lange, TegelType.Lange,TegelType.Hoek, TegelType.Hoek, TegelType.Hoek,TegelType.Lange,TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Lange,TegelType.Hoek, TegelType.Lange, TegelType.Lange, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok}
        };
        
        return new Level(design,15);
    }
    
    private Level getLevel18()
    {
        TegelType[][] design = new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok},
            {TegelType.Blok_mario,TegelType.Eind,TegelType.Hoek,TegelType.Start,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek, TegelType.Hoek, TegelType.Lange, TegelType.Lange,TegelType.Hoek, TegelType.Hoek,TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Hoek,TegelType.Lange, TegelType.Lange,TegelType.Hoek, TegelType.Hoek, TegelType.Hoek,TegelType.Lange,TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Lange,TegelType.Hoek, TegelType.Lange, TegelType.Lange, TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok, TegelType.Blok}
        };
        
        return new Level(design,19);
    }
}
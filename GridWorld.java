 import greenfoot.*;

public class GridWorld extends World
{
    
    private static final int gridWidth = 32;
    private static final int gridHeight = 32;
    private static Actor[][] grid = new Actor[gridWidth][gridHeight];
    
    private int counter = 0;
    private Counter the_counter;
    private GameMaster gameMaster;
    public static final int gridSize = 32;
    public Tegel[][] huidigLevel = null;

    
    
    public GridWorld()
    {    
        super(gridWidth * gridSize, gridHeight * gridSize, 1);
        
        setPaintOrder( Counter.class, Wall.class, Tegel.class);
        the_counter=new Counter();
        addObjectToGrid(the_counter, gridWidth / 2 - 10, 0);
        
        gameMaster=new GameMaster();
        
        for (int x = 0; x < gridWidth; x++) {
            addObjectToGrid(new Wall(), x, 0);
            addObjectToGrid(new Wall(), x, gridHeight - 1);
        }
        
        for (int y = 0; y < gridHeight; y++) {
            addObjectToGrid(new Wall(), 0, y);
            addObjectToGrid(new Wall(), gridWidth - 1, y);
        }
        //eerste level
        TegelType[][] level= new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Lange,TegelType.Hoek,TegelType.Start, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek,TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Eind,TegelType.Hoek,TegelType.Lange,TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Lange,TegelType.Lange,TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok}
        };       
        
        huidigLevel=maakLevel(level);

    }
    
    public Counter getCounter()
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
            Tegel gemaaktLevel[][] = new Tegel[6][];
            
            for(int y=0;y<level.length;y++){
                gemaaktLevel[y]=new Tegel[6];
                for(int x=0;x<level[y].length;x++){
                    Tegel tegel=fabriek.MaakTegel(level[y][x]);
                    gemaaktLevel[y][x]=tegel;
                    addObjectToGrid(tegel,x*space+ 1,y*space +1);
                }
            }
                    
            return gemaaktLevel;
        }
        
    //public Counter getCounter()
    //{
    //    return counter;
    //}
}

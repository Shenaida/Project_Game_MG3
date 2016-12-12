import greenfoot.*;

public class GridWorld extends World
{
    
    private static final int gridWidth = 32;
    private static final int gridHeight = 32;
    private static Actor[][] grid = new Actor[gridWidth][gridHeight];
    
    private int counter = 0;
    
    public static final int gridSize = 32;
    public TegelType[][] huidiglevel = null;

    
    
    public GridWorld()
    {    
        super(gridWidth * gridSize, gridHeight * gridSize, 1);
        
        setPaintOrder( Counter.class, Wall.class, Tegel.class);
        
        addObjectToGrid(new Counter(), gridWidth / 2 - 10, 0);

        for (int x = 0; x < gridWidth; x++) {
            addObjectToGrid(new Wall(), x, 0);
            addObjectToGrid(new Wall(), x, gridHeight - 1);
        }
        
        for (int y = 0; y < gridHeight; y++) {
            addObjectToGrid(new Wall(), 0, y);
            addObjectToGrid(new Wall(), gridWidth - 1, y);
        }
        TegelType[][] level= new TegelType[][]
        {
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Hoek,TegelType.Lange,TegelType.Eind, TegelType.Blok},
            {TegelType.Blok,TegelType.Lange,TegelType.Hoek,TegelType.Lange,TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Start,TegelType.Hoek,TegelType.Lange,TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Hoek,TegelType.Lange,TegelType.Lange,TegelType.Hoek, TegelType.Blok},
            {TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok,TegelType.Blok, TegelType.Blok}
        };       
        huidiglevel=level;
        maakLevel(level);

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
    
        private void maakLevel(TegelType[][] level)
        {
            int space=5;
            TegelFabriek fabriek=new TegelFabriek();
            
            for(int y=0;y<level.length;y++){
                for(int x=0;x<level[y].length;x++){
                    addObjectToGrid(fabriek.MaakTegel(level[y][x]),x*space+ 1,y*space +1);
                }
            }
                    
        }
}

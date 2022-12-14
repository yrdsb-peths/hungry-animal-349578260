import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Titlescreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Titlescreen extends World
{
    Label titleLabel = new Label("Hungry Elephant", 60);
    Label instructionLabel = new Label("Press Spacebar to Play!", 40);
    Label instructionLabel2 = new Label("(Arrow keys to move)", 40);
    /**
     * Constructor for objects of class Titlescreen.
     * 
     */
    public Titlescreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(titleLabel, getWidth()/2, getHeight()/2);
        addObject(instructionLabel, getWidth()/2, (getHeight()/3) * 2 );
        addObject(instructionLabel2, getWidth()/2, (getHeight()/4) * 3 );

    }
    
    public void act()
    {
        //Starts game on press of spacebar
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}

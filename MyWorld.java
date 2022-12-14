import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Richard Zhang
 * @version November 11th 2022
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public static int score;
    Label scoreLabel;
    int level = 1;
    boolean gameOverState = false;
    SimpleTimer appleTimer = new SimpleTimer();
    double spawnRateInS = 1;
    int time;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        //Creating the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 200);
        
        //Creation of a label
        scoreLabel = new Label(0, 70);
        addObject(scoreLabel, 50, 50);
        score = 0;
    }
    
    public void act()
    {
        if(gameOverState == false) time += appleTimer.millisElapsed();
        else
        {
            if(Greenfoot.isKeyDown("space"))
            {
                MyWorld gameWorld = new MyWorld();
                Greenfoot.setWorld(gameWorld);
            }
        }
        if(time > spawnRateInS * 100000 && gameOverState == false)
        {
            createApple();
        }
    }
    
    //Ends the game
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        Label restartLabel = new Label("Press Space to Try Again!", 60);
        
        addObject(gameOverLabel, 300, 200);
        addObject(restartLabel, getWidth()/2, (getHeight()/3) * 2);
        score = 0;
        gameOverState = true;
    }
    
    //Increases the score
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        if(score % 3 == 0) level += 1;
    }
    
    //Instanciates an apple on the scene
    public void createApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level * 2);
        int x = Greenfoot.getRandomNumber(600);
        addObject(apple, x, 0);
        time = 0;
        appleTimer.mark();
    }
}

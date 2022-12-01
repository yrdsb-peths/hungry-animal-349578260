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
    public static int score = 0;
    Label scoreLabel;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        //Creating the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 200);
        
        //Creation of a label
        Label scoreLabel = new Label(0, 70);
        addObject(scoreLabel, 50, 50);
        
        createApple();
    }
    
    //Ends the game
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    //Increases the score
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
    //Instanciates an apple on the scene
    public void createApple()
    {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        addObject(apple, x, 0);
    }
}

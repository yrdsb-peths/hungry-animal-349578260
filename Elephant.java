import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Elephant hero.
 * 
 * @author Richard Zhang 
 * @version November 11th 2022
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    // Direction that the elephant is facing
    public Elephant()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(80, 80);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(80, 80);
        }
        
        animationTimer.mark();
        
        // Set default image
        setImage(idleRight[0]);
    }
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 200) return;
        animationTimer.mark();
        
        if(facing.equals("right"))
        {   
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else 
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left")) 
        {
            move(-3);
            facing = "left";            
        }
        else if(Greenfoot.isKeyDown("right")) 
        {
            move(3);
            facing = "right";
        }
        
        // Remove an apple after it has been eating
        eat();
        
        // Animate the elephant
        animateElephant();
    }
    
    //Code for the elephant to eat an apple
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            elephantSound.play();
        }
    }
}

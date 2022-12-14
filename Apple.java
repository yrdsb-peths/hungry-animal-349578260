import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for our elephant.
 * 
 * @author Richard Zhang
 * @version November 11th 2022
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //modifies the speed
    int speedModifier = 1;
    
    public void act()
    {
        // Add your action code here.
        //Apple falling downwards
        setLocation(getX(), getY() + speedModifier );
        
        //Removes the apple when it touches the ground
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
        
    }
    public void setSpeed(int speed)
    {
        speedModifier = 1;        
    }
}

package MyLove;

import java.awt.image.BufferedImage;
import java.util.Random;

public class EnemyA extends Fly {

    private boolean aDirection = true;
    private boolean bDirection = true;
    private Random r = new Random();
    public int enemylife = 2;


    public EnemyA(int x, int y, int width, int height, BufferedImage image) {
        super(x, y, width, height, image);
    }

    @Override
    public void move(long time) {
       if (aDirection) {
           if (x < 450)
               x += r.nextInt(5);
           else
               aDirection = false;
       }
       else {
           if (x > 250)
               x -= r.nextInt(5);
           else
               aDirection = true;
       }
       if (bDirection) {
           if (y < 250)
               y += r.nextInt(5);
           else
               bDirection = false;
       }
       else {
           if (y > 50)
               y -= r.nextInt(5);
           else
               bDirection = true;
       }
    }

    public EnemyBullet enemyfire(){
        EnemyBullet e = new EnemyBullet(this.x+width/4,this.y+height/4);
        return e;
    }


}

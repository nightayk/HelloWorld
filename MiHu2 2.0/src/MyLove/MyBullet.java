package MyLove;

import java.awt.image.BufferedImage;

public class MyBullet extends Fly {

    public MyBullet(int x, int y,int width,int heigth, BufferedImage image) {
        super(x+10, y-20,width , heigth, image);
    }

    @Override
    public void move(long time) {
        if(time%10 == 0){
            y -= 10;
        }
    }
}

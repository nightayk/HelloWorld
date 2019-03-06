package MyLove;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Gift extends Fly {

    private Random r = new Random();
    private boolean d;

    public Gift(int x, int y, int width, int height, BufferedImage image) {
        super(x, y, width, height, image);
        if (x<250)
            d = true;
    }

    @Override
    public void move(long time) {
        int m = r.nextInt(5);
        if(d)
            x += m;
        else
            x -= m;
        y += m;

    }
}

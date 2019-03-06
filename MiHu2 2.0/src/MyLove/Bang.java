package MyLove;


import java.awt.*;

public class Bang extends Fly{

    public Bang(int x, int y) {
        super(x-60, y-70, 128, 128, ImageRead.boom);
    }

    @Override
    public void move(long time) {

    }
    public void draw(Graphics g){
            g.drawImage(ImageRead.boom2,x,y,120,120,null);

    }
}

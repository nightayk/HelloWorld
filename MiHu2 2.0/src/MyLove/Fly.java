package MyLove;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Fly {

    public int x,y;
    public int width,height;
    BufferedImage image;

    //构造器
    public Fly(int x,int y,int width,int height,BufferedImage image){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.image = image;
    }
    //移动
    public abstract void move(long time);
    //碰撞
    public static boolean boom (Fly f1,Fly f2){
        int f1x = f1.x + f1.width/2;
        int f1y = f1.y + f1.height/2;
        int f2x,f2y;
        if (f2.width > 200 && f2.height > 350 ) {
            f2.width -= 150;
            f2.height -= 150;
        }
            f2x = f2.x + f2.width / 2;
            f2y = f2.y + f2.height / 2;
        boolean H = Math.abs(f1x - f2x) < (f1.width + f2.width)/2;
        boolean V = Math.abs(f1y -f2y) < (f1.height + f2.height)/2;
        return H&V;
    }

    //绘制
    public void draw(Graphics g){
        g.drawImage(image,x,y,width,height,null);
    }


}

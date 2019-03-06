package MyLove;


import java.awt.*;

public class Me extends Fly {

    public int speed = 7;

    public Me(int x, int y) {
        super(x, y, 120, 79, ImageRead.me);
    }

    public void MoveUp() {
        if (y >= 10)
            y -= speed;
    }

    public void MoveDown() {
        if (y <= 650)
            y += speed;
    }

    public void MoveLeft() {
        if (x >= 0)
            x -= speed;
    }

    public void MoveRight() {
        if (x <= 420)
            x += speed;
    }


    @Override
    public void move(long time) {

    }


    public MyBullet MyFire(int n){
        MyBullet bullet = new MyBullet(this.x + width / 4, this.y + height / 4,42,50, ImageRead.mybullet1);
        switch (n) {
            case 1:
                bullet = new MyBullet(this.x + width / 4, this.y + height / 4, 42,50,ImageRead.mybullet1);
                break;
            case 2:
                bullet = new MyBullet(this.x + width / 4, this.y + height / 4,42,50, ImageRead.mybullet2);
                break;
            case 3:
                bullet = new MyBullet(this.x + width / 4, this.y + height / 4,42,50, ImageRead.mybullet3);
                break;
            case 5:
                bullet = new MyBullet(this.x + width / 4 - 40, this.y + height / 4 - 50, 128,128,ImageRead.superbullet);
                break;
        }
        return bullet;
    }

    public void draw(Graphics g){
        g.drawImage(image,x,y,width,height,null);
    }

}

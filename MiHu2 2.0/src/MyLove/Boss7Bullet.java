package MyLove;



public class Boss7Bullet extends Fly{


    public Boss7Bullet(int x, int y) {
        super(x, y, 48, 46,ImageRead.enemybullet1 );
    }
    public void move(long time,int m,int n) {
        if (time % 20 == 0){
            if ( x < m)
                x += 5;
            if (x > m)
                x -= 5;
            if (y < n)
                y += 5;
            if (y > n)
                y -= 5;
        }


    }

    @Override
    public void move(long time) {

    }
}

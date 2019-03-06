package MyLove;

public class EnemyBullet extends Fly {
    public EnemyBullet(int x, int y) {
        super(x, y, 48, 46, ImageRead.enemybullet1);
    }

    @Override
    public void move(long time) {
        if(time%20 == 0){
            y += 10;
        }
    }
}

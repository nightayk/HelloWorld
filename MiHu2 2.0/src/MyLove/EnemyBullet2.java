package MyLove;

import java.util.Random;

public class EnemyBullet2 extends Fly {

    private Random r = new Random();

    public EnemyBullet2(int x, int y) {
        super(x, y, 120, 150, ImageRead.enemybullet2);
    }
    @Override
    public void move(long time) {
        int a;
        if(time%10 == 0){
            y += 20;
            if (time %50 ==0) {
                a = r.nextInt(2)+1;
                if (a % 2 == 0)
                    x += r.nextInt(20)+10;
                else
                    x -= r.nextInt(20)+10;
            }

        }
    }
}

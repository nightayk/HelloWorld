package MyLove;

import java.awt.image.BufferedImage;

public class Boss extends Fly {

        int blife;

        public Boss(int x, int y, int width, int height, BufferedImage image,int blife) {
            super(x, y, width, height, image);
            this.blife = blife;
        }

        @Override
        public void move(long time) {
           if (this.y < 0)
               y += 3;
        }

        public EnemyBullet2 enemyfire(){
            EnemyBullet2 e = new EnemyBullet2(this.x+width/4,this.y+height/4);
            return e;
        }
         public EnemyBullet2 enemyfire2(){
           EnemyBullet2 e = new EnemyBullet2(this.x+width/4+170,this.y+height/4);
           return e;
    }
}


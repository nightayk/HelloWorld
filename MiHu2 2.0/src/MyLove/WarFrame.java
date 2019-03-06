package MyLove;




import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;




public class WarFrame extends JPanel implements KeyListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int state = START;
    private boolean left,up,right,down,SPACE, ENTER,X,Z,C;

    private static int START = 0;
    private static int RUNNING = 1;
    private static int GAMEOVER = 3;
    private static int WIN = 4;


    private int time = 0;
    private int bgmove = 0;
    private int score = 0;
    private int stage = 0;
    private int life = 30;
    private int fire = 1;
    private int level = 1;
    private int shield = 0;
    private int spower = 30;
    private int supnum = 2;
    private int hit = 1;


    private boolean bosslife1 = true;
    private boolean bosslife2 = true;
    private boolean bosslife3 = true;
    private boolean bosslife4 = true;
    private boolean bosslife5 = true;
    private boolean bosslife6 = true;
    private boolean bosslife7 = true;

    private boolean bosslifes1 = true;
    private boolean bosslifes2 = true;
    private boolean bosslifes3 = true;
    private boolean bosslifes4 = true;
    private boolean bosslifes5 = true;
    private boolean bosslifes6 = true;
    private boolean bosslifes7 = true;

    private Date endTime;
    private Date startTime;
    private boolean superend;

    private Random r = new Random();

    private AudioClip bgmusic;
    private AudioClip bangmusic;
    private AudioClip bulletmusic;

    private int blife1 = 50;
    private int blife2 = 80;
    private int blife3 = 120;
    private int blife4 = 200;
    private int blife5 = 300;
    private int blife6 = 600;
    private int blife7 = 1000;


    private Me me = new Me(206,650);
    private Boss b1 = new Boss(70,-300,362,217,ImageRead.boss1,50);
    private Boss b2 = new Boss(70,-300,407,207,ImageRead.boss2,80);
    private Boss b3 = new Boss(70,-300,424,275,ImageRead.boss3,120);
    private Boss b4 = new Boss(70,-300,349,260,ImageRead.boss4,200);
    private Boss b5 = new Boss(70,-300,302,190,ImageRead.boss5,300);
    private Boss b6 = new Boss(70,-300,302,190,ImageRead.boss6,600);
    private Boss b7 = new Boss(206,-300,120,79,ImageRead.boss7,1000);
    private List<Bang> bang = new ArrayList<>();
    private List<EnemyA> enemyA1 = new ArrayList<>();
    private List<EnemyA> enemyA2 = new ArrayList<>();
    private List<EnemyB> enemyB1 = new ArrayList<>();
    private List<EnemyB> enemyB2 = new ArrayList<>();
    private List<EnemyB> enemyB3 = new ArrayList<>();
    private List<Gift> g1 = new ArrayList<>();
    private List<Gift> g2 = new ArrayList<>();
    private List<Boss> boss = new ArrayList<>();
    private List<EnemyBullet> enemyBullet1 = new ArrayList<>();
    private List<EnemyBullet2> enemyBullet2 = new ArrayList<>();
    private List<Boss7Bullet> boss7Bullet = new ArrayList<>();
    private List<MyBullet> myBullet1 = new ArrayList<>();


    public WarFrame() {

        this.addKeyListener(this);

        File f1 = new File("./Music/bgm.wav");
        File f2 = new File("./Music/bang.wav");
        File f3 = new File("./Music/bullet.wav");

        URL u1 = null;
        URL u2 = null;
        URL u3 = null;
        try {
            u1 = f1.toURI().toURL();
            u2 = f2.toURI().toURL();
            u3 = f3.toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        bgmusic = Applet.newAudioClip(u1);
        bangmusic = Applet.newAudioClip(u2);
        bulletmusic = Applet.newAudioClip(u3);


    Thread game = new Thread() {
        public void run() {
            bgmusic.loop();

            while (true) {
                moving();
                if (state == RUNNING && stage == 1) {
                    if (score > 200 ) {
                        stage = 6;
                    }
                    enemymoving(time);
                    mbmoving(time);
                    ebmoving(time);
                    enemy(time);
                    enemyfire(time);
                    collison(time);
                    crash(time);
                    gift(time);
                    giftmove(time);
                    giftcrash(time);
                    bulletover(time);
                    setme();
                    maxcrash();


                    time += 30;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (state == RUNNING && stage == 2) {
                    if (score > 1000 ) {
                        stage = 7;
                    }
                    enemymoving(time);
                    mbmoving(time);
                    ebmoving(time);
                    enemy2(time);
                    enemyfire(time);
                    collison(time);
                    crash(time);
                    bbmoving(time);
                    gift(time);
                    giftmove(time);
                    giftcrash(time);
                    bulletover(time);
                    setme();
                    maxcrash();
                    boss7Bullet.clear();


                    time += 30;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (state == RUNNING && stage == 3) {
                    if (score > 2500 ) {
                        stage = 8;
                    }
                    enemymoving(time);
                    mbmoving(time);
                    ebmoving(time);
                    enemy3(time);
                    enemyfire(time);
                    collison(time);
                    crash(time);
                    bbmoving(time);
                    gift(time);
                    giftmove(time);
                    giftcrash(time);
                    bulletover(time);
                    setme();
                    maxcrash();
                    boss7Bullet.clear();


                    time += 30;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (state == RUNNING && stage == 4) {
                    if (score > 4000 ) {
                        stage = 9;
                    }
                    enemymoving(time);
                    mbmoving(time);
                    ebmoving(time);
                    enemy4(time);
                    enemyfire(time);
                    collison(time);
                    crash(time);
                    bbmoving(time);
                    gift(time);
                    giftmove(time);
                    giftcrash(time);
                    bulletover(time);
                    setme();
                    maxcrash();
                    boss7Bullet.clear();


                    time += 30;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (state == RUNNING && stage == 5) {
                    if (score > 6000 ) {
                        stage = 10;
                    }
                    enemymoving(time);
                    mbmoving(time);
                    ebmoving(time);
                    enemy4(time);
                    enemy4(time);
                    enemyfire(time);
                    collison(time);
                    crash(time);
                    bbmoving(time);
                    gift(time);
                    giftmove(time);
                    giftcrash(time);
                    bulletover(time);
                    setme();
                    maxcrash();
                    boss7Bullet.clear();

                    time += 30;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (state == RUNNING && stage == 6){
                    if (bosslifes1) {
                        boss.add(b1);
                        bosslifes1 = false;
                    }
                    bossmove(time,0);
                    mbmoving(time);
                    bossfire(time,800,0);
                    bcrash(time,3);
                    bcollison(time,0);
                    enemymoving(time);
                    ebmoving(time);
                    bbmoving(time);
                    collison(time);
                    crash(time);
                    giftmove(time);
                    giftcrash(time);
                    bulletover(time);
                    setme();
                    maxcrash();

                    time += 30;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (state == RUNNING && stage == 7){
                    if (bosslifes2) {
                        boss.add(b2);
                        bosslifes2 = false;
                    }
                    bossmove(time,1);
                    mbmoving(time);
                    bossfire(time,700,1);
                    bcrash(time,5);
                    bcollison(time,1);
                    enemymoving(time);
                    ebmoving(time);
                    bbmoving(time);
                    collison(time);
                    crash(time);
                    giftmove(time);
                    giftcrash(time);
                    bulletover(time);
                    setme();
                    maxcrash();

                    time += 30;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (state == RUNNING && stage == 8){
                    if (bosslifes3) {
                        boss.add(b3);
                        bosslifes3 = false;
                    }
                    bossmove(time,2);
                    mbmoving(time);
                    bossfire(time,600,2);
                    bcrash(time,7);
                    bcollison(time,2);
                    enemymoving(time);
                    ebmoving(time);
                    bbmoving(time);
                    collison(time);
                    crash(time);
                    giftmove(time);
                    giftcrash(time);
                    bulletover(time);
                    setme();
                    maxcrash();

                    time += 30;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (state == RUNNING && stage == 9){
                    if (bosslifes4) {
                        boss.add(b4);
                        bosslifes4 = false;
                    }
                    bossmove(time,3);
                    mbmoving(time);
                    bossfire(time,500,3);
                    bcrash(time,10);
                    bcollison(time,3);
                    enemymoving(time);
                    ebmoving(time);
                    bbmoving(time);
                    collison(time);
                    crash(time);
                    giftmove(time);
                    giftcrash(time);
                    bulletover(time);
                    setme();
                    maxcrash();

                    time += 30;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (state == RUNNING && stage == 10){
                    if (bosslifes5) {
                        boss.add(b5);
                        bosslifes5 = false;
                    }
                    bossmove(time,4);
                    mbmoving(time);
                    bossfire(time,400,4);
                    bcrash(time,20);
                    bcollison(time,4);
                    enemymoving(time);
                    ebmoving(time);
                    bbmoving(time);
                    collison(time);
                    crash(time);
                    giftmove(time);
                    giftcrash(time);
                    bulletover(time);
                    setme();
                    maxcrash();

                    time += 30;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (state == RUNNING && stage == 11){
                    if (bosslifes6) {
                        boss.add(b6);
                        bosslifes6 = false;
                    }
                    bossmove(time,5);
                    mbmoving(time);
                    bossfire(time,400,5);
                    bcrash(time,30);
                    bcollison(time,5);
                    enemymoving(time);
                    mbmoving(time);
                    ebmoving(time);
                    enemy2(time);
                    enemyfire(time);
                    bbmoving(time);
                    collison(time);
                    crash(time);
                    gift(time);
                    giftmove(time);
                    giftcrash(time);
                    bulletover(time);
                    setme();
                    maxcrash();

                    time += 30;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (state == RUNNING && stage == 12){
                    if (bosslifes7) {
                        boss.add(b7);
                        bosslifes7 = false;
                    }
                    bossmove(time,6);
                    mbmoving(time);
                    bossfire(time,400,6);
                    bcrash(time,20);
                    bcollison(time,6);
                    enemymoving(time);
                    ebmoving(time);
                    collison(time);
                    crash(time);
                    bbmoving(time);
                    gift(time);
                    gift(time);
                    giftmove(time);
                    giftcrash(time);
                    bulletover(time);
                    setme();
                    maxcrash();


                    time += 30;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                repaint();
            }
        }

        public void moving() {
            if (up) {
                me.MoveUp();
            }
            if (down) {
                me.MoveDown();
            }
            if (left) {
                me.MoveLeft();
            }
            if (right) {
                me.MoveRight();
            }
            if (SPACE) {
                MyBullet bullet = me.MyFire(fire);
                if (time % 40 == 0) {   
                    bulletmusic.play();
                    myBullet1.add(bullet);
                }
            }
            if (X){
                fire ++;
                if (fire > 3)
                    fire = 1;
            }
            if (Z && supnum > 0){
                if (! superend && level == 4) {
                    level = 6;
                    startTime = new Date();
                    superend = true;
                    if (level == 6)
                        supnum --;
                    setme();
                }
            }
            if (C){
                if (superend && level == 6) {
                    level = 3;
                    superend = false;
                    life -= 10;
                    setme();
                }
            }
            if (ENTER) {
                if (state == START && stage == 0) {
                    state = RUNNING;
                    stage = 1;
                } else if (state == GAMEOVER || state == WIN) {
                    state = RUNNING;
                    me.x = 206;
                    me.y = 650;
                    mystart();
                }
            }

        }

        public void mystart() {
            myBullet1.clear();
            enemyA1.clear();
            enemyA2.clear();
            enemyB1.clear();
            enemyB2.clear();
            enemyB3.clear();
            enemyBullet1.clear();
            enemyBullet2.clear();
            boss7Bullet.clear();
            boss.clear();
            g1.clear();
            g2.clear();

            state = 1;
            fire = 1;
            stage = 1;
            score = 0;
            level = 1;
            shield = 0;
            life = 30;
            hit = 1;
            spower = 30;
            superend = false;
            supnum = 2;

            bosslife1 = true;
            bosslife2 = true;
            bosslife3 = true;
            bosslife4 = true;
            bosslife5 = true;
            bosslife6 = true;
            bosslife7 = true;

            bosslifes1 = true;
            bosslifes2 = true;
            bosslifes3 = true;
            bosslifes4 = true;
            bosslifes5 = true;
            bosslifes6 = true;
            bosslifes7 = true;

            b1.blife = 50;
            b2.blife = 80;
            b3.blife = 120;
            b4.blife = 200;
            b5.blife = 300;
            b6.blife = 600;
            b7.blife = 1000;

            blife1 = 50;
            blife2 = 80;
            blife3 = 120;
            blife4 = 200;
            blife5 = 300;
            blife6 = 600;
            blife7 = 1000;




        }

        public void collison(long time) {
            int m1 = myBullet1.size();
            int e1 = enemyA1.size();
            int e2 = enemyA2.size();
            int e3 = enemyB1.size();
            int e4 = enemyB2.size();
            int e5 = enemyB3.size();
            
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < e1; j++) {
                    if (Fly.boom(myBullet1.get(i), enemyA1.get(j))) {
                        bangmusic.play();
                        MyBullet hb = myBullet1.get(i);
                        Bang bang1 = new Bang(hb.x, hb.y);
                        bang.add(bang1);
                        myBullet1.remove(myBullet1.get(i));
                        enemyA1.get(j).enemylife -= hit;
                        if (enemyA1.get(j).enemylife <= 0)
                        enemyA1.remove(enemyA1.get(j));

                        score += 20;
                        m1--;
                        e1--;
                        i--;
                        j--;

                        break;
                    }
                }
            }
       
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < e2; j++) {
                    if (Fly.boom(myBullet1.get(i), enemyA2.get(j))) {
                        bangmusic.play();
                        MyBullet hb = myBullet1.get(i);
                        Bang bang2 = new Bang(hb.x, hb.y);
                        bang.add(bang2);
                        myBullet1.remove(myBullet1.get(i));
                        enemyA2.get(j).enemylife -= hit;
                        if (enemyA2.get(j).enemylife <= 0)
                        enemyA2.remove(enemyA2.get(j));

                        score += 20;
                        m1--;
                        e2--;
                        i--;
                        j--;

                        break;
                    }
                }
            }
     
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < e3; j++) {
                    if (Fly.boom(myBullet1.get(i), enemyB1.get(j))) {
                        bangmusic.play();
                        MyBullet hb = myBullet1.get(i);
                        Bang bang3 = new Bang(hb.x, hb.y);
                        bang.add(bang3);
                        myBullet1.remove(myBullet1.get(i));
                        enemyB1.get(j).enemylife -= hit;
                        if (enemyB1.get(j).enemylife <= 0)
                            enemyB1.remove(enemyB1.get(j));

                        score += 20;
                        m1--;
                        e3--;
                        i--;
                        j--;

                        break;
                    }
                }
            }
     
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < e4; j++) {
                    if (Fly.boom(myBullet1.get(i), enemyB2.get(j))) {
                        bangmusic.play();
                        MyBullet hb = myBullet1.get(i);
                        Bang bang4 = new Bang(hb.x, hb.y);
                        bang.add(bang4);
                        myBullet1.remove(myBullet1.get(i));
                        enemyB2.get(j).enemylife -= hit;
                        if (enemyB2.get(j).enemylife <= 0)
                        enemyB2.remove(enemyB2.get(j));

                        score += 20;
                        m1--;
                        e4--;
                        i--;
                        j--;

                        break;
                    }
                }
            }
       
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < e5; j++) {
                    if (Fly.boom(myBullet1.get(i), enemyB3.get(j))) {
                        bangmusic.play();
                        MyBullet hb = myBullet1.get(i);
                        Bang bang5 = new Bang(hb.x, hb.y);
                        bang.add(bang5);
                        myBullet1.remove(myBullet1.get(i));
                        enemyB3.get(j).enemylife -= hit;
                        if (enemyB3.get(j).enemylife <= 0)
                        enemyB3.remove(enemyB3.get(j));

                        score += 20;
                        m1--;
                        e5--;
                        i--;
                        j--;

                        break;
                    }
                }
            }
        }

        public void bcollison(long time,int n){
            int m1 = myBullet1.size();
            for (int i = 0; i < m1; i++) {
                if (Fly.boom(myBullet1.get(i), boss.get(n))) {
                        boss.get(n).blife -= hit;
                    switch (n){
                        case 0:
                            blife1 -= hit;
                            break;
                        case 1:
                            blife2 -= hit;
                            break;
                        case 2:
                            blife3 -= hit;
                            break;
                        case 3:
                            blife4 -= hit;
                            break;
                        case 4:
                            blife5 -= hit;
                            break;
                        case 5:
                            blife6 -= hit;
                            break;
                        case 6:
                            blife7 -= hit;
                            break;
                        default:
                            break;
                    }
                    MyBullet hb = myBullet1.get(i);
                    myBullet1.remove(myBullet1.get(i));
                    Bang bang1 = new Bang(hb.x, hb.y);
                    bang.add(bang1);

                    if (boss.get(n).blife <= 0 ) {
                        Bang bang2 = new Bang(boss.get(n).x, boss.get(n).y);
                        bang.add(bang2);
                        Bang bang3 = new Bang(boss.get(n).x, boss.get(n).y+50);
                        bang.add(bang3);
                        Bang bang4 = new Bang(boss.get(n).x, boss.get(n).y+100);
                        bang.add(bang4);
                        Bang bang5 = new Bang(boss.get(n).x+60, boss.get(n).y);
                        bang.add(bang5);
                        Bang bang6 = new Bang(boss.get(n).x+120, boss.get(n).y+30);
                        bang.add(bang6);
                        Bang bang7 = new Bang(boss.get(n).x+200, boss.get(n).y+100);
                        bang.add(bang7);
                        bosssetlife(n);
                    switch (n){
                        case 0:
                            score += 100;
                            break;
                        case 1:
                            score += 200;
                            break;
                        case 2:
                            score += 400;
                            break;
                        case 3:
                            score += 650;
                            break;
                        case 4:
                            score += 1000;
                            break;
                        case 5:
                            score += 5000;
                            break;
                        case 6:
                            score += 10000;
                            break;
                        default:
                            break;
                    }
                        if (stage != 10 && stage != 11 && stage != 12) {
                            stage -= 4;
                        }
                        if (stage == 10 ) {
                            stage = 11;
                        }
                        if (stage == 11 && blife6 <= 0) {
                            stage = 12;
                        }
                        if (stage == 12 && blife7 <= 0) {
                            state = WIN;
                        }
                    }
                    m1 --;
                    i --;
                    break;
                }
            }
        }

        public void crash(long time) {
            int m4 = enemyBullet1.size();
            for (int i = 0; i < m4; i++) {
                if (Fly.boom(enemyBullet1.get(i), me)) {
                    Bang bang3 = new Bang(enemyBullet1.get(i).x, enemyBullet1.get(i).y + 50);
                    bang.add(bang3);
                    enemyBullet1.remove(enemyBullet1.get(i));
                    if (shield > 0 && level == 8)
                        shield --;
                    else
                        life --;
                    if (life <= 0) {
                        state = GAMEOVER;
                    }
                    m4--;
                    i--;
                    break;
                }
            }
        }

        public void maxcrash() {
            int e1 = enemyA1.size();
            int e2 = enemyA2.size();
            int e3 = enemyB1.size();
            int e4 = enemyB2.size();
            int e5 = enemyB3.size();
            if (shield > 0 && level == 8) {
                for (int j = 0; j < e1; j++) {
                    if (Fly.boom(me, enemyA1.get(j))) {
                        bangmusic.play();
                        Bang bang1 = new Bang(enemyA1.get(j).x, enemyA1.get(j).y);
                        bang.add(bang1);
                        enemyA1.get(j).enemylife = 0;
                        if (enemyA1.get(j).enemylife <= 0)
                            enemyA1.remove(enemyA1.get(j));
                        score += 20;
                        shield--;
                        e1--;
                        j--;
                        break;
                    }
                }
                for (int j = 0; j < e2; j++) {
                    if (Fly.boom(me, enemyA2.get(j))) {
                        bangmusic.play();
                        Bang bang1 = new Bang(enemyA2.get(j).x, enemyA2.get(j).y);
                        bang.add(bang1);
                        enemyA2.get(j).enemylife = 0;
                        if (enemyA2.get(j).enemylife <= 0)
                            enemyA2.remove(enemyA2.get(j));
                        score += 20;
                        shield--;
                        e1--;
                        j--;
                        break;
                    }
                }
                for (int j = 0; j < e3; j++) {
                    if (Fly.boom(me, enemyB1.get(j))) {
                        bangmusic.play();
                        Bang bang1 = new Bang(enemyB1.get(j).x, enemyB1.get(j).y);
                        bang.add(bang1);
                        enemyB1.get(j).enemylife = 0;
                        if (enemyB1.get(j).enemylife <= 0)
                            enemyB1.remove(enemyB1.get(j));
                        score += 20;
                        shield--;
                        e1--;
                        j--;
                        break;
                    }
                }
                for (int j = 0; j < e4; j++) {
                    if (Fly.boom(me, enemyB2.get(j))) {
                        bangmusic.play();
                        Bang bang1 = new Bang(enemyB2.get(j).x, enemyB2.get(j).y);
                        bang.add(bang1);
                        enemyB2.get(j).enemylife = 0;
                        if (enemyB2.get(j).enemylife <= 0)
                            enemyB2.remove(enemyB2.get(j));
                        score += 20;
                        shield--;
                        e1--;
                        j--;
                        break;
                    }
                }
                for (int j = 0; j < e5; j++) {
                    if (Fly.boom(me, enemyB3.get(j))) {
                        bangmusic.play();
                        Bang bang1 = new Bang(enemyB3.get(j).x, enemyB3.get(j).y);
                        bang.add(bang1);
                        enemyB3.get(j).enemylife = 0;
                        if (enemyB3.get(j).enemylife <= 0)
                            enemyB3.remove(enemyB3.get(j));
                        score += 20;
                        shield--;
                        e1--;
                        j--;
                        break;
                    }
                }
            }
        }

        public void bcrash(long time, int n) {
            int m4 = enemyBullet2.size();
            for (int i = 0; i < m4; i++) {
                if (Fly.boom(enemyBullet2.get(i), me)) {
                    Bang bang3 = new Bang(me.x+50, me.y + 50);
                    bang.add(bang3);
                    enemyBullet2.remove(enemyBullet2.get(i));
                    if (shield > 0 && level == 8)
                       shield -= n;
                    else
                       life -= n;
                    if (life <= 0) {
                        state = GAMEOVER;
                    }
                    m4--;
                    i--;
                    break;
                }
            }
            int m5 = boss7Bullet.size();
            for (int i = 0; i < m5; i++) {
                if (Fly.boom(boss7Bullet.get(i), me)) {
                    Bang bang3 = new Bang(me.x+50, me.y + 50);
                    bang.add(bang3);
                    boss7Bullet.remove(boss7Bullet.get(i));
                    if (shield > 0 && level == 8)
                        shield --;
                    else
                        life --;
                    if (life <= 0) {
                        state = GAMEOVER;
                    }
                    m5--;
                    i--;
                    break;
                }
            }
        }

        public void giftcrash(long time){
            int m = g1.size();
            for (int i=0; i < m; i++){
                if (Fly.boom(g1.get(i),me)){
                    int k = r.nextInt(3);
                    switch (k) {
                        case 1:
                            life += 5;
                            break;
                        case 2:
                            shield += 3;
                            break;

                        default:
                            if (level < 4) {
                                level ++;
                                life += 2 * level;
                             }
                             break;
                    }

                g1.remove(g1.get(i));
                m --;
                i --;
                break;
                }
            }
            int m2 = g2.size();
            for (int i=0; i < m2; i++) {
                if (Fly.boom(g2.get(i), me)) {
                    int k = r.nextInt(10);
                    switch (k){
                        case 9:{
                            level = 8;
                            shield += 20;
                        }
                            break;
                        case 1:
                        case 6:
                            life = 90;
                            break;
                        case 3:
                        case 4:
                        case 7:
                            life += 15;
                            break;
                        default:
                            fire = 5;

                    }
                    g2.remove(g2.get(i));
                m2--;
                i--;
                break;
                }
            }
        }

        public void bulletover(long time){
            int m1 = enemyBullet1.size();
            for (int i = 0; i < m1; i ++){
                if (enemyBullet1.get(i).y > 800){
                    enemyBullet1.remove(enemyBullet1.get(i));
                    i --;
                    m1 --;
                    break;
                }
            }

            int m2 = enemyBullet2.size();
            for (int i = 0; i < m2; i ++){
                if (enemyBullet2.get(i).y > 800){
                    enemyBullet2.remove(enemyBullet2.get(i));
                    i --;
                    m2 --;
                    break;
                }
            }

            int m3 = myBullet1.size();
            for (int i = 0; i < m3; i ++){
                if (myBullet1.get(i).y < -50){
                    myBullet1.remove(myBullet1.get(i));
                    i --;
                    m3 --;
                    break;
                }
            }

            int m4 = g1.size();
            for (int i = 0; i < m4; i ++){
                if (g1.get(i).y > 800){
                    g1.remove(g1.get(i));
                    i --;
                    m4 --;
                    break;
                }
            }
            int m5 = g2.size();
            for (int i = 0; i < m5; i ++){
                if (g2.get(i).y > 800){
                    g2.remove(g2.get(i));
                    i --;
                    m5 --;
                    break;
                }
            }
            int m6 = myBullet1.size();
            for (int i = 0; i < m6; i ++){
                if (myBullet1.get(i).y > 800){
                    myBullet1.remove(myBullet1.get(i));
                    i --;
                    m6 --;
                    break;
                }
            }
        }

        public void enemymoving(long time) {
            for (int i = 0; i < enemyA1.size(); i ++)
                enemyA1.get(i).move(time);
            for (int i = 0; i < enemyA2.size(); i ++)
                enemyA2.get(i).move(time);
            for (int i = 0; i < enemyB1.size(); i ++)
                enemyB1.get(i).move(time);
            for (int i = 0; i < enemyB2.size(); i ++)
                enemyB2.get(i).move(time);
            for (int i = 0; i < enemyB3.size(); i ++)
                enemyB3.get(i).move(time);
        }

        public void ebmoving(long time) {
            for (int i = 0; i < enemyBullet1.size(); i++) {
                enemyBullet1.get(i).move(time);
            }
        }
        public void bbmoving(long time) {
            for (int i = 0; i < enemyBullet2.size(); i++) {
                enemyBullet2.get(i).move(time);
            }
            for (int j = 0; j < boss7Bullet.size(); j++) {
                boss7Bullet.get(j).move(time,me.x,me.y);
            }
        }

        public void mbmoving(long time) {
            for (int i = 0; i < myBullet1.size(); i++) {
                myBullet1.get(i).move(time);
                if (myBullet1.get(i).y < - 20)
                    myBullet1.remove(i);
            }
        }

        public void enemyfire(long time) {
            if (time % 1000 == 0) {
                for (int i = 0; i < enemyA1.size(); i++) {
                    EnemyBullet b1 = enemyA1.get(i).enemyfire();
                    enemyBullet1.add(b1);
                }
            }
            if (time % 1500 == 0) {
                for (int i = 0; i < enemyA2.size(); i++) {
                    EnemyBullet b2 = enemyA2.get(i).enemyfire();
                    enemyBullet1.add(b2);
                }
            }
            if (time % 2000 == 0) {
                for (int i = 0; i < enemyB1.size(); i++) {
                    EnemyBullet b3 = enemyB1.get(i).enemyfire();
                    enemyBullet1.add(b3);
                }
            }
            if (time % 2500 == 0) {
                for (int i = 0; i < enemyB2.size(); i++) {
                    EnemyBullet b4 = enemyB2.get(i).enemyfire();
                    enemyBullet1.add(b4);
                }
            }
            if (time % 6000 == 0) {
                for (int i = 0; i < enemyB3.size(); i++) {
                    EnemyBullet b3 = enemyB3.get(i).enemyfire();
                    enemyBullet1.add(b3);
                }
            }
        }

        public void bossfire(long time,int t,int n){
            if (time % t == 0) {
                EnemyBullet2 b2 = boss.get(n).enemyfire();
                enemyBullet2.add(b2);
                EnemyBullet2 b22 = boss.get(n).enemyfire2();
                enemyBullet2.add(b22);
            }
            switch (n){
                case 0:
                    bossfire2(time ,n);
                    break;
                case 1:
                    bossfire2(time ,n);
                    break;
                case 2:
                    bossfire2(time ,n);
                    break;
                case 3:
                    bossfire2(time ,n);
                    break;
                case 4:
                    bossfire2(time ,n);
                    break;
                case 5:
                    bossfire2(time ,n);
                    break;
                case 6:
                    bossfire2(time ,n);
                    break;
                default:
                    break;
            }
        }

        public void bossfire2(long time ,int n){
            if (time % 100*(10 - n) == 0 && boss7Bullet.size() <= (n+1) * 2) {
                Boss7Bullet b = new Boss7Bullet(r.nextInt(400)+100, r.nextInt(500)+100);
                boss7Bullet.add(b);
            }
        }

        public void enemy(long time){
            if (time % 400 == 0) {
                EnemyA a1 = new EnemyA(r.nextInt(450 + 30), 0, 200, 120, ImageRead.enemyA1);
                enemyA1.add(a1);
            }
            if (time % 800 == 0) {
                EnemyB b1 = new EnemyB(r.nextInt(450 + 30), 0, 200, 150, ImageRead.enemyB1);
                enemyB1.add(b1);
            }
        }
        public void enemy2(long time) {
            if (time % 400 == 0) {
                EnemyA a1 = new EnemyA(r.nextInt(450 + 30), 0, 200, 120, ImageRead.enemyA1);
                enemyA1.add(a1);
            }
            if (time % 1000 == 0) {
                EnemyA a2 = new EnemyA(r.nextInt(450 + 30), 0, 120, 110, ImageRead.enemyA2);
                enemyA1.add(a2);
            }
            if (time % 800 == 0) {
                EnemyB b1 = new EnemyB(r.nextInt(450 + 30), 0, 200, 150, ImageRead.enemyB1);
                enemyB1.add(b1);
            }
        }
        public void enemy3(long time){
            if (time % 400 == 0) {
                EnemyA a1 = new EnemyA(r.nextInt(450 + 30), 0, 200, 120, ImageRead.enemyA1);
                enemyA1.add(a1);
            }
            if (time % 1000 == 0) {
                EnemyA a2 = new EnemyA(r.nextInt(450 + 30), 0, 120, 110, ImageRead.enemyA2);
                enemyA1.add(a2);
            }
            if (time % 800 == 0) {
                EnemyB b1 = new EnemyB(r.nextInt(450 + 30), 0, 197, 134, ImageRead.enemyB1);
                enemyB1.add(b1);
            }
            if (time % 1000 == 0) {
                EnemyB b2 = new EnemyB(r.nextInt(450 + 30), 0, 200, 150, ImageRead.enemyB2);
                enemyB2.add(b2);
            }
        }
        public void enemy4(long time){
            if (time % 400 == 0) {
                EnemyA a1 = new EnemyA(r.nextInt(450 + 30), 0, 200, 120, ImageRead.enemyA1);
                enemyA1.add(a1);
            }
            if (time % 1000 == 0) {
                EnemyA a2 = new EnemyA(r.nextInt(450 + 30), 0, 120, 110, ImageRead.enemyA2);
                enemyA1.add(a2);
            }
            if (time % 800 == 0) {
                EnemyB b1 = new EnemyB(r.nextInt(450 + 30), 0, 197, 134, ImageRead.enemyB1);
                enemyB1.add(b1);
            }
            if (time % 1000 == 0) {
                EnemyB b2 = new EnemyB(r.nextInt(450 + 30), 0, 200, 150, ImageRead.enemyB2);
                enemyB2.add(b2);
            }
            if (time % 1200 == 0) {
                EnemyB b3 = new EnemyB(r.nextInt(450 + 30), 0, 200, 150, ImageRead.enemyB3);
                enemyB3.add(b3);
            }
        }

        public void gift(long time){
            if (time % 1500 == 0 && time > 1500) {
                Gift g = new Gift(r.nextInt(300 + 200), 0, 128, 128, ImageRead.gift);
                g1.add(g);
            }
            if (time % 7500 == 0 && time > 7500 ) {
                Gift g02 = new Gift(r.nextInt(300 + 200), 0, 128, 128, ImageRead.gift2);
                g2.add(g02);
            }
        }

        public void setme(){
            me.speed = 6 + level;

            if (level == 4) {
                hit = 2;
                if (fire == 5)
                    hit = 3;
            }
            if (level == 6) {
                hit = 3;
                if (fire == 5)
                    hit = 4;
            }
            if (level == 8) {
                hit = 5;
                if (fire == 5)
                    hit = 6;
            }
        }


        public void bosssetlife(int n){
            switch (n){
                case 0:
                    bosslife1 = false;
                    break;
                case 1:
                    bosslife2 = false;
                    break;
                case 2:
                    bosslife3 = false;
                    break;
                case 3:
                    bosslife4 = false;
                    break;
                case 4:
                    bosslife5 = false;
                    break;
                case 5:
                    bosslife6 = false;
                    break;
                case 6:
                    bosslife7 = false;
                    break;
                default:
                    break;
            }
        }

        public void bossmove(long time, int n ){
            boss.get(n).move(time);
        }

        public void giftmove(long time){
            for (int i=0; i < g1.size(); i++)
                g1.get(i).move(time);
            for (int i=0; i < g2.size(); i++)
                g2.get(i).move(time);
        }

    };
    game.start();
}

    protected void paintbg(Graphics g){
        super.paintComponent(g);
        if (bgmove > 768){
            bgmove = 0;
        }
        if (stage == 1 || stage == 6) {
            g.drawImage(ImageRead.map1, 0, bgmove, 512, 768, null);
            bgmove += 3;
            g.drawImage(ImageRead.map1, 0, -768 + bgmove, 512, 768, null);
        }
        if (stage == 2 || stage == 7) {
            g.drawImage(ImageRead.map2, 0, bgmove, 512, 768, null);
            bgmove += 3;
            g.drawImage(ImageRead.map2, 0, -768 + bgmove, 512, 768, null);
        }
        if (stage == 3 || stage == 8) {
            g.drawImage(ImageRead.map3, 0, bgmove, 512, 768, null);
            bgmove += 3;
            g.drawImage(ImageRead.map3, 0, -768 + bgmove, 512, 768, null);
        }
        if (stage == 4 || stage == 9) {
            g.drawImage(ImageRead.map4, 0, bgmove, 512, 768, null);
            bgmove += 3;
            g.drawImage(ImageRead.map4, 0, -768 + bgmove, 512, 768, null);
        }
        if (stage == 5 || stage == 10) {
            g.drawImage(ImageRead.map5, 0, bgmove, 512, 768, null);
            bgmove += 3;
            g.drawImage(ImageRead.map5, 0, -768 + bgmove, 512, 768, null);
        }
        if (stage == 11) {
            g.drawImage(ImageRead.map7, 0, bgmove, 512, 768, null);
            bgmove += 4;
            g.drawImage(ImageRead.map7, 0, -768 + bgmove, 512, 768, null);
        }
        if (stage == 12) {
            g.drawImage(ImageRead.map7, 0, bgmove, 512, 768, null);
            bgmove += 5;
            g.drawImage(ImageRead.map7, 0, -768 + bgmove, 512, 768, null);
        }

    }

    public void paint(Graphics g){
        super.paint(g);
        if (state == START){
            paintstart(g);
        }
        if (state == RUNNING){
            paintbg(g); 
            paintme(g); 
            paintenemy(g); 
            paintbpush(g);
            paintbb(g);
            painteb(g); 
            if (!myBullet1.isEmpty())
            paintmb(g); 
            paintwarning2(g);
            if (level == 8)
                if (shield > 0)
                paintshield(g);
           if (up){
               paintpush(g);
           }
           paintswift(g);

            if (stage == 6 && bosslife1) {
                paintb(g, 0); //boss
                paintbosshp(g,0);
                if (b1.y < 0)
                    paintwarning(g);
            }
            if (stage == 7 && bosslife2) {
                paintb(g, 1);
                paintbosshp(g, 1);
                if (b2.y < 0)
                    paintwarning(g);
            }
            if (stage == 8 && bosslife3) {
                paintb(g, 2);
                paintbosshp(g, 2);
                if (b3.y < 0)
                    paintwarning(g);
            }
            if (stage == 9 && bosslife4) {
                paintb(g, 3);
                paintbosshp(g, 3);
                if (b4.y < 0)
                    paintwarning(g);
            }
            if (stage == 10 && bosslife5) {
                paintb(g, 4);
                paintbosshp(g, 4);
                if (b5.y < 0)
                    paintwarning(g);
            }
            if (stage == 11 && bosslife6) {
                paintb(g, 5);
                paintbosshp(g, 5);
                if (b6.y < 0)
                    paintwarning(g);
            }
            if (stage == 12 && bosslife7) {
                paintb(g, 6);
                paintbosshp(g, 6);
                if (b7.y < 0)
                    paintwarning(g);
            }
            paintgift(g);
            paintbang(g);
            paintboard(g);

        }
        if (state == GAMEOVER){
            paintover(g);
        }
        if (state == WIN){
            paintwin(g);
        }
    }

    public void paintover(Graphics g){
        g.drawImage(ImageRead.map6,0,0,512,768,null);
        Font f1 = new Font("黑体",Font.ITALIC,80);
        g.setColor(Color.WHITE);
        g.setFont(f1);
        g.drawString("GAME OVER",90,200);
        g.drawImage(ImageRead.classframe,160,200,180,200,null);
        g.drawImage(ImageRead.room,0,438,512,330,null);
        Font f2 = new Font("黑体",Font.ITALIC,30);
        g.setFont(f2);
        switch (score/1000){
            case 0:
            case 1:
                g.drawImage(ImageRead.D,200,250,100,100,null);
                break;
            case 2:
            case 3:
                g.drawImage(ImageRead.C,200,250,100,100,null);
                break;
            case 4:
            case 5:
                g.drawImage(ImageRead.B,200,250,100,100,null);
                break;
            case 6:
            case 7:
                g.drawImage(ImageRead.A,200,250,100,100,null);
                break;
            case 8:
            case 9:
                g.drawImage(ImageRead.S,200,250,100,100,null);
                break;
            default:
             {
                g.drawImage(ImageRead.S, 250, 250, 100, 100, null);
                g.drawImage(ImageRead.S, 150, 250, 100, 100, null);
            }
            break;
        }

        int s = score;
        int[] a = new int[5];
        int i = 0;
        while(s != 0){
            a[i] = s % 10;
            s = s/10;
            i++;
        }
        i = 0;
        while( i < 5){
            switch (a[i]){
                case 0:
                    g.drawImage(ImageRead.zero,280 - i * 25,390,25,30,null);
                    break;
                case 1:
                    g.drawImage(ImageRead.one,280 - i * 25,390,25,30,null);
                    break;
                case 2:
                    g.drawImage(ImageRead.two,280 - i * 25,390,25,30,null);
                    break;
                case 3:
                    g.drawImage(ImageRead.three,280 - i * 25,390,25,30,null);
                    break;
                case 4:
                    g.drawImage(ImageRead.four,280 - i * 25,390,25,30,null);
                    break;
                case 5:
                    g.drawImage(ImageRead.five,280 - i * 25,390,25,30,null);
                    break;
                case 6:
                    g.drawImage(ImageRead.six,280 - i * 25,390,25,30,null);
                    break;
                case 7:
                    g.drawImage(ImageRead.seven,280 - i * 25,390,25,30,null);
                    break;
                case 8:
                    g.drawImage(ImageRead.eight,280 - i * 25,390,25,30,null);
                    break;
                case 9:
                    g.drawImage(ImageRead.nine,280 - i * 25,390,25,30,null);
                    break;
            }
            i ++;
        }
        g.drawString("Enter重新开始",150,450);
    }

    public void paintwin(Graphics g){
        g.drawImage(ImageRead.map6,0,0,512,768,null);
        Font f1 = new Font("黑体",Font.ITALIC,80);
        Font f2 = new Font("黑体",Font.ITALIC,30);
        g.setColor(Color.WHITE);
        g.setFont(f1);
        g.drawString("YOU WIN",110,200);
        g.setFont(f2);
        g.drawImage(ImageRead.room,0,438,512,330,null);
        g.drawImage(ImageRead.classframe,160,200,180,200,null);
        g.drawImage(ImageRead.S, 200, 250, 100, 100, null);
        g.drawImage(ImageRead.S, 100, 250, 100, 100, null);
        g.drawImage(ImageRead.S, 300, 250, 100, 100, null);
        int s = score;
        int[] a = new int[5];
        int i = 0;
        while(s != 0){
            a[i] = s % 10;
            s = s/10;
            i++;
        }
        i = 0;
        while( i < 5){
            switch (a[i]){
                case 0:
                    g.drawImage(ImageRead.zero,280 - i * 25,390,25,30,null);
                    break;
                case 1:
                    g.drawImage(ImageRead.one,280 - i * 25,390,25,30,null);
                    break;
                case 2:
                    g.drawImage(ImageRead.two,280 - i * 25,390,25,30,null);
                    break;
                case 3:
                    g.drawImage(ImageRead.three,280 - i * 25,390,25,30,null);
                    break;
                case 4:
                    g.drawImage(ImageRead.four,280 - i * 25,390,25,30,null);
                    break;
                case 5:
                    g.drawImage(ImageRead.five,280 - i * 25,390,25,30,null);
                    break;
                case 6:
                    g.drawImage(ImageRead.six,280 - i * 25,390,25,30,null);
                    break;
                case 7:
                    g.drawImage(ImageRead.seven,280 - i * 25,390,25,30,null);
                    break;
                case 8:
                    g.drawImage(ImageRead.eight,280 - i * 25,390,25,30,null);
                    break;
                case 9:
                    g.drawImage(ImageRead.nine,280 - i * 25,390,25,30,null);
                    break;
            }
            i ++;
        }
        g.drawString("Enter重新开始",150,450);

    }

    public void paintstart(Graphics g){
        super.paintComponent(g);
        g.drawImage(ImageRead.map6,0,0,512,768,null);
        g.drawImage(ImageRead.frame3,20,100,587,600,null);
        g.drawImage(ImageRead.two,220,40,80,96,null);
        g.drawImage(ImageRead.logo,-30,50,573,178,null);
        Font f = new Font("黑体",Font.PLAIN,40);
        g.setFont(f);
        g.setColor(Color.WHITE);
        g.drawString("Enter开始游戏",130,600);


    }
    public void paintme(Graphics g){
        if(level == 1)
        g.drawImage(ImageRead.me,me.x,me.y,null);
        if(level == 2)
            g.drawImage(ImageRead.me2,me.x,me.y,null);
        if(level == 3)
            g.drawImage(ImageRead.me3,me.x,me.y,null);
        if(level == 4)
            g.drawImage(ImageRead.me4,me.x,me.y,null);
        if(level == 6)
            g.drawImage(ImageRead.superme,me.x,me.y,null);
        if(level == 8)
            g.drawImage(ImageRead.maxme,me.x,me.y,null);

    }
    public void paintbang(Graphics g){
        int a = bang.size();
        for (int i = 0;i < a;){
            Bang b = bang.get(i);
            b.draw(g);
            bang.remove(b);
            a --;
            i --;
            break;
        }
    }
    public void paintenemy(Graphics g){
        for (int i = 0; i<enemyA1.size();i++){
            EnemyA a1 = enemyA1.get(i);
            a1.draw(g);
        }
        for (int i = 0; i<enemyA2.size();i++){
            EnemyA a2 = enemyA2.get(i);
            a2.draw(g);
        }
        for (int i = 0; i<enemyB1.size();i++){
            EnemyB b1 = enemyB1.get(i);
            b1.draw(g);
        }
        for (int i = 0; i<enemyB2.size();i++){
            EnemyB b2 = enemyB2.get(i);
            b2.draw(g);
        }
        for (int i = 0; i<enemyB3.size();i++){
            EnemyB b3 = enemyB3.get(i);
            b3.draw(g);
        }
    }

    public void paintb(Graphics g, int n){
       switch (n) {
           case 0:
               b1.draw(g);
               break;
           case 1:
               b2.draw(g);
               break;
           case 2:
               b3.draw(g);
               break;
           case 3:
               b4.draw(g);
               break;
           case 4:
               b5.draw(g);
               break;
           case 5:
               b6.draw(g);
               break;
           case 6:
               b7.draw(g);
               break;
           default:
               break;
       }
    }

    public void painteb(Graphics g){
        for (int i = 0;i < enemyBullet1.size();i++){
            EnemyBullet eb = enemyBullet1.get(i);
            eb.draw(g);
        }
    }
    public void paintbb(Graphics g){
        for (int i = 0;i < enemyBullet2.size();i++){
            EnemyBullet2 eb = enemyBullet2.get(i);
            eb.draw(g);
        }
        for (int i = 0;i < boss7Bullet.size();i++){
            Boss7Bullet eb = boss7Bullet.get(i);
            eb.draw(g);
        }
    }
    public void paintmb(Graphics g){
        for (int i = 0;i < myBullet1.size();i++){
            MyBullet mb = myBullet1.get(i);
            if (myBullet1.get(i) != null)
            mb.draw(g);
        }
    }

    public void paintboard(Graphics g){
        if (level == 6) {
            g.drawImage(ImageRead.spower, 0, 85, 60, 60, null);
            endTime = new Date();
            spower = 30 - (int) (endTime.getTime() - startTime.getTime()) / 1000;
            int b = spower / 10;
            int c = spower % 10;
            switch (b) {
                case 0:
                    g.drawImage(ImageRead.zero, 70, 85, 25, 30, null);
                    break;
                case 1:
                    g.drawImage(ImageRead.one, 70, 85, 25, 30, null);
                    break;
                case 2:
                    g.drawImage(ImageRead.two, 70, 85, 25, 30, null);
                    break;
                case 3:
                    g.drawImage(ImageRead.three, 70, 85, 25, 30, null);
                    break;
                case 4:
                    g.drawImage(ImageRead.four, 70, 85, 25, 30, null);
                    break;
                case 5:
                    g.drawImage(ImageRead.five, 70, 85, 25, 30, null);
                    break;
                case 6:
                    g.drawImage(ImageRead.six, 70, 85, 25, 30, null);
                    break;
                case 7:
                    g.drawImage(ImageRead.seven, 70, 85, 25, 30, null);
                    break;
                case 8:
                    g.drawImage(ImageRead.eight, 70, 85, 25, 30, null);
                    break;
                case 9:
                    g.drawImage(ImageRead.nine, 70, 85, 25, 30, null);
                    break;
            }
            switch (c) {
                case 0:
                    g.drawImage(ImageRead.zero, 95, 85, 25, 30, null);
                    break;
                case 1:
                    g.drawImage(ImageRead.one, 95, 85, 25, 30, null);
                    break;
                case 2:
                    g.drawImage(ImageRead.two, 95, 85, 25, 30, null);
                    break;
                case 3:
                    g.drawImage(ImageRead.three, 95, 85, 25, 30, null);
                    break;
                case 4:
                    g.drawImage(ImageRead.four, 95, 85, 25, 30, null);
                    break;
                case 5:
                    g.drawImage(ImageRead.five, 95, 85, 25, 30, null);
                    break;
                case 6:
                    g.drawImage(ImageRead.six, 95, 85, 25, 30, null);
                    break;
                case 7:
                    g.drawImage(ImageRead.seven, 95, 85, 25, 30, null);
                    break;
                case 8:
                    g.drawImage(ImageRead.eight, 95, 85, 25, 30, null);
                    break;
                case 9:
                    g.drawImage(ImageRead.nine, 95, 85, 25, 30, null);
                    break;
            }
            if (spower == 0) {
                level = 1;
            }
        }
        if (level == 8)
            g.drawImage(ImageRead.maxpower,0,85,60,60,null);
        g.drawImage(ImageRead.HP,0,45,60,40,null);
        switch ((life/100) % 10){
            case 0:
                g.drawImage(ImageRead.zero,65,51,25,30,null);
                break;
            case 1:
                g.drawImage(ImageRead.one,65,51,25,30,null);
                break;
            case 2:
                g.drawImage(ImageRead.two,65,51,25,30,null);
                break;
            case 3:
                g.drawImage(ImageRead.three,65,51,25,30,null);
                break;
            case 4:
                g.drawImage(ImageRead.four,65,51,25,30,null);
                break;
            case 5:
                g.drawImage(ImageRead.five,65,51,25,30,null);
                break;
            case 6:
                g.drawImage(ImageRead.six,65,51,25,30,null);
                break;
            case 7:
                g.drawImage(ImageRead.seven,65,51,25,30,null);
                break;
            case 8:
                g.drawImage(ImageRead.eight,65,51,25,30,null);
                break;
            case 9:
                g.drawImage(ImageRead.nine,65,51,25,30,null);
                break;
        }
        switch ((life/10) % 10){
            case 0:
                g.drawImage(ImageRead.zero,90,51,25,30,null);
                break;
            case 1:
                g.drawImage(ImageRead.one,90,51,25,30,null);
                break;
            case 2:
                g.drawImage(ImageRead.two,90,51,25,30,null);
                break;
            case 3:
                g.drawImage(ImageRead.three,90,51,25,30,null);
                break;
            case 4:
                g.drawImage(ImageRead.four,90,51,25,30,null);
                break;
            case 5:
                g.drawImage(ImageRead.five,90,51,25,30,null);
                break;
            case 6:
                g.drawImage(ImageRead.six,90,51,25,30,null);
                break;
            case 7:
                g.drawImage(ImageRead.seven,90,51,25,30,null);
                break;
            case 8:
                g.drawImage(ImageRead.eight,90,51,25,30,null);
                break;
            case 9:
                g.drawImage(ImageRead.nine,90,51,25,30,null);
                break;
        }
        switch (life % 10){
            case 0:
                g.drawImage(ImageRead.zero,115,51,25,30,null);
                break;
            case 1:
                g.drawImage(ImageRead.one,115,51,25,30,null);
                break;
            case 2:
                g.drawImage(ImageRead.two,115,51,25,30,null);
                break;
            case 3:
                g.drawImage(ImageRead.three,115,51,25,30,null);
                break;
            case 4:
                g.drawImage(ImageRead.four,115,51,25,30,null);
                break;
            case 5:
                g.drawImage(ImageRead.five,115,51,25,30,null);
                break;
            case 6:
                g.drawImage(ImageRead.six,115,51,25,30,null);
                break;
            case 7:
                g.drawImage(ImageRead.seven,115,51,25,30,null);
                break;
            case 8:
                g.drawImage(ImageRead.eight,115,51,25,30,null);
                break;
            case 9:
                g.drawImage(ImageRead.nine,115,51,25,30,null);
                break;
        }
        g.drawImage(ImageRead.score,10,20,45,25,null);
        int s = score;
        int[] a = new int[5];
        int i = 0;
        while(s != 0){
            a[i] = s % 10;
            s = s/10;
            i++;
        }
        i = 0;
        while( i < 5){
            switch (a[i]){
                case 0:
                    g.drawImage(ImageRead.zero,170 - i * 25,17,25,30,null);
                    break;
                case 1:
                    g.drawImage(ImageRead.one,170 - i * 25,17,25,30,null);
                    break;
                case 2:
                    g.drawImage(ImageRead.two,170 - i * 25,17,25,30,null);
                    break;
                case 3:
                    g.drawImage(ImageRead.three,170 - i * 25,17,25,30,null);
                    break;
                case 4:
                    g.drawImage(ImageRead.four,170 - i * 25,17,25,30,null);
                    break;
                case 5:
                    g.drawImage(ImageRead.five,170 - i * 25,17,25,30,null);
                    break;
                case 6:
                    g.drawImage(ImageRead.six,170 - i * 25,17,25,30,null);
                    break;
                case 7:
                    g.drawImage(ImageRead.seven,170 - i * 25,17,25,30,null);
                    break;
                case 8:
                    g.drawImage(ImageRead.eight,170 - i * 25,17,25,30,null);
                    break;
                case 9:
                    g.drawImage(ImageRead.nine,170 - i * 25,17,25,30,null);
                    break;
            }
            i ++;
        }

    }

    public void paintpush(Graphics g){
        g.drawImage(ImageRead.push,me.x , me.y + 100,null);
    }

    public void paintgift(Graphics g){
        for (int i = 0; i < g1.size(); i++) {
            Gift g01 = g1.get(i);
            g01.draw(g);
        }
        for (int i = 0; i < g2.size(); i++) {
            Gift g02 = g2.get(i);
            g02.draw(g);
        }
    }

    public void paintshield(Graphics g){
        g.drawImage(ImageRead.shield,me.x - 5,me.y,128,128,null);
    }

    public void paintbosshp(Graphics g ,int n){
        Font f = new Font("榛戜綋",Font.PLAIN,20);
        g.setFont(f);
        g.setColor(Color.RED);
        switch (n) {
            case 0:
                  g.drawString("HP " + blife1, 230, 20);
                  break;
            case 1:
                g.drawString("HP " + blife2, 230, 20);
                break;
            case 2:
                g.drawString("HP " + blife3, 230, 20);
                break;
            case 3:
                g.drawString("HP " + blife4, 230, 20);
                break;
            case 4:
                g.drawString("HP " + blife5, 230, 20);
                break;
            case 5:
                g.drawString("HP " + blife6, 230, 20);
                break;
            case 6:
                g.drawString("HP " + blife7, 230, 20);
                break;
        }
    }


    public void paintwarning(Graphics g){
        g.drawImage(ImageRead.warning2,40,320,453,92,null);
    }
    public void paintwarning2(Graphics g){
        if (level == 6)
            if (spower < 15) {
            g.drawImage(ImageRead.warning1, 120, 250, 255, 148, null);
            if (spower < 5)
            life = 20;
        }
    }

    public void paintbpush(Graphics g){
        for (int i = 0; i< enemyBullet2.size(); i ++)
        g.drawImage(ImageRead.bpush,enemyBullet2.get(i).x + 30,enemyBullet2.get(i).y - 70,60,120,null);
    }

    public void paintswift(Graphics g){
        if (level == 6) {
                if (up) {
                    if (left && !right) {
                        g.drawImage(ImageRead.swift1, me.x + 80, me.y + 80, 120, 110, null);
                        g.drawImage(ImageRead.swift1, me.x + 60, me.y + 60, 120, 110, null);
                        g.drawImage(ImageRead.swift1, me.x + 40, me.y + 40, 120, 110, null);
                    }
                    if (right && !left){
                        g.drawImage(ImageRead.swift1, me.x - 80, me.y + 80, 120, 110, null);
                        g.drawImage(ImageRead.swift1, me.x - 60, me.y + 60, 120, 110, null);
                        g.drawImage(ImageRead.swift1, me.x - 40, me.y + 40, 120, 110, null);
                    }
                    if (!left && !right || right && left){
                        g.drawImage(ImageRead.swift1, me.x, me.y + 80, 120, 110, null);
                        g.drawImage(ImageRead.swift1, me.x, me.y + 60, 120, 110, null);
                        g.drawImage(ImageRead.swift1, me.x, me.y + 40, 120, 110, null);
                    }
                }
                if (left && !up && !down && !right){
                    g.drawImage(ImageRead.swift1, me.x + 100, me.y, 120, 110, null);
                    g.drawImage(ImageRead.swift1, me.x + 80, me.y, 120, 110, null);
                    g.drawImage(ImageRead.swift1, me.x + 60, me.y, 120, 110, null);
                }
                if (right && !up && !down && !left){
                    g.drawImage(ImageRead.swift1, me.x - 100, me.y, 120, 110, null);
                    g.drawImage(ImageRead.swift1, me.x - 80, me.y, 120, 110, null);
                    g.drawImage(ImageRead.swift1, me.x - 60, me.y, 120, 110, null);
                }
                if (down) {
                    if (left && !right) {
                        g.drawImage(ImageRead.swift1, me.x + 80, me.y - 80, 120, 110, null);
                        g.drawImage(ImageRead.swift1, me.x + 60, me.y - 60, 120, 110, null);
                        g.drawImage(ImageRead.swift1, me.x + 40, me.y - 40, 120, 110, null);
                    }
                    if (right && !left){
                        g.drawImage(ImageRead.swift1, me.x - 80, me.y - 80, 120, 110, null);
                        g.drawImage(ImageRead.swift1, me.x - 60, me.y - 60, 120, 110, null);
                        g.drawImage(ImageRead.swift1, me.x - 40, me.y - 40, 120, 110, null);
                    }
                    if (!left && !right || right && left){
                        g.drawImage(ImageRead.swift1, me.x, me.y - 80, 120, 110, null);
                        g.drawImage(ImageRead.swift1, me.x, me.y - 60, 120, 110, null);
                        g.drawImage(ImageRead.swift1, me.x, me.y - 40, 120, 110, null);
                    }
                }
        }
        if (level == 8) {
            if (up) {
                if (left && !right) {
                    g.drawImage(ImageRead.swift2, me.x + 80, me.y + 80, 120, 110, null);
                    g.drawImage(ImageRead.swift2, me.x + 60, me.y + 60, 120, 110, null);
                    g.drawImage(ImageRead.swift2, me.x + 40, me.y + 40, 120, 110, null);
                }
                if (right && !left){
                    g.drawImage(ImageRead.swift2, me.x - 80, me.y + 80, 120, 110, null);
                    g.drawImage(ImageRead.swift2, me.x - 60, me.y + 60, 120, 110, null);
                    g.drawImage(ImageRead.swift2, me.x - 40, me.y + 40, 120, 110, null);
                }
                if (!left && !right || right && left){
                    g.drawImage(ImageRead.swift2, me.x, me.y + 80, 120, 110, null);
                    g.drawImage(ImageRead.swift2, me.x, me.y + 60, 120, 110, null);
                    g.drawImage(ImageRead.swift2, me.x, me.y + 40, 120, 110, null);
                }
            }
            if (left && !up && !down && !right){
                g.drawImage(ImageRead.swift2, me.x + 100, me.y, 120, 110, null);
                g.drawImage(ImageRead.swift2, me.x + 80, me.y, 120, 110, null);
                g.drawImage(ImageRead.swift2, me.x + 60, me.y, 120, 110, null);
            }
            if (right && !up && !down && !left){
                g.drawImage(ImageRead.swift2, me.x - 100, me.y, 120, 110, null);
                g.drawImage(ImageRead.swift2, me.x - 80, me.y, 120, 110, null);
                g.drawImage(ImageRead.swift2, me.x - 60, me.y, 120, 110, null);
            }
            if (down) {
                if (left && !right) {
                    g.drawImage(ImageRead.swift2, me.x + 80, me.y - 80, 120, 110, null);
                    g.drawImage(ImageRead.swift2, me.x + 60, me.y - 60, 120, 110, null);
                    g.drawImage(ImageRead.swift2, me.x + 40, me.y - 40, 120, 110, null);
                }
                if (right && !left){
                    g.drawImage(ImageRead.swift2, me.x - 80, me.y - 80, 120, 110, null);
                    g.drawImage(ImageRead.swift2, me.x - 60, me.y - 60, 120, 110, null);
                    g.drawImage(ImageRead.swift2, me.x - 40, me.y - 40, 120, 110, null);
                }
                if (!left && !right || right && left){
                    g.drawImage(ImageRead.swift2, me.x, me.y - 80, 120, 110, null);
                    g.drawImage(ImageRead.swift2, me.x, me.y - 60, 120, 110, null);
                    g.drawImage(ImageRead.swift2, me.x, me.y - 40, 120, 110, null);
                }
            }
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_SPACE:
                SPACE = true;
                break;
            case KeyEvent.VK_ENTER:
                ENTER = true;
                break;
            case KeyEvent.VK_X:
                X = true;
                break;
            case KeyEvent.VK_Z:
                Z = true;
                break;
            case KeyEvent.VK_C:
                C = true;
                break;
            default:
                break;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_SPACE:
                SPACE = false;
                break;
            case KeyEvent.VK_ENTER:
                ENTER = false;
                break;
            case KeyEvent.VK_X:
                X = false;
                break;
            case KeyEvent.VK_Z:
                Z = false;
                break;
            case KeyEvent.VK_C:
                C = false;
                break;
            default:
                break;
        }

    }

}


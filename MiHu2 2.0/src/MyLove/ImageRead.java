package MyLove;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;


public class ImageRead {
    public static BufferedImage enemyA1;
    public static BufferedImage enemyA2;
    public static BufferedImage enemyB1;
    public static BufferedImage enemyB2;
    public static BufferedImage enemyB3;
    public static BufferedImage me;
    public static BufferedImage me2;
    public static BufferedImage me3;
    public static BufferedImage me4;
    public static BufferedImage superme;
    public static BufferedImage maxme;

    public static BufferedImage boss1;
    public static BufferedImage boss2;
    public static BufferedImage boss3;
    public static BufferedImage boss4;
    public static BufferedImage boss5;
    public static BufferedImage boss6;
    public static BufferedImage boss7;

    public static BufferedImage enemybullet1;
    public static BufferedImage enemybullet2;
    public static BufferedImage mybullet1;
    public static BufferedImage mybullet2;
    public static BufferedImage mybullet3;
    public static BufferedImage superbullet;

    public static BufferedImage gift;
    public static BufferedImage gift2;


    public static BufferedImage boom;
    public static BufferedImage boom2;

    public static BufferedImage map1;
    public static BufferedImage map2;
    public static BufferedImage map3;
    public static BufferedImage map4;
    public static BufferedImage map5;
    public static BufferedImage map6;
    public static BufferedImage map7;
    public static BufferedImage frame1;
    public static BufferedImage frame2;
    public static BufferedImage frame3;
    public static BufferedImage icon;

    public static BufferedImage push;
    public static BufferedImage score;
    public static BufferedImage HP;
    public static BufferedImage shield;
    public static BufferedImage spower;
    public static BufferedImage laser;
    public static BufferedImage maxpower;
    public static BufferedImage warning1;
    public static BufferedImage warning2;

    public static BufferedImage zero;
    public static BufferedImage one;
    public static BufferedImage two;
    public static BufferedImage three;
    public static BufferedImage four;
    public static BufferedImage five;
    public static BufferedImage six;
    public static BufferedImage seven;
    public static BufferedImage eight;
    public static BufferedImage nine;

    public static BufferedImage bpush;

    public static BufferedImage D;
    public static BufferedImage C;
    public static BufferedImage B;
    public static BufferedImage A;
    public static BufferedImage S;

    public static BufferedImage classframe;
    public static BufferedImage room;
    public static BufferedImage logo;

    public static BufferedImage swift1;
    public static BufferedImage swift2;

    static {

        try {

            map1 = ImageIO.read(new FileInputStream("./Image/bg01.jpg"));
            map2 = ImageIO.read(new FileInputStream("./Image/bg02.jpg"));
            map3 = ImageIO.read(new FileInputStream("./Image/bg03.jpg"));
            map4 = ImageIO.read(new FileInputStream("./Image/bg04.jpg"));
            map5 = ImageIO.read(new FileInputStream("./Image/bg05.jpg"));
            map6 = ImageIO.read(new FileInputStream("./Image/bg06.jpg"));
            map7 = ImageIO.read(new FileInputStream("./Image/bg07.jpg"));

            boss1 = ImageIO.read(new FileInputStream("./Image/boss01.png"));
            boss2 = ImageIO.read(new FileInputStream("./Image/boss02.png"));
            boss3 = ImageIO.read(new FileInputStream("./Image/boss03.png"));
            boss4 = ImageIO.read(new FileInputStream("./Image/boss04.png"));
            boss5 = ImageIO.read(new FileInputStream("./Image/boss05.png"));
            boss6 = ImageIO.read(new FileInputStream("./Image/boss06.png"));
            boss7 = ImageIO.read(new FileInputStream("./Image/boss07.png"));

            enemybullet1 = ImageIO.read(new FileInputStream("./Image/enemybullet02.png"));
            enemybullet2 = ImageIO.read(new FileInputStream("./Image/enemybullet03.png"));

            mybullet1 = ImageIO.read(new FileInputStream("./Image/bullet03.png"));
            mybullet2 = ImageIO.read(new FileInputStream("./Image/bullet04.png"));
            mybullet3 = ImageIO.read(new FileInputStream("./Image/bullet05.png"));
            superbullet = ImageIO.read(new FileInputStream("./Image/superbullet.png"));

            enemyA1 = ImageIO.read(new FileInputStream("./Image/enemy001.png"));
            enemyA2 = ImageIO.read(new FileInputStream("./Image/enemy005.png"));
            enemyB1 = ImageIO.read(new FileInputStream("./Image/enemy004.png"));
            enemyB2 = ImageIO.read(new FileInputStream("./Image/enemy003.png"));
            enemyB3 = ImageIO.read(new FileInputStream("./Image/enemy002.png"));

            me = ImageIO.read(new FileInputStream("./Image/me01.png"));
            me2 = ImageIO.read(new FileInputStream("./Image/me02.png"));
            me3 = ImageIO.read(new FileInputStream("./Image/me03.png"));
            me4 = ImageIO.read(new FileInputStream("./Image/me04.png"));
            superme = ImageIO.read(new FileInputStream("./Image/super-me.png"));
            maxme = ImageIO.read(new FileInputStream("./Image/max-me.png"));

            bpush = ImageIO.read(new FileInputStream("./Image/bpush.png"));
            boom2 = ImageIO.read(new FileInputStream("./Image/bang02.png"));

            gift = ImageIO.read(new FileInputStream("./Image/gift.png"));
            gift2 = ImageIO.read(new FileInputStream("./Image/gift02.png"));

            frame1 = ImageIO.read(new FileInputStream("./Image/frame01.png"));
            frame2 = ImageIO.read(new FileInputStream("./Image/frame02.jpg"));
            frame3 = ImageIO.read(new FileInputStream("./Image/frame03.png"));

            icon = ImageIO.read(new FileInputStream("./Image/icon.png"));
            push = ImageIO.read(new FileInputStream("./Image/push.png"));
            HP = ImageIO.read(new FileInputStream("./Image/hp.png"));

            score = ImageIO.read(new FileInputStream("./Image/score.png"));
            shield = ImageIO.read(new FileInputStream("./Image/shield.png"));
            spower = ImageIO.read(new FileInputStream("./Image/super.png"));
            laser = ImageIO.read(new FileInputStream("./Image/laser.png"));
            maxpower = ImageIO.read(new FileInputStream("./Image/max.png"));
            warning1 = ImageIO.read(new FileInputStream("./Image/warning01.png"));
            warning2 = ImageIO.read(new FileInputStream("./Image/warning02.png"));

            zero = ImageIO.read(new FileInputStream("./Image/num0.png"));
            one = ImageIO.read(new FileInputStream("./Image/num1.png"));
            two = ImageIO.read(new FileInputStream("./Image/num2.png"));
            three = ImageIO.read(new FileInputStream("./Image/num3.png"));
            four = ImageIO.read(new FileInputStream("./Image/num4.png"));
            five = ImageIO.read(new FileInputStream("./Image/num5.png"));
            six = ImageIO.read(new FileInputStream("./Image/num6.png"));
            seven = ImageIO.read(new FileInputStream("./Image/num7.png"));
            eight = ImageIO.read(new FileInputStream("./Image/num8.png"));
            nine = ImageIO.read(new FileInputStream("./Image/num9.png"));

            D = ImageIO.read(new FileInputStream("./Image/classD.png"));
            C = ImageIO.read(new FileInputStream("./Image/classC.png"));
            B = ImageIO.read(new FileInputStream("./Image/classB.png"));
            A = ImageIO.read(new FileInputStream("./Image/classA.png"));
            S = ImageIO.read(new FileInputStream("./Image/classS.png"));
            classframe = ImageIO.read(new FileInputStream("./Image/classframe.png"));
            room = ImageIO.read(new FileInputStream("./Image/room.png"));
            logo = ImageIO.read(new FileInputStream("./Image/LOGO.png"));

            swift1 = ImageIO.read(new FileInputStream("./Image/swiftsuper-me.png"));
            swift2 = ImageIO.read(new FileInputStream("./Image/swiftmax-me.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

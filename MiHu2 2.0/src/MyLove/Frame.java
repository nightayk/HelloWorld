package MyLove;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	WarFrame wf = new WarFrame();

    public Frame(){
        wf.setFocusable(true);
        wf.requestFocus();
        this.add(wf, BorderLayout.CENTER);

        this.setSize(512,768);
        this.setTitle("AirForce 1 2.0");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setIconImage(ImageRead.icon);
        setVisible(true);
    }

    public static void main(String [] args){
        new Frame();
    }

}

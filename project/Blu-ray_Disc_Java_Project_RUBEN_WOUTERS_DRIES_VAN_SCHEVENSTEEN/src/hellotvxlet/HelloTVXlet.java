package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.event.UserEvent;
import org.havi.ui.*;
import org.havi.ui.event.*;
import java.awt.event.*;
import org.dvb.event.UserEventListener;

public class HelloTVXlet implements Xlet, HActionListener {
    
    private MijnComponent scene,
                          bgImage,
                          btnPlay,
                          img1,
                          img2,
                          img3,
                          img4,
                          img5;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
      HScene scene = HSceneFactory.getInstance().getDefaultHScene();
      
      //ACHTERGROND
      bgImage = new MijnComponent("Intro_bg_test.png", 0, -35);
      
      //PLAY BUTTON
      btnPlay = new MijnComponent("Intro_btn_play.png", 280,440);
      
      //IMAGES TO CHOOSE
      img1 = new MijnComponent("Intro_illu_1.png", 20, 250);
      img2 = new MijnComponent("Intro_illu_2.png", 158, 250);
      img3 = new MijnComponent("Intro_illu_3.png", 292, 250);
      img4 = new MijnComponent("Intro_illu_4.png", 426, 250);
      img5 = new MijnComponent("Intro_illu_5.png", 560, 250);
      
      //ADD EVERYTHING TO SCENE
      scene.add(btnPlay);
      scene.add(img1);
      scene.add(img2);
      scene.add(img3);
      scene.add(img4);
      scene.add(img5);
      scene.add(bgImage);
      scene.validate();
      scene.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        
    }
    public void startXlet() {
        
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }   
}

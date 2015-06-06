package hellotvxlet;

import javax.tv.xlet.*;

import org.havi.ui.event.*;
import java.awt.event.*;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;

public class HelloTVXlet implements Xlet, HActionListener {
  
    public HelloTVXlet() {
        
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
       
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();
        
        MijnComponent mc = new MijnComponent(30,30,100,100);
        
        scene.add(mc);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
        
    }

    public void startXlet() throws XletStateChangeException {
        
    }

    public void actionPerformed(ActionEvent arg0) {
       
    }
}

package hellotvxlet;

import javax.tv.xlet.*;
import org.havi.ui.*;
import java.awt.event.*;
import java.util.Timer;
import org.havi.ui.event.*;
import org.dvb.event.*;

public class HelloTVXlet implements Xlet, UserEventListener {
  
    
    MijnComponent mc;
    int X;
    int Y;
    private int sterreny;
    private MijnComponent sterren;
    private MijnComponent sterren2;
    private MijnComponent scene;
            
    public HelloTVXlet() {
        
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
       
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();
        
        mc = new MijnComponent("spaceship.png",300,300);
        sterren = new MijnComponent("sterren.png", 0, 0);
        sterren2 = new MijnComponent("sterren.png", 0, -569);
        
        scene.add(mc);
        scene.add(sterren);
        scene.add(sterren2);
        scene.popToFront(mc);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
        
    }
    
    public void callback()
    {
        sterreny++;
        sterren.Verplaats(0, sterreny);
        sterren2.Verplaats(0, sterreny-569);
        if(sterreny > 569) sterreny -= 569;
    }

    public void startXlet() throws XletStateChangeException {
        MijnTimerTask objMijnTimerTask = new MijnTimerTask(this);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(objMijnTimerTask, 0, 50);
        
        scene.validate();
        scene.setVisible(true);
    }
    
    public void userEventReceived(org.dvb.event.UserEvent e)
    {
        
    }

    public void actionPerformed(ActionEvent arg0) {
       
    }
}

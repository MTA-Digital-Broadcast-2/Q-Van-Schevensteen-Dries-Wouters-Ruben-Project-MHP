package hellotvxlet;

import java.awt.*;
import org.havi.ui.*;
import org.dvb.ui.DVBColor;

public class MijnScore extends HComponent {
    
    public String scoreTxt;
    public int x, y;
    
    public MijnScore(String score, int x, int y)
    {
        this.setBounds(0,0,1000,1000);
        this.scoreTxt = score;
        this.x = x;
        this.y = y;
    }
    
    public void paint(Graphics g)
    {
        g.setColor(new DVBColor(100,150,100,179));
        g.fillRect(0,0,0,0);
        g.setColor(Color.white);
        
        g.drawString( scoreTxt, x, y);
    }
}

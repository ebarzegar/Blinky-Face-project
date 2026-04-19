import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Head extends JPanel {
    private boolean mouseInside = false;

    public Head(){
        this.setPreferredSize(new Dimension(500, 300));
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.addMouseListener(new MyMouseListener());
    }

    class MyMouseListener extends MouseAdapter{
        public void mouseEntered(MouseEvent e){
            mouseInside = true;
            repaint();
        }

        public void mouseExited(MouseEvent e){
            mouseInside = false;
            repaint();
        }
    }

    @Override public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(3.0f));

        Ellipse2D.Double outline = new Ellipse2D.Double(100,100,300,300);
        g2.draw(outline);

        Rectangle2D.Double mouth = new Rectangle2D.Double(225,310,70,25);
        g2.draw(mouth);

        if(mouseInside){
            g2.draw(new Ellipse2D.Double(200,200,40,40));
            g2.draw(new Ellipse2D.Double(300,200,40,40));
        }
        else{
            g2.draw(new Line2D.Double(200,220,240,220));
            g2.draw(new Line2D.Double(300,220,340,220));
        }
    }
}

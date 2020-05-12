package Popper;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Blob.ABlob;

public class MouseEnteredPopper implements MouseListener{

    private ABlob b;
    public MouseEnteredPopper(ABlob b) {
        this.b = b;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        b.hit();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}

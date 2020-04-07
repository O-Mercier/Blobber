package Popper;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Blob.ABlob;

public class SingleClickPopper implements MouseListener{

	private ABlob b;
	public SingleClickPopper(ABlob b) {
		this.b = b;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		b.hit();		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

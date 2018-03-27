import java.awt.GridLayout;

import javax.swing.JFrame;

public class MainP4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame f = new JFrame();
		f.add(new VueP4());
		f.setVisible(true);
		f.setLayout(new GridLayout());
		f.setSize(500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
	}

}

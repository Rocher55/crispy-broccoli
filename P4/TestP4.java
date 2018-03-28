import java.awt.GridLayout;

import javax.swing.JFrame;

public class TestP4 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setLayout(new GridLayout(1, 1));

        f.add(new VueP4());
        f.setTitle("Jeu Puissance 4");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setSize(500, 600);
    }

}

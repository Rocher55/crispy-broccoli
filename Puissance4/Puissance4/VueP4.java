import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VueP4 extends JPanel {
	private static final int TAILLECOLONNE=6;
	private static final int TAILLELIGNES=5;
	
	public VueP4() {

		this.setLayout(new BorderLayout());
		JPanel Grille=new JPanel();
		Grille.setLayout(new GridLayout(7,7));
		JButton[][] GrilleJeu=new JButton[5][6];
		JButton[] BandeauJeu=new JButton[TAILLECOLONNE];
		JPanel haut = new JPanel();
		haut.setLayout(new GridBagLayout());

		JButton rejouer = new JButton ("rejouer");
		GridBagConstraints cRejouer = new GridBagConstraints();
		cRejouer.fill=GridBagConstraints.VERTICAL;
		cRejouer.gridheight=3;
		cRejouer.gridx=2;
		cRejouer.gridy=0;
		cRejouer.anchor=GridBagConstraints.CENTER;
		cRejouer.weightx=0.1;
		haut.add(rejouer, cRejouer);



		JLabel partiesJaunes =new JLabel("Parties Jaunes");
		GridBagConstraints cpj = new GridBagConstraints();
		cpj.gridx=0;
		cpj.gridy=0;
		cpj.weightx=0.1;
		haut.add(partiesJaunes, cpj);

		JLabel partiesRouges =new JLabel("Parties Rouges");
		GridBagConstraints cpr = new GridBagConstraints();
		cpr.gridx=0;
		cpr.gridy=1;
		haut.add(partiesRouges, cpr);

		JLabel partiesNulles =new JLabel("Parties nulles");
		GridBagConstraints cpn = new GridBagConstraints();
		cpn.gridx=0;
		cpn.gridy=2;
		haut.add(partiesNulles, cpn);

		JTextField nbPartieJaunes = new JTextField();
		nbPartieJaunes.setPreferredSize(new Dimension(50,5));
		GridBagConstraints cnpj = new GridBagConstraints();
		cnpj.gridx=1;
		cnpj.anchor=GridBagConstraints.CENTER;
		cnpj.gridy=0;
		cnpj.fill=(GridBagConstraints.BOTH);
		haut.add(nbPartieJaunes, cnpj);

		JTextField nbPartieRouges = new JTextField();
		GridBagConstraints cnpr = new GridBagConstraints();
		cnpr.gridx=1;
		cnpr.gridy=1;
		cnpr.fill=GridBagConstraints.HORIZONTAL;
		nbPartieRouges.setMinimumSize(new Dimension(50, 5));
		haut.add(nbPartieRouges, cnpr);

		JTextField nbPartieNulles = new JTextField();
		GridBagConstraints cnpn = new GridBagConstraints();
		cnpn.gridx=1;
		cnpn.gridy=2;
		cnpn.fill=GridBagConstraints.HORIZONTAL;

		haut.add(nbPartieNulles, cnpn);

		this.add(haut,BorderLayout.NORTH);
		
		String path = new File("").getAbsolutePath();
		for (int i=0;i<TAILLECOLONNE;i++) {
			BandeauJeu[i]= new JButton();
			BandeauJeu[i].setIcon(new ImageIcon(path+ "/Puissance4/Puissance4/images/pionRouge.jpg"));
			Grille.add(BandeauJeu[i]);
		}
		
		for (int i=0;i<TAILLELIGNES;i++) {
			for (int y=0; y<TAILLECOLONNE;y++) {
				
				GrilleJeu[i][y]=new JButton();		
				System.out.println(path);
				GrilleJeu[i][y].setIcon(new ImageIcon("C:/Users/Pierre/git/crispy-broccoli/Puissance4/Puissance4/caseVide.jpg"));			
				Grille.add(GrilleJeu[i][y]);

			}
		}
		
		this.add(Grille);
	}
}

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VueP4 extends JPanel {
	
	public VueP4() {
	
	this.setLayout(new BorderLayout());
	
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
	cnpr.
	haut.add(nbPartieRouges, cnpr);
	
	JTextField nbPartieNulles = new JTextField();
	GridBagConstraints cnpn = new GridBagConstraints();
	cnpn.gridx=1;
	cnpn.gridy=2;
	
	haut.add(nbPartieNulles, cnpn);
	
	
	this.add(haut,BorderLayout.NORTH);
	}
}

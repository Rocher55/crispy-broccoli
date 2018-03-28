import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * jeu graphique du jeu Puissance 4
 * 
 * @version 6.0
 * @see javax.swing.JComponent
 */
public class VueP4 extends JPanel {

    /**
     * champ affichant le nombre de parties gagnees par le joueur jaune
     */
    private JTextField chJaune;

    /**
     * champ affichant le nombre de parties gagnees par le joueur rouge
     */
    private JTextField chRouge;

    /**
     * champ affichant le nombre de parties nulles
     */
    private JTextField chNul;

    /**
     * panneau contenant les pions du joueur courant et la grille des cases ou
     * sont disposees les differentes pions
     */
    private JPanel pPionsEtGrille;

    /**
     * pions a cliquer
     */
    private PionP4[] tabPionP4;

    /**
     * construit l'interface graphique du jeu de Chessquito
     */
    public VueP4() {
        ControleurP4 controleur = new ControleurP4(this);
        this.setLayout(new BorderLayout(10, 10));
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 4, 10, 10));
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(2, 1));
        p2.add(new JLabel(" JAUNE"));
        this.chJaune = new JTextField("0");
        this.chJaune.setEditable(false);
        p2.add(this.chJaune);

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(2, 1));
        p3.add(new JLabel(" ROUGE"));
        this.chRouge = new JTextField("0");
        this.chRouge.setEditable(false);
        p3.add(this.chRouge);

        JPanel p4 = new JPanel();
        p4.setLayout(new GridLayout(2, 1));
        p4.add(new JLabel(" NUL"));
        this.chNul = new JTextField("0");
        this.chNul.setEditable(false);
        p4.add(this.chNul);
        JButton btRejouer = new JButton("rejouer");
        p1.add(p2);
        p1.add(p3);
        p1.add(p4);
        p1.add(btRejouer, BorderLayout.EAST);

        btRejouer.addActionListener(controleur);
        // associer le panneau p1 à l'instance courante

        this.add(p1, BorderLayout.NORTH);

        // créer le panneau du centre
        this.pPionsEtGrille = new JPanel();
        // lui associer le gestionnaire de mise en page
        this.pPionsEtGrille.setLayout(new GridLayout(7, 7));
        // créer la rangée de pions
        this.tabPionP4 = new PionP4[8];
        for (int j = 0; j < 7; j++) {
            this.tabPionP4[j] = new PionP4(j);
            this.tabPionP4[j].addActionListener(controleur);
            this.pPionsEtGrille.add(this.tabPionP4[j]);
        }
        // mettre les pions rouges dans la rangée
        this.setCouleurPions(CouleurP4.ROUGE);
        // créer les cases graphiques de la grille
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                CaseP4 c = new CaseP4(i, j);
                c.setIcon(new ImageIcon("./src/images/caseVide.jpg"));
                this.pPionsEtGrille.add(c);
            }
        }
        // ajouter le panneau du centre à l'instance courante
        this.add(this.pPionsEtGrille, BorderLayout.CENTER);
    }

    /**
     * positionne l'image des pions surplombant la grille avec le fichier
     * associé à la couleur du joueur courant
     * 
     * @param c
     *            couleur du joueur courant
     */
    public void setCouleurPions(CouleurP4 c) {
        String couleur;
        if (c == CouleurP4.ROUGE) {
            couleur = "RougeInitiale";
        } else {
            if (c == CouleurP4.JAUNE) {
                couleur = "JauneInitiale";
            } else {
                couleur = "vide";
            }
        }
        for (int j = 0; j < 7; j++) {
            if (couleur.equals("vide")) {
                this.tabPionP4[j].setIcon(null);
            } else {
                this.tabPionP4[j].setIcon(
                        new ImageIcon("./src/images/pion" + couleur + ".jpg"));
            }
        }
    }

    /**
     * positionne une image sur une case de coordonnees i et j
     * 
     * @param piece
     *            couleur de la pièce (NUL sui pas de pièce)
     * @param i
     *            indice de ligne de la case
     * @param j
     *            indice de colonne de la case
     */
    public void setImageCase(CouleurP4 couleur, int i, int j) {
        CaseP4 caseCourante = (CaseP4) this.pPionsEtGrille
                .getComponent(i * 7 + j);
        String libelle = "";
        switch (couleur) {
        case ROUGE:
            libelle = "RougeInitiale";
            break;
        case JAUNE:
            libelle = "JauneInitiale";
            break;
        case VIDE:
            libelle = "Vide";
            break;
        }
        caseCourante
                .setIcon(new ImageIcon("./src/images/case" + libelle + ".jpg"));
    }

    /**
     * incrémente le score ROUGE
     */
    public void incrementerRouge() {
        int valeur = Integer.parseInt(this.chRouge.getText());
        valeur += 1;
        this.chRouge.setText("" + valeur);
    }

    /**
     * incrémente le score JAUNE
     */
    public void incrementerJaune() {
        int valeur = Integer.parseInt(this.chJaune.getText());
        valeur += 1;
        this.chJaune.setText("" + valeur);
    }

    /**
     * incrémente le score NUL
     */
    public void incrementerNul() {
        int valeur = Integer.parseInt(this.chNul.getText());
        valeur += 1;
        this.chNul.setText("" + valeur);
    }

}

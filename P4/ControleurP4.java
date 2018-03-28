import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ControleurP4 implements ActionListener {
    private enum EtatControleur {
        ATTENTE_CLIC_PION_ROUGE, ATTENTE_CLIC_PION_JAUNE, FIN_PARTIE
    }

    private EtatControleur etat;
    private VueP4 vue;
    private ModeleP4 modele;

    public ControleurP4(VueP4 vue) {
        this.vue = vue;
        this.modele = new ModeleP4();
        this.etat = EtatControleur.ATTENTE_CLIC_PION_ROUGE;
    }

    public void actionPerformed(ActionEvent e) {
        // récupérer le bouton cliqué
        JButton b = (JButton) e.getSource();
        if (b.getText().equals("rejouer")) {
            // réinitialiser la grille du modèle
            this.modele.initialiser();
            // mettre les pions rouge sur la rangée de la vue
            this.vue.setCouleurPions(CouleurP4.ROUGE);
            // rafraichir la vue de la grille à partir du modèle
            this.rafraichir();
            this.etat = EtatControleur.ATTENTE_CLIC_PION_ROUGE;
        } else {
            PionP4 pion = (PionP4) b;
            switch (this.etat) {
            case ATTENTE_CLIC_PION_ROUGE:
                // sun pion rouge a été cliqué
                // positionner un pion rouge dans la grille du
                // modèle à partir de son numéro de colonne
                this.modele.jouer(CouleurP4.ROUGE, pion.getColonne());
                // rafraichir la vue de la grille à partir du modèle
                this.rafraichir();
                // si la partie est finie
                if (this.modele.estPartieFinie()) {
                    this.etat = EtatControleur.FIN_PARTIE;
                    // ne mettre aucun pion sur la rangée du haut
                    this.vue.setCouleurPions(CouleurP4.VIDE);
                    // si la partie a été gagné par les rouges
                    if (this.modele.rougeGagnant()) {
                        // ajouter 1 au score des rouges
                        this.vue.incrementerRouge();
                    } else {
                        // sinon la partie est nulle
                        // ajouter 1 au nombre de parties nulles
                        this.vue.incrementerNul();
                    }
                } else {
                    // sinon la partie n'est pas finie
                    // positionner les pions jaunes sur la rangée
                    this.vue.setCouleurPions(CouleurP4.JAUNE);
                    this.etat = EtatControleur.ATTENTE_CLIC_PION_JAUNE;
                }
                break;
            case ATTENTE_CLIC_PION_JAUNE:
                // un pion jaune a été cliqué
                this.modele.jouer(CouleurP4.JAUNE, pion.getColonne());
                this.rafraichir();
                if (this.modele.estPartieFinie()) {
                    this.etat = EtatControleur.FIN_PARTIE;
                    this.vue.setCouleurPions(CouleurP4.VIDE);
                    if (this.modele.jauneGagnant()) {
                        this.vue.incrementerJaune();
                    } else {
                        this.vue.incrementerNul();
                    }
                } else {
                    this.vue.setCouleurPions(CouleurP4.ROUGE);
                    this.etat = EtatControleur.ATTENTE_CLIC_PION_ROUGE;
                }
                break;
            case FIN_PARTIE:
            }
        }
    }

    /**
     * rafraichit l'affichage de la grille des cases graphiques contenant les
     * pions de puissance 4 à partir du modèle
     */
    public void rafraichir() {
        for (int i = 1; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                CouleurP4 couleurPion = this.modele.getCouleur(i - 1, j);
                this.vue.setImageCase(couleurPion, i, j);
            }
        }
    }

}

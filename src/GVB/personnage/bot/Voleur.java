package GVB.personnage.bot;

import GVB.generateur.GenerateurVoleur;
import iut.Game;
import iut.GameItem;

import java.util.Random;

/**
 * Classe qui gère les voleurs du jeu
 * @author Lucas Guillaume
 */
public class Voleur extends iut.BoxGameItem {
    private double vitesse;
    private double angle;
    private boolean gauchedroite = true;
    private long TimeToShoot = 1000;
    private final int posPremierEtage = 80;
    private final int posDeuxiemeEtage = 260;
    private final int posTroisiemeEtage = 440;
    private final int posQuatriemeEtage = 620;
    private String sens;//= "voleurGauche";

    public Voleur(Game g, int x, int y, double angle, double vitesse, String sens) {
        super(g, sens, x, y); // sens permet de chopper le bon sprite
        this.sens = sens;
        this.vitesse = vitesse;
        this.angle = angle;
        // 80, 260, 440, 620
    }

    /**
     * Permet de gerer les collions avec les voleurs
     * @param gameItem objet que peut rentrer les voleurs
     */
    @Override
    public void collideEffect(GameItem gameItem) {
        if (gameItem.getItemType() == "balle"){
            this.getGame().remove(this);
        }
    }

    @Override
    public String getItemType() {
        return "voleur";
    }

    /**
     * Permet a un voleur de changer d'étage lorsqu'il rencontre un bord
     */
    private void bounce() {
        int posY = 0 ;
        int posX = this.getMiddleX();
        double A = 0;

        //On commence par le supprimer
        this.getGame().remove(this);
        //Puis on regarde a qu'elle étage il etait pour qu'il change entre celui du dessus ou celui du dessous
        switch (this.getMiddleY()-50){
            case (80):
                posY = this.posDeuxiemeEtage;
                break;
            case (260):
                Random r1 = new Random();
                int t1 = r1.nextInt(2)+1;
                if (t1 == 1){
                    posY = this.posPremierEtage;
                }
                else{
                    posY = this.posTroisiemeEtage;
                }
                break;
            case(440):
                Random r2 = new Random();
                int t2 = r2.nextInt(2)+1;
                if (t2 == 1){
                    posY = this.posQuatriemeEtage;
                }
                else{
                    posY = this.posDeuxiemeEtage;
                }
                break;
            case (620):
                posY = this.posTroisiemeEtage;
                break;
        }
        A = (this.angle + 180)%360;
        if(A == 180.0){
            this.sens = "voleurGauche";
        }
        else{
            this.sens = "voleurDroite";
        }

        //Puis on le rajoute dans le jeu
        if (this.gauchedroite) {//Permet de savoir s'il il est bien en état de changement ou non
            if (this.getLeft() <= 0) {
                GenerateurVoleur nGL = new GenerateurVoleur(this, posY, posX+25, A, this.vitesse + 0.005, sens);
            } else if (this.getRight() > this.getGame().getWidth()) {
                GenerateurVoleur nGL = new GenerateurVoleur(this, posY, posX-25, A, this.vitesse + 0.005, sens);
            }
            this.gauchedroite = false;
        }
    }

    /**
     * Permet a un voleur de changer d'appeller la méthode bounce lorsqu'il rencontre un bord
     * @param l temps qui décompte en mili-seconde
     */
    @Override
    public void evolve(long l) {
        double A = 0;
        int x = 0;
        if (this.getLeft() <= 0) {
            bounce();
        }
        else if (this.getRight() > this.getGame().getWidth()) {
            bounce();
        }
        this.moveDA(l*this.vitesse, this.angle);
    }
}

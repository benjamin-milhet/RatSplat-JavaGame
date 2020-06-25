package GVB;

import GVB.objet.Balle;
import GVB.personnage.Joueur;
import iut.Game;
import iut.GameItem;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class fakeJoueur extends iut.BoxGameItem implements KeyListener {

    private GameItem echelle;
    private boolean gauchedroite = true;
    private String posJ;
    private int posX;
    private int posY;

    /**
     * Initialise le joueur
     * @param g le jeu
     * @param x la position de départ
     * @param y la position de départ
     */
    public fakeJoueur(Game g, int x, int y) {
        super(g, "policeDroite", x, y);
        this.posJ = "policeDroite";
        this.posX = x;
        this.posY = y;

    }

    public fakeJoueur(Game g, int x, int y, String sens) {
        super(g, sens, x, y);
        this.posJ = sens;
        this.posX = x;
        this.posY = y;
    }

    public GameItem getEchelle() {
        return echelle;
    }

    public String getPosJ() {
        return posJ;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Permet de récuperer les touches du clavier afin de déplacer le personnage
     * @param e touche actionner sur le clavier
     */
    @Override
    public void keyPressed(KeyEvent e) {
        try {
            //Si le joueur va a droite ou a gauche, on regarde bien qu'il ne dépasse pas les bords
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (this.getLeft() > 0) {
                        if (this.gauchedroite) {
                            if (this.posJ.equals("policeDroite")) {
                                Joueur joueur = new Joueur(this.getGame(), this.posX, this.posY, "policeGauche");
                                this.getGame().remove(this);
                                this.getGame().addItem(joueur);
                            }
                            this.posX -= 5;
                            this.moveXY(-5, 0);
                        }
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (this.getRight() < this.getGame().getWidth()) {
                        if (this.gauchedroite) {
                            if (this.posJ.equals("policeGauche")) {
                                Joueur joueur = new Joueur(this.getGame(), this.posX, this.posY, "policeDroite");
                                this.getGame().remove(this);
                                this.getGame().addItem(joueur);
                            }
                            this.posX += 5;
                            this.moveXY(+5, 0);
                        }
                    }
                    break;
                //Si le joueur veut monter ou descendre une echelle, on l'empeche d'aller a droite ou a gauche et on regarde si sa position est bien dans l'échelle
                case KeyEvent.VK_UP:
                    if (this.getTop() >= 0) {
                        if (this.getRight() <= this.echelle.getRight()) {
                            if (this.getLeft() >= this.echelle.getLeft()) {
                                if (this.getBottom() > this.echelle.getTop()) {
                                    this.gauchedroite = false;
                                    this.posY -= 5;
                                    this.moveXY(0, -5);
                                }
                            }
                        }
                        if (this.getBottom() <= this.echelle.getTop()) {
                            this.gauchedroite = true;
                        }
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (this.getRight() <= this.echelle.getRight()) {
                        if (this.getLeft() >= this.echelle.getLeft()) {
                            if (this.getBottom() < this.echelle.getBottom()) {
                                this.gauchedroite = false;
                                this.posY += 5;
                                this.moveXY(0, +5);
                            }
                        }
                    }
                    if (this.getBottom() >= this.echelle.getBottom()) {
                        this.gauchedroite = true;
                    }
                    break;
                //Touche permettant au joueur de tirer des balles suivant l'orientation du joueur
                case KeyEvent.VK_Q:
                    if(this.posJ.equals("policeGauche")) {
                        Balle ba = new Balle(getGame(), this.getMiddleX() - 41, this.getMiddleY()+5, 0.5, 180);getGame().addItem(ba);
                    }
                    break;
                case KeyEvent.VK_D:
                    if(this.posJ.equals("policeDroite")) {
                        Balle bd = new Balle(getGame(), this.getMiddleX() + 30, this.getMiddleY()+5, 0.5, 0);
                        getGame().addItem(bd);
                    }
                    break;
            }
        }
        catch (Exception e1){
            System.out.println("Impossible de monter ou descendre maintenant");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * Permet de gerer les objets que peut rencontrer le joueur
     * @param gameItem objet que le boss peut rencontrer
     */
    @Override
    public void collideEffect(GameItem gameItem) {
        Score score = new Score(this.getGame());
        //Permet de récuperer l'échelle sur laquelle y monte ou descend
        if (gameItem.getItemType() == "echelle"){
            this.echelle = gameItem;
        }
        //Permet de tuer le joueur s'il prend une balle
        if (gameItem.getItemType() == "balle"){
            this.getGame().remove(this);
            try {
                score.getExecTimer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Permet de passer le test sans lancer le jeu
            //this.getGame().die();
        }

    }

    @Override
    public String getItemType() {
        return "Joueur";
    }

    @Override
    public void evolve(long l) {

    }

}

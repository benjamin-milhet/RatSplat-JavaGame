package GVB.objet;

import GVB.GVB;
import GVB.generateur.GenerateurButin;
import iut.Game;
import iut.GameItem;

/**
 * Cette classe représente un objet de type butin, il doit être défendue par le joueur contre les voleurs
 */
public class Butin extends iut.BoxGameItem {
    private GenerateurButin generateurButin;
    public Butin(Game g, int x, int y, GenerateurButin generateurButin) {
        super(g, "butin", x, y);
        this.generateurButin = generateurButin;
        System.out.println(this.generateurButin.getNbArgent());


    }



    /**
     * Permet de supprimer le butin si un voleur l'attrape, S'il il n'y plus butin, le joueur a perdu
     * @param gameItem objet que peut rencontrer le butin
     */
    @Override
    public void collideEffect(GameItem gameItem) {
        if(gameItem.getItemType() == "voleur"){
            this.getGame().remove(this);
            this.generateurButin.enlever();
            System.out.println(this.generateurButin.getNbArgent());
            if(this.generateurButin.getNbArgent() <=0 ){
                this.getGame().die();
            }



        }
        if(gameItem.getItemType() == "Joueur"){
            //this.getGame().remove(this);
            //--nombre;
        }
    }

    @Override
    public String getItemType() {
        return "butin";
    }

    @Override
    public void evolve(long l) {


    }
}

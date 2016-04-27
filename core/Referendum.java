/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JUASP-G73-Android
 */
package core;

public class Referendum {
    final static public int INITIALISE = 0;
    final static public int OUVERT = 1;
    final static public int TERMINE = 2;
    private int statut;
    private Vector<BulletinReferendum>[] votes;

    public Referendum() {
        statut = INITIALISE;
        setVotes(new Vector[2]);
        setVotes(BulletinReferendum.OUI, new Vector<BulletinReferendum>());
        setVotes(BulletinReferendum.NON, new Vector<BulletinReferendum>());
    }
    public void ouvrir() {
        switch (statut) {
            case INITIALISE: { statut = OUVERT; }
            case OUVERT: { Log.log("statut invalide"); }
            case TERMINE: { Log.log("statut invalide"); }
        }
    }
    public void fermer() {
        switch (statut) {
            case INITIALISE: { Log.log("statut invalide"); }
            case OUVERT:    { 
                                statut = TERMINE;
                                depouiller();
                            }
        case TERMINE: { Log.log("statut invalide"); }
        }
       
    }
    public void votation() {
        switch (statut) {
            case INITIALISE: { Log.log("statut invalide"); }
            case OUVERT: {
                            Electeur unElecteur = getElecteurSuivant();
                            isoloir(unElecteur);
                           }
            case TERMINE: { Log.log("statut invalide"); }
    }
}
// rend le vainqueur du référendum
public Object depouiller() {
    switch (statut) {
        case INITIALISE: { Log.log("statut invalide"); }
        case OUVERT: { Log.log("statut invalide"); }
        case TERMINE: { 
                        int nbOui = getVotes(BulletinReferendum.OUI).size();
                        int nbNon = getVotes(BulletinReferendum.NON).size();
                        if (nbOui > nbNon)
                        return BulletinReferendum.OUI;
                        if (nbOui < nbNon)
                        return BulletinReferendum.NON;
                      }
    }
    return null; // aucun vainqueur ou invocation inappropriée
}

public void isoloir(Electeur electeur) {
    if (estEligible (electeur)) {
        BulletinReferendum b = new BulletinReferendum();
        electeur.voter(b);
        getVotes(b.getVoteIndex()).add(b);
    }
}
//protected boolean estEligible(Electeur electeur) {  }
//protected Electeur getElecteurSuivant() {  }
protected Vector[] getVotes() {return votes;}
protected Vector<BulletinReferendum> getVotes(int i) {return votes[i];}
protected void setVotes(Vector<BulletinReferendum>[] votes) {votes = votes;}
protected void setVotes(int i, Vector<BulletinReferendum> v) {votes[i] = v;}
}
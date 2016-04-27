package core;

import java.util.Vector;

public class Referendum {
    /******************************/
    /********  CONSTANTS **********/
    /******************************/
    final static public int INITIALISE = 0;
    final static public int OUVERT = 1;
    final static public int TERMINE = 2;
    
    /******************************/
    /****  PRIVATE ATTRIBUTES *****/
    /******************************/
    private int statut;
    
    //Design pattern - Observer : Subject 
    private Subject subject = null;
    
    private Vector<BulletinReferendum>[] votes;

    
    /***************************************/
    /***********  CONSTRUCTOR **************/
    /***************************************/

    public Referendum() {
        this.subject = new Subject(); // new instance of Subject
        statut = INITIALISE;
        setVotes(new Vector[2]); 
        setVotes(BulletinReferendum.OUI, new Vector<BulletinReferendum>()); // index 1
        setVotes(BulletinReferendum.NON, new Vector<BulletinReferendum>()); // index 2
    }
    
    /***************************************/
    /********  GETTER AND SETTER ***********/
    /***************************************/
    
    public int getStatut() {
        return statut;
    }
    
    public Subject getSubject() {
        return subject;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }    

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    
    
    
    /***************************************/
    /*************  METHODS ****************/
    /***************************************/
    public void ouvrir() {
        switch (statut) {
            case INITIALISE: { 
                                statut = OUVERT;
                                this.subject.setState(statut);
                }
            case OUVERT: { Log.log("statut invalide"); }
            case TERMINE: { Log.log("statut invalide"); }
        }
    }
    public void fermer() {
        switch (statut) {
            case INITIALISE: { Log.log("statut invalide"); }
            case OUVERT:    { 
                                statut = TERMINE;
                                this.subject.setState(statut);
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
                            this.subject.setState(3); // 3 is the state for a new vote
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
                        else
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
    
    /************************************/
    /******  PROTECTED METHODS **********/
    /************************************/
    
    protected boolean estEligible(Electeur electeur) { 
        return true;
    }
    protected Electeur getElecteurSuivant() { 
        return new Electeur();
    }
    protected Vector[] getVotes() {
        return votes;
    }
    protected Vector<BulletinReferendum> getVotes(int i) {
        return votes[i];
    }
    protected void setVotes(Vector<BulletinReferendum>[] v) {
        this.votes = v;
    }
    protected void setVotes(int i, Vector<BulletinReferendum> v) {
        votes[i] = v;
    }
}
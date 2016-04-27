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
    private ReferendumState state;
    
    //Design pattern - Observer : Subject 
    private Subject subject = null;
    
    private Vector<BulletinReferendum>[] votes;

    
    /***************************************/
    /***********  CONSTRUCTOR **************/
    /***************************************/

    public Referendum() {
        this.subject = new Subject(); // new instance of Subject
        ReferendumState rs = ReferendumStateFactory.getReferendumState("INITIALISE");
        rs.doStateAction(this);
        setVotes(new Vector[2]); 
        setVotes(BulletinReferendum.OUI, new Vector<BulletinReferendum>()); // index 1
        setVotes(BulletinReferendum.NON, new Vector<BulletinReferendum>()); // index 2
    }

 
    
    /***************************************/
    /********  GETTER AND SETTER ***********/
    /***************************************/
    
    
    public ReferendumState getState() {
        return state;
    }

    public void setState(ReferendumState state) {
        this.state = state;
    }
    
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    
    
    
    /***************************************/
    /*************  METHODS ****************/
    /***************************************/
    public void ouvrir() {
        if(this.getState().getStateCode() == OUVERT) {
        //Replace Temp with Query
        ReferendumStateFactory.getReferendumState("START").doStateAction(this);
        
        //We change the state on the Subject, so he can notify all the observers
        this.subject.setState(this.getState().getStateCode());
        }
        else{
            Log.log("Referendum-ouvrir(): statut invalide");
        }
    }
    public void fermer() {       
        if(this.getState().getStateCode() == OUVERT) {
            //Replace Temp with Query
            ReferendumStateFactory.getReferendumState("STOP").doStateAction(this);
            
            //We change the state on the Subject, so he can notify all the observers
            this.subject.setState(this.getState().getStateCode());
            depouiller();
        }
        else{
            Log.log("Referendum-fermer(): statut invalide");
        }
    }
    public void votation() {
        switch (statut) {
            case INITIALISE: { Log.log("Referendum-votation(): statut invalide");break; }
            case OUVERT: {
                            Log.log("Referendum-votation(): Un vote");
                            Electeur unElecteur = getElecteurSuivant();
                            isoloir(unElecteur);
                            this.subject.setState(3); // 3 is the state for a new vote
                            break;
                           }
            case TERMINE: { Log.log("Referendum-votation(): statut invalide");break; }
    }
}
// rend le vainqueur du référendum
public Object depouiller() {
    switch (statut) {
        case INITIALISE: { Log.log("Referendum-depouiller(): statut invalide");break; }
        case OUVERT: { Log.log("Referendum-depouiller(): statut invalide");break; }
        case TERMINE: { 
                        Log.log("Referendum-depouiller(): statut invalide");
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
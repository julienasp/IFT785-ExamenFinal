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
    private IReferendumState state;
    
    //Design pattern - Observer : Subject 
    private Subject subject = null;
    
    private Vector<BulletinReferendum>[] votes;

    
    /***************************************/
    /***********  CONSTRUCTOR **************/
    /***************************************/

    public Referendum() {
        this.subject = new Subject(); // new instance of Subject
        //Replace Temp with Query
        ReferendumStateFactory.getReferendumState("INITIALISE").doStateAction(this);        
        setVotes(new Vector[2]); 
        setVotes(BulletinReferendum.OUI, new Vector<BulletinReferendum>()); // index 1
        setVotes(BulletinReferendum.NON, new Vector<BulletinReferendum>()); // index 2
    }

 
    
    /***************************************/
    /********  GETTER AND SETTER ***********/
    /***************************************/
    
    
    public IReferendumState getState() {
        return state;
    }

    public void setState(IReferendumState state) {
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
        //Replace Temp with Query + State pattern
        ReferendumStateFactory.getReferendumState("START").doStateAction(this);
    }
    public void fermer() {  
        //Replace Temp with Query + State pattern
        ReferendumStateFactory.getReferendumState("STOP").doStateAction(this);    
    }
    public void votation() {
       //Use of the State pattern
       this.getState().doVoting(this);    
    }

    public Object depouiller() {
        //Use of the State pattern
        return this.getState().getReferendumResult(this);
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
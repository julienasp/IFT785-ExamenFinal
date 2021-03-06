package core;

import java.util.Vector;

public class Referendum extends Election {
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
        
        //Default VotingSystemStandard is set to ReferendumVotingSystemStandardStrategy
        setVotingSystemStandard(VotingSystemStandardStrategyFactory.getVotingSystemStandardStrategy("ReferendumVSSS"));
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
    
    /************************************/
    /******  PROTECTED METHODS **********/
    /************************************/    
    
    protected Electeur getElecteurSuivant() { 
        return new Electeur();
    }
    protected Vector[] getVotes() {
        return this.votes;
    }
    protected Vector<BulletinReferendum> getVotes(int i) {
        return this.votes[i];
    }
    protected void setVotes(Vector<BulletinReferendum>[] v) {
        this.votes = v;
    }
    protected void setVotes(int i, Vector<BulletinReferendum> v) {
        this.votes[i] = v;
    }
}
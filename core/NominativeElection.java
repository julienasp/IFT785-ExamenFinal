package core;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class NominativeElection extends Election {   
    /******************************/
    /****  PRIVATE ATTRIBUTES *****/
    /******************************/
    private INominativeElectionState state;    
    private Vector<String> nominate;
    private Hashtable <String,Vector<NominativeBallot>> votes;  
    
    //Design pattern - Observer : Subject 
    private Subject subject = null;
    

    
    /***************************************/
    /***********  CONSTRUCTOR **************/
    /***************************************/

    public NominativeElection() {
        //Static values for the default Constructor                
        this.nominate.add("A");
        this.nominate.add("B");
        this.nominate.add("C");
        this.nominate.add("D");
        this.nominate.add("E");
        //End of the static values
        
        this.subject = new Subject(); // new instance of Subject
        
        //Replace Temp with Query
        NominativeElectionStateFactory.getNominativeElectionState("INITIALISE").doStateAction(this);
        
        //Default VotingSystemStandard is set to ReferendumVotingSystemStandardStrategy
        setVotingSystemStandard(VotingSystemStandardStrategyFactory.getVotingSystemStandardStrategy("NominativeVSSS"));        
        setVotes(generateInitialVoteTable(this.nominate));       
    }

  

    /***************************************/
    /********  GETTER AND SETTER ***********/
    /***************************************/  

    public INominativeElectionState getState() {
        return state;
    }

    public void setState(INominativeElectionState state) {
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
    private Hashtable <String,Vector<NominativeBallot>> generateInitialVoteTable(Vector<String> v){
        Iterator it = v.iterator();
        
        Hashtable <String,Vector<NominativeBallot>> votes = new Hashtable <String,Vector<NominativeBallot>>();
        while(it.hasNext()){
            votes.put((String)it.next(), new Vector<NominativeBallot>());
        }
        return votes;
    }
    public void ouvrir() {        
        //Replace Temp with Query + State pattern
        NominativeElectionStateFactory.getNominativeElectionState("START").doStateAction(this);
    }
    public void fermer() {  
        //Replace Temp with Query + State pattern
        NominativeElectionStateFactory.getNominativeElectionState("STOP").doStateAction(this);    
    }
    public void votation() {
       //Use of the State pattern
       this.getState().doVoting(this);    
    }
    public Object depouiller() {
        //Use of the State pattern
        return this.getState().getNominativeElectionResult(this);
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
    protected Vector<NominativeBallot> getVotes(int i) {
        return this.votes[i];
    }
    protected void setVotes(Hashtable <String,Vector<NominativeBallot>> ht) {
        this.votes = ht;
    }    
}
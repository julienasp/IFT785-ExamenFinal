package core;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class NominativeElection extends Election {   
    /******************************/
    /****  PRIVATE ATTRIBUTES *****/
    /******************************/
    private INominativeElectionState state;
    private Hashtable <String,Vector<NominativeBallot>> votes;  
    
    //Design pattern - Observer : Subject 
    private Subject subject = null;
    

    
    /***************************************/
    /***********  CONSTRUCTOR **************/
    /***************************************/    
     public NominativeElection() {
        //Static values for the default Constructor
        Vector<String> nominate = new Vector<String>();
        nominate.add("A");
        nominate.add("B");
        nominate.add("C");
        nominate.add("D");
        nominate.add("E");
        //End of the static values
        
        this.subject = new Subject(); // new instance of Subject
        
        //Replace Temp with Query
        NominativeElectionStateFactory.getNominativeElectionState("INITIALISE").doStateAction(this);
        
        //Default VotingSystemStandard is set to ReferendumVotingSystemStandardStrategy
        setVotingSystemStandard(VotingSystemStandardStrategyFactory.getVotingSystemStandardStrategy("NominativeVSSS"));        
        setVotes(generateInitialVoteTable(nominate));       
    }
    public NominativeElection(Vector<String> nominateList) {        
        this.subject = new Subject(); // new instance of Subject
        
        //Replace Temp with Query
        NominativeElectionStateFactory.getNominativeElectionState("INITIALISE").doStateAction(this);

        //Default VotingSystemStandard is set to ReferendumVotingSystemStandardStrategy
        setVotingSystemStandard(VotingSystemStandardStrategyFactory.getVotingSystemStandardStrategy("NominativeVSSS"));        
        setVotes(generateInitialVoteTable(nominateList));       
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
    public Vector<String> extractNomiate(){
        Vector<String> nominateList = new Vector<String>();
        
        Hashtable <String,Vector<NominativeBallot>> votes = this.getVotes();

            //Creating a set for the Hashtable
            Set set = votes.entrySet();

            //Iterator for the set
            Iterator it = set.iterator();

            //While loop to iterate through the Set
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();

                String currentNominateName = (String) entry.getKey();

                //If the currentNominate has 50% of the total vote count he wins
                nominateList.add(currentNominateName);
            }
        return nominateList;
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
    protected Hashtable <String,Vector<NominativeBallot>> getVotes() {
        return this.votes;
    }
    protected Vector<NominativeBallot> getVotes(String nominateName) {
        return this.getVotes().get(nominateName);
    }
    protected void setVotes(Hashtable <String,Vector<NominativeBallot>> ht) {
        this.votes = ht;
    }    
}
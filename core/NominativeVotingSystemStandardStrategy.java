/*
 * USED FOR :
 * DESIGN PATTERN : Strategy
 * RELATIVE EXAM QUESTION: Question 6-C  
 */
package core;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 *
 * @author JUASP-G73-Android
 */
public class NominativeVotingSystemStandardStrategy implements IVotingSystemStandardStrategy{
    public boolean validateEligibility(Electeur e){
        //Here we code how we want to validate the Eligibility
        //Question 6, c, needs to be a woman between 18 and 50 to vote so 18 < Woman < 50
        if(e.getAge() > 18 && e.getAge() < 50 && e.getGender() == Electeur.WOMAN) return true;
        else return false;
    }
    public Bulletin giveBallotPaper(){
        return new NominativeBallot(); // We return a Referendum Ballot Paper
    }
    public void votingProcess(Electeur e, Bulletin b){
        e.voter((NominativeBallot)b);
    }
    public void savingVote(Election e, Bulletin b){
        NominativeElection ne  = (NominativeElection) e;
        NominativeBallot nb = (NominativeBallot) b;
        if(nb.isValide()){
            ne.getVotes(nb.getVote()).add(nb);
        }        
    }    
    public Object processingResult(Election e){
        NominativeElection ne  = (NominativeElection) e;
        
        int totalVoteCount = 0;
        
        //We count the number of votes
        for(Vector<NominativeBallot> currentNominativeBallot: ne.getVotes().values()){
            totalVoteCount += currentNominativeBallot.size();
        }
        
        if(totalVoteCount > 0){
            Hashtable <String,Vector<NominativeBallot>> votes = ne.getVotes();

            //Création d'un set pour parcourir la Hashtable
            Set set = votes.entrySet();

            //Création d'un iterator pour parcourir notre set
            Iterator it = set.iterator();

            //Boucle while qui parcours le set.
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();

                Vector<NominativeBallot> currentVectorOfNominativeBallot = (Vector<NominativeBallot>) entry.getValue();
                String currentNominateName = (String) entry.getKey();
                
                //If the currentNominate has 50% of the total vote count he wins
                if( (currentVectorOfNominativeBallot.size() / totalVoteCount) >= 0.5 ) return currentNominateName;
            }
        
        }
        return "No winner";        
    }
}
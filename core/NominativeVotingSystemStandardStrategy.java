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
    public Bulletin giveBallotPaper(Election e){
        NominativeElection ne  = (NominativeElection) e;
        return new NominativeBallot(ne.extractNomiate()); // We return a Referendum Ballot Paper
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
        
        //We dont want a divide by 0
        if(totalVoteCount > 0){
            Hashtable <String,Vector<NominativeBallot>> votes = ne.getVotes();

            //Creating a set for the Hashtable
            Set set = votes.entrySet();

            //Iterator for the set
            Iterator it = set.iterator();

            //While loop to iterate through the Set
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();

                Vector<NominativeBallot> currentVectorOfNominativeBallot = (Vector<NominativeBallot>) entry.getValue();
                String currentNominateName = (String) entry.getKey();
                
                //If the currentNominate has 50% of the total vote count he wins
                if( (currentVectorOfNominativeBallot.size() / totalVoteCount) >= 0.5 ) return currentNominateName;
            }
        
        }
        return null;        
    }
}
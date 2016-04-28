/*
 * USED FOR :
 * DESIGN PATTERN : Strategy
 */
package core;

/**
 *
 * @author JUASP-G73-Android
 */
public class ReferendumVotingSystemStandardStrategy implements IVotingSystemStandardStrategy{
    public boolean validateEligibility(Electeur e){
        //Here we code how we want to validate the Eligibility
        //Question 6, b, needs to be an adult to vote
        if(e.getAge() >= 18) return true;
        else return false;
    }
    public Bulletin giveBallotPaper(Election e){
        return new BulletinReferendum(); // We return a Referendum Ballot Paper
    }
    public void votingProcess(Electeur e, Bulletin b){
        e.voter((BulletinReferendum)b);
    }
    public void savingVote(Election e, Bulletin b){
        Referendum r = (Referendum) e;
        BulletinReferendum br = (BulletinReferendum) b;
        if(br.isValide()){
            r.getVotes(br.getVoteIndex()).add(br);
        }        
    }    
    public Object processingResult(Election e){
        Referendum r = (Referendum) e;
        
        //Refactoring : Replace Temp with Query
        if (r.getVotes(BulletinReferendum.OUI).size() > r.getVotes(BulletinReferendum.NON).size())
            return BulletinReferendum.OUI;
        else
            return BulletinReferendum.NON; 
    }
}
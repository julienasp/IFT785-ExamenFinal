/*
 * USED FOR :
 * DESIGN PATTERN : Strategy
 * RELATIVE EXAM QUESTION: Question 6-C  
 */
package core;

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
        return new BulletinNomative(); // We return a Referendum Ballot Paper
    }
    public void votingProcess(Electeur e, Bulletin b){
        e.voter((BulletinNomative)b);
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
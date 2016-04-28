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
        return true; // returning true since, the algo isn't a part of the problem... for now
    }
    public Bulletin giveBallotPaper(){
        return new BulletinReferendum(); // We return a Referendum Ballot Paper
    }
    public void votingProcess(Electeur e, Bulletin b){
        e.voter((BulletinReferendum)b);
    }
    public void savingVote(Election e, Bulletin b){
        Referendum r = (Referendum) e;
        BulletinReferendum br = (BulletinReferendum) b;
        r.getVotes(br.getVoteIndex()).add(br);
    }
}
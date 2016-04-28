/*
 * USED FOR :
 * DESIGN PATTERN : Strategy pattern + Template pattern
 */
package core;

/**
 *
 * @author JUASP-G73-Android
 */
public abstract class Election {
    /******************************/
    /********  CONSTANTS **********/
    /******************************/
    final static public int INITIALISE = 0;
    final static public int OUVERT = 1;
    final static public int TERMINE = 2;
    
    /******************************/
    /****  PRIVATE ATTRIBUTES *****/
    /******************************/
    private IVotingSystemStandardStrategy votingSystemStandard;
    
    /***************************************/
    /********  GETTER AND SETTER ***********/
    /***************************************/
    public IVotingSystemStandardStrategy getVotingSystemStandard() {
        return this.votingSystemStandard;
    }    
    public void setVotingSystemStandard(IVotingSystemStandardStrategy votingSystemStandard) {
        this.votingSystemStandard = votingSystemStandard;
    }
    
    /***************************************/
    /**********  FINAL METHODS *************/
    /***************************************/
    public final void isoloir(Electeur electeur) {
        //Use of the Strategy pattern + Template pattern
        IVotingSystemStandardStrategy vss = this.getVotingSystemStandard();
        if(vss.validateEligibility(electeur)){
            Bulletin b = vss.giveBallotPaper(this);
            vss.votingProcess(electeur, b);
            vss.savingVote(this, b);
        }      
    }
}

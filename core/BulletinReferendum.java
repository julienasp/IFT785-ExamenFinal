package core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JUASP-G73-Android
 */

public class BulletinReferendum extends Bulletin{
    final static int OUI = 0;
    final static int NON = 1;
    private int vote;

    public void voter(int vote){
           this.vote = vote;
    }
    public boolean isValide(){
            return vote == OUI || vote == NON;
    }
    public int getVoteIndex() {
        return vote;
    }
}

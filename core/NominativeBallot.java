package core;

import java.util.Hashtable;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JUASP-G73-Android
 */

public class NominativeBallot extends Bulletin{    
    /******************************/
    /****  PRIVATE ATTRIBUTES *****/
    /******************************/
    private Vector<String> nominate;
    private String vote;

    /***************************************/
    /***********  CONSTRUCTOR **************/
    /***************************************/
    public NominativeBallot(Vector<String> nominateList) {
        this.nominate = nominateList;
    }    
    
    /***************************************/
    /********  GETTER AND SETTER ***********/
    /***************************************/
    public Vector<String> getNominate() {
        return nominate;
    }

    public void setNominate(Vector<String> nominate) {
        this.nominate = nominate;
    }
    
    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }
    
    /***************************************/
    /********* USEFUL METHODS **************/
    /***************************************/
    synchronized public void addNominate(String nominateName){
        this.getNominate().add(nominateName);
    }
    synchronized public void removeNominate(int index){
        this.getNominate().remove(index);
    }
    
    /***************************************/
    /*************  METHODS ****************/
    /***************************************/
    public void voter(Object o){
        String v = o.toString();
        this.vote = v;
    }
    public boolean isValide(){        
        return (this.getNominate().contains(vote));            
    }    
}

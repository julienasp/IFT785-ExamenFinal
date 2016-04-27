/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author JUASP-G73-Android
 */
public class MediaObserverFactory {
    public Observer getMediaObserver(String typeMediaObserver, Subject s){
		
	switch (typeMediaObserver.toUpperCase()) {
            case "RADIOCANADA":  Log.log("MediaObserverFactory-getMediaObserver(): new RadioCanadaMediaObserver returned"); return new RadioCanadaMediaObserver(s);                    
            case "LAPRESSE":  Log.log("MediaObserverFactory-getMediaObserver(): new LaPresseMediaObserver returned"); return new LaPresseMediaObserver(s);  
            default: Log.log("MediaObserverFactory-getMediaObserver(): null returned");return null;                     
        }	
    }
}

/*
 * USED FOR :
 * DESIGN PATTERN : Factory Method
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

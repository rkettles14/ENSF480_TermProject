/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CHUCK
 */
import java.util.ArrayList;
public interface Subject {
    
    public void register(Observer obj);
    public void unregister(Observer obj);
    public void notifyObservers();
    public ArrayList<Promotion> getUpdate(Observer obj);
}

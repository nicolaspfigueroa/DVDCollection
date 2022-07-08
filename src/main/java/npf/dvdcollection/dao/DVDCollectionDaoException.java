/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npf.dvdcollection.dao;

/**
 *
 * @author Nico
 */
public class DVDCollectionDaoException extends Exception{
    
    public DVDCollectionDaoException(String message) {
        super(message);
    }
    
    public DVDCollectionDaoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
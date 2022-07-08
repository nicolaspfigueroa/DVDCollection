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
import java.util.*;
import java.io.*;
import npf.dvdcollection.dto.DVD;
public interface DVDCollectionDao {
    
    public DVD addDVD(String name, DVD newDVD)
            throws DVDCollectionDaoException;
    
    public DVD removeDVD(String name)
            throws DVDCollectionDaoException;
    
    public void changeName(String oldName, String newName)
            throws DVDCollectionDaoException;
    
    
    public void changeReleaseDate(String name, String date)
            throws DVDCollectionDaoException;
    
    public void changeMPAARating(String name, String rating)
            throws DVDCollectionDaoException;
    
    public void changeDirectorsName(String name, String dirName)
            throws DVDCollectionDaoException;
    
    public void changeStudio(String name, String studio)
            throws DVDCollectionDaoException;
    
    public void changeUserRating(String name, String rating)
            throws DVDCollectionDaoException;
    
    public void listDVDs()
            throws DVDCollectionDaoException;
    
    public void listValues(String name)
            throws DVDCollectionDaoException;
    
    public DVD getDVD(String dvdId) 
        throws DVDCollectionDaoException;
    
    public List<DVD> getAllDVDs() 
        throws DVDCollectionDaoException;
}

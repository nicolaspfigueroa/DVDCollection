/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npf.dvdcollection.ui;

import java.util.*;
import npf.dvdcollection.dto.DVD;

/**
 *
 * @author Nico
 */
public class DVDCollectionView {
      private UserIO io;
    
    public DVDCollectionView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Welcome to the DVD collection interface.");
        io.print("1.) Add DVD to the collection");
        io.print("2.) Remove a DVD from the collection");
        io.print("3.) Edit the information for an existing DVD");
        io.print("4.) List all DVDs currently in the collection");
        io.print("5.) Display all available information for a DVD");
        io.print("6.) Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    public int printEditMenu() {
        io.print("1.) Change name");
        io.print("2.) Change realease date");
        io.print("3.) Change MPAA rating");
        io.print("4.) Change director's name");
        io.print("5.) Change sudio");
        io.print("6.) Change user rating");
        io.print("7.) Exit");
        
        return io.readInt("Please select from the above choices.", 1, 7);
    }
    
    public DVD getDVDInfo() {
        String title = io.readString("Please enter the DVD title");
        String releaseDate = io.readString("Please enter the Release Date");
        String mPAARating = io.readString("Please enter the MPAA Rating");
        String directorsName = io.readString("Please enter the Director's Name");
        String studio = io.readString("Please enter the Studio name");
        String userRating = io.readString("Please enter the User Rating / Comments");
        DVD currentDVD = new DVD(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setmPAARating(mPAARating);
        currentDVD.setDirectorsName(directorsName);
        currentDVD.setStudio(studio);
        currentDVD.setUserRating(userRating);
        return currentDVD;
    }
    
    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }
    
    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created.  Please hit enter to continue");
    }
    
    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            String dvdInfo = String.format("#%s",
                  currentDVD.getTitle());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }
    
    public void displayDisplayDVDBanner () {
        io.print("=== Display DVD ===");
    }

    public String getDVDChoice() {
        return io.readString("Please enter the DVD Title.");
    }

    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print("Release Date: " + dvd.getReleaseDate());
            io.print("MPAA Rating: " + dvd.getmPAARating());
            io.print("Director's Name: " + dvd.getDirectorsName());
            io.print("Studio: " + dvd.getStudio());
            io.print("User Rating / Comments: " + dvd.getUserRating());
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayRemoveDVDBanner () {
    io.print("=== Remove DVD ===");
}

    public void displayRemoveResult(DVD dvdRecord) {
        if(dvdRecord != null){
          io.print("DVD successfully removed.");
        }else{
          io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }  
}

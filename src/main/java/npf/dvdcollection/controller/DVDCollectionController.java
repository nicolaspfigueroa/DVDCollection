/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npf.dvdcollection.controller;

import java.util.List;
import npf.dvdcollection.dao.DVDCollectionDao;
import npf.dvdcollection.dao.DVDCollectionDaoException;
import npf.dvdcollection.dto.DVD;
import npf.dvdcollection.ui.DVDCollectionView;
import npf.dvdcollection.ui.UserIO;
import npf.dvdcollection.ui.UserIOConsoleImpl;

/**
 *
 * @author Nico
 */
public class DVDCollectionController {
    private DVDCollectionView view;
    private DVDCollectionDao dao;
    private UserIO io = new UserIOConsoleImpl();
    
    public DVDCollectionController(DVDCollectionDao dao, DVDCollectionView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        createDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        runEditMenu();
                        break;
                    case 4:
                        listDVDs();
                        break;
                    case 5:
                        viewDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (DVDCollectionDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    public void runEditMenu() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getEditMenuSelection();

                switch (menuSelection) {
                    case 1:
                        changeName();
                        break;
                    case 2:
                        changeReleaseDate();
                        break;
                    case 3:
                        changeMPAARating();
                        break;
                    case 4:
                        changeDirectorsName();
                        break;
                    case 5:
                        changeStudio();
                        break;
                    case 6:
                        changeUserRating();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (DVDCollectionDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
        
    private int getEditMenuSelection() {
        return view.printEditMenu();
    }

    private void createDVD() throws DVDCollectionDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void listDVDs() throws DVDCollectionDaoException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }

    private void viewDVD() throws DVDCollectionDaoException {
        view.displayDisplayDVDBanner();
        String dvdId = view.getDVDChoice();
        DVD dvd = dao.getDVD(dvdId);
        view.displayDVD(dvd);
    }

    private void removeDVD() throws DVDCollectionDaoException {
        view.displayRemoveDVDBanner();
        String dvdId = view.getDVDChoice();
        DVD removedDVD = dao.removeDVD(dvdId);
        view.displayRemoveResult(removedDVD);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
    
    private void changeName() throws DVDCollectionDaoException {
        view.displayDisplayDVDBanner();
        String dvdId = view.getDVDChoice();
        String newTitle = io.readString("Enter new title: ");
        dao.changeName(dvdId, newTitle);
        DVD dvd = dao.getDVD(newTitle);
        view.displayDVD(dvd);
    }
    
    private void changeReleaseDate() throws DVDCollectionDaoException {
        view.displayDisplayDVDBanner();
        String dvdId = view.getDVDChoice();
        String newDate = io.readString("Enter new release date: ");
        dao.changeReleaseDate(dvdId, newDate);
        DVD dvd = dao.getDVD(newDate);
        view.displayDVD(dvd);
    }
       
    private void changeMPAARating() throws DVDCollectionDaoException {
        view.displayDisplayDVDBanner();
        String dvdId = view.getDVDChoice();
        String newRating = io.readString("Enter new MPAA Rating: ");
        dao.changeMPAARating(dvdId, newRating);
        DVD dvd = dao.getDVD(newRating);
        view.displayDVD(dvd);
    }
    
    private void changeDirectorsName() throws DVDCollectionDaoException {
        view.displayDisplayDVDBanner();
        String dvdId = view.getDVDChoice();
        String newName = io.readString("Enter new director's name: ");
        dao.changeDirectorsName(dvdId, newName);
        DVD dvd = dao.getDVD(newName);
        view.displayDVD(dvd);
    }
    
    private void changeStudio() throws DVDCollectionDaoException {
        view.displayDisplayDVDBanner();
        String dvdId = view.getDVDChoice();
        String newStudio = io.readString("Enter new studio name: ");
        dao.changeMPAARating(dvdId, newStudio);
        DVD dvd = dao.getDVD(newStudio);
        view.displayDVD(dvd);
    }
    
    private void changeUserRating() throws DVDCollectionDaoException {
        view.displayDisplayDVDBanner();
        String dvdId = view.getDVDChoice();
        String newRating = io.readString("Enter new user rating: ");
        dao.changeUserRating(dvdId, newRating);
        DVD dvd = dao.getDVD(newRating);
        view.displayDVD(dvd);
    } 
}

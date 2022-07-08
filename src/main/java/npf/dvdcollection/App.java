/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npf.dvdcollection;

import npf.dvdcollection.controller.DVDCollectionController;
import npf.dvdcollection.dao.DVDCollectionDao;
import npf.dvdcollection.dao.DVDCollectionDaoFileImpl;
import npf.dvdcollection.ui.DVDCollectionView;
import npf.dvdcollection.ui.UserIO;
import npf.dvdcollection.ui.UserIOConsoleImpl;

/**
 *
 * @author Nico
 */
public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DVDCollectionView myView = new DVDCollectionView(myIo);
        DVDCollectionDao myDao = new DVDCollectionDaoFileImpl();
        DVDCollectionController controller =
                new DVDCollectionController(myDao, myView);
        controller.run();
    }  
}

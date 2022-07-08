/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npf.dvdcollection.dto;

/**
 *
 * @author Nico
 */
public class DVD {
    private String title;
    private String releaseDate;
    private String mPAARating;
    private String directorsName;
    private String studio;
    private String userRating;
       
    public DVD(String title){
        this.title = title;
        
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public void setReleaseDate(String releaseDate){
        this.releaseDate = releaseDate;
    }
    
    public String getReleaseDate(){
        return this.releaseDate;
    }
    
    public void setmPAARating(String mPAARating){
        this.mPAARating = mPAARating;
    }
    
    public String getmPAARating(){
        return this.mPAARating;
    }
    
    public void setDirectorsName(String directorsName){
        this.directorsName = directorsName;
    }
    
    public String getDirectorsName(){
        return this.directorsName;
    }
    
    public void setStudio(String studio){
        this.studio = studio;
    }
    
    public String getStudio(){
        return this.studio;
    }
    
    public void setUserRating(String userRating){
        this.userRating = userRating;
    }
    
    public String getUserRating(){
        return this.userRating;
    }

}

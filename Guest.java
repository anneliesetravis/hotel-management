package hotel;
import java.time.LocalDate;

class Guest {
private int guestID;
private String fName;
private String lName;
private LocalDate dateJoin;
private static int noOfGuests = 0;

/*
The constructor for Guest class (sets attributes)
param guestID:sets the guest ID, int
param fName: sets the Guest's first name, string
param lName: sets the Guest's last name, string
param dateJoin: sets the date that the guest registered with the hotel
*/

public Guest(int guestID, String fName, String lName, LocalDate dateJoin){
  this.guestID = guestID;
  this.fName = fName;
  this.lName = lName;
  this.dateJoin = dateJoin;
  int noOfGuests =+ 1;
}
public Guest(String fName, String lName, LocalDate dateJoin){
  this.guestID = ++noOfGuests;
  this.fName = fName;
  this.lName = lName;
  this.dateJoin = dateJoin;
}

public String toString(){
  return getGuestID() + "," + getFName() + "," + getLName() + "," + getDateJoin();
}

//getter methods
public int getGuestID(){
  return guestID;
}
public String getFName(){
  return fName;
}
public String getLName(){
  return lName;
}
public LocalDate getDateJoin(){
  return dateJoin;
}
public int getNoOfGuests(){
  return noOfGuests;
}
//setter methods

public void setGuestID(int guestID){
  this.guestID = guestID;
}
public void setFName(String fName){
  this.fName = fName;
}
public void setLName(String lName){
this.lName = lName;
}
public void setDateJoin(LocalDate dateJoin){
  this.dateJoin = dateJoin;
}
public void setNoOfGuests(int noOfGuests){
  this.noOfGuests = noOfGuests + 1;

}
}

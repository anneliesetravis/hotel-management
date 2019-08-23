package hotel;
import java.time.LocalDate;

class VIPGuest extends Guest {
private LocalDate VIPstartDate;
private LocalDate VIPexpiryDate;
/*
The constructor for VIPGuest class (sets attributes)
param guestID:sets the guest ID, int
param fName: sets the Guest's first name, string
param lName: sets the Guest's last name, string
param dateJoin: sets the date that the guest registered with the hotel
*/
public VIPGuest(int guestID, String fName, String lName, LocalDate dateJoin, LocalDate VIPstartDate, LocalDate VIPexpiryDate){
  super(guestID, fName, lName, dateJoin);
  this.VIPstartDate = VIPstartDate;
  this.VIPexpiryDate = VIPexpiryDate;
}
public VIPGuest(String fName, String lName, LocalDate dateJoin, LocalDate VIPstartDate, LocalDate VIPexpiryDate){
  super(fName, lName, dateJoin);
  this.setGuestID(this.getNoOfGuests());
  this.VIPstartDate = VIPstartDate;
  this.VIPexpiryDate = VIPexpiryDate;
}
public String toString(){
  return super.toString() + "," + getVIPstartDate() + "," + getVIPexpiryDate();
}

//getter methods

public LocalDate getVIPstartDate(){
  return VIPstartDate;
}
public LocalDate getVIPexpiryDate(){
  return VIPexpiryDate;
}

}

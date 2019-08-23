package hotel;
import java.time.LocalDate;

class Booking {
private int id;
private static int numberOfBookings;
private int guestID;
private int roomNumber;
private LocalDate bookingDate;
private LocalDate checkinDate;
private LocalDate checkoutDate;
private float totalAmount;

public Booking(int guestID, int roomNumber, LocalDate bookingDate, LocalDate checkinDate, LocalDate checkoutDate, float totalAmount) {
  this.guestID = guestID;
  this.roomNumber = roomNumber;
  this.bookingDate = bookingDate;
  this.checkinDate = checkinDate;
  this.checkoutDate = checkoutDate;
  this.totalAmount = totalAmount;
  this.id = ++this.numberOfBookings;
}

public String toString(){
  return getGuestID() + "," + getRoomNumber() + "," + getBookingDate()
   + "," + getCheckinDate() + "," + getCheckoutDate() + "," + getTotalAmount();
}

//getter methods
public int getId(){
  return id;
}
public int getGuestID(){
  return guestID;
}
public int getRoomNumber(){
  return roomNumber;
}
public LocalDate getBookingDate(){
  return bookingDate;
}
public LocalDate getCheckinDate(){
  return checkinDate;
}
public LocalDate getCheckoutDate(){
  return checkoutDate;
}
public float getTotalAmount(){
  return totalAmount;
}
public static int getNumberOfBookings() {
  return numberOfBookings;
}

}

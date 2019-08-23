package hotel;
import java.time.LocalDate;

class Payment {
private LocalDate date;
private int guestID;
private float amount;
private String payReason;

public Payment(LocalDate date, int guestID, float amount, String payReason){
  this.date = date;
  this.guestID = guestID;
  this.amount = amount;
  this.payReason = payReason;
}

public String toString(){
  return getDate() + "," + getGuestID() + "," + getAmount() + "," + getPayReason();
}
//getter methods
public LocalDate getDate(){
  return date;
}
public int getGuestID(){
  return guestID;
}
public float getAmount(){
  return amount;
}
public String getPayReason(){
  return payReason;
}

}

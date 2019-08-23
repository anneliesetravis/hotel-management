package hotel;
class Room {
private int roomNumber;
private RoomType roomType;
private double price;
private int capacity;
private String facilities;



public Room(int roomNumber, RoomType roomType, double price, int capacity, String facilities){
  this.roomNumber = roomNumber;
  this.roomType = roomType;
  this.price = price;
  this.capacity = capacity;
  this.facilities = facilities;
}
public String toString(){
  return getRoomNumber() + "," + getRoomType() + "," + getPrice()
   + "," + getCapacity() + "," + getFacilities();
}

//getter methods
public int getRoomNumber(){
  return roomNumber;
}
public RoomType getRoomType(){
  return roomType;
}
public double getPrice(){
  return price;
}
public int getCapacity(){
  return capacity;
}
public String getFacilities(){
  return facilities;
}

}

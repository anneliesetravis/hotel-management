package hotel;
import java.io.*;
import java.util.*;
import java.time.*;
import java.lang.Integer;
public class HotelImpl implements Hotel { // means this class is an implementation of the Hotel interface


  private ArrayList<Guest> guests = new ArrayList<Guest>(); //Array to store all guest data
  private ArrayList<Room> rooms = new ArrayList<Room>(); //Array to store all room data
  private ArrayList<Booking> bookings = new ArrayList<Booking>(); // Array to store all booking data
  private ArrayList<Payment> payments = new ArrayList<Payment>(); //Array to store all payments data
  private static final int MIN_CANCEL = 2;
  private Scanner input = new Scanner(System.in);

  public ArrayList<String> textToArray(String path){
    //An array to store all data from the text file.
    try{
    ArrayList<String> array = new ArrayList<String>();
    BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
    String line = bufferedReader.readLine();
    while(line != null){
      array.add(line);
      line = bufferedReader.readLine();
    }
    bufferedReader.close();
    return array;
  } catch (FileNotFoundException ex) {
    System.out.print("File not found.");
    return null;
  } catch (IOException e){
    System.out.print("Invalid file.");
    return null;
  }
  }


  public HotelImpl(String roomsTxtFileName, String guestsTxtFileName,
  String bookingsTxtFileName, String paymentsTxtFileName){
    ArrayList<String> roomArray = textToArray(roomsTxtFileName);
    ArrayList<String> guestArray = textToArray(guestsTxtFileName);
    ArrayList<String> bookingArray = textToArray(bookingsTxtFileName);
    ArrayList<String> paymentArray = textToArray(paymentsTxtFileName);

    //for each line in the text file, split into variables to make objects
    //and add each object to the array
    for (String i : roomArray){
            String[] addingArray = i.split(",");
            rooms.add(
                new Room(
                  Integer.parseInt(addingArray[0]), RoomType.valueOf(addingArray[1].toUpperCase()), Float.parseFloat(addingArray[2]),
                  Integer.parseInt(addingArray[3]), addingArray[4]
                )
            );
        }
        for (String i : bookingArray){
          String[] addingArray = i.split(",");
          bookings.add(
            new Booking(
              Integer.parseInt(addingArray[0]), Integer.parseInt(addingArray[1]), LocalDate.parse(addingArray[2]),
              LocalDate.parse(addingArray[3]), LocalDate.parse(addingArray[4]), Float.parseFloat(addingArray[5])
            )
          );
        }
        for (String i : paymentArray){
          String[] addingArray = i.split(",");
          payments.add(
            new Payment(
              LocalDate.parse(addingArray[0]), Integer.parseInt(addingArray[1]), Float.parseFloat(addingArray[2]), addingArray[3]
            )
          );
        }
        for (String i : guestArray){
          String[] addingArray = i.split(",");
          if (addingArray.length == 4) {
            guests.add(
              new Guest(
                Integer.parseInt(addingArray[0]), addingArray[1], addingArray[2], LocalDate.parse(addingArray[3])
              )
            );
          }
          else {
            guests.add(
              new VIPGuest(
                Integer.parseInt(addingArray[0]), addingArray[1], addingArray[2],
                LocalDate.parse(addingArray[3]), LocalDate.parse(addingArray[4]),LocalDate.parse(addingArray[5])
              )
            );

          }
        }
  }

/**
   * Load all the room records from a text file
   *
   * @param  roomsTxtFileName  the text file for all room records
   * @return true if loading data successfully, otherwise false
   */
  public boolean importRoomsData(String roomsTxtFileName){

      ArrayList<String> RoomArray = textToArray(roomsTxtFileName);
      return true;

  }

  /**
   * Load all the guest records from a text file
   *
   * @param  guestsTxtFileName  the text file for all guest records
   * @return true if loading data successfully, otherwise false
   */
  public boolean importGuestsData(String guestsTxtFileName){

      ArrayList<String> guestArray = textToArray(guestsTxtFileName);
      return true;

  }

  /**
   * Load all the booking records from a text file
   *
   * @param  bookingsTxtFileName  the text file for all booking records
   * @return true if loading data successfully, otherwise false
   */
  public boolean importBookingsData(String bookingsTxtFileName){
    ArrayList<String> bookingArray = textToArray(bookingsTxtFileName);
      return true;

  }

  /**
   * Load all the payment records from a text file
   *
   * @param  paymentsTxtFileName  the text file for all payment records
   * @return true if loading data successfully, otherwise false
   */
  public boolean importPaymentsData(String paymentsTxtFileName){

      ArrayList<String> paymentArray = textToArray(paymentsTxtFileName);
      return true;

  }

  /**
   * Display all room information in the current hotel
   */
   public void displayAllRooms(){
 // ***
     System.out.println("All room information:");
     for (Room r: rooms){
       System.out.printf(
       "Room Number: %d%nRoom Type: %s%nPrice: %f%nCapacity: %d&nFacilities: %s",
       r.getRoomNumber(),r.getRoomType(), r.getPrice(), r.getCapacity(), r.getFacilities());
     }
   }
   /**
    * Display all guest information in the current hotel
    */
   public void displayAllGuests(){
     System.out.println("All guest information:");
     for (Guest g: guests){
       System.out.printf(
       "Guest ID: %d%nFirst Name: %s%nLast Name: %s%nDate Joined: %s",//*** the string format for date may need changing
       g.getGuestID(),g.getFName(), g.getLName(), g.getDateJoin());
     }
   }
   /**
    * Display all booking information in the current hotel
    */
   public void displayAllBookings(){
     System.out.println("All booking information:");
     for (Booking b: bookings){
       System.out.printf("Guest ID: %d%nRoom Number: %d%nDate Booked: %s%nCheckin Date: %s%nCheckout Date: %s%nTotal Amount: %f",
       b.getGuestID(),b.getRoomNumber(),b.getBookingDate(),b.getCheckinDate(),b.getCheckoutDate(),b.getTotalAmount());//!!!HOW TO ADD LOCALDATE FOR PRINTING LIKE THIS!!!
     }
   }
   /**
    * Display all payment information in the current hotel
    */
   public void displayAllPayments(){
     System.out.println("All payment information:");
     for (Payment p: payments){
       System.out.printf("Payment Date: %s%nGuest ID: %d%nAmount: %f%nPay Reason: %s",
       p.getDate(),p.getGuestID(),p.getAmount(),p.getPayReason());
     }
   }
  /**
  * Add one room to the hotel
  *
  * @param roomNumber   the room number
  * @param roomType     the room type
  * @param price        the room price (with no discount)
  * @param capacity     the maximal number of people to stay
  * @param facilities   the facilities of the room
  * @return             true if adding the room successfully, otherwise false
  */
  public boolean addRoom(int roomNumber, RoomType roomType, double price, int capacity, String facilities){
    new Room(roomNumber, roomType, price, capacity, facilities);
    return true;
  }

  /**
  * Remove one room from the hotel
  *
  * @param roomNumber   the room number
  * @return             true if removing the room successfully, otherwise false
  */
  public boolean removeRoom(int roomNumber){
    return true;

  }

  /**
  * Add one standard guest to the hotel
  *
  * @param fName    the first name of the guest
  * @param lName    the last name of the guest
  * @param dateJoin the date of registration
  * @return         true if adding the guest successfully, otherwise false
  */
  public boolean addGuest(String fName, String lName, LocalDate dateJoin){
    new Guest(fName, lName, dateJoin);

    return true;
  }

  /**
  * Add one VIP guest to the hotel
  *
  * @param fName        the first name of the guest
  * @param lName        the last name of the guest
  * @param dateJoin     the date of registration
  * @param VIPstartDate the start date of VIP membership
  * @param VIPexpiryDate the expiry date of VIP membership
  * @return             true if adding the guest successfully, otherwise false
  */
  public boolean addGuest(String fName, String lName, LocalDate dateJoin, LocalDate VIPstartDate, LocalDate VIPexpiryDate){
    new VIPGuest(fName, lName, dateJoin, VIPstartDate, VIPexpiryDate);

    return true;
  }

  /**
  * Remove one guest from the hotel
  *
  * @param guestID the guest unique ID
  * @return        true if removing the guest successfully, otherwise false
  */
  public boolean removeGuest(int guestID){
    return true;

  }

  /**
  * check for a room's availability
  *
  * @param roomNumber a unique room number
  * @param checkin    the check-in date
  * @param checkout   the check-out date
  * @return           true if the room is available for this period
  */
  public boolean isAvailable(int roomNumber, LocalDate checkin, LocalDate checkout){
    //get list of all bookings for that room number
    ArrayList<Booking> roomBookings = new ArrayList<Booking>();
    for (Booking i : bookings) {
      if (roomNumber == i.getRoomNumber()) {
        roomBookings.add(i);
      }
    }
    //check that there are no overlapping bookings
    for (Booking b : roomBookings){
      if ((checkin.isAfter(b.getCheckinDate()) || checkin.isEqual(b.getCheckinDate())) && checkin.isBefore(b.getCheckoutDate())) {
        return false;
      }
      else if (checkout.isAfter(b.getCheckinDate()) && (checkout.isBefore(b.getCheckoutDate()) || checkout.isEqual(b.getCheckoutDate()))) {
        return false;
      }
    }
    return true;
  }

  /**
  * Search for available rooms for one room type
  * @param roomType   a room type
  * @param checkin    the check-in date
  * @param checkout   the check-out date
  * @return           an array of available room numbers for this period
  */
  public int[] availableRooms(RoomType roomType, LocalDate checkin, LocalDate checkout){
    try{
     ArrayList<Room> possibleRooms = new ArrayList<Room>();
     for (Room i:  rooms){
       if(roomType == i.getRoomType()){
         possibleRooms.add(i);
       }
     }

     for (Room i: possibleRooms){
       if (isAvailable(i.getRoomNumber(), checkin, checkout) == false){
         possibleRooms.remove(i);
       }
     }
     return rooms;
   } catch (Exception e){
     System.out.println("Problem processing your data");
   }


  }

  /**
  * Make a booking for one room type.
  * If more than one room avaible, choose one room randomly to book
  *
  * @param guestID    a unique guest ID
  * @param roomType   a room type
  * @param checkin    the check-in date
  * @param checkout   the check-out date
  * @return           the booked room number if the booking is successful,
  *                   otherwise, return -1
  */
  public int bookOneRoom(int guestID, RoomType roomType, LocalDate checkin, LocalDate checkout){
    try{
     int[] roomChoices = availableRooms(roomType, checkin, checkout);
     int n;
     if (roomChoices.length == 0){
       System.out.println("No available rooms");
     } else if (roomChoices.length == 1){
       n = 0;
     }else{
       Random rd = new Random();
       int n = rd.newInt(roomChoices.length);
     }
     int roomBooked = roomChoices[n];
     //assign roomBooked to guestID ***
     System.out.println("Room booked");
     return roomBooked;
   } catch (Exception e){
     return -1;
   }

  }

  /**
  * Check out by offering a unique booking ID.
  *
  * @param bookingID a unique booking ID
  * @param actualCheckoutDate the actual check-out date
  * @return          true if the check-out is successful, otherwise false.
  */
  public boolean checkOut(int bookingID, LocalDate actualCheckoutDate){
    return true;
  }

  /**
  * Cancel a booking by offering a unique booking ID.
  *
  * @param bookingID a unique booking ID
  * @return          true if the cancellation is successful, otherwise false.
  */
  public boolean cancelBooking(int bookingID){
    return true;
  }

  /**
  * Search for a guest
  *
  * @param firstName the guest first name
  * @param lastName  the guest last name
  * @return          an array of guest IDs who match the name
  */
  public int [] searchGuest(String firstName, String lastName){
    try{
      if(firstName.equals("") || lastName.equals("")){
        System.out.println("Both first and last name required");
        return;
      }catch (Exception e){
        System.out.println("Problem processing your data");
        return;
      }
    }
//put first name and surname together as fullname?
//search through guests that way?
    ArrayList<String> guestList = new ArrayList<Guest>();
    if (guestList.size() == 0){
      System.out.println("No guests found");
    }else{

      for(String g : guestList){

      }
    }

//***

  }



  /**
  * Print out a guest's booking information (if any)
  * by given the unique guest ID.
  *
  * @param guestID a unique guest ID
  *
  */
  public void displayGuestBooking(int guestID){

  }

  /**
   * Display on the screen all the booking information by given a date
   * The output contains booking ID, the guest name, the room number,
   * the room type, the room price, the payment price (if the guest is
   * a VIP, the payment price is different from the room price, otherwise,
   * it equals the room price)
   *
   * @param  thisDate  a given date
   */
  public void displayBookingsOn(LocalDate thisDate){

  }

 /**
  * Display on the screen all the payments on a given date.
  * This is to check how much income on a specific day.
  * The output contains the guest ID, the payment amount,
  * the payment reason (booking, VIPmembership or refund).
  * If it is due to cancelling, the payment amount refers to the
  * refund amount – a negative value.
  *
  * @param  thisDate  a given date
  */
 public void displayPaymentsOn(LocalDate thisDate){

 }

  /**
   * Save all the room records in a text file
   *
   * @param  roomsTxtFileName  the text file for all room records
   * @return true if saving data successfully, otherwise false
   */
  public boolean saveRoomsData(String roomsTxtFileName){
    BufferedWriter writer;
    try{
      writer = new BufferedWriter(new FileWriter(roomsTxtFileName));
    } catch (IOException e){
      System.out.print("Invalid file.");
      return false;
    }
      try{
            for (Room r : rooms){
              writer.write(
                    r.toString()
            writer.newLine();
            }
          writer.close();
            return true;
          } catch (FileNotFoundException ex) {
            System.out.print("File not found.");
            return false;
          } catch (IOException e){
            System.out.print("Invalid file.");
            return false;
          }

  }

  /**
   * Save all the guest records in a text file
   *
   * @param  guestsTxtFileName  the text file for all guest records
   * @return true if saving data successfully, otherwise false
   */
  public boolean saveGuestsData(String guestsTxtFileName){
    BufferedWriter writer;
    try{
      writer = new BufferedWriter(new FileWriter(guestsTxtFileName));
    } catch (IOException e){
      System.out.print("Invalid file.");
      return false;
    }
      try{
            for (Guest g : guests){
              writer.write(g.toString());
              writer.newLine();
            }
          writer.close();
          return true;
          } catch (FileNotFoundException ex) {
            System.out.print("File not found.");
            return false;
          } catch (IOException e){
            System.out.print("Invalid file.");
            return false;
          }

  }

  /**
   * Save all the booking records in a text file
   *
   * @param  bookingsTxtFileName  the text file for all booking records
   * @return true if saving data successfully, otherwise false
   */
  public boolean saveBookingsData(String bookingsTxtFileName){
    BufferedWriter writer;
    try{
      writer = new BufferedWriter(new FileWriter(bookingsTxtFileName));
    } catch (IOException e){
      System.out.print("Invalid file.");
      return false;
    }
      try{
            for (Booking b : bookings){
              writer.write(b.toString());
              writer.newLine();
            }
          writer.close();
          return true;
          } catch (FileNotFoundException ex) {
            System.out.print("File not found.");
            return false;
          } catch (IOException e){
            System.out.print("Invalid file.");
            return false;
          }
  }

  /**
   * Save all the payment records in a text file
   *
   * @param  paymentsTxtFileName  the text file for all payment records
   * @return true if saving data successfully, otherwise false
   */
  public boolean savePaymentsData(String paymentsTxtFileName){
    BufferedWriter writer;
    try{
      writer = new BufferedWriter(new FileWriter(paymentsTxtFileName));
    } catch (IOException e){
      System.out.print("Invalid file.");
      return false;
    }
      try{
            for (Payment p: payments){
              writer.write(p.toString());
              writer.newLine();
            }
          writer.close();
          return true;
          } catch (FileNotFoundException ex) {
            System.out.print("File not found.");
            return false;
          } catch (IOException e){
            System.out.print("Invalid file.");
            return false;
  }

/*
* You may add any other necessary methods here.
*/
}

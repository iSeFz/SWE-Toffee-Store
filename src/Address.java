import java.util.Scanner;

/**
 * The `Address` class defines a set of instance variables and methods to represent and manipulate an
 * address.
 */
public class Address {
    // `private String governorate;` is declaring a private instance variable named `governorate` of
    // type `String` in the `Address` class. This variable will hold the name of the governorate in an
    // address.
    private String governorate;
    // `private String district;` is declaring a private instance variable named `district` of type
    // `String` in the `Address` class. This variable will hold the name of the district in an address.
    private String district;
    // `private String street;` is declaring a private instance variable named `street` of type
    // `String` in the `Address` class. This variable will hold the name of the street in an address.
    private String street;
    // `private int buildingNumber;` is declaring a private instance variable named `buildingNumber` of
    // type `int` in the `Address` class. This variable will hold the number of the building in an
    // address.
    private int buildingNumber;
    // `private int floorNumber;` is declaring a private instance variable named `floorNumber` of type
    // `int` in the `Address` class. This variable will hold the number of the floor in an address.
    private int floorNumber;
    // `private int flatNumber;` is declaring a private instance variable named `flatNumber` of type
    // `int` in the `Address` class. This variable will hold the number of the flat in an address.
    private int flatNumber;
    // `private String landmark;` is declaring a private instance variable named `landmark` of type
    // `String` in the `Address` class. This variable will hold the name of a landmark in an address,
    // which is a recognizable feature or location near the address that can be used as a reference
    // point.
    private String landmark;

// This is a constructor method for the `Address` class that initializes all the instance variables to
// their default values. It sets the `governorate`, `district`, `street`, and `landmark` variables to
// empty strings, and the `buildingNumber`, `floorNumber`, and `flatNumber` variables to 0.
    public Address(){
        this.governorate = "";
        this.district = "";
        this.street = "";
        this.buildingNumber = 0;
        this.floorNumber = 0;
        this.flatNumber = 0;
        this.landmark = "";
    }

// This is a constructor method for the `Address` class that takes in seven parameters: `governorate`,
// `district`, `street`, `buildingNumber`, `floorNumber`, `flatNumber`, and `landmark`. It initializes
// the instance variables of the `Address` object to the values passed in as arguments. The `this`
// keyword is used to refer to the instance variables of the object being created.
    public Address(String governorate, String district, String street, int buildingNumber, int floorNumber, int flatNumber, String landmark){
        this.governorate = governorate;
        this.district = district;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.floorNumber = floorNumber;
        this.flatNumber = flatNumber;
        this.landmark = landmark;
    }

   /**
    * This Java function prompts the user to input their address information and stores it in
    * corresponding variables.
    */
    public void fillAddress(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your governorate: ");
        this.governorate = sc.nextLine();
        System.out.print("Enter your district: ");
        this.district = sc.nextLine();
        System.out.print("Enter your street: ");
        this.street = sc.nextLine();
        System.out.print("Enter your landmark: ");
        this.landmark = sc.nextLine();
        System.out.print("Enter your building number: ");
        this.buildingNumber = sc.nextInt();
        System.out.print("Enter your floor number: ");
        this.floorNumber = sc.nextInt();
        System.out.print("Enter your flat number: ");
        this.flatNumber = sc.nextInt();
    }
}

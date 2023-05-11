import java.util.Scanner;

public class Address {
    private String governorate;
    private String district;
    private String street;
    private int buildingNumber;
    private int floorNumber;
    private int flatNumber;
    private String landmark;

    public Address(String governorate, String district, String street, int buildingNumber, int floorNumber, int flatNumber, String landmark){
        this.governorate = governorate;
        this.district = district;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.floorNumber = floorNumber;
        this.flatNumber = flatNumber;
        this.landmark = landmark;
    }

    public void fillAddress(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your governorate: ");
        this.governorate = sc.nextLine();
        System.out.println("Enter your district: ");
        this.district = sc.nextLine();
        System.out.println("Enter your street: ");
        this.street = sc.nextLine();
        System.out.println("Enter your building number: ");
        this.buildingNumber = sc.nextInt();
        System.out.println("Enter your floor number: ");
        this.floorNumber = sc.nextInt();
        System.out.println("Enter your flat number: ");
        this.flatNumber = sc.nextInt();
        System.out.println("Enter your landmark: ");
        this.landmark = sc.nextLine();
        sc.close();
    }
}

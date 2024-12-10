public class Patient {
    private int id ;
    private String name ;
    private int birthyear ;
    private double height ;
    private double weight ;
    private String bloodGroup ;
    private String phoneNumber ;
    public Patient(int id ,String name, int birthyear, String bloodGroup, double height, double weight, String phoneNumber) {
        this.id = id ;
        this.name = name ;
        this.birthyear = birthyear ;
        if(height > 0 && height < 250) {
            this.height = height ;
        }
        else {
            this.height = Math.abs(height) ;
        }
        if(weight > 0) {
            this.weight = weight ;
        }
        else {
            this.weight = Math.abs(weight) ;
        }
        this.bloodGroup = bloodGroup ;
        this.phoneNumber = phoneNumber ;
    }
    public void displayDetails(int currentYear) { 
        System.out.println("Patient Id: " + id);
        System.out.println("Patient Name: " + name); 
        System.out.println("Patient Age: " + getAge(currentYear));
        System.out.println("Patient BloodGroup: " + bloodGroup);
        System.out.println("Patient Height (cm): " + height);
        System.out.println("Patient Weight (kg): " + weight);
        System.out.println(String.format("Patient BMI: %.2f", getBMI(height,weight)));
        System.out.println("Patient PhoneNumber: " + phoneNumber);
    }
    public int getAge(int currentYear){
        if (birthyear > 0 && birthyear < currentYear){
            return currentYear - birthyear ;
        }
        else {
            this.birthyear = Math.abs(birthyear) ;
            return currentYear - birthyear ;
        }
    }
    public double getBMI(double height , double weight){
        double heightM = height/100 ;
        return (weight / Math.pow(heightM , 2)) ;
    }
    public String getBloodGroup() {
        return bloodGroup;
    }
    
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("\\d{10}")) { // ตรวจสอบว่าเบอร์โทรศัพท์มีความยาว 10 ตัวเลข
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Invalid phone number! Phone number should contain 10 digits.");
        }
    }
    public static void main(String[] args) {
        int currentYear = 2024; 
        Patient patient = new Patient(1001, "John Doe", 1978, "O-" , 175.5, 78.0, "5644875498");
        patient.displayDetails(currentYear);
        Patient invalidPatient = new Patient(1002, "Joe Dohn", 1990, "AB" , -160.0, -65.0, "1234857849");
        invalidPatient.displayDetails(currentYear);
        System.out.println("\nUpdating patient details...");
        patient.setBloodGroup("A+");
        patient.setPhoneNumber("9876543210");
        patient.displayDetails(currentYear);
    }
}

import java.util.*;

class Practical_4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Enter your choice :");
            System.out.println("1.Int to Byte\n2.Int to Short\n3.Int to Any of them");
            int ch=sc.nextInt();
            int num;
            switch (ch) {
                case 1:
                    System.out.println("Enter the number to convert into byte");
                    num=sc.nextInt();
                    System.out.println(getByte(num));
                    break;
                case 2:
                    System.out.println("Enter the number to convert into short");
                    num=sc.nextInt();
                    System.out.println(getShort(num));
                    break;
                case 3:
                    System.out.println("Enter the number to convert :");
                    num=sc.nextInt();
                    String res;
                    System.out.println("Enter the string type value:");
                    res=sc.nextLine();
                    System.out.println(getNumber(num, res));
                    break;
                default:
                    System.out.println("Invalid case...");
                    break;
            }
        }
    }
    static int getByte(int num){
        int res=num%256;
        if (res < -128) {
            return res + 256;
        } 
        else if (res > 127) {
            return res - 256;
        } 
        else {
            return res;
        }
    }
    static int getShort(int num){
        int res=num%65536;
        if(res<-32768){
            return res+65536;
        }
        else if(res>32767){
            return res-65536;
        }
        else{
            return res;
        }
    }
    static int getNumber(int num,String type){
        if(type.toLowerCase().equals("byte")){
            return getByte(num);
        }
        else if(type.toLowerCase().equals("short")){
            return getShort(num);
        }
        else{
            System.out.println("The invalid type is provided");
            return 0;
        }
    }



    static String toXXSystem(String num,String xx){
        if(num.startsWith("0b")){
            binToDec();
        }
        else if(num.startsWith("0x")){
            hexToDec();
        }
        else if(num.startsWith("00")){
            if(num.charAt(2)!='0'){
                octToDec();
            }
        }
        else{
            //call here the whichever method you want to call for decimal according to the type specified by the user
        }
        return "";
    }

    //Same logic for all the decimal to other system conversions...
    //create the empty string
    //temp variable to store decimal value

    public static String decToBin(int dec) {
        String binary = "";
        int temp = dec;
    
        while (temp > 0) {
            int remainder = temp % 2;
            binary = remainder + binary;
            temp /= 2;
        }
        return binary.isEmpty() ? "0" : binary;
    }

    public static String decToOct(int dec) {
        String octal = "";
        int temp = dec;
    
        while (temp > 0) {
            int remainder = temp % 8;
            octal = remainder + octal;
            temp /= 8;
        }
        return octal.isEmpty() ? "0" : octal;   //used the ternary operator for simplicity
    }

    public static String decToHex(int dec) {
        String hex = "";
        int temp = dec;
        
        //for simplicity used the hashmap to store the keys and map their corresponding values

        HashMap<Integer, Character> hexM = new HashMap<>();

        hexM.put(10, 'A');
        hexM.put(11, 'B');
        hexM.put(12, 'C');
        hexM.put(13, 'D');
        hexM.put(14, 'E');
        hexM.put(15, 'F');

        while (temp > 0) {
            int remainder = temp % 16;
            if (remainder >= 10) {
                hex = hexM.get(remainder) + hex;
            } else {
                hex = remainder + hex;
            }
            temp /= 16;
        }
        return hex.isEmpty() ? "0" : hex;
    }
    
// ===========================================================================

    //functions for the three systems to the decimal conversions...

    public static int octToDec(String octal) {
        int decimal = 0;
        int base = 8;

        for (int i = 0; i < octal.length(); i++) {
            char currentChar = octal.charAt(i);
            int digit = currentChar - '0';
            decimal = decimal * base + digit;
        }

        return decimal;
    }


    public static int hexToDec(String hex) {
        int decimal = 0;
        int base = 16;

        for (int i = 0; i < hex.length(); i++) {
            char currentChar = hex.charAt(i);
            int value;

            if (Character.isDigit(currentChar)) {
                value = currentChar - '0';
            } else {
                value = Character.toUpperCase(currentChar) - 'A' + 10;
            }

            decimal = decimal * base + value;
        }

        return decimal;
    }


    public static int binToDec(String binary) {
        int decimal = 0;
        int base = 2;

        for (int i = 0; i < binary.length(); i++) {
            char currentChar = binary.charAt(i);
            int digit = currentChar - '0';
            decimal = decimal * base + digit;
        }

        return decimal;
    }

}

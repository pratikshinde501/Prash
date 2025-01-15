import java.util.*;
class Practical_4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(hexToDec("AAAA"));
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
                    System.out.println(getNumber(num,res));
                    break;
                default:
                    System.out.println("Invalid case...");
                    break;
            }
        }
    }

//1) first function for integer to byte value

    static int getByte(int num){
        int res=num%256;
        if (res<-128) {
            return res+256;
        } 
        else if (res>127) {
            return res-256;
        } 
        else {
            return res;
        }
    }

//2) second function for integer to short value

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

//3) third function for integer to byte or short value

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

//4) fourth function for any system to any system value

    static String toXXSystem(String num,String xx){
        if(num.startsWith("0b")){
            binToDec("01110");
        }
        else if(num.startsWith("0x")){
            hexToDec("ABA12");
        }
        else if(num.startsWith("00")){
            if(num.charAt(2)!='0'){
                octToDec("891");
            }
        }
        else{
        }
        return "";
    }

    //decimal to binary
    
    static String decToBin(int dec) {
        String binary="";
        int temp=dec;
        while (temp>0) {
            int remainder=temp%2;
            binary=remainder+binary;
            temp=temp/2;
        }
        return binary;
    }

    //decimal to octal

    static String decToOct(int dec) {
        String octal="";
        int temp=dec;
        while (temp>0) {
            int remainder=temp%8;
            octal=remainder+octal;
            temp=temp/8;
        }
        return octal;
    }

    //decimal to hexa

    static String decToHex(int dec) {
        String hex="";
        int temp=dec;
        HashMap<Integer,Character> hexM=new HashMap<>();
        hexM.put(10,'A');
        hexM.put(11,'B');
        hexM.put(12,'C');
        hexM.put(13,'D');
        hexM.put(14,'E');
        hexM.put(15,'F');
        while (temp>0) {
            int remainder=temp%16;
            if (remainder>=10) {
                hex=hexM.get(remainder)+hex;
            } 
            else {
                hex=remainder+hex;
            }
            temp=temp/16;
        }
        return hex;
    }
    
    //octal to decimal
    
    static int octalToDecimal(String octal){
        int octalans=0;
        int power=0;
        for(int i=octal.length()-1;i>=0;i--){
            int digit=octal.charAt(i)-'0';
            int anspower=(int)Math.pow(8, power);
            int answer=digit*anspower;
            octalans=octalans+answer;
            power++;
        }
        return octalans;
    }

    //hexa to decimal

    static int hexToDecimal(String hex1){
        int hex=0;
        int power=0;
        HashMap<Character,Integer> h=new HashMap<>();
        h.put('A', 10);
        h.put('B', 11);
        h.put('C', 12);
        h.put('D', 13);
        h.put('E', 14);
        h.put('F', 15);
        for(int i=hex1.length()-1;i>=0;i--){
        int digit;
            if(hex1.charAt(i)<'9'&&hex1.charAt(i)>'0'){
                digit=hex1.charAt(i)-'0';
            }
            else{
                digit=h.get(hex1.charAt(i));
            }
            int ans=(int)Math.pow(16,power);
            int answer=digit*ans;
            hex=hex+answer;
            power++;
        }
        return hex;
    }

    //binary to decimal

    static int binToDec(String bin) {
        int decimal=0;
        int power=0;
        for (int i=bin.length()-1;i>=0;i--) {
            int digit=bin.charAt(i)-'0';   
            int ans=Math.pow(2,power);
            int value=digit*ans;
            decimal=decimal+value;
            power++;
        }
        return decimal;
    }
}

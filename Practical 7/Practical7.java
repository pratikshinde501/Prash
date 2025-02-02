public class Practical7 {     
    public String printName(int size) throws InterruptedException {         
        int inc = size;         
        int inc1 = 2;         
        int inc2 = 5 + size-2;      
        String prash="";       

        // p
        for (int i = 1; i <= (7 + size); i++) {             
            for (int j = 1; j <= (5 + size); j++) {                 
                if (j == 1 || i == 1 || i == ((7 + size) / 2) || (j == (5 + size) && i <= ((7 + size) / 2))) {                     
                    prash+="*";            
                } else {                     
                    prash+=" ";                  
                }             
            }             
            prash+=" ";           

            //r
            for (int j = 1; j <= (5 + size); j++) {                 
                if (i == 1 || j == 1 || i == ((7 + size) / 2) || (j == (5 + size) && i <= ((7 + size) / 2))) {                     
                    prash+="*";                  
                } else if (i > ((7 + size) / 2) && j == inc) {                     
                    prash+="*";                 
                } else {                     
                    prash+=" ";                  
                }             
            }             
            if (i >= ((7 + size) / 2)) {                 
                inc++;             
            }             
            prash+=" ";             


        //     //a
            for (int j = 1; j <= (5 + size); j++) {                 
                if (j == 1 || i == 1 || i == ((7 + size) / 2) || j == (5 + size)) {                     
                    prash+="*";                  
                } else {                     
                    prash+=" ";                 
                }             
            }             
            prash+=" ";              


        //     //t
            for (int j = 1; j <= (5 + size); j++) {                 
                if (i == 1) {                     
                    prash+="*";                  
                } else if (j == ((size + 5) / 2+((size+5)%2))) {                     
                    prash+="*";                  
                } else {                     
                    prash+=" ";                  
                }             
            }             
            prash+=" ";               


        //     //i
            for (int j = 1; j <= (5 + size); j++) {                 
                if (i == 1 || i == (size + 7)) {                     
                    prash+="*";                  
                } else if (j == ((size + 5) / 2 +((size+5)%2))) {                     
                    prash+="*";                  
                } else {                     
                    prash+=" ";                  
                }             
            }             
            prash+=" ";               


            //k
            for (int j = 1; j <= (size + 5); j++) {                 
                if (j == 1) {                     
                    prash+="*";                 
                } else {                     
                    prash+=" ";                  
                }                 
                if (i > ((7 + size) / 2+((size+7)%2)) && j == inc1) {                     
                    prash+="*";                  
                }                 
                if (i <= ((7 + size)/2 + ((size+7)%2)) && j == inc2) {                     
                    prash+="*";                  
                }             
            }             
            if (i > ((7 + size) / 2)+((size+7)%2)) {                 
                inc1++; 
            }
            if (i <= ((7 + size) / 2)) {                 
                inc2--;             
            }              

            prash+="\n";               
            //printing each line string 
            System.out.println(prash);
            //to pause the execution by sec
            Thread.sleep(1000);         
        }     
        return prash;
    }      

    public static void main(String[] args) throws InterruptedException {         
        Practical7 p = new Practical7();         
        System.out.println();         
        System.out.println(p.printName(1));     
    } 
}

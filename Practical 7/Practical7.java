public class Practical7 {
    public String printName(int size){
        String ans="";
        int inc=size;
        int inc1 = size;
        int inc2 = 5*size;
        if(size!=1){
            inc1=size-2;
            inc2=(5*size)-size;
        }
        int prash=size%2==0?0:1;
        for(int i=1;i<=7*size;i++){

            //Code for P
            for(int j=1;j<=5*size;j++){
                if(j==1||i==1||i==7*size/2||(j==5*size&&i<=7*size/2)){
                    ans+="*";
                }
                else{
                    ans+=" ";
                }
            }
            ans+=" ";

            //code for R
            for (int j = 1; j <= 5 * size; j++) {
                if (i == 1 || j == 1 || i == 7 * size / 2 || (j == 5 * size && i <= 7 * size / 2)) {
                    ans += "*";
                } else if (i > 7 * size / 2 && j == inc) {
                    ans += "*"; 
                } else {
                    ans += " ";
                }
            }
            if (i >= (7 * size) / 2) {
                inc++;
            }
            ans+=" ";

            //code for A
                for(int j=1;j<=5*size;j++){
                    if(j==1||i==1||i==7*size/2||j==5*size){
                        ans+="*";
                    }
                    else{
                        ans+=" ";
                    }
                }
                ans+=" ";


                //code for T
                for(int j=1;j<=5*size;j++){
                    if(i==1){
                        ans+="*";
                    }else if(j==(size*5)/2+prash){
                        ans+="*";
                    }else{
                        ans+=" ";
                    }
                }
                ans+=" ";


                //code for I
                for(int j=1;j<=5*size;j++){
                    if(i==1||i==size*7){
                        ans+="*";
                    }else if(j==(size*5)/2+prash){
                        ans+="*";
                    }else{
                        ans+=" ";
                    }
                }
                ans+=" ";


                //code for K
                for (int j = 1; j <= size * 5; j++) {
                    if (j == 1) {
                        ans+="*";
                    } else {
                        ans+=" ";
                    }
                    if (i > 7 * size / 2 && j == inc1) {
                        ans+="*";
                    }
                    if (i <= 7 * size / 2 && j == inc2) {
                        ans+="*";
                    }
                }
                if (i >= (7 * size) / 2) {
                        inc1++;
                }
                if (i <= (7 * size) / 2) {
                    inc2--;
            }
            ans+="\n";
    }
    return ans;
}
    public static void main(String[] args) {
        Practical7 p=new Practical7();
        System.out.println(p.printName(2));
    }
}

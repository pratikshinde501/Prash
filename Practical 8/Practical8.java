class Practical8{
    void printPattern2(int size,int start){
        if(start>size+1){
            return;
        }
        for(int space=size-start;space>=0;space--){
            System.out.print(" ");
        }
        for(int i=1;i<=start;i++){
            if(start!=4){
            System.out.print("*");
            }else{
                System.out.print("+");
            }
        }
        System.out.println();
        printPattern2(size,start+1);
        for(int space=size-start+1;space>=0;space--){
            System.out.print(" ");
        }
        for(int i=1;i<start;i++){
            System.out.print("/");
        }
        System.out.println();
    }
    void printPattern1(int size,int start){
        if(start>size+1){
            return;
        }
        for(int i=1;i<=start;i++){
            System.out.print("*");
        }
        System.out.println();
        printPattern1(size,start+1);
        for(int i=1;i<start;i++){
            System.out.print("*");
        }
        System.out.println();
    }
    void printPattern3(int size,int start){
        if(start>=size*2){
            return;
        }
        int res;
        if((start>size)){
            res=size*2-start; 
        }else{
            res=start;
        }
        for(int space=1;space<=size-res;space++){
            System.out.print(" ");
        }
        for(int star=1;star<res*2;star++){
            System.out.print("*");
        }
        System.out.println();
        printPattern3(size, start+1);
        for(int i=1;i<=size;i++){
            if(i==size)
            System.out.print("+");
            else{
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Practical8 p1=new Practical8();
        
        p1.printPattern1(3,1);
        p1.printPattern2(3,1);
        p1.printPattern3(3, 1);
    }
}

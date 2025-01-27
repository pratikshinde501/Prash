public class Pattern1 {
    void pattern1(int size){
        for(int i=1;i<=size;i++){
            for(int space=size-i;space>0;space--){
                System.out.print("  ");
            }
            for(int plus=1;plus<i*2;plus++){
                System.out.print("+ ");
            }
            System.out.println();
        }
        for(int i=size-1;i>0;i--){
            for(int space=size-i;space>0;space--){
                System.out.print("  ");
            }
            for(int plus=1;plus<i*2;plus++){
                System.out.print("+ ");
            }
            System.out.println();
        }
       
    }
    
    void pattern2(int size){
        for(int ln=1;ln<=size;ln++){
            for(int spaces=1;spaces<=size-ln;spaces++){
                System.out.print("  ");
            }
            for(int symbol=1;symbol<2*ln;symbol++){
                if((ln+symbol)%2==0){
                    System.out.print("* ");
                }else{
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
        for(int ln=3;ln>0;ln--){
            for(int spaces=size-ln;spaces>0;spaces--){
                System.out.print("  ");
            }
            for(int symbol=2*ln-1;symbol>0;symbol--){
                if((symbol+ln)%2!=0){
                    System.out.print("* ");
                }
                else{
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
    }

    void pattern3(int size){
        for(int i=1;i<size * 2;i++){
                int currentRow=0;
                if(i<=size){
                    currentRow=i;
                }else{
                    currentRow=size*2-i;
                }
                for(int space=1;space<size-currentRow+1;space++){
                    System.out.print("  ");
                }
                for(int plus=1;plus<=currentRow*2-1;plus++){
                    if(plus%2!=0&&i<=size){
                        System.out.print("+ ");
                    }
                    else if(plus%2==0){
                        System.out.print("  ");
                    }else{
                        System.out.print("* ");
                    }
                    
                }
                System.out.println();
            }
    }

    public static void main(String[] args) {
        Practical6 p=new Practical6();
        p.pattern1(3);
        p.pattern2(3);
        p.pattern3(3);
    }
}









//practice codes that didnt work

// static void pattern2(int size){
    //     int currentRow=0,count=0;
    //     for(int i=1;i<=size * 2;i++){
    //         if(currentRow==3&&count==0){
    //             count=1;
    //         }
    //         else if(i<=size){
    //             currentRow=i;
    //         }
    //         else{
    //             currentRow=size*2-i;
    //         }
    //         for(int space=1;space<size-currentRow+1;space++){
    //             System.out.print("  ");
    //         }
    //         for(int plus=1;plus<=currentRow*2-1;plus++){
    //             if((plus+i)%2==0){
    //                 System.out.print("* ");
    //             }else{
    //                 System.out.print("+ ");
    //             }
    //         }
    //         System.out.println();
    //         if(currentRow==3&&count==1){
    //             i=i-1;
    //         }
    //     }
    // }

public class Practical7 {
    public void printP(int size){
        for(int i=1;i<=7*size;i++){
            for(int j=1;j<=5*size;j++){
                if(j==1||i==1||i==7*size/2||(j==5*size&&i<=7*size/2)){
                    System.out.print(" * ");
                }
                else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
    public void printA(int size){
        for(int i=1;i<=7*size;i++){
            for(int j=1;j<=5*size;j++){
                if(j==1||i==1||i==7*size/2||j==5*size){
                    System.out.print(" * ");
                }
                else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
    public void printI(int size){
        for(int i=1;i<=7*size;i++){
            for(int j=1;j<=5*size;j++){
                if(i==1||i==size*7){
                    System.out.print(" * ");
                }else if(j==(size*5)/2){
                    System.out.print(" * ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
    public void printT(int size){
        for(int i=1;i<=7*size;i++){
            for(int j=1;j<=5*size;j++){
                if(i==1){
                    System.out.print(" * ");
                }else if(j==(size*5)/2){
                    System.out.print(" * ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
    static void printR(int size){
		int inc = 5*size-2;
		for(int i=1;i<=7*size;i++){
			for(int j=1;j<=5*size;j++){
				if(i==1 || j==1 || i==7*size/2 || (j==5*size && i<=7*size/2)){
					System.out.print(" * ");
					}
				else{
					System.out.print("   ");
					}
					if(i>7*size/2 && (i+j)==inc){
					    System.out.print(" * ");
					}
				}
				if(i>=7*size/2){
                    inc+=2;
					  }
				System.out.println("");
			}
		}

    
        public void printK(int size) {
            int inc = size * 5 - 2;
            int inc2 = size * 5 - 2;
            for (int i = 1; i <= size * 7; i++) {
                for (int j = 1; j <= size * 5; j++) {
                    if (j == 1) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                    if (i >= size * 7 / 2 && (i + j - 2) == inc) {
                        System.out.print("* ");
                    }
                    if (i < size * 7 / 2 && (j - i - 1) == inc2) {
                        System.out.print("* ");
                    }
                }
                if (i >= size * 7 / 2) {
                    inc += 2;
                }
                if (i < size * 7 / 2) {
                    inc2 -= 2;
                }
                System.out.println();
            }
        }
    public static void main(String[] args) {
        Practical7 p=new Practical7();
        p.printP(2);
        p.printR(2);
        p.printA(2);
        p.printT(2);
        p.printI(2);
        p.printK(2);
    }
}

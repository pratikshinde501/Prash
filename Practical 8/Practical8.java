class Practical_8 {
    void printPattern2(int size, int start) {
        if (start > size + 1) {
            return;
        }
        printSpaces(size - start, 0);
        printStarsOrPlus(start, 1, false);
        System.out.println();
        printPattern2(size, start + 1);
        printSpaces(size - start + 1, 0);
        printSlashes(start - 1, 1);
        System.out.println();
    }

    void printPattern1(int size, int start) {
        if (start > size + 1) {
            return;
        }
        printStars(start, 1);
        System.out.println();
        printPattern1(size, start + 1);
        printStars(start - 1, 1);
        System.out.println();
    }

    void printPattern3(int size, int start) {
        if (start >= size * 2) {
            return;
        }
        int res;
        if(start>size){
            res=size*2-start;
        }
        else{
            res=start;
        }
        printSpaces(size - res, 1);
        printStars(res * 2 - 1, 1);
        System.out.println();
        printPattern3(size, start + 1);
        printSpaces(size - 1, 1);
        System.out.print("+");
        System.out.println();
    }

    void printSpaces(int count, int current) {
        if (current > count) {
            return;
        }
        System.out.print(" ");
        printSpaces(count, current + 1);
    }

    void printStars(int count, int current) {
        if (current > count) {
            return;
        }
        System.out.print("*");
        printStars(count, current + 1);
    }

    void printStarsOrPlus(int count, int current, boolean isPlus) {
        if (current > count) {
            return;
        }
        if(isPlus){
            System.out.print("+");
        }
        else{
            System.out.print("*");
        }
        printStarsOrPlus(count, current + 1, isPlus);
    }

    void printSlashes(int count, int current) {
        if (current > count) {
            return;
        }
        System.out.print("/");
        printSlashes(count, current + 1);
    }

    public static void main(String[] args) {
        Practical_8 p1 = new Practical_8();
        p1.printPattern1(3, 1);
        p1.printPattern2(3, 1);
        p1.printPattern3(3, 1);
    }
}

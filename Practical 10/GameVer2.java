import java.util.Arrays;
import java.util.Scanner;
public class GameVer2{
	static String[][] layout; 
	static String[][] ansLayout;
	static String[][] ans; 
	static int len;
	static int size;
	static int blankCount;
  static String[][] gridGenerator(int size){
    String s = Integer.toString(size);
    int len = s.length();
 
    layout = new String[2*size+1][2*size+1];
    ans = new String[2*size+1][2*size+1];
    ansLayout = new String[2*size+1][2*size+1];
    for(int i=0;i<layout.length;i++){
      Arrays.fill(layout[i],"0");
    }
    String s1= "_".repeat(len);
    String s2= " ".repeat(len);
    for(int i=0;i<2*size+1;i++){
 	    for(int j=0;j<2*size+1;j++){
 		    if(i%2==0){
 			    if(j%2==0){
 				    layout[i][j]=".";
 			    }
 			    else{
 				    layout[i][j]=s1;
 			    }
 		    }
 		  else{
 		  	if(j%2==0){
 		  		layout[i][j]="|";
 		  	}
 		  	else{
 		  		layout[i][j]=s2;
 		  	}
 		  }
 	  }
  }
 gridFiller(layout,size);
 for(int i=0;i<2*size+1;i++){
 	  for(int j=0;j<2*size+1;j++){
 	  	ansLayout[i][j]=layout[i][j];
 	  }
 	  }
 deleteRandom(layout,size);
    for(int i=0;i<2*size+1;i++){
 	  for(int j=0;j<2*size+1;j++){
 	  	ans[i][j]=layout[i][j];
 	  }
 	  }
    return layout;
  }
    
  static void gridFiller(String[][] layout,int size){
  String s = Integer.toString(size);
  int len = s.length();
  int temp=0;
  int start=(int)(System.nanoTime()%size+1);
  for(int i=1;i<2*size+1;i=i+2){
  temp=start;
   for(int j=1;j<2*size+1;j=j+2){
      layout[i][j]=String.format("%"+len+"d",start);
      start=start%size+1;
    }
    start=temp%size+1;
  }
}

static void deleteRandom(String[][] layout,int size){
  len = Integer.toString(size).length();
  int count=0;
  //int range=(size*size)/3;
  int row;
  int column;
  while(count<(size*size)/3){
    row = (int)(System.nanoTime()%(2*size+1));
    column = (int)(System.nanoTime()%(2*size+1));
    if(row%2==0 || column%2==0){
      continue;
    }
    if(layout[row][column].isBlank()==false){
      layout[row][column]=(" ".repeat(len));
      count++;
    }
  }
}

static void feedLayout(int row ,int column ,int value ){
row--;
column--;
if(ans[2*row+1][2*column+1].equals(" ".repeat(len))){
ans[2*row+1][2*column+1]=String.format("%"+len+"d",value);
blankCount--;
}
else{
System.out.println("Already filled");
}
for(int i=0;i<2*size+1;i++){
 	  for(int j=0;j<2*size+1;j++){
 	  	System.out.print(ans[i][j]);
 	  }
 	  System.out.println();
    }
  
}
public static void main(String[] args){
	GameVer2 obj = new GameVer2();
  //String[][] layout = new String[2*size+1][2*size+1];
	if(args.length==0){
    System.out.println("Please enter valid size in command line arguments................");
    return;
  }
	size = Integer.parseInt(args[0]);	
  if(size<0){
    System.out.println("Please enter VALID SIZE in command line arguments................");
    return;
  }
  blankCount = 0;
	String[][] layout = gridGenerator(size);
	for(int i=0;i<2*size+1;i++){
 	  for(int j=0;j<2*size+1;j++){
 	  	if(layout[i][j].trim()==""){
 	  	blankCount++;
 	  	}
 	  }
    }
  for(int i=0;i<2*size+1;i++){
 	  for(int j=0;j<2*size+1;j++){
 	  	System.out.print(layout[i][j]);
 	  }
 	  System.out.println();
    }
    int choice = -1;
    int row;
    int column;
    int number;
    int choice2;
    Scanner sc = new Scanner(System.in);
    while(blankCount>0){
    System.out.println("Enter the row number:");
    row = sc.nextInt();
    System.out.println("Enter column number:");
    column = sc.nextInt();
    System.out.println("Enter the number you want to feed:");
    number = sc.nextInt();
    
    feedLayout(row,column,number);
    System.out.println(".".repeat(50));
    System.out.println("Do you want to continue 0(no)/1(yes):");
    choice2 = sc.nextInt();
    if(choice2 == 0){
      System.out.println("Thankyou for visiting.");
      return;
    }
    }
    int p=1;
    for(int i=0;i<2*size+1;i++){
 	  for(int j=0;j<2*size+1;j++){
 	  	if(!ansLayout[i][j].equals(ans[i][j])){
 	  	  System.out.println("Sorry you may have done some mistakes,better luck next time."+ansLayout[i][j]+" "+ans[i][j]);
 	  	  p=0;
 	  	}
 	  }
 	  }
    
    if(p==1){
      System.out.println("You are correct!!!!!!!!");
    }
    System.out.println("ThankYou!");
  }
}
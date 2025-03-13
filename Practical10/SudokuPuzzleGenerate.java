import java.util.Arrays;
public class SudokuPuzzleGenerate{
	static String[][] layout; 
  static String[][] gridGenerator(int size){
    String s = Integer.toString(size);
    int len = s.length();
 
    String layout[][] = new String[2*size+1][2*size+1];
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
 deleteRandom(layout,size);
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
  int len = Integer.toString(size).length();
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

public static void main(String[] args){
	SudokuPuzzleGenerate obj = new SudokuPuzzleGenerate();
  //String[][] layout = new String[2*size+1][2*size+1];
	if(args.length==0){
    System.out.println("Please enter valid size in command line arguments................");
    return;
  }
	int size = Integer.parseInt(args[0]);	
  if(size<0){
    System.out.println("Please enter VALID SIZE in command line arguments................");
    return;
  }
	String[][] layout = gridGenerator(size);
  for(int i=0;i<2*size+1;i++){
 	  for(int j=0;j<2*size+1;j++){
 	  	System.out.print(layout[i][j]);
 	  }
 	  System.out.println();
    }
  }
}

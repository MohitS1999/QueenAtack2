import java.util.*;
public class QueenAttack2{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int queenRow=sc.nextInt();
		int queenCol=sc.nextInt();
		int top=n-queenRow;
		int right=n-queenCol;
		int left=queenCol-1;
		int bottom=queenRow-1;
		int topleft=Math.min(top,left);
		int topright= Math.min(top,right);
		int bottomleft=Math.min(bottom,left);
		int bottomright=Math.min(bottom,right);
		for(int i=0;i<k;i++){
			int row=sc.nextInt();
			int col=sc.nextInt();
			if(row==queenRow){
				if(col<queenCol){
					left=Math.min(left,queenCol-col-1);
				}else{
					right=Math.min(right,col-queenCol-1);
				}
			}else if(col==queenCol){
				if(row<queenRow){
					bottom=Math.min(bottom,queenRow-row-1);
				}else{
					top=Math.min(top,row-queenRow-1);
				}
			}else if(Math.abs(col-queenCol)==Math.abs(row-queenRow)){
				int diff=Math.abs(queenCol-col)-1;
				if(col<queenCol){
					if(row>queenRow){
						topleft=Math.min(topleft,diff);
					}else{
						bottomleft=Math.min(bottomleft,diff);
					}
				}else {
					if(row>queenRow){
						topright=Math.min(topright,diff);
					}else{
						bottomright=Math.min(bottomright,diff);
					}
				}
			}
		}
		
		int result=top+right+left+bottom+topleft+topright+bottomleft+bottomright;
		System.out.println(result);
	}
}
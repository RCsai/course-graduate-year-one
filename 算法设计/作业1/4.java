package 算法课作业1;

public class zuoye1_4 {
	
	public static void main(String[] args){
		int size=8;
		int specialRow=1;
		int specialCol=1;
		
		//特殊点设置在棋盘内，否则提示错误
		if(specialRow<=size-1&&specialCol<=size-1){
			chessProblem chessProblem=new chessProblem(specialRow, specialCol, size);
			chessProblem.printBoard(specialRow, specialCol, size);
		}
		else{
			System.out.println("特殊点坐标不正确");
		}
		
	}
}


class chessProblem{
	int size;		//容量
	int[][] board;	//棋盘
	int specialRow;	//特殊点横坐标
	int specialCol;	//特殊点纵坐标
	int number=0;	//L形编号
	
	//初始化
	public chessProblem(int specialRow,int specilaCol,int size){
		this.size=size;
		this.specialRow=specialRow;
		this.specialCol=specilaCol;
		board=new int[size][size];
	}
	
	//specialRow	特殊点行下标
	//specialCol	特殊点列下标
	//leftRow		矩阵的左边起点行下标
	//leftCol		矩阵的左边起点列下标
	//size			矩阵的宽或高
	
	public void setBoard(int specialRow,int specialCol,int leftRow,int leftCol,int size){
		if(size==1){
			return;
		}
		int subSize=size/2;
		number++;
		int n=number;	//number存在当前递归层次中，否则进入下一层次递归全局变量会发生改变
		
		//假设特殊点在左上角区域
		if(specialRow<leftRow+subSize&&specialCol<leftCol+subSize){
			setBoard(specialRow, specialCol, leftRow, leftCol, subSize);
		}
		else{
			//不在左上角，设左上角的右下角就是特殊点
			board[leftRow+subSize-1][leftCol+subSize-1]=n;
			setBoard(leftRow+subSize-1,leftCol+subSize-1,leftRow,leftCol,subSize);
		}
		
		//假设特殊点在右上方
		if(specialRow<leftRow+subSize&&specialCol>=leftCol+subSize){
			setBoard(specialRow, specialCol, leftRow, leftCol+subSize, subSize);
		}
		else{
			//不在右上方则将左下角的设置为特殊点
			board[leftRow+subSize-1][leftCol+subSize]=n;
			setBoard(leftRow+subSize-1, leftCol+subSize, leftRow, leftCol+subSize, subSize);
		}
		
		
		//假设特殊点在左下角区域
		if(specialRow>=leftRow+subSize&&specialCol<leftCol+subSize){
			setBoard(specialRow, specialCol, leftRow+subSize, leftCol, subSize);
		}
		else{
			//不在左下角，设右上角就是特殊点
			board[leftRow+subSize][leftCol+subSize-1]=n;
			setBoard(leftRow+subSize,leftCol+subSize-1,leftRow+subSize,leftCol,subSize);
		}
		
		//假设特殊点在右下角
		if(specialRow>=leftRow+subSize&&specialCol>=leftCol+subSize){
			setBoard(specialRow,specialCol,leftRow+subSize,leftCol+subSize,subSize);
		}
		
		else {
			//不在右下角，左上角就是特殊点
			board[leftRow+subSize][leftCol+subSize]=n;
			setBoard(leftRow+subSize, leftCol+subSize, leftRow+subSize, leftCol+subSize, subSize);
		}
	}
	
	public void printBoard(int specialRow,int specialCol,int size){
		setBoard(specialRow, specialCol, 0, 0, size);
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board.length;j++){
				System.out.print(board[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
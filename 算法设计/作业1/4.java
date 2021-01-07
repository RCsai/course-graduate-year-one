package �㷨����ҵ1;

public class zuoye1_4 {
	
	public static void main(String[] args){
		int size=8;
		int specialRow=1;
		int specialCol=1;
		
		//����������������ڣ�������ʾ����
		if(specialRow<=size-1&&specialCol<=size-1){
			chessProblem chessProblem=new chessProblem(specialRow, specialCol, size);
			chessProblem.printBoard(specialRow, specialCol, size);
		}
		else{
			System.out.println("��������겻��ȷ");
		}
		
	}
}


class chessProblem{
	int size;		//����
	int[][] board;	//����
	int specialRow;	//����������
	int specialCol;	//�����������
	int number=0;	//L�α��
	
	//��ʼ��
	public chessProblem(int specialRow,int specilaCol,int size){
		this.size=size;
		this.specialRow=specialRow;
		this.specialCol=specilaCol;
		board=new int[size][size];
	}
	
	//specialRow	��������±�
	//specialCol	��������±�
	//leftRow		��������������±�
	//leftCol		��������������±�
	//size			����Ŀ���
	
	public void setBoard(int specialRow,int specialCol,int leftRow,int leftCol,int size){
		if(size==1){
			return;
		}
		int subSize=size/2;
		number++;
		int n=number;	//number���ڵ�ǰ�ݹ����У����������һ��εݹ�ȫ�ֱ����ᷢ���ı�
		
		//��������������Ͻ�����
		if(specialRow<leftRow+subSize&&specialCol<leftCol+subSize){
			setBoard(specialRow, specialCol, leftRow, leftCol, subSize);
		}
		else{
			//�������Ͻǣ������Ͻǵ����½Ǿ��������
			board[leftRow+subSize-1][leftCol+subSize-1]=n;
			setBoard(leftRow+subSize-1,leftCol+subSize-1,leftRow,leftCol,subSize);
		}
		
		//��������������Ϸ�
		if(specialRow<leftRow+subSize&&specialCol>=leftCol+subSize){
			setBoard(specialRow, specialCol, leftRow, leftCol+subSize, subSize);
		}
		else{
			//�������Ϸ������½ǵ�����Ϊ�����
			board[leftRow+subSize-1][leftCol+subSize]=n;
			setBoard(leftRow+subSize-1, leftCol+subSize, leftRow, leftCol+subSize, subSize);
		}
		
		
		//��������������½�����
		if(specialRow>=leftRow+subSize&&specialCol<leftCol+subSize){
			setBoard(specialRow, specialCol, leftRow+subSize, leftCol, subSize);
		}
		else{
			//�������½ǣ������ϽǾ��������
			board[leftRow+subSize][leftCol+subSize-1]=n;
			setBoard(leftRow+subSize,leftCol+subSize-1,leftRow+subSize,leftCol,subSize);
		}
		
		//��������������½�
		if(specialRow>=leftRow+subSize&&specialCol>=leftCol+subSize){
			setBoard(specialRow,specialCol,leftRow+subSize,leftCol+subSize,subSize);
		}
		
		else {
			//�������½ǣ����ϽǾ��������
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
package �㷨����ҵ1;

public class zuoye1_3 {

	public static void main(String[] args){
		search s=new search();
		s.getData();
		s.target=21;
		s.binarySearch(s.data, s.target);
	}
}


class search{
	int[] data;
	int NUM;
	int target;
	
	//������������
	public void getData(){
		NUM=15;
		data=new int[NUM];
		for(int i=0;i<NUM;i++){
			data[i]=i*2+2;
		}
		System.out.println("��ʼ���ݣ�");
		for(int i=0;i<NUM;i++){
			System.out.print(data[i]+"  ");
		}
		System.out.println();
	}
	
	
	//���ֲ����㷨
	public void binarySearch(int[] data,int target){
		int left=0;
		int right=data.length-1;
		int mid=0;
		
		while(left<=right){
			mid=(right+left)/2;
			if(data[mid]==target){
				System.out.print("���ڸ�ֵ,λ������Ϊ��"+mid);
				return;
			}
			else if(data[mid]<target){
				left=mid+1;
			}
			else if(data[mid]>target){
				right=mid-1;
			}
		}
		if(data[mid]>target){
			System.out.print("�����ڸ�ֵ������λ������Ϊ��"+(mid-1)+"��"+mid);
		}
		else if (data[mid]<target) {
			System.out.print("�����ڸ�ֵ������λ������Ϊ��"+mid+"��"+(mid+1));
		}
		
	}
}



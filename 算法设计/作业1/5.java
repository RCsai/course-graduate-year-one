package �㷨����ҵ1;

import java.util.Random;
public class zuoye1_5 {
	public static void main(String[] args){
		sort sort=new sort();
		sort.N=20;
		sort.data=new int[sort.N];
		sort.getData(sort.data, sort.N);
		sort.mergeSort(sort.data, 0, sort.data.length-1);
		sort.showData(sort.data);
	}
}

class sort{
	int N;
	int[] data;
	
	
	//������ʼ����
	public void getData(int[] data,int N){
		Random random=new Random();
		for(int i=0;i<N;i++){
			data[i]=random.nextInt(100);
		}
		System.out.println("��ʼ���ݣ�");
		for(int i=0;i<N;i++){
			System.out.print(data[i]+"\t");
		}
		System.out.println();
	}
	
	public void merge(int[] data,int left,int mid,int right){
		int[] tempData=new int[data.length];
		int leftStart=left;
		int rightStart=mid+1;
		int tempIndex=left;
		
		//�Ƚ����������ִ�С���и���
		while(leftStart<=mid&&rightStart<=right){
			if(data[leftStart]<data[rightStart]){
				tempData[tempIndex]=data[leftStart];
				tempIndex++;
				leftStart++;
			}
			else{
				tempData[tempIndex]=data[rightStart];
				tempIndex++;
				rightStart++;
			}
		}
		
		//��߻������ݣ�ֱ�Ӹ��Ƶ�����
		while(leftStart<=mid){
			tempData[tempIndex]=data[leftStart];
			tempIndex++;
			leftStart++;
		}
		
		//�ұ߻�������
		while(rightStart<=right){
			tempData[tempIndex]=data[rightStart];
			tempIndex++;
			rightStart++;
		}
		
		//��������Ƶ���ʼԪ����
		while(left<=right){
			data[left]=tempData[left];
			left++;
		}
	}
	
	public void mergeSort(int[] data,int left,int right){
		if(data==null){
			return;
		}
		if(left<right){
			//ȡ�е�
			int mid=(left+right)/2;
			//����߽��еݹ�����
			mergeSort(data, left, mid);
			//���ұ߽�������
			mergeSort(data, mid+1, right);
			//���й鲢
			merge(data, left, mid, right);
		}
	}
	
	//��ʾ�������
	public void showData(int[] data){
		System.out.println("���������");
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+"\t");
		}
		System.out.println();
	}
} 

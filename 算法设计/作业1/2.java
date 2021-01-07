package �㷨����ҵ1;

import java.util.*;
public class zuoye1_2 {
	
	public static void main(String[] args){	
		//��������
		//ȡ�з�
		QuZhongFa sort1=new QuZhongFa();
		sort1.arr=new int[]{12,1,24,35,6,7,68,23,45,69,10,12,34};
		sort1.quickSort(sort1.arr,0,sort1.arr.length-1);
		System.out.println("ȡ�з����������£�");
		System.out.println(Arrays.toString(sort1.arr));
		
		//��һԪ��
		FirstElement sort2=new FirstElement();
		sort2.arr=new int[]{12,1,24,35,6,7,68,23,45,69,10,12,34};
		sort2.quickSort(sort2.arr,0,sort2.arr.length-1);
		System.out.println("��һԪ�����������£�");
		System.out.println(Arrays.toString(sort2.arr));	
	}
}

//��λȡ�п�������

class QuZhongFa{
		int[] arr;
		//��������
		public  void swap(int[] arr,int a,int b){
			int temp=arr[a];
			arr[a]=arr[b];
			arr[b]=temp;
		}
		
		//������Ŧֵ
		public  void dealPivot(int[] arr,int left,int right){
			int mid=(left+right)/2;
			if(arr[left]>arr[mid]){
				swap(arr,left,mid);
			}
			if(arr[left]>arr[right]){
				swap(arr,left,right);
			}
			if(arr[mid]>arr[right]){
				swap(arr,mid,right);
			}
			swap(arr,right-1,mid);
		}
		
		//������Ŧֵ���зָ�����
		public  void quickSort(int[] arr,int left,int right){
			if(left<right){
				//��ȡ��Ŧֵ�����д���
				dealPivot(arr,left,right);
				//��¼��Ŧֵλ��
				int pivot=right-1;
				//��ָ��
				int i=left;
				//��ָ��
				int j=right-1;
				
				while(true){
					//Ѱ�Ҵ�����Ŧֵ����
					while(arr[++i]<arr[pivot]){
					}
					
					//Ѱ��С����Ŧֵ����
					while(j>left&&arr[--j]>arr[pivot]){
					}
					
					if(i<j){
						swap(arr,i,j);
					}
					else{
						break;
					}
				}
				
				//�滻��Ŧֵ
				if(i<right){
					swap(arr,i,pivot);
				}
				
				//�ݹ�����ָ������			
				quickSort(arr,left,i-1);
				quickSort(arr,i+1,right);
			}			
		}
}


//��һԪ�ؿ�������
class FirstElement{
	int[] arr;
	public  void quickSort(int[] arr,int low,int high){
		if(low<high){
			//��ȡ�ָ��
			int k=partitionWithFirst(arr,low,high);
			//�ݹ�ָ����²���
			quickSort(arr,low,k-1);
			quickSort(arr,k+1,high);
		}
		
	}
	
	//�ҵ���Ԫλ��
	public  int partitionWithFirst(int[] arr,int low,int high){
		int k=arr[low];
		int i=low;
		int j=high;
		while(j>i){
			//--j�������С��k��Ԫ��
			while(j>i&&arr[j]>k){
				j--;
			}
			//�ҵ�С��kֵ֮������滻
			if(i<j){
				arr[i]=arr[j];
				i++;
			}
			
			
			//++i������Ҵ���k��ֵ�����滻
			while(j>i&&arr[i]<k){
				i++;
			}
			if(i<j){
				arr[j]=arr[i];
				j--;
			}
		}
		arr[i]=k;
		return i;
	}
}


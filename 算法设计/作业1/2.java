package 算法课作业1;

import java.util.*;
public class zuoye1_2 {
	
	public static void main(String[] args){	
		//测试用例
		//取中法
		QuZhongFa sort1=new QuZhongFa();
		sort1.arr=new int[]{12,1,24,35,6,7,68,23,45,69,10,12,34};
		sort1.quickSort(sort1.arr,0,sort1.arr.length-1);
		System.out.println("取中法输出结果如下：");
		System.out.println(Arrays.toString(sort1.arr));
		
		//第一元素
		FirstElement sort2=new FirstElement();
		sort2.arr=new int[]{12,1,24,35,6,7,68,23,45,69,10,12,34};
		sort2.quickSort(sort2.arr,0,sort2.arr.length-1);
		System.out.println("第一元素输出结果如下：");
		System.out.println(Arrays.toString(sort2.arr));	
	}
}

//三位取中快速排序

class QuZhongFa{
		int[] arr;
		//交换数据
		public  void swap(int[] arr,int a,int b){
			int temp=arr[a];
			arr[a]=arr[b];
			arr[b]=temp;
		}
		
		//处理枢纽值
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
		
		//根据枢纽值进行分割排序
		public  void quickSort(int[] arr,int left,int right){
			if(left<right){
				//获取枢纽值并进行处理
				dealPivot(arr,left,right);
				//记录枢纽值位置
				int pivot=right-1;
				//左指针
				int i=left;
				//右指针
				int j=right-1;
				
				while(true){
					//寻找大于枢纽值的数
					while(arr[++i]<arr[pivot]){
					}
					
					//寻找小于枢纽值数据
					while(j>left&&arr[--j]>arr[pivot]){
					}
					
					if(i<j){
						swap(arr,i,j);
					}
					else{
						break;
					}
				}
				
				//替换枢纽值
				if(i<right){
					swap(arr,i,pivot);
				}
				
				//递归排序分割的两段			
				quickSort(arr,left,i-1);
				quickSort(arr,i+1,right);
			}			
		}
}


//第一元素快速排序
class FirstElement{
	int[] arr;
	public  void quickSort(int[] arr,int low,int high){
		if(low<high){
			//获取分割点
			int k=partitionWithFirst(arr,low,high);
			//递归分割余下部分
			quickSort(arr,low,k-1);
			quickSort(arr,k+1,high);
		}
		
	}
	
	//找到主元位置
	public  int partitionWithFirst(int[] arr,int low,int high){
		int k=arr[low];
		int i=low;
		int j=high;
		while(j>i){
			//--j反向查找小于k的元素
			while(j>i&&arr[j]>k){
				j--;
			}
			//找到小于k值之后进行替换
			if(i<j){
				arr[i]=arr[j];
				i++;
			}
			
			
			//++i方向查找大于k的值进行替换
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


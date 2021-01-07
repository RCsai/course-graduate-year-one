package 算法课作业1;

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
	
	
	//产生初始数据
	public void getData(int[] data,int N){
		Random random=new Random();
		for(int i=0;i<N;i++){
			data[i]=random.nextInt(100);
		}
		System.out.println("初始数据：");
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
		
		//比较左右两部分大小进行复制
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
		
		//左边还有数据，直接复制到后面
		while(leftStart<=mid){
			tempData[tempIndex]=data[leftStart];
			tempIndex++;
			leftStart++;
		}
		
		//右边还有数据
		while(rightStart<=right){
			tempData[tempIndex]=data[rightStart];
			tempIndex++;
			rightStart++;
		}
		
		//将结果复制到初始元素中
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
			//取中点
			int mid=(left+right)/2;
			//对左边进行递归排序
			mergeSort(data, left, mid);
			//对右边进行排序
			mergeSort(data, mid+1, right);
			//进行归并
			merge(data, left, mid, right);
		}
	}
	
	//显示排序后结果
	public void showData(int[] data){
		System.out.println("排序后结果：");
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+"\t");
		}
		System.out.println();
	}
} 

package 算法课作业1;

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
	
	//产生测试数据
	public void getData(){
		NUM=15;
		data=new int[NUM];
		for(int i=0;i<NUM;i++){
			data[i]=i*2+2;
		}
		System.out.println("初始数据：");
		for(int i=0;i<NUM;i++){
			System.out.print(data[i]+"  ");
		}
		System.out.println();
	}
	
	
	//二分查找算法
	public void binarySearch(int[] data,int target){
		int left=0;
		int right=data.length-1;
		int mid=0;
		
		while(left<=right){
			mid=(right+left)/2;
			if(data[mid]==target){
				System.out.print("存在该值,位置索引为："+mid);
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
			System.out.print("不存在该值，相邻位置索引为："+(mid-1)+"、"+mid);
		}
		else if (data[mid]<target) {
			System.out.print("不存在该值，相邻位置索引为："+mid+"、"+(mid+1));
		}
		
	}
}



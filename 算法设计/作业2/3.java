package 算法课作业1;

public class zuoye2_3 {
	
	public static void main(String[] args){
		activity act=new activity();
		act.s=new int[]{0,2,2,3,4,6,7,9,10,13};
		act.f=new int[]{0,3,4,5,7,8,11,12,15,17};
		act.a=new int[act.s.length];
		act.count=1;
		
		act.select(act.s, act.f, act.a, act.count);
	}
}


class activity{
	int[] s;	//活动开始
	int[] f;	//活动结束
	
	int[] a;	//活动是否被选中,表示被选中，0表示未被选中
	
	int count;	//记录活动安排时间
	
	
	//选择活动
	public void select(int[] s,int[] f,int[] a,int count){
		timeSort(s, f, 0, f.length-1);
		
		a[1]=1;
		int j=1;
		for(int i=2;i<s.length;i++){
			if(s[i]>=f[j]){
				a[i]=1;
				j=i;
				count++;
			}
			else{
				a[i]=0;
			}
		}		
		System.out.println("总共有活动"+count+"个可以安排：");
		showSelect(s, f, a);
	}
	
	//找到主元位置
	public int partitionWithFirst(int[] s,int[] f,int low,int high){
		int k=f[low];
		int m=s[low];
		int i=low;
		int j=high;
		while(j>i){
			//--j反向查找小于k的元素
			while(j>i&&f[j]>k){
				j--;
			}
			//找到小于k值之后进行替换
			if(i<j){
				f[i]=f[j];
				s[i]=s[j];
				i++;
			}
			
			
			//++i方向查找大于k的值进行替换
			while(j>i&&f[i]<k){
				i++;
			}
			if(i<j){
				f[j]=f[i];
				s[j]=s[i];
				j--;
			}
		}
		f[i]=k;
		s[i]=m;
		return i;
	}
	
	//对结束时间进行排序
	public void timeSort(int[] s,int[] f,int low,int high){
		if(low<high){
			int k=partitionWithFirst(s, f, low, high);
			timeSort(s, f, low, k-1);
			timeSort(s, f, k+1, high);
		}
		
	}
	
	//输出结果
	public void showSelect(int[] s,int[] f,int[] a){
		int t=0;
		for(int i=1;i<s.length;i++){
			if(a[i]==1){
				t++;
				System.out.println("活动"+t+"\t"+"开始时间："+s[i]+"\t"+"结束时间："+f[i]);
			}
		}
	}
}
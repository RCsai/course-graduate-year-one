package �㷨����ҵ1;

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
	int[] s;	//���ʼ
	int[] f;	//�����
	
	int[] a;	//��Ƿ�ѡ��,��ʾ��ѡ�У�0��ʾδ��ѡ��
	
	int count;	//��¼�����ʱ��
	
	
	//ѡ��
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
		System.out.println("�ܹ��л"+count+"�����԰��ţ�");
		showSelect(s, f, a);
	}
	
	//�ҵ���Ԫλ��
	public int partitionWithFirst(int[] s,int[] f,int low,int high){
		int k=f[low];
		int m=s[low];
		int i=low;
		int j=high;
		while(j>i){
			//--j�������С��k��Ԫ��
			while(j>i&&f[j]>k){
				j--;
			}
			//�ҵ�С��kֵ֮������滻
			if(i<j){
				f[i]=f[j];
				s[i]=s[j];
				i++;
			}
			
			
			//++i������Ҵ���k��ֵ�����滻
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
	
	//�Խ���ʱ���������
	public void timeSort(int[] s,int[] f,int low,int high){
		if(low<high){
			int k=partitionWithFirst(s, f, low, high);
			timeSort(s, f, low, k-1);
			timeSort(s, f, k+1, high);
		}
		
	}
	
	//������
	public void showSelect(int[] s,int[] f,int[] a){
		int t=0;
		for(int i=1;i<s.length;i++){
			if(a[i]==1){
				t++;
				System.out.println("�"+t+"\t"+"��ʼʱ�䣺"+s[i]+"\t"+"����ʱ�䣺"+f[i]);
			}
		}
	}
}
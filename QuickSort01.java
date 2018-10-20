package cn.haiwen.arrays.sort;

import java.util.Arrays;

/**
 * 本测试   --  快速排序方法一：挖坑法！
 * 利用分治法，和递归方法
 * 本测试不足点:
 * 以第一位置元素为基准元素，如果第一个元素要么最小值或者最大值，那么就无法发挥分治法的优势，这种情况时间复杂度O（n^2）
 * 所以之后可以随机一个元素作为基准元素，平均时间复杂度为O（nlogn）,最坏情况O(n^2)
 */
public class QuickSort01 {

	/**
	 * 挖坑法：选定基准元素，先从右边开始，和基准元素比较，比基准小，就放入左边的坑，坑的位置+1,到左边
	 * 		 左边开始和基准元素比较，比基准大，就放入右边的坑，坑位置-1 ，到右边
	 * 		最后，一轮结束，将基准元素放到最后的坑位置上
	 */
	public static void main(String[] args) {
		int[] arr = new int[]{4,7,6,5,3,2,8,1,100,0,1};
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int startIndex, int endIndex) {
		//递归结束条件
		if(startIndex>=endIndex){	
			return;
		}
		//获得基准元素位置
		int pivotIndex = partition(arr,startIndex,endIndex);
		//用分治法递归数列的两部分
		quickSort(arr,startIndex,pivotIndex-1);
		quickSort(arr,pivotIndex+1,endIndex);
	}

	private static int partition(int[] arr, int startIndex, int endIndex) {
		//取第一个位置的元素为基准元素
		int pivot = arr[startIndex];
		int left = startIndex;
		int right = endIndex;
		//坑的位置，初始等于基准元素pivot的位置
		int index = startIndex;

		//大循环在左右指针重合或者交错时结束
		while( right>=left ){
			//right指针从右到左进行比较
			while( right>=left ){
				if(arr[right]<pivot){	//如果右边元素比基准元素小就填坑
					arr[left] = arr[right];
					index = right;		//坑的位置放到右边
					left++;		//左边填完，位置自增到下一个位置
					break;		//跳出这个循环，到从左往右进行比较
				}
				right--;
			}	
			//left指针从左到右进行比较
			while( right>=left ){
				if(arr[left]>pivot){	//如果左边元素比基准元素大就填坑
					arr[right] = arr[left];
					index = left;
					right-- ;
					break;
				}
				left++;
			}
		}
		//一轮循环结束后，将基准元素放到index位置上
		arr[index] = pivot;
		return index;
	}

}

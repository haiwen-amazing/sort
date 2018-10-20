package cn.haiwen.arrays.sort;

import java.util.Arrays;

/**
 * 本测试 --- 快速排序方法二：指针交换法
 * 利用递归
 */
public class QuickSort02 {
	/*
	 * 指针交换法（原理和挖坑法差不多）：选定基准元素pivot，左指针left和右指针right
	 * 		从right开始，right元素指向的元素和基准元素比较，大于等于 就right--，小于就停止，切换到left
	 * 		从left开始，left元素指向的元素和基准元素比较，如果小于等于就left++，大于就停止
	 * 		接着left和right指向的元素进行交换，之后继续循环
	 * 		一轮下来，指针重合，将重合位置的元素和第一位置元素交换
	 * 		递归重复
	 */
	public static void main(String[] args) {
		int[] arr = new int[]{4,7,6,5,3,2,8,1};
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
		
		while(left!=right){
			//right指针开始和基准元素比较，而且满足比基准元素大，就自减到下一个继续比较
			while(left<right && arr[right]>pivot){
				right--;
			}
			//left指针开始和基准元素比较，而且满足比基准元素小，就自增到下一个继续比较
			while(left<right && arr[left]<=pivot){
				left++;
			}
			//一轮下来，交换left和right指向的元素
			if(left<right){ 
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
			}
		}
		//循环结束，此时left和right重合，和第一个位置元素交换（注意不是和pivot交换，基准元素只用来比较）
		int tmp = arr[left];
		arr[left] = arr[startIndex];
		arr[startIndex] = tmp;
		return left;
	}	

}

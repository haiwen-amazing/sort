package cn.haiwen.arrays.sort;

import java.util.Arrays;


/**
 *  测试冒泡排序和鸡尾酒排序
 */
import java.util.Random;
import java.util.Scanner;

public class BubbleAndCocktail {
	public static void main(String[] args) {
		//冒泡排序
		int[] arr = arr();//调用方法arr（）自动生成数组
		int[] arr2 = arr;//给鸡尾酒排序
		long t = System.currentTimeMillis();
		blue(arr);//冒泡排序
		t = System.currentTimeMillis()-t;
		System.out.println("需要时间："+t);

		System.out.println("=====================");
		//鸡尾酒排序
		long t2 = System.currentTimeMillis();
		wine(arr2);
		t2 = System.currentTimeMillis()-t2;
		System.out.println("需要时间："+t2);






	}
	//鸡尾酒排序
	private static void wine(int[] arr2) {
		int tmp = 0;//交换
		//外循环控制回合，内循环两两比较
		//交换下标标记，和交换无序的边界
		int firstborder = arr2.length-1;
		int firstlastIndex = 0;
		int secondborder = 0;
		int secondlastIndex =0;
		//回合数应该是一半减
		for(int i=0;i<arr2.length/2 ;i++){
			//标记
			boolean isSort = true;
			//先往右摆
			for(int j=i;j<firstborder;j++){
				if(arr2[j]>arr2[j+1]){
					tmp = arr2[j];
					arr2[j] = arr2[j+1];
					arr2[j+1] = tmp;
					isSort = false;
					firstlastIndex = j;
				}
			}
			firstborder = firstlastIndex;
			if(isSort){
				break;
			}

			//往左摆
			for(int j=arr2.length-i-1;j>secondborder;j--){

				if(arr2[j-1]>arr2[j]){
					tmp = arr2[j-1];
					arr2[j-1] = arr2[j];
					arr2[j] = tmp;
					isSort = false;
					secondlastIndex = j;
				}
			}
			secondborder = secondlastIndex;
			if(isSort){
				break;
			}
			System.out.println("鸡尾酒排序："+Arrays.toString(arr2));
		}
		System.out.println("鸡尾酒排序："+Arrays.toString(arr2));
	}
	//冒泡排序
	private static void blue(int[] arr) {
		int tmp = 0;//交换
		//外循环控制回合，内循环两两比较
		//交换下标标记，和交换无序的边界
		int border = arr.length-1;
		int lastIndex = 0;

		for(int i=0;i<arr.length;i++){
			boolean isSort = true;//标记是否已经有序
			for(int j=0;j<border;j++){
				if(arr[j]>arr[j+1]){
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					isSort = false;//只要交换了就是无序的
					lastIndex = j;//每次交换假设都是最后一次交换
				}
			}
			border = lastIndex;//最后一次交换的下标就是无序的边界
			if(isSort){
				break;
			}
		}
		System.out.println("冒泡排序："+Arrays.toString(arr));
	}


	//生成数组
	private static int[] arr() {
		System.out.println("请输入数组长度");
		int length = new Scanner(System.in).nextInt();
		int[] a = new int[length];
		for(int i=0;i<length;i++){
			a[i] = new Random().nextInt(10000);
		}
		System.out.println("初始数组："+Arrays.toString(a));
		return a;
	}
}

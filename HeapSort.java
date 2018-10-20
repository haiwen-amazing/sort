package cn.haiwen.arrays.sort;

import java.util.Arrays;

/**
 * 堆排序：二叉堆，分为最大堆和最小堆
 * 说明：二叉堆的根节点叫做堆顶，最大堆和最小堆的特点，决定了在最大堆的对顶是整个堆中的最大元素。（最小堆同理）
 * 堆的自我调整：1插入节点（插入位置是完全二叉树的最后一个位置） 2 删除节点（所删除的是处于堆顶的节点） 
 * 				3构建二叉堆（也就是把一个无序的完全二叉树调整为二叉堆，本质上就是让所有非叶子节点一次下沉）
 * 	（未完整）		
 * @author Administrator
 *
 */
public class HeapSort {

	/**
	 * 上浮调整
	 * @param array
	 */
	public static void upAdjust(int[] array){
		int childIndex = array.length-1;
		int parentIndex = childIndex/2;
		//temp保存插入的叶子节点值，用于最后的赋值
		int temp = array[childIndex];
		while(childIndex > 0 && temp <array[parentIndex]){
			//无需真正交换，单项赋值即可
			array[childIndex] = array[parentIndex];
			childIndex = parentIndex;
			parentIndex = parentIndex/2;
		}
		array[childIndex] = temp;
	}
	
	/**
	 * 向下调整
	 * @param array
	 * @param parentIndex	要下沉的父节点
	 * @param length		堆的有效大小
	 */
	public static void downAdjust(int[] array,int parentIndex,int length){
		//temp保存父节点值，用于最后的赋值
		int temp = array[parentIndex];
		int childIndex = 2*parentIndex+1;
		while(childIndex<=length){
			//如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
			if(childIndex+1<=length && array[childIndex+1]<array[childIndex]){
				childIndex++;
			}
			//如果父节点小于任何一个孩子的值，直接跳出
			if(temp<=array[childIndex]){
				break;
			}
			//无需交换，单项赋值即可
			array[parentIndex] = array[childIndex];
			parentIndex = childIndex;
			childIndex = 2*childIndex+1;
		}
		array[parentIndex] = temp;
	}
	
	/**
	 * 构建堆
	 * @param array
	 */
	public static void buildHeap(int[] array){
		//从最后一个非叶子节点开始，一次下沉调整
		for(int i=array.length/2;i>=0;i--){
			downAdjust(array,i,array.length-1);
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1,3,2,6,5,7,8,9,10,0};
		upAdjust(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[]{7,1,3,10,5,2,8,9,6};
		buildHeap(array);
		System.out.println(Arrays.toString(array));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}

package jav.leetcode.groupanagrams;

import java.util.ArrayList;
import java.util.List;

public class GroupAnagramsSolution {

    public static void main(String[] args) {
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagramsSolution groupAnagramsSolution = new GroupAnagramsSolution();
        List<List<String>> lists = groupAnagramsSolution.groupAnagrams(input);
        for (List<String> list : lists) {
            for (String j : list) {
                System.out.print(j + " ");
            }
            System.out.println("");
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        //结果处理
        List<List<String>> result = new ArrayList<>();
        List<String> emptyStr = new ArrayList<>();
        emptyStr.add("");
        result.add(emptyStr);


        List<String> standard = new ArrayList<String>();
        for (String i : strs) {
            if (standard.size() == 0) {
                char[] k = i.toCharArray();
                quickSort(k, 0, k.length - 1);
                standard.add(String.valueOf(k));
                result.get(0).clear();
                result.get(0).add(i);
                continue;
            }
            boolean matchFlag = false;
            for (int j = 0; j < standard.size(); j++) {
                if (compareAnagrams(i, standard.get(j))) {
                    matchFlag = true;
                    result.get(j).add(i);
                    break;
                }
            }
            if (!matchFlag) {
                char[] k = i.toCharArray();
                quickSort(k, 0, k.length-1);
                standard.add(String.valueOf(k));
                List<String> capacityStr = new ArrayList<>();
                capacityStr.add(i);
                result.add(capacityStr);
            }
        }
        return result;
    }

    private boolean compareAnagrams(String compared, String comparator) {
        if (compared.length() != comparator.length()) return false;
        char[] byteCompared = compared.toCharArray();
        char[] byteComparator = comparator.toCharArray();
        if (!compareTotalNum(byteCompared, byteComparator)) return false;
        return compareChars(byteCompared, byteComparator);
    }

    private boolean compareChars(char[] byteCompared, char[] byteComparator) {
        //快排
        quickSort(byteCompared, 0, byteCompared.length - 1);
        quickSort(byteComparator, 0, byteComparator.length - 1);
        return String.valueOf(byteComparator).equals(String.valueOf(byteCompared));
    }

    public static void quickSort(char[] arr, int low, int high) {
        if (low < high) {
            // 分区操作，返回基准值的正确位置
            int pi = partition(arr, low, high);
            // 递归排序左半部分
            quickSort(arr, low, pi - 1);
            // 递归排序右半部分
            quickSort(arr, pi + 1, high);
        }
    }

    // 分区方法
    private static int partition(char[] arr, int low, int high) {
        int pivot = arr[high]; // 选择最后一个元素作为基准值
        int i = low - 1; // 较小元素的索引

        // 遍历数组，将小于基准值的元素放到左边
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j); // 交换元素
            }
        }

        // 将基准值放到正确的位置
        swap(arr, i + 1, high);
        return i + 1; // 返回基准值的索引
    }

    // 交换数组中两个元素的位置
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private boolean compareTotalNum(char[] byteCompared, char[] byteComparator) {
        return charTotalNum(byteCompared) == charTotalNum(byteComparator);
    }

    private long charTotalNum(char[] charString) {
        long total = 0;
        for (char i : charString) {
            total += i;
        }
        return total;
    }
}

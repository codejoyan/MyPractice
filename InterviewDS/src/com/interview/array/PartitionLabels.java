package com.interview.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    //Find partitions and return list with length of each partitions.
    public List<Integer> partitionLabels(String S) {
        Map<Character, int[]> rangeMap;
        char[] charArr = S.toCharArray();
        rangeMap = findBounds(S);
        List<Integer> result = new ArrayList<>();
        int[] initPart = rangeMap.get(charArr[0]);
        List<int[]> rangePartition = new ArrayList<>();
        rangePartition.add(0, initPart);
        int start;
        int end;
        int count=0;
        for (int i = 1; i < charArr.length; i++) {
            int[] tmpPart = rangeMap.get(charArr[i]);
            if (tmpPart[0]>=initPart[0] && tmpPart[0]<=initPart[1]) {
                end = Integer.max(tmpPart[1], initPart[1]);
                if (end > initPart[1]) {
                    initPart[1] = end;
                    rangePartition.set(count, initPart);
                }
            } else {
                initPart = tmpPart;
                count++;
                rangePartition.add(count, tmpPart);
            }
        }
        //printRangeIntervals(rangePartition);
        for (int i=0; i<rangePartition.size(); i++) {
            result.add(i, (rangePartition.get(i)[1]-rangePartition.get(i)[0]+1));
        }

        return result;
    }

    //Find lower and upper bound for all characters in the array.
    public Map<Character, int[]> findBounds(String S) {
        Map<Character, int[]> rangeMap = new HashMap<>();
        char[] charArr = S.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (rangeMap.containsKey(charArr[i])) {
                int[] tmp = rangeMap.get(charArr[i]);
                tmp[1] = i;
                rangeMap.put(charArr[i], tmp);
            } else {
                int[] tmp = new int[2];
                tmp[0] = i;
                tmp[1] = i;
                rangeMap.put(charArr[i], tmp);
            }
        }
        return rangeMap;
    }

    //Print the lower and upper bound of every character in the string.
    public void printRangeIntervals(List<int[]> rangePartition) {
        for (int[] elem: rangePartition) {
            System.out.println(elem[0]+"-"+elem[1]);
        }
    }

    //Print the lower and upper bound of each partition.
    public void printRangeMap(Map<Character, int[]> rangeMap) {
        for (Map.Entry<Character, int[]> entry: rangeMap.entrySet()) {
            int[] res = entry.getValue();
            System.out.println(entry.getKey()+"-> {"+res[0]+","+res[1]+"}");
        }
    }

    public static void main(String[] args) {
        String input = "ababcbacadefegdehijhklij";
        PartitionLabels pLabels = new PartitionLabels();
        //pLabels.printRangeMap(pLabels.findBounds(input));
        pLabels.partitionLabels(input).forEach(x-> System.out.println(x));
    }
}

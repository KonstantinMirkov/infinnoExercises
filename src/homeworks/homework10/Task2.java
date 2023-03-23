package homeworks.homework10;

import homeworks.homework9.Task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 5}, {2, 4}};
        int[][] mergedIntervals = mergeRanges(intervals);
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
            // [1, 5]
        }
        int[][] intervals2 = {{1, 5}, {6, 8}};

        int[][] mergedIntervals2 = mergeRanges(intervals2);

        for (int[] interval2 : mergedIntervals2) {
            System.out.println(Arrays.toString(interval2));
            // [1, 5]
            // [6, 8]
        }

        int[][] intervals3 = {{1, 5}, {5, 6}};

        int[][] mergedIntervals3 = mergeRanges(intervals3);

        for (int[] interval3 : mergedIntervals3) {
            System.out.println(Arrays.toString(interval3));
            // [1, 6]
        }
        int[][] intervals4 = {{1, 5}, {4, 7}, {6, 8}};

        int[][] mergedIntervals4 = mergeRanges(intervals4);

        for (int[] interval4 : mergedIntervals4) {
            System.out.println(Arrays.toString(interval4));
            // [1, 8]
        }

    }


    public static int[][] mergeRanges(int[][] intervals) {
        List<int[]> mergedIntervals = new ArrayList<>();

        int[] currentInterval = intervals[0];

        if (currentInterval.length == 0) {
            return new int[0][0];
        }

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (currentInterval[1] >= interval[0]) {
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = interval;
            }
        }

        mergedIntervals.add(currentInterval);

        int[][] result = new int[mergedIntervals.size()][2];

        for (int i = 0; i < mergedIntervals.size(); i++) {
            result[i] = mergedIntervals.get(i);
        }

        return result;
    }
}

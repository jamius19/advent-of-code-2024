package dev.jamius.aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

record Day01Input(int[] list1, int[] list2) {
}

public class Day01HistorianHysteria {
    static String INPUT_PATH = "/input/day1.txt";

    public static void main(String[] args) throws Exception {
        var sortedInput = getSortedInput();
        var length = sortedInput.list1().length;
        int similarity = 0;

        for (int i = 0; i < length; i++) {
            var val = sortedInput.list1()[i];

            for (int j = 0; j < length; j++) {
                if (sortedInput.list2()[j] == val) {
                    similarity += val;

                    if (j < length - 1 && sortedInput.list2()[j + 1] != val) {
                        break;
                    }
                }
            }
        }

        System.out.println(similarity);
    }

    static Day01Input getSortedInput() throws Exception {
        BufferedReader bfReader = new BufferedReader(new FileReader(Day01HistorianHysteria.class.getResource(INPUT_PATH).getPath()));
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();

        for (String line = bfReader.readLine(); line != null; line = bfReader.readLine()) {
            var values = line.split("\\s+");

            list1.add(Integer.parseInt(values[0]));
            list2.add(Integer.parseInt(values[1]));
        }

        bfReader.close();

        var arr1 = list1.stream().mapToInt(Integer::intValue).toArray();
        var arr2 = list2.stream().mapToInt(Integer::intValue).toArray();

        sort(arr1);
        sort(arr2);

        return new Day01Input(arr1, arr2);
    }

    static void sort(int[] v) {
        for (int i = 0; i < v.length; i++) {
            int smallestIdx = i;

            for (int j = i + 1; j < v.length; j++) {
                if (v[j] < v[smallestIdx]) {
                    smallestIdx = j;
                }
            }

            if (smallestIdx == i) {
                continue;
            }

            int tmp = v[i];
            v[i] = v[smallestIdx];
            v[smallestIdx] = tmp;
        }
    }
}


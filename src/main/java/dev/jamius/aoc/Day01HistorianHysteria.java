package dev.jamius.aoc;

record Day01Input(int[] list1, int[] list2) {
}

public class Day01HistorianHysteria {
    public static int similarityScore(Day01Input input) throws Exception {
        sort(input.list1());
        sort(input.list2());

        var length = input.list1().length;
        int similarity = 0;

        for (int i = 0; i < length; i++) {
            var val = input.list1()[i];

            for (int j = 0; j < length; j++) {
                if (input.list2()[j] == val) {
                    similarity += val;

                    if (j < length - 1 && input.list2()[j + 1] != val) {
                        break;
                    }
                }
            }
        }

        return similarity;
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


package dev.jamius.aoc;

import java.util.ArrayList;
import java.util.Map;

record RuleEntry(ArrayList<Integer> before, ArrayList<Integer> after) {
}

record Day05Input(Map<Integer, RuleEntry> rules, ArrayList<int[]> pages) {
}


public class Day05PrintQueue {

    public static int partOne(Day05Input input) {
        int total = 0;

        var rules = input.rules();
        var pages = input.pages();

        for(var page: pages) {
            var isValid = true;

            for (int i = 0; i < page.length; i++) {
                if (rules.containsKey(page[i])) {
                    var beforeValid = isBeforeValid(page, i, rules.get(page[i]).after());
                    var afterValid = isAfterValid(page, i, rules.get(page[i]).before());

                    if (!beforeValid || !afterValid) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid) {
                total += page[page.length / 2];
            }
        }

        return total;
    }

    public static int partTwo(Day05Input input) {
        int total = 0;

        var rules = input.rules();
        var pages = input.pages();

        for(var page: pages) {
            var isValid = true;

            for (int i = 0; i < page.length; i++) {
                if (rules.containsKey(page[i])) {
                    var beforeValid = fixBefore(page, i, rules.get(page[i]).after());
                    var afterValid = fixAfter(page, i, rules.get(page[i]).before());

                    if (!beforeValid || !afterValid) {
                        isValid = false;
                        i = -1;
                    }
                }
            }

            if (!isValid) {
                total += page[page.length / 2];
            }
        }

        return total;
    }

    private static boolean isBeforeValid(int[] pages, int idx, ArrayList<Integer> rules) {
        for (int i = idx - 1; i >= 0; i--) {
            if (rules.contains(pages[i])) {
                return false;
            }
        }

        return true;
    }

    private static boolean isAfterValid(int[] pages, int idx, ArrayList<Integer> rules) {
        for (int i = idx + 1; i < pages.length; i++) {
            if (rules.contains(pages[i])) {
                return false;
            }
        }

        return true;
    }

    private static boolean fixBefore(int[] pages, int idx, ArrayList<Integer> rules) {
        var val = true;

        for (int i = idx - 1; i >= 0; i--) {
            if (rules.contains(pages[i])) {
                var tmp = pages[idx];
                pages[idx] = pages[i];
                pages[i] = tmp;

                val = false;
            }
        }

        return val;
    }

    private static boolean fixAfter(int[] pages, int idx, ArrayList<Integer> rules) {
        var val = true;

        for (int i = idx + 1; i < pages.length; i++) {
            if (rules.contains(pages[i])) {
                var tmp = pages[idx];
                pages[idx] = pages[i];
                pages[i] = tmp;

                val = false;
            }
        }

        return val;
    }
}

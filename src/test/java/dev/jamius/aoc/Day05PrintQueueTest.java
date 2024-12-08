package dev.jamius.aoc;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Day05PrintQueueTest {
    private static final String INPUT_PATH = "/input/day5.txt";

    private static Day05Input getInput() throws Exception {
        BufferedReader bf = new BufferedReader(
                new FileReader(
                        Day05PrintQueueTest.class.getResource(INPUT_PATH).getPath()
                )
        );

        String line;
        var rules = new HashMap<Integer, RuleEntry>();
        var pages = new ArrayList<int[]>();

        //for the rules
        for (line = bf.readLine(); line != null; line = bf.readLine()) {
            if (line.isEmpty()) break;

            var vals = Arrays.stream(line.split("\\|")).mapToInt(Integer::parseInt).toArray();

            if (!rules.containsKey(vals[0])) {
                rules.put(vals[0], new RuleEntry(new ArrayList<>(), new ArrayList<>()));
            }

            if (!rules.containsKey(vals[1])) {
                rules.put(vals[1], new RuleEntry(new ArrayList<>(), new ArrayList<>()));
            }

            rules.get(vals[0]).after().add(vals[1]);
            rules.get(vals[1]).before().add(vals[0]);
        }

        // for the pages
        for (line = bf.readLine(); line != null; line = bf.readLine()) {
            var vals = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
            pages.add(vals);
        }


        bf.close();
        return new Day05Input(rules, pages);
    }

    @Test
    public void partOneTest() throws Exception {
        var input = getInput();
        var totalPages = Day05PrintQueue.partOne(input);

        System.out.println(totalPages);
    }

    @Test
    public void partTwoTest() throws Exception {
        var input = getInput();
        var totalPages = Day05PrintQueue.partTwo(input);

        System.out.println(totalPages);
    }
}

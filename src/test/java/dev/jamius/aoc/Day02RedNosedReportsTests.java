package dev.jamius.aoc;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Day02RedNosedReportsTests {
    static String INPUT_PATH = "/input/day2.txt";

    public static List<int[]> getInput() throws Exception {
        var list = new LinkedList<int[]>();
        var bf = new BufferedReader(
                new FileReader(
                        Day02RedNosedReports.class.getResource(INPUT_PATH).getPath()
                )
        );

        for (var line = bf.readLine(); line != null; line = bf.readLine()) {
            var vals = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            list.add(vals);
        }

        bf.close();

        return list;
    }

    @Test
    public void validReportPart01() throws Exception {
        var inputs = getInput();
        var validCount = 0;

        for(var report: inputs) {
            var valid = Day02RedNosedReports.isValidReportPartOne(report);
            if (valid) {
                validCount++;
            }
        }

        System.out.println(validCount);
    }

    @Test
    public void validReportPart02() throws Exception {
        var inputs = getInput();
        var validCount = 0;

        for(var report: inputs) {
            var valid = Day02RedNosedReports.isValidReportPartTwo(report);
            if (valid) {
                validCount++;
            }
        }

        System.out.println(validCount);
    }

    @Test
    public void validateSpecificReports() {
        var validCount = 0;

        var inputs = new HashMap<int[], Boolean>();
        inputs.put(new int[]{1, 2, 3, 4}, true);
        inputs.put(new int[]{4, 1, 2, 3, 4, 5}, true);
        inputs.put(new int[]{1, 1, 2, 3, 4, 5}, true);
        inputs.put(new int[]{1, 2, 7, 8, 9}, false);
        inputs.put(new int[]{9, 7, 6, 2, 1}, false);
        inputs.put(new int[]{8, 6, 4, 4, 1}, true);

        for(var report: inputs.entrySet()) {
            var valid = Day02RedNosedReports.isValidReportPartTwo(report.getKey());
            assertThat(valid == report.getValue()).isTrue();

            if (valid) {
                validCount++;
            }
        }

        System.out.println(validCount);
    }
}

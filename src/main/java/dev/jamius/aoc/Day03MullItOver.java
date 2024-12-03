package dev.jamius.aoc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day03MullItOver {
    private static final Pattern PATTERN = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
    private static final Pattern PATTERN_CONDITIONAL = Pattern.compile("mul\\((\\d+),(\\d+)\\)|(don)|(do)");

    public static int getMulValue(String input) {
        Matcher m = PATTERN.matcher(input);
        var total = 0;

        while (m.find()) {
            var num1 = Integer.parseInt(m.group(1));
            var num2 = Integer.parseInt(m.group(2));

            total += num1 * num2;
        }

        return total;
    }

    public static int getConditionalMulValue(String input) {
        Matcher m = PATTERN_CONDITIONAL.matcher(input);
        var total = 0;

        var lastInsDo = true;

        while (m.find()) {
            if (m.group().startsWith("do")) {
                var isDont = m.group().equals("don");
                lastInsDo = !isDont;
            } else {
                var num1 = Integer.parseInt(m.group(1));
                var num2 = Integer.parseInt(m.group(2));

                total += lastInsDo ? num1 * num2 : 0;
            }
        }

        return total;
    }
}

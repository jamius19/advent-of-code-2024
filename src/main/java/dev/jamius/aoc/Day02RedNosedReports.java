package dev.jamius.aoc;

public class Day02RedNosedReports {

    public static boolean partOne(int[] report) {
        int direction = report[0] - report[1];

        for (int i = 0; i < report.length - 1; i++) {
            var tmpDir = report[i] - report[i + 1];
            var valid = isValid(tmpDir, direction);

            if (!valid) {
                return false;
            }

            direction = tmpDir;
        }

        return true;
    }

    public static boolean partTwo(int[] report) {
        var validityScore = getReportValidity(report, true);
        return validityScore == 1;
    }

    private static int getReportValidity(int[] report, boolean noError) {
        if (report.length < 2) {
            return 1;
        }

        int direction = report[0] - report[1];

        for (int i = 0; i < report.length - 1; i++) {
            var tmpDir = report[i] - report[i + 1];
            var valid = isValid(tmpDir, direction);

            if (valid) {
                direction = tmpDir;
                continue;
            }

            if (noError) {
                if (i == 0) {
                    return Math.max(
                            getReportValidity(removeAt(report, i), false),
                            getReportValidity(removeAt(report, i + 1), false)
                    );
                } else {
                    return Math.max(
                            getReportValidity(removeAt(report, i), false),
                            Math.max(
                                    getReportValidity(removeAt(report, i - 1), false),
                                    getReportValidity(removeAt(report, i + 1), false)
                            )
                    );
                }
            } else {
                return -1;
            }
        }

        return 1;
    }

    private static int[] removeAt(int[] arr, int idx) {
        int[] newArr = new int[arr.length - 1];

        for (int i = 0, offset = 0; i < arr.length; i++) {
            if (i == idx) {
                offset++;
                continue;
            }

            newArr[i - offset] = arr[i];
        }

        return newArr;
    }

    private static boolean isValid(int tmpDir, int direction) {
        var diff = Math.abs(tmpDir);

        if (diff < 1 || diff > 3) {
            return false;
        }

        // different direction
        if (Integer.signum(tmpDir) != Integer.signum(direction)) {
            return false;
        }

        return true;
    }
}

package dev.jamius.aoc;

public class Day04CeresSearch {

    public static int partOne(int[][] input) {
        var count = 0;

        for (int i = 0; i < input.length; i++) {
            var row = input[i];

            for (int j = 0; j < row.length; j++) {
                if (row[j] == 88) {
                    // check forward
                    count += countForward(row, j);

                    // check vertical
                    count += countVertical(input, j, i);

                    // check diagonal
                    count += countDiagonal(input, j, i);

                } else if (row[j] == 83) {
                    // check backward
                    count += countBackward(row, j);
                }
            }
        }


        return count;
    }

    public static int partTwo(int[][] input) {
        var count = 0;

        for (int i = 0; i < input.length; i++) {
            var row = input[i];

            for (int j = 0; j < row.length; j++) {
                if (row[j] == 65) {
                    // check diagonal
                    count += countDiagonalMas(input, j, i);
                }
            }
        }


        return count;
    }

    private static int countDiagonalMas(int[][] data, int idx, int idy) {
        var length = data.length;
        var width = data[idy].length;

        if (idx - 1 < 0 || idx + 1 >= width ||
            idy - 1 < 0 || idy + 1 >= length) {

            return 0;
        }

        if ((
                    (data[idy - 1][idx - 1] == 77 && data[idy + 1][idx + 1] == 83) ||
                    (data[idy - 1][idx - 1] == 83 && data[idy + 1][idx + 1] == 77)
            ) && (
                    (data[idy - 1][idx + 1] == 77 && data[idy + 1][idx - 1] == 83) ||
                    (data[idy - 1][idx + 1] == 83 && data[idy + 1][idx - 1] == 77)
            )) {

            return 1;
        }


        return 0;
    }

    private static int countVertical(int[][] data, int idx, int idy) {
        var count = 0;

        // upper vertical check
        if (idy - 3 >= 0 &&
            data[idy - 1][idx] == 77 &&
            data[idy - 2][idx] == 65 &&
            data[idy - 3][idx] == 83) {

            count++;
        }

        // lower vertical check
        if (idy + 3 < data.length &&
            data[idy + 1][idx] == 77 &&
            data[idy + 2][idx] == 65 &&
            data[idy + 3][idx] == 83) {

            count++;
        }

        return count;
    }

    private static int countDiagonal(int[][] data, int idx, int idy) {
        var count = 0;

        // upper left check
        if (idy - 3 >= 0 &&
            idx - 3 >= 0 &&
            data[idy - 1][idx - 1] == 77 &&
            data[idy - 2][idx - 2] == 65 &&
            data[idy - 3][idx - 3] == 83) {

            count++;
        }

        // upper right check
        if (idy - 3 >= 0 &&
            idx + 3 < data[idy].length &&
            data[idy - 1][idx + 1] == 77 &&
            data[idy - 2][idx + 2] == 65 &&
            data[idy - 3][idx + 3] == 83) {

            count++;
        }

        // lower left check
        if (idy + 3 < data.length &&
            idx - 3 >= 0 &&
            data[idy + 1][idx - 1] == 77 &&
            data[idy + 2][idx - 2] == 65 &&
            data[idy + 3][idx - 3] == 83) {

            count++;
        }

        // lower left check
        if (idy + 3 < data.length &&
            idx + 3 < data[idy].length &&
            data[idy + 1][idx + 1] == 77 &&
            data[idy + 2][idx + 2] == 65 &&
            data[idy + 3][idx + 3] == 83) {

            count++;
        }

        return count;
    }

    private static int countForward(int[] row, int idx) {
        if (idx + 3 < row.length &&
            row[idx + 1] == 77 &&
            row[idx + 2] == 65 &&
            row[idx + 3] == 83) {

            return 1;
        }

        return 0;
    }

    private static int countBackward(int[] row, int idx) {
        if (idx + 3 < row.length &&
            row[idx + 1] == 65 &&
            row[idx + 2] == 77 &&
            row[idx + 3] == 88) {

            return 1;
        }

        return 0;
    }
}

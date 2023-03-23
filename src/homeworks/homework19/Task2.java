package homeworks.homework19;

import java.util.function.BiFunction;

public class Task2 {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(4, 4, (rows, columns) -> 1);
        System.out.println(m1);

        Matrix m2 = new Matrix(4, 4, (rows, columns) -> rows == columns ? 1 : 0);
        System.out.println(m2);

        Matrix m3 = new Matrix(4, 4, (rows, columns) -> rows == columns ? rows + 1 : 0);
        System.out.println(m3);
       
        Matrix m4 = new Matrix(4, 4, Integer::compareTo);
        System.out.println(m4);

        Matrix m5 = new Matrix(4, 4, (rows, columns) -> Math.abs(rows - columns));
        System.out.println(m5);

        Matrix m6 = new Matrix(4, 4, (x, y) -> {
            int value = x * 4 + y;
            return value < 10 ?  value : ((char) ('a' + value - 10));
        });
        System.out.println(m6);
    }

    public static class Matrix {
        private int[][] matrix;
        private int rows;
        private int columns;

        public Matrix(int rows, int columns, BiFunction<Integer, Integer, Object> fillFunction) {
            if (rows <= 0 || columns <= 0) {
                throw new IllegalArgumentException("Rows and columns must be positive.");
            }

            this.rows = rows;
            this.columns = columns;
            this.matrix = new int[rows][columns];

            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    matrix[row][column] = (int) fillFunction.apply(column, row);
                }
            }
        }

        public Matrix(int rows, int columns, BiFunction<Integer, Integer, Object> fillFunction, int defaultValue) {
            this(rows, columns, fillFunction);
            this.fill(defaultValue);
        }

        public int[][] getMatrix() {
            return matrix;
        }

        public void setMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        public int getRows() {
            return rows;
        }

        public void setRows(int rows) {
            this.rows = rows;
        }

        public int getColumns() {
            return columns;
        }

        public void setColumns(int columns) {
            this.columns = columns;
        }

        public static int fillMatrix6(int rows, int columns) {
            int count = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    count++;
                }
            }
            return count;
        }

        public void fill(int value) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {
                    matrix[row][col] = value;
                }
            }
        }

        public void clear() {
            this.fill(0);
        }

        public int[] getRow(int row) {
            return matrix[row];
        }

        public int[] getColumn(int column) {
            int[] col = new int[rows];
            for (int row = 0; row < rows; row++) {
                col[row] = matrix[row][column];
            }
            return col;
        }

        public int get(int row, int column) {
            return matrix[row][column];
        }

        public void set(int row, int column, int value) {
            matrix[row][column] = value;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {
                    sb.append(matrix[row][col]).append(" ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }
}
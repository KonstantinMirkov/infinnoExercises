package homeworks.homework18;

import java.util.Random;
import java.util.function.BiFunction;

public class Task2 {
    public static void main(String[] args) {
        // Създавам матрица с размери 2 х 3 и запълвам с 1ци
        Matrix m1 = new Matrix(2, 3, (x, y) -> 1);
        System.out.println("Matrix m1:");
        System.out.println(m1);

        // Създавам матрица с размери 2 х 3 и запълвам със случайни числа от 0 до 100
        Matrix m2 = new Matrix(2, 3, (x, y) -> new Random().nextInt(100));
        System.out.println("Matrix m2:");
        System.out.println(m2);

        // Създавам матрица с размери 3 х 2 и запълвам с произволни стойности
        Matrix m3 = new Matrix(3, 2, (x, y) -> x * y);
        System.out.println("Matrix m3:");
        System.out.println(m3);
    }

    public static class Matrix {
        private int[][] matrix;
        private int rows;
        private int columns;

        public Matrix(int rows, int columns, BiFunction<Integer, Integer, Integer> fillFunction) {
            if (rows <= 0 || columns <= 0) {
                throw new IllegalArgumentException("Rows and columns must be positive.");
            }

            this.rows = rows;
            this.columns = columns;
            this.matrix = new int[rows][columns];

            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    matrix[row][column] = fillFunction.apply(column, row);
                }
            }
        }

        public Matrix(int rows, int columns, BiFunction<Integer, Integer, Integer> fillFunction, int defaultValue) {
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

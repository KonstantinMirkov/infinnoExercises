package homeworks.homework19;

import java.util.Random;
import java.util.function.BiFunction;

public class Task1 {
    public static void main(String[] args) {
        Matrix m = new Matrix(3, 3, (x, y) -> new Random().nextInt(120));
        System.out.println("Matrix:");
        System.out.println(m);
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
                    sb.append(String.format("%3d", matrix[row][col])).append(" ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }
}

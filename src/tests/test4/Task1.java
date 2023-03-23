package tests.test4;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        // Constructor without default value
        Matrix m1 = new Matrix(4, 4);
        System.out.println("m1:\n" + m1);

        // Constructor with default value
        Matrix m2 = new Matrix(2, 2, 5);
        System.out.println("m2:\n" + m2);

        // The fill method
        m1.fill(1);
        System.out.println("m1 after fill:\n" + m1);
        m2.fill(1);
        System.out.println("m2 after fill:\n" + m2);

        // The clear method
        m2.clear();
        System.out.println("m2 after clear:\n" + m2);

        // The getRow method
        int[] row = m1.getRow(1);
        System.out.println("row 1 of m1: " + Arrays.toString(row));

        // The getColumn method
        int[] col = m1.getColumn(1);
        System.out.println("column 1 of m1: " + Arrays.toString(col) + "\n");

        // The subMatrix method
        Matrix sub = m1.subMatrix(0, 0, 1, 1);
        System.out.println("sub-matrix of m1:\n" + sub);

        // The get and set methods
        System.out.println("element at of m1: " + m1.get(1, 1));
        m1.set(1, 1, 7);
        System.out.println("element of m1 after set: " + m1.get(1, 1) + "\n");

        try {
            Matrix m3 = new Matrix(-2, 3);
            System.out.println("m3:\n" + m3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static class Matrix {
        private int[][] matrix;
        private int rows;
        private int columns;

        public Matrix(int rows, int columns) {
            if (rows <= 0 || columns <= 0) {
                throw new IllegalArgumentException("Rows and columns must be positive.");
            }

            this.rows = rows;
            this.columns = columns;
            this.matrix = new int[rows][columns];
        }

        public Matrix(int rows, int columns, int defaultValue) {
            this(rows, columns);
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

        public Matrix subMatrix(int x1, int y1, int x2, int y2) {
            int subRows = x2 - x1 + 1;
            int subCols = y2 - y1 + 1;
            Matrix subMatrix = new Matrix(subRows, subCols);

            for (int row = x1; row <= x2; row++) {
                for (int col = y1; col <= y2; col++) {
                    subMatrix.set(row - x1, col - y1, matrix[row][col]);
                }
            }
            return subMatrix;
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

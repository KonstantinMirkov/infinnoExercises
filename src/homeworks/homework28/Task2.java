package homeworks.homework28;

public class Task2 {
    public static void main(String[] args) {
        Matrix a = new Matrix(2, 3);
        a.setMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}});

        Matrix b = new Matrix(3, 2);
        b.setMatrix(new int[][]{{7, 8}, {9, 10}, {11, 12}});

        Matrix c = a.multiply(b);
        System.out.println(c);
        //58 64
        //139 154
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

        public Matrix multiply(Matrix other) {
            if (this.columns != other.rows) {
                throw new IllegalArgumentException("Columns count in the first matrix must be equal to the rows count in the second matrix.");
            }

            Matrix result = new Matrix(this.rows, other.columns);
            for (int row = 0; row < this.rows; row++) {
                for (int col2 = 0; col2 < other.columns; col2++) {
                    for (int col1 = 0; col1 < this.columns; col1++) {
                        result.matrix[row][col2] += this.matrix[row][col1] * other.matrix[col1][col2];
                    }
                }
            }
            return result;
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
package homeworks.homework10;

public class Task0And1 {
    public static void main(String[] args) {
        //Task 0 test:
        Matrix matrix1 = new Matrix(2, 2, -1);
        matrix1.set(0, 1, 15);
        int v1 = matrix1.get(0, 1); // 15
        int v2 = matrix1.get(0, 0); // -1
        System.out.println(v1 + " " + v2);

        //Task 1 test:
        Matrix matrix2 = new Matrix(4, 4);
        for (int i = 0; i < 4; i++) {
            matrix2.set(i, i, i + 1);
        }

        Range columns = new Range(1, 2);
        Range rows = new Range(2, 3);
        Matrix subMatrix = matrix2.subMatrix(columns, rows);
        System.out.println(subMatrix);
//      0 3
//      0 0
    }

    public static class Matrix {
        private int[][] data;

        public Matrix(int cols, int rows) {
            this.data = new int[cols][rows];
        }

        public Matrix(int cols, int rows, int defaultValue) {
            this(cols, rows);

            for (int col = 0; col < cols; col++) {
                for (int row = 0; row < rows; row++) {
                    try {
                        this.data[col][row] = defaultValue;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }

        public void set(int col, int row, int value) {
            try {
                this.data[col][row] = value;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        public int get(int col, int row) {
            try {
                return this.data[col][row];
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return 0;
            }
        }

        public Matrix subMatrix(Range columns, Range rows) {
            int subCols = columns.size() + 1;
            int subRows = rows.size() + 1;
            Matrix subMatrix = new Matrix(subCols, subRows);

            for (int row = 0; row < subCols; row++) {
                for (int col = 0; col < subRows; col++) {
                    subMatrix.set(row, col, data[columns.getStart() + row][rows.getStart() + col]);
                }
            }
            return subMatrix;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < this.data[0].length; row++) {
                for (int col = 0; col < this.data.length; col++) {
                    sb.append(this.data[col][row]);
                    sb.append(" ");
                }
                if (row < this.data[0].length - 1) {
                    sb.append("\n");
                }
            }
            return sb.toString();
        }
    }

    public static class Range {
        private int start;
        private int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }


        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int size() {
            return end - start;
        }
    }
}

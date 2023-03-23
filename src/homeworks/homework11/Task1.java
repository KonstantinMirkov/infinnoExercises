package homeworks.homework11;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        // Test parameterless constructor
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.capacity()); // 16
        System.out.println(sb.length()); // 0

        // Test initialization from another StringBuilder
        StringBuilder sb1 = new StringBuilder("git");
        StringBuilder sb2 = new StringBuilder(sb1);
        sb2.append("hub");
        System.out.println(sb2); // github

        // Test initialization with initial capacity
        StringBuilder sb3 = new StringBuilder(10);
        System.out.println(sb3.capacity()); // 10

        // Test initialization from String
        StringBuilder sb4 = new StringBuilder("Hello");
        System.out.println(sb4); // Hello

        // Test append methods
        sb4.append(" World");
        System.out.println(sb4); // Hello World
        sb4.append(123);
        System.out.println(sb4); // Hello World123

        // Test capacity method
        System.out.println(sb4.capacity()); // 21

        // Test length method
        System.out.println(sb4.length()); // 15

        // Test secureCapacity method
        sb4.secureCapacity(50);
        System.out.println(sb4.capacity()); // 50

        // Test indexOf methods
        System.out.println(sb4.indexOf("World")); // 6
        System.out.println(sb4.indexOf("World", 8)); // -1
        System.out.println(sb4.lastIndexOf("l")); // 9
        System.out.println(sb4.lastIndexOf("l", 8)); // 3

        // Test setCharAt method
        sb4.setCharAt(4, 'O');
        System.out.println(sb4); // HellO World123

        // Test insert methods
        sb4.insert(5, "!");
        System.out.println(sb4); // HellO! World123
        sb4.insert(6, "big ", 0, 3);
        System.out.println(sb4); // HellO! big World123

        // Test replace method
        sb4.replace(6, 9, " small");
        System.out.println(sb4); // HellO! small World123

        // Test trimToSize method
        sb4.trimToSize();
        System.out.println(sb4.capacity()); // 50

        // Test reverse method
        sb4.reverse();
        System.out.println(sb4); // 321dlroW llams !Oll eH

        // Test substring methods
        System.out.println(sb4.substring(5)); // roW llams !Oll eH
        System.out.println(sb4.substring(5, 11)); // roW ll

        // Test delete methods
        sb4.delete(5, 11);
        System.out.println(sb4); // 321dlams !OlleH
        sb4.delete(4);
        System.out.println(sb4); // 321lams !OlleH
    }

    public static class StringBuilder {
        private static final int INITIAL_CAPACITY = 16;
        private char[] value;
        private int count;
        private int capacity;

        public StringBuilder() {
            this(INITIAL_CAPACITY);
        }

        public StringBuilder(int capacity) {
            if (capacity <= 0) {
                throw new IllegalArgumentException("Capacity must be positive.");
            }

            this.value = new char[capacity];
            this.capacity = capacity;
        }

        public StringBuilder(String str) {
            this(str.length() + INITIAL_CAPACITY);
            append(str);
        }

        public StringBuilder(StringBuilder sb) {
            this(sb.length() + INITIAL_CAPACITY);
            append(String.valueOf(sb));
        }

        public void append(String str) {
            if (str == null) {
                str = "null";
            }

            int len = str.length();
            secureCapacity(count + len);

            str.getChars(0, len, value, count);
            count += len;
        }

        public void append(StringBuilder sb) {
            if (sb == null) {
                sb = new StringBuilder("null");
            }

            int len = sb.length();
            secureCapacity(count + len);

            sb.toString().getChars(0, len, value, count);
            count += len;
        }

        public void append(int num) {
            append(Integer.toString(num));
        }

        public int capacity() {
            return this.capacity;
        }

        public int length() {
            return this.count;
        }

        public void secureCapacity(int minimumCapacity) {
            if (minimumCapacity <= this.capacity) {
                return;
            }

            int newCapacity = Math.max(minimumCapacity, this.capacity * 2);
            char[] newValue = new char[newCapacity];

            System.arraycopy(this.value, 0, newValue, 0, this.count);

            this.value = newValue;
            this.capacity = newCapacity;
        }

        public int indexOf(String str) {
            return indexOf(str, 0);
        }

        public int indexOf(String str, int fromIndex) {
            if (fromIndex < 0) {
                fromIndex = 0;
            }

            if (str == null) {
                str = "null";
            }

            int len = str.length();
            if (len == 0 && fromIndex < count) {
                return fromIndex;
            }

            for (int i = fromIndex; i <= count - len; i++) {
                if (value[i] == str.charAt(0)) {
                    boolean found = true;
                    for (int j = 1; j < len; j++) {
                        if (value[i + j] != str.charAt(j)) {
                            found = false;
                            break;
                        }
                    }
                    if (found) {
                        return i;
                    }
                }
            }
            return -1;
        }

        public int lastIndexOf(String str) {
            return lastIndexOf(str, this.count - 1);
        }

        public int lastIndexOf(String str, int fromIndex) {
            if (str == null) {
                return -1;
            }

            int strLen = str.length();
            if (strLen > this.count) {
                return -1;
            }

            int max = this.count - strLen;
            if (fromIndex > max) {
                fromIndex = max;
            }

            if (strLen == 0) {
                return fromIndex;
            }

            char[] value = this.value;
            int i = fromIndex + strLen - 1;

            while (i >= strLen - 1) {
                int j = i - strLen + 1;
                int k = strLen - 1;
                while (value[j] == str.charAt(k)) {
                    if (k == 0) {
                        return j;
                    }
                    j--;
                    k--;
                }
                i--;
            }

            return -1;
        }

        public void setCharAt(int index, char ch) {
            if (index < 0 || index >= this.count) {
                throw new StringIndexOutOfBoundsException(index);
            }

            this.value[index] = ch;
        }

        public void insert(int offset, String str) {
            if (offset < 0 || offset > count) {
                throw new StringIndexOutOfBoundsException(offset);
            }

            int strLength = str.length();
            secureCapacity(count + strLength);

            System.arraycopy(value, offset, value, offset + strLength, count - offset);

            str.getChars(0, strLength, value, offset);

            count += strLength;
        }

        public void insert(int index, String str, int offset, int len) {
            if (index < 0 || index > count || offset < 0 || len < 0 || offset + len > str.length()) {
                throw new StringIndexOutOfBoundsException();
            }

            secureCapacity(count + len);

            System.arraycopy(value, index, value, index + len, count - index);

            str.getChars(offset, offset + len, value, index);

            count += len;
        }

        public void replace(int start, int end, String str) {
            if (start < 0 || start > end || end > count) {
                throw new StringIndexOutOfBoundsException();
            }

            int strLength = str.length();
            int replacementLength = end - start;
            if (strLength > replacementLength) {
                secureCapacity(count + strLength - replacementLength);
            }

            System.arraycopy(value, end, value, start + strLength, count - end);

            str.getChars(0, strLength, value, start);

            count += strLength - replacementLength;
        }

        public void trimToSize() {
            if (count < value.length) {
                value = Arrays.copyOf(value, count);
            }
        }

        public void reverse() {
            int n = count - 1;

            for (int j = (n - 1) >> 1; j >= 0; --j) {
                char temp = value[j];
                value[j] = value[n - j];
                value[n - j] = temp;
            }
        }

        public String substring(int start) {
            if (start < 0 || start > count) {
                throw new StringIndexOutOfBoundsException(start);
            }

            char[] newString = new char[count - start];

            System.arraycopy(value, start, newString, 0, count - start);

            return new String(newString);
        }

        public String substring(int start, int end) {
            if (start < 0 || end > count || start > end) {
                throw new StringIndexOutOfBoundsException();
            }

            char[] newString = new char[end - start];
            System.arraycopy(value, start, newString, 0, end - start);

            return new String(newString);
        }

        public void delete(int start, int end) {
            if (start < 0) {
                throw new StringIndexOutOfBoundsException(start);
            }

            if (end > count) {
                end = count;
            }

            if (start > end) {
                throw new StringIndexOutOfBoundsException();
            }

            int len = end - start;
            if (len > 0) {
                System.arraycopy(value, start + len, value, start, count - end);
                count -= len;
            }
        }

        public void delete(int start) {
            if (start < 0 || start > count) {
                throw new StringIndexOutOfBoundsException(start);
            }

            System.arraycopy(value, start, value, start - 1, count - start);
            count--;
        }

        public String toString() {
            return new String(value, 0, count);
        }
    }
}
package homeworks.homework21;

import java.util.logging.LogRecord;

import static java.util.logging.Level.*;

public class Task2 {
    public static void main(String[] args) {
        Logger logger = new Logger();

        logger.setFormatter(record -> record.getLevel() + ": " + record.getMessage());

        logger.setLogLevel(LogLevel.INFO);

        logger.setFilter(record -> !record.getMessage().contains("filtered"));

        logger.log(new LogRecord(SEVERE, "A severe message"));
        logger.log(new LogRecord(WARNING, "A warning message"));
        logger.log(new LogRecord(INFO, "An info message"));
        logger.log(new LogRecord(CONFIG, "A config message"));
        logger.log(new LogRecord(FINE, "A fine message"));
        logger.log(new LogRecord(FINER, "A finer message"));
        logger.log(new LogRecord(FINEST, "A finest message"));
        logger.log(new LogRecord(INFO, "An info message that should be filtered"));
    }

    public static class Logger {
        private LogFormatter formatter;
        private LogLevel level;
        private LogFilter filter;

        public void setFormatter(LogFormatter formatter) {
            this.formatter = formatter;
        }

        public void setLogLevel(LogLevel level) {
            this.level = level;
        }

        public void setFilter(LogFilter filter) {
            this.filter = filter;
        }

        public void log(LogRecord record) {
            if (record.getLevel().intValue() < level.intValue()) {
                return;
            }

            if (filter != null && !filter.isLoggable(record)) {
                return;
            }

            String message = formatter.format(record);
            System.out.println(message);
        }
    }

    interface LogFormatter {
        String format(LogRecord record);
    }

    interface LogFilter {
        boolean isLoggable(LogRecord record);
    }

    public static class LogLevel {
        public static final LogLevel SEVERE = new LogLevel(1000);
        public static final LogLevel WARNING = new LogLevel(900);
        public static final LogLevel INFO = new LogLevel(800);
        public static final LogLevel CONFIG = new LogLevel(700);
        public static final LogLevel FINE = new LogLevel(500);
        public static final LogLevel FINER = new LogLevel(400);
        public static final LogLevel FINEST = new LogLevel(300);

        private int value;

        private LogLevel(int value) {
            this.value = value;
        }

        public int intValue() {
            return value;
        }
    }
}

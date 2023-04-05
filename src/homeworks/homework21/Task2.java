package homeworks.homework21;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static homeworks.homework21.Task2.LogLevel.*;

public class Task2 {
    public static void main(String[] args) {
        Logger logger = new Logger("name");

        logger.setFormatter(record -> record.logLevel + ": " + record.logMessage);

        logger.setLogLevel(LogLevel.FINEST);

        // logger.setFilter(record -> record.logMessage.contains("warning"));

        logger.log(SEVERE, "A severe message");
        logger.log(WARNING, "A warning message");
        logger.log(INFO, "An info message");
        logger.log(CONFIG, "A config message");
        logger.log(FINE, "A fine message");
        logger.log(FINER, "A finer message");
        logger.log(FINEST, "A finest message");
        logger.log(INFO, "An info message that should be filtered");
    }

    public static class Logger {
        static class DefaultLogFormatter implements LogFormatter {
            private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss,SSS");

            @Override
            public String format(LogRecord record) {
                StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
                String sourceFile = stackTraceElements[stackTraceElements.length - 1].getFileName();
                int lineNumber = stackTraceElements[stackTraceElements.length - 1].getLineNumber();

                return LocalDateTime.now().format(dateFormatter) + " " + record.logLevel + " " + record.loggerName + " (" + sourceFile + ":" + lineNumber + ") - " + record.logMessage;
            }
        }

        private String name = "";

        private LogFormatter formatter = new DefaultLogFormatter();
        private LogLevel level = WARNING;
        private LogFilter filter;

        public Logger(String name) {
            this.name = name;
        }

        public void setFormatter(LogFormatter formatter) {
            this.formatter = formatter;
        }

        public void setLogLevel(LogLevel level) {
            this.level = level;
        }

        public void setFilter(LogFilter filter) {
            this.filter = filter;
        }

        public void log(LogLevel loglevel, String message) {
            if (loglevel.ordinal() < level.ordinal()) {
                return;
            }

            LogRecord logRecord = new LogRecord(name, loglevel, message);
            if (filter != null && !filter.isLoggable(logRecord)) {
                return;
            }

            message = formatter.format(logRecord);
            System.out.println(message);
        }
    }

    interface LogFormatter {
        String format(LogRecord record);
    }

    interface LogFilter {
        boolean isLoggable(LogRecord record);
    }

    static class LogRecord {
        String loggerName;
        LogLevel logLevel;
        String logMessage;

        public LogRecord(String loggerName, LogLevel logLevel, String logMessage) {
            this.loggerName = loggerName;
            this.logLevel = logLevel;
            this.logMessage = logMessage;
        }
    }

    enum LogLevel {
        FINEST, FINER, FINE, CONFIG, INFO, WARNING, SEVERE
    }
}

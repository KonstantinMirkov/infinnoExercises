package tests.test7;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task1 {

    public static void main(String[] args) {
        Logger log = Logger.getLogger("con.infinno.logger");
        log.info("test message");
        log.warning("test warning");
        log.error("test error");
        log.debug("test debug");
        log.fatal("test fatal");
    }

    public static class Logger {
        private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss,SSS");
        private final String name;
        private static Logger logger;

        private Logger(String name) {
            this.name = name;
        }

        public static Logger getLogger(String name) {
            if (logger == null) {
                logger = new Logger(name);
            }
            return logger;
        }

        public void fatal(String message) {
            log(LogLevel.FATAL, message);
        }

        public void error(String message) {
            log(LogLevel.ERROR, message);
        }

        public void warning(String message) {
            log(LogLevel.WARNING, message);
        }

        public void info(String message) {
            log(LogLevel.INFO, message);
        }

        public void debug(String message) {
            log(LogLevel.DEBUG, message);
        }

        public void log(LogLevel level, String message) {
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            String sourceFile = stackTraceElements[stackTraceElements.length - 1].getFileName();
            int lineNumber = stackTraceElements[stackTraceElements.length - 1].getLineNumber();

            System.out.println(LocalDateTime.now().format(formatter) + " " + level + " " + name +
                    " (" + sourceFile + ":" + lineNumber + ") - " + message);
        }
    }

    enum LogLevel {
        FATAL,
        ERROR,
        WARNING,
        INFO,
        DEBUG
    }
}
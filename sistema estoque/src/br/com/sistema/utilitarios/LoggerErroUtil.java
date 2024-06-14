package br.com.sistema.utilitarios;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerErroUtil {
    private static final Logger logger = Logger.getLogger(LoggerErroUtil.class.getName());

    static {
        try {
            String logFilePath = "C:\\Users\\eliza\\OneDrive\\Documentos\\Curso de Java\\sistema estoque\\logs_erro\\erros.log";
            FileHandler fileHandler = new FileHandler(logFilePath, true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Falha ao configurar o Logger de Erro", e);
        }
    }

    public static void log(String message) {
        logger.severe(message);
    }

    public static void log(String message, Throwable throwable) {
        logger.log(Level.SEVERE, message, throwable);
    }
}

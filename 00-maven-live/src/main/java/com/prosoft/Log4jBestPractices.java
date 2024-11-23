package com.prosoft;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.ThreadContext;
import java.io.IOException;

public class Log4jBestPractices {

    private static final Logger LOGGER = LogManager.getLogger(); // Пример 1: Инициализация логгера
    private static final Marker ACCOUNT_MARKER = MarkerManager.getMarker("ACCOUNT"); // Пример 9: Маркеры

    public static void main(String[] args) {
        String userId = "user123";
        String tableName = "users";
        ThreadContext.put("sessionId", "abc123"); // Пример 10: Контекст потока (ThreadContext Map)

        // Пример 2: Использование {} для форматирования, вместо toString() или конкатенации
        LOGGER.info("Работаем с пользователем с ID: {}", userId);

        try {
            // Пример 3: Передача исключения как последнего аргумента
            truncateTable(null);
            //truncateTable(tableName);
        } catch (IOException e) {
            // Пример 4: Логирование исключения на уровне ERROR
            LOGGER.error("Ошибка при очистке таблицы `{}` для пользователя `{}`", tableName, userId, e);
        }

        // Пример 5: Использование лямбд (Suppliers) для логирования вычислительно сложных аргументов
        LOGGER.info("Получение роли пользователя: {}", () -> getUserRole(userId));

        // Пример 6: Логирование с использованием форматов printf
        LOGGER.debug("Форматирование с использованием printf: %s", userId);
        LOGGER.printf(org.apache.logging.log4j.Level.INFO, "Пользователь %s был успешно обработан", userId);

        // Пример 7: Логирование события с использованием метода atInfo() и метки (marker)
        LOGGER.atInfo()
                .withMarker(ACCOUNT_MARKER)
                .log("Удаление пользователя с ID `{}`", userId);

        // Пример 8: Использование потоковых методов traceEntry и traceExit для отслеживания выполнения
        LOGGER.traceEntry();
        performWork();
        LOGGER.traceExit();

        ThreadContext.clearAll(); // Очищаем контекст потока
    }

    // Пример функции, которая выбрасывает исключение
    private static void truncateTable(String tableName) throws IOException {
        if (tableName == null || tableName.isEmpty()) {
            throw new IOException("Название таблицы не должно быть пустым");
        }
        LOGGER.warn("Очистка таблицы `{}`", tableName);
        // Логика очистки таблицы...
    }

    // Пример получения роли пользователя
    private static String getUserRole(String userId) {
        return "ADMIN"; // Заглушка, имитирующая получение роли пользователя
    }

    // Пример функции с использованием traceEntry и traceExit
    private static void performWork() {
        LOGGER.trace("Выполняем некоторую работу...");
        // Здесь выполняется работа...
        LOGGER.trace("Работа выполнена.");
    }
}

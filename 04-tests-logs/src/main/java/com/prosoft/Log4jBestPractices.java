package com.prosoft;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.ThreadContext;
import java.io.IOException;

/**
 * Инициализация логгера (Пример 1) с использованием LogManager.getLogger().
 * Логирование с использованием placeholder {} для форматирования сообщений (Пример 2).
 * Логирование исключения с использованием метода error() и передачи исключения последним аргументом (Пример 3 и Пример 4).
 * Использование лямбд (Suppliers) для передачи вычислительно затратных аргументов (Пример 5).
 * Логирование с использованием форматирования printf (Пример 6).
 * Логирование с использованием маркеров (Markers) для более детализированного контроля логов (Пример 7).
 * Использование traceEntry() и traceExit() для отслеживания выполнения программы (Пример 8).
 * Работа с ThreadContext для передачи контекстных данных (Пример 10).
 */
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
            // truncateTable(null);
            truncateTable(tableName);
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

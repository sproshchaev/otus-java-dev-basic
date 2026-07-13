[![Java](https://img.shields.io/badge/Java-E43222??style=for-the-badge&logo=openjdk&logoColor=FFFFFF)](https://www.java.com/)
# otus-java-dev-basic

**Сергей Прощаев**

[![Email](https://img.shields.io/badge/sproshchaev%40gmail.com-red?logo=gmail&logoColor=white)](mailto:sproshchaev@gmail.com)
[![Website](https://img.shields.io/badge/prosoft.pages.dev-blue?logo=googlechrome&logoColor=white)](https://prosoft.pages.dev)

---

## Демо. Java I/O — символьные потоки и кодировки (слайды 5–12)

Символьные потоки чтения/записи и работа с кодировками. `RandomAccessFile` и
сериализация сюда не входят — они в отдельном демо ниже.

Пакет: `ru.otus.io.text` (`src/main/java/ru/otus/io/text/`).

**Порядок запуска.** Часть примеров использует файлы, созданные в предыдущих:
- Примеры 2, 3, 4 читают `notes.txt` → сначала запустите Пример 1.
- Примеры 8, 9 читают `utf8.txt` → сначала запустите Пример 7.

| №  | Имя класса                 | Что демонстрирует                                                |
|----|----------------------------|------------------------------------------------------------------|
| 1  | `CharFileWriteDemo`        | Запись символов в файл (FileWriter)                              |
| 2  | `CharFileReadDemo`         | Посимвольное чтение файла (FileReader, read())                  |
| 3  | `BulkCharReadDemo`         | Чтение порциями в буфер char[] (read(char[]))                   |
| 4  | `BufferedLineReadDemo`     | Построчное чтение (BufferedReader.readLine())                   |
| 5  | `BufferedLineWriteDemo`    | Буферизованная запись строк (BufferedWriter.newLine())          |
| 6  | `EncodingReadDemo`         | Чтение с явной кодировкой UTF-8 (InputStreamReader)             |
| 7  | `EncodingWriteDemo`        | Запись с явной кодировкой UTF-8 (OutputStreamWriter)            |
| 8  | `WrongEncodingDemo`        | «Кракозябры» при неверной кодировке (UTF-8 против ISO-8859-1)   |
| 9  | `BufferedEncodingReadDemo` | Построчное чтение в UTF-8 (BufferedReader + InputStreamReader)  |
| 10 | `FormattedWriteDemo`       | Форматированный вывод в файл (PrintWriter)                      |

---

## Демо. Java I/O — RandomAccessFile (слайд 14)

Работа с файлом в произвольном порядке через `RandomAccessFile`: позиционирование,
чтение/запись с любой позиции, запись примитивов и доступ к записям по индексу.

Пакет: `ru.otus.io.raf` (`src/main/java/ru/otus/io/raf/`).

**Запуск.** Все примеры самодостаточны — каждый сам создаёт нужный файл, поэтому
запускать их можно в любом порядке и сколько угодно раз.

**Важно про байты и символы.** `RandomAccessFile` — байтоориентированный класс
(реализует `DataInput`/`DataOutput`, а не `Reader`/`Writer`). В текстовых примерах
используется `writeBytes` (один байт на символ, только ASCII/латиница); для строк с
кириллицей есть `writeUTF` — он корректно сохраняет Unicode (Пример 7).

| № | Имя класса             | Что демонстрирует                                             |
|---|------------------------|--------------------------------------------------------------|
| 1 | `RafWriteDemo`         | Запись в файл в режиме "rw" (writeBytes, length)             |
| 2 | `RafSeekReadDemo`      | Чтение с позиции через seek (пример со слайда)               |
| 3 | `RafFilePointerDemo`   | Позиция указателя: getFilePointer() и его перемещение        |
| 4 | `RafAppendDemo`        | Размер файла и добавление в конец (length, seek(length()))   |
| 5 | `RafOverwriteDemo`     | Изменение данных на месте без перезаписи всего файла         |
| 6 | `RafPrimitivesDemo`    | Примитивы через DataOutput/DataInput (writeInt/readDouble…)  |
| 7 | `RafUtfStringsDemo`    | Строки с Unicode через writeUTF/readUTF                      |
| 8 | `RafFixedRecordsDemo`  | Доступ к записи по номеру (записи фиксированной длины)       |

---

## Демо. Java I/O — Сериализация (слайд 16)

Сериализация и десериализация объектов через `ObjectOutputStream` / `ObjectInputStream`:
маркерный интерфейс `Serializable`, поля `transient` и `static`, граф объектов,
коллекции и версии классов через `serialVersionUID`.

Пакет: `ru.otus.io.serialization` (`src/main/java/ru/otus/io/serialization/`).

**Запуск.** Пример 2 использует файл, созданный в Примере 1 (запустите сначала
Пример 1). Примеры 3–8 самодостаточны — каждый сам сериализует и тут же десериализует
объект.

**Модель данных.** В Примерах 1–2 используется общий класс `User` (отдельный файл).
В Примерах 3–8 каждый определяет собственный небольшой класс-модель прямо внутри себя.

| № | Имя класса              | Что демонстрирует                                            |
|---|-------------------------|-------------------------------------------------------------|
| 1 | `SerializeDemo`         | Сериализация объекта (ObjectOutputStream.writeObject)       |
| 2 | `DeserializeDemo`       | Десериализация объекта (ObjectInputStream.readObject)       |
| 3 | `NotSerializableDemo`   | Без Serializable — NotSerializableException                 |
| 4 | `TransientDemo`         | Поле transient не сериализуется                             |
| 5 | `StaticFieldDemo`       | Поле static не является частью объекта                      |
| 6 | `ObjectGraphDemo`       | Граф объектов: сохраняются и вложенные объекты по ссылке    |
| 7 | `CollectionDemo`        | Сериализация коллекции (List) одним вызовом                 |
| 8 | `SerialVersionUidDemo`  | Версии класса и serialVersionUID                            |

Вспомогательный класс: `User` — общая модель для Примеров 1–2.

---

### References
1. Collections-framework-demo https://github.com/sproshchaev/collections-framework-demo/

![duke.svg](src/main/resources/images/duke.svg)

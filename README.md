[![Java](https://img.shields.io/badge/Java-E43222??style=for-the-badge&logo=openjdk&logoColor=FFFFFF)](https://www.java.com/)
# otus-java-dev-basic

**Сергей Прощаев**

[![Website](https://img.shields.io/badge/prosoft.pages.dev-blue?logo=googlechrome&logoColor=white)](https://prosoft.pages.dev)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-sproshchaev-0A66C2)](https://www.linkedin.com/in/sproshchaev/)
[![Habr](https://img.shields.io/badge/Habr-sproshchaev-65A3BE?logo=habr&logoColor=white)](https://habr.com/ru/users/sproshchaev/)

---

Examples from webinars

![duke.svg](src/main/resources/images/duke.svg)

## Открытый урок «Пишем веб-сервер на Java»

Примеры лежат в `src/main/java/ru/otus/webserver`. В `TcpDemo` принимаем TCP-соединение, в `RawHttpDemo` читаем запрос и отправляем фиксированный ответ. `Main` запускает сервер с маршрутами и пулом потоков.

Для запуска нужны JDK 17 и Maven. Из корня проекта:

```bash
mvn -q compile
java -Djava.net.preferIPv4Stack=true -cp target/classes ru.otus.webserver.Main
```

Откройте `http://127.0.0.1:8080/` в браузере или выполните команды во втором терминале.

```bash
curl -i http://127.0.0.1:8080/hello
curl -i http://127.0.0.1:8080/api/info
curl -i http://127.0.0.1:8080/unknown
curl -i -X POST http://127.0.0.1:8080/hello
```

Учебный сервер слушает только `127.0.0.1`, обрабатывает один запрос на соединение и поддерживает GET. Для просмотра промежуточных запусков в первой команде Java замените `Main` на `TcpDemo` или `RawHttpDemo`. Каждый сервер занимает порт 8080, останавливайте его через Ctrl+C перед следующим запуском.

### References
1. Collections-framework-demo https://github.com/sproshchaev/collections-framework-demo/

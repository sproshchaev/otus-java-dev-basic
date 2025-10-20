
Запускает интерактивную сессию MongoDB Shell, подключаясь к базе данных MongoDB, которая работает в контейнере 
с именем mongo внутри Docker-сети otus-java-dev-basic_default, используя учётные данные root:password.
```bash
docker run -it --rm --network otus-java-dev-basic_default mongo:8.0 mongosh "mongodb://root:password@mongo:27017"
```

Выйти из консоли
```text
exit
```
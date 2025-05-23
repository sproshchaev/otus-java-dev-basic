package ru.otus.java.basic.http.server;

import com.google.gson.Gson;
import ru.otus.java.basic.http.server.application.ItemsRepository;
import ru.otus.java.basic.http.server.exceptions.BadRequestException;
import ru.otus.java.basic.http.server.exceptions.ErrorDto;
import ru.otus.java.basic.http.server.processors.*;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Dispatcher {
    private Map<String, RequestProcessor> processors;
    private ItemsRepository itemsRepository;
    private RequestProcessor defaultNotFoundProcessor;
    private RequestProcessor defaultStaticResourceProcessor;

    public Dispatcher() {
        this.itemsRepository = new ItemsRepository();
        this.processors = new HashMap<>();
        this.processors.put("GET /hello", new HelloProcessor());
        this.processors.put("GET /calculator", new CalculatorProcessor());
        this.processors.put("GET /items", new GetItemProcessor(itemsRepository));
        this.processors.put("POST /items", new CreateItemProcessor(itemsRepository));
        this.defaultNotFoundProcessor = new DefaultNotFoundProcessor();
        this.defaultStaticResourceProcessor = new DefaultStaticResourcesProcessor();
    }

    public void execute(HttpRequest request, OutputStream output) throws IOException {
        if (Files.exists(Paths.get("static/", request.getUri().substring(1)))) {
            defaultStaticResourceProcessor.execute(request, output);
            return;
        }
        if (!processors.containsKey(request.getRoutingKey())) {
            defaultNotFoundProcessor.execute(request, output);
            return;
        }
        try {
            processors.get(request.getRoutingKey()).execute(request, output);
        } catch (BadRequestException e) {
            Gson gson = new Gson();
            ErrorDto errorDto = new ErrorDto(e.getCode(), e.getMessage());
            String errorDtoJson = gson.toJson(errorDto);
            String response = "" +
                    "HTTP/1.1 400 Bad Request\r\n" +
                    "Content-Type: application/json\r\n" +
                    "\r\n" + errorDtoJson;
            output.write(response.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            // 500 Internal Server Error
        }
    }
}

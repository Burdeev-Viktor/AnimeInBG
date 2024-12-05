package com.example.AnimeInBG.service.aniList;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class AniListClient {

    // HttpClient для выполнения запросов
    private final HttpClient webClient;

    public AniListClient(HttpClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public String getAnimeInfoById(Long animeId) throws Exception {
        // Формируем GraphQL-запрос
        String query = "{\n" +
                "  Media(id: " + animeId + ", type: ANIME) {\n" +
                "    id\n" +
                "    title {\n" +
                "      romaji\n" +
                "      english\n" +
                "    }\n" +
                "    coverImage {\n" +
                "      large\n" +
                "    }\n" +
                "    description\n" +
                "    genres\n" +
                "    episodes\n" +
                "    averageScore\n" +
                "    format\n" +
                "    status\n" +
                "    studios {\n" +
                "      edges {\n" +
                "        node {\n" +
                "          name\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";

        // Формируем JSON-тело для GraphQL-запроса
        String body = "{\"query\": \"" + query.replace("\"", "\\\"").replace("\n", "") + "\", \"variables\": null}";

        // Формируем HTTP-запрос
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://graphql.anilist.co")) // Адрес API AniList
                .header("Content-Type", "application/json") // Указываем формат данных
                .POST(HttpRequest.BodyPublishers.ofString(body)) // Указываем тело запроса
                .build();

        // Выполняем HTTP-запрос и получаем ответ
        HttpResponse<String> response = webClient.send(request, HttpResponse.BodyHandlers.ofString());

        // Проверяем код состояния ответа на наличие ошибок
        if (response.statusCode() >= 400) {
            throw new RuntimeException("Ошибка при запросе к AniList API: " + response.body());
        }

        // Возвращаем тело ответа в формате JSON
        return response.body();
    }


    public void getAnimeFromAniListById(Long animeId) {
        try {
            // Создаем экземпляр клиента
            HttpClient.Builder builder = HttpClient.newBuilder();
            AniListClient client = new AniListClient(builder);

            // Выполняем запрос к API AniList
            String response = client.getAnimeInfoById(animeId);
            System.out.println(response); // Выводим результат в консоль
        } catch (Exception e) {
            e.printStackTrace(); // Выводим стек ошибки в случае сбоя
        }
    }
}

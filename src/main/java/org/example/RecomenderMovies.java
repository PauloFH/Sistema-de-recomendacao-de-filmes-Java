package org.example;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.example.builder.RecomendationBuilder;
import org.example.recomender.Recomandation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecomenderMovies {

    public String recomendation(long userID, int qt) throws IOException, TasteException {
        StringBuilder st = new StringBuilder();

        DataModel movies = new Recomandation().getModelfilmes();
        Recommender recommender = new RecomendationBuilder().buildRecommender(movies);

        Map<String, String> movieIdToNameMap = loadMovieIdToNameMap("movies2.csv");

        List<RecommendedItem> recommendations = recommender.recommend(userID, qt);

        System.out.println("Você pode gostar desses filmes !!!");
        for (RecommendedItem recommendation : recommendations) {
            long movieID = recommendation.getItemID();
            String movieName = movieIdToNameMap.get(String.valueOf(movieID)); // Obtenha o nome do filme a partir do mapa

            if (movieName != null) {
                st.append("Filme: ").append(movieName).append(", Pontuação: ").append(recommendation.getValue()).append("\n");
            } else {
                st.append("Filme (ID não encontrado): ").append(movieID).append(", Pontuação: ").append(recommendation.getValue()).append("\n");
            }
        }

        return st.toString();
    }

    private Map<String, String> loadMovieIdToNameMap(String moviesCsvFilePath) throws IOException {
        Map<String, String> movieIdToNameMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/"+moviesCsvFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String movieID = parts[0];
                    String movieName = parts[1];
                    movieIdToNameMap.put(movieID, movieName);
                }
            }
        }
        return movieIdToNameMap;
    }
}

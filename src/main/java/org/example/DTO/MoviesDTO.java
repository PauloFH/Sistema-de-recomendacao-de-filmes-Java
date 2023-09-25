package org.example.DTO;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MoviesDTO {

    public static String getMovies(String id) {
            StringBuilder r = new StringBuilder();
        try {
            // Carregue o arquivo CSV que contém as avaliações dos usuários
            BufferedReader ratingsReader = new BufferedReader(new FileReader("src/main/resources/treinamento.csv"));
            String ratingsLine;

            // Estrutura de dados para armazenar as avaliações do usuário para cada filme
            Map<String, Double> userRatings = new HashMap<>();

            while ((ratingsLine = ratingsReader.readLine()) != null) {
                String[] ratingsData = ratingsLine.split(",");
                String csvUserId = ratingsData[0];
                String movieId = ratingsData[1];
                double rating = Double.parseDouble(ratingsData[2]); // Converte a avaliação para double

                // Verifique se a avaliação pertence ao usuário desejado
                if (csvUserId.equals(id)) {
                    userRatings.put(movieId, rating); // Armazene a avaliação no mapa
                }
            }

            ratingsReader.close();

            // Carregue o arquivo CSV que contém informações sobre os filmes
            BufferedReader moviesReader = new BufferedReader(new FileReader("src/main/resources/movies.csv"));
            String moviesLine;

            while ((moviesLine = moviesReader.readLine()) != null) {
                String[] movieData = moviesLine.split(",");
                String movieId = movieData[0];
                String movieTitle = movieData[1];

                // Verifique se o filme foi avaliado pelo usuário
                if (userRatings.containsKey(movieId)) {
                    double userRating = userRatings.get(movieId);
                    r.append("Filme: ").append(movieTitle).append(", Avaliação: ").append(userRating).append("\n");
                }
            }

            moviesReader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return r.toString();
    }
}


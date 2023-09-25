package org.example;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.example.builder.RecomendationBuilder;
import org.example.recomender.Recomandation;

import java.io.IOException;
import java.util.List;
public class RecomenderMovies {

    public static void main(String[] args) throws IOException, TasteException {
        int controller = 0;
        DataModel movies = new Recomandation().getModelfilmes();
        Recommender recommender = new RecomendationBuilder().buildRecommender(movies);
        List<RecommendedItem> recommendations = recommender.recommend(4000,10);

        System.out.println("Você pode gostar desses filmes !!!");
        for(RecommendedItem recommendation : recommendations) {
            System.out.println(recommendation);
        }
    }
}


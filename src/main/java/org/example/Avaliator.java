package org.example;

import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.common.RandomUtils;
import org.example.builder.RecomendationBuilder;
import org.example.recomender.Recomandation;

import java.io.IOException;
import java.io.PushbackInputStream;

public class Avaliator {

    public static void main(String[] args) throws IOException,TasteException{
        RandomUtils.useTestSeed();
        DataModel dataModel = new Recomandation().getModelfilmes();
        RecommenderEvaluator eval = new AverageAbsoluteDifferenceRecommenderEvaluator();
        RecomendationBuilder builder = new RecomendationBuilder();
        double e = eval.evaluate(builder, null,dataModel, 0.9,1.0);
        System.out.println("A taxa de erro de recomendação atual é: " + e);

    }
}

package org.example.view;

import org.apache.mahout.cf.taste.common.TasteException;
import org.example.DTO.MoviesDTO;
import org.example.RecomenderMovies;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UserInterface {

    private final JFrame frame;
    private final JTextField userIDField;
    private final JTextField numRecommendationsField; // Campo para especificar o número de recomendações
    private final JTextArea movieListArea;

    public UserInterface() {
        frame = new JFrame("Sistema de Recomendação de Filmes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tela para inserir o ID do usuário e o número de recomendações desejadas
        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel userIDLabel = new JLabel("Digite seu ID de usuário:");
        userIDField = new JTextField(10);
        JLabel numRecommendationsLabel = new JLabel("Número de Recomendações:");
        numRecommendationsField = new JTextField(3); // Campo para especificar o número de recomendações
        JButton submitButton = new JButton("Enviar");
        JButton recommendButton = new JButton("Calcular Recomendação");

        inputPanel.add(userIDLabel);
        inputPanel.add(userIDField);
        inputPanel.add(numRecommendationsLabel);
        inputPanel.add(numRecommendationsField);
        inputPanel.add(submitButton);
        inputPanel.add(recommendButton);

        // Tela para mostrar os filmes e avaliações
        movieListArea = new JTextArea(10, 40);
        movieListArea.setEditable(false);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(new JScrollPane(movieListArea), BorderLayout.CENTER);

        // Ação quando o botão "Enviar" é clicado
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obter o ID do usuário inserido
                String userID = userIDField.getText();
                // Aqui você deve implementar a lógica para obter os filmes e avaliações para o usuário com o ID fornecido
                // e exibi-los na área de texto 'movieListArea'.
                // Suponha que você tenha uma função 'getMoviesAndRatings' para obter os dados do usuário.
                String moviesAndRatings = getMoviesAndRatings(userID);

                // Exibir os filmes e avaliações na área de texto
                movieListArea.setText(moviesAndRatings);

                // Redimensionar a janela com base no conteúdo
                frame.pack();
            }
        });

        // Ação quando o botão "Calcular Recomendação" é clicado
        recommendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obter o ID do usuário inserido e o número de recomendações desejadas
                String userID = userIDField.getText();
                int numRecommendations = Integer.parseInt(numRecommendationsField.getText()); // Converter para int
                // Aqui você deve implementar a lógica para calcular a recomendação com base no ID do usuário e no número de recomendações
                // e exibi-la na área de texto 'movieListArea'.
                // Suponha que você tenha uma função 'calculateRecommendation' para calcular as recomendações.
                String recommendations = calculateRecommendation(userID, numRecommendations);

                // Exibir as recomendações na área de texto
                movieListArea.setText(recommendations);

                // Redimensionar a janela com base no conteúdo
                frame.pack();
            }
        });

        // Redimensionar a janela com base no conteúdo inicial
        frame.pack();
    }

    // Função de exemplo para obter os filmes e avaliações do usuário (você deve implementar sua própria lógica)
    private String getMoviesAndRatings(String userID) {
        return MoviesDTO.getMovies(userID);
    }

    // Função de exemplo para calcular recomendações (você deve implementar sua própria lógica)
    private String calculateRecommendation(String userID, int numRecommendations) {
        RecomenderMovies rm = new RecomenderMovies();

        try {
            return rm.recomendation(Long.parseLong(userID), numRecommendations);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TasteException e) {
            throw new RuntimeException(e);
        }
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UserInterface ui = new UserInterface();
                ui.show();
            }
        });
    }
}

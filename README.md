
# Sistema de Recomendação de Filmes

Este é um sistema de recomendação de filmes simples desenvolvido em Java usando o Apache Mahout. O sistema permite que os usuários insiram seus IDs e obtenham recomendações de filmes com base em suas avaliações e preferências.

## Funcionalidades

- Visualizar a lista de filmes e avaliações do usuário.
- Calcular recomendações personalizadas para o usuário.
- Retorna filmes que estão condizentes com os interesses do usuário

## Pré-requisitos

- Java (versão 8 ou superior)
- Apache Mahout (incluído no projeto)
- Arquivos CSV de dados de avaliação de filmes (`ratings.csv`) e informações sobre filmes (`movies.csv`)

## Como Usar

1. Clone o repositório para o seu ambiente local:

```bash
git clone https://github.com/seu-usuario/seu-projeto.git
cd seu-projeto
```

2. Compile e execute o projeto:

```bash
javac -cp .:lib/* org/example/view/UserInterface.java
java -cp .:lib/* org.example.view.UserInterface
```

3. Na interface de usuário, insira o ID do usuário e clique em "Enviar" para ver a lista de filmes e avaliações do usuário. Clique em "Calcular Recomendação" para obter recomendações personalizadas.

## Estrutura do Projeto

- `src/main`: Contém o código-fonte Java.
- `src/main/resources`: Contém os arquivos CSV de dados de avaliação de filmes e informações sobre filmes.
- `lib`: Contém as bibliotecas necessárias, incluindo o Apache Mahout.

## Personalização

- Você pode personalizar a lógica de recomendação no arquivo `UserInterface.java`.
- Substitua os arquivos CSV de dados de avaliação de filmes e informações sobre filmes pelos seus próprios dados, se necessário.


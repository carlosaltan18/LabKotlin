package uvg.edu.lab5carlosaltan.data

import uvg.edu.lab5carlosaltan.model.Article

object ArticleRepository {
    val technologyArticles: List<Article> = listOf(
        Article(
            author = "Pablo Vasquez",
            title = "El puente que escucha antes de moverse",
            excerpt = "Sensores sencillos están ayudando a detectar vibraciones antes de que una estructura necesite una reparación costosa.",
            readingMinutes = 6,
            date = "18 ago",
            isAuthorFollowed = true,
            isFeatured = false
        ),
        Article(
            author = "Angel Sanabria",
            title = "Diseñar baterías para el calor de la ciudad",
            excerpt = "La ingeniería térmica permite que las celdas duren más cuando el tráfico y el sol elevan la temperatura.",
            readingMinutes = 8,
            date = "15 ago",
            isAuthorFollowed = false,
            isFeatured = false
        ),
        Article(
            author = "Sofia Saraí",
            title = "Un dron que mide los cultivos sin tocarlos",
            excerpt = "Cámaras y mapas de color convierten un vuelo corto en decisiones más precisas para el riego.",
            readingMinutes = 5,
            date = "11 ago",
            isAuthorFollowed = false,
            isFeatured = true
        )
    )
}

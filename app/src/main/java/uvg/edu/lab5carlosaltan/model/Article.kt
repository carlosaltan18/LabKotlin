package uvg.edu.lab5carlosaltan.model

data class Article(
    val author: String,
    val title: String,
    val excerpt: String,
    val readingMinutes: Int,
    val date: String,
    val isAuthorFollowed: Boolean,
    val isFeatured: Boolean
)

/*
Quita el weight de la columna del artículo, observa el @Preview y describe qué le pasó a la pantalla y por qué:
R: Sin weight, la columna solo ocupa el ancho de su contenido y deja espacio libre antes de la miniatura.
Con weight ocupa el espacio sobrante del Row, por lo que el texto se ajusta y la miniatura conserva su tamaño fijo.

¿Por qué tu componente de artículo recibe un Modifier por parámetro en lugar de fijar su propio margen adentro?
El Modifier deja que cada pantalla decida el margen exterior que necesita para colocar el artículo.
Así el mismo componente puede reutilizarse con espaciados distintos sin editarlo ni duplicar su código.
*/
package uvg.edu.lab5carlosaltan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uvg.edu.lab5carlosaltan.data.ArticleRepository
import uvg.edu.lab5carlosaltan.model.Article
import uvg.edu.lab5carlosaltan.ui.components.ArticleItem
import uvg.edu.lab5carlosaltan.ui.components.FeedTabs
import uvg.edu.lab5carlosaltan.ui.components.PublicationHeader
import uvg.edu.lab5carlosaltan.ui.theme.Lab5CarlosAltanTheme
import uvg.edu.lab5carlosaltan.ui.theme.avatarColors
import uvg.edu.lab5carlosaltan.ui.theme.thumbnailColors

@Composable
fun FeedScreen(
    articles: List<Article>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFFFEFC))
    ) {
        PublicationHeader(
            publicationName = "Circuito Humano"
        )
        FeedTabs(
            tabs = listOf("Para ti", "Laboratorio", "Futuro"),
            selectedTabIndex = 0
        )
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color(0xFFE5E5E5)
        )

        articles.forEachIndexed { index, article ->
            ArticleItem(
                article = article,
                avatarColor = avatarColors[index % avatarColors.size],
                thumbnailColor = thumbnailColors[index % thumbnailColors.size]
            )
            if (index < articles.lastIndex) {
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    thickness = 1.dp,
                    color = Color(0xFFE5E5E5)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun FeedScreenPreview() {
    Lab5CarlosAltanTheme(dynamicColor = false) {
        FeedScreen(articles = ArticleRepository.technologyArticles)
    }
}

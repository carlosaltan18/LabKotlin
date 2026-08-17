/*
Quita el weight de la columna del artículo, observa el @Preview y describe qué le pasó a la pantalla y por qué:
R: Sin weight, la columna solo ocupa el ancho de su contenido y deja espacio libre antes de la miniatura.
Con weight ocupa el espacio sobrante del Row, por lo que el texto se ajusta y la miniatura conserva su tamaño fijo.

¿Por qué tu componente de artículo recibe un Modifier por parámetro en lugar de fijar su propio margen adentro?
El Modifier deja que cada pantalla decida el margen exterior que necesita para colocar el artículo.
Así el mismo componente puede reutilizarse con espaciados distintos.
*/
package uvg.edu.lab5carlosaltan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    var searchQuery by rememberSaveable { mutableStateOf("") }
    var showShortReadsOnly by rememberSaveable { mutableStateOf(false) }

    val visibleArticles = articles.filter { article ->
        val matchesQuery = searchQuery.isBlank() ||
            article.title.contains(searchQuery, ignoreCase = true) ||
            article.author.contains(searchQuery, ignoreCase = true)
        val matchesShortRead = !showShortReadsOnly || article.readingMinutes <= 5
        matchesQuery && matchesShortRead
    }
    val resultCount = visibleArticles.size

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFFFEFC))
    ) {
        PublicationHeader(publicationName = "Circuito Humano")
        FeedTabs(
            tabs = listOf("Para ti", "Siguiendo", "Destacados"),
            selectedTabIndex = 0
        )
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color(0xFFE5E5E5)
        )

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            label = { Text("Buscar por título o autor") },
            singleLine = true
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Switch(
                    checked = showShortReadsOnly,
                    onCheckedChange = { showShortReadsOnly = it }
                )
                Text(text = "Solo lecturas cortas", fontSize = 14.sp)
            }
            Text(
                text = "$resultCount ${if (resultCount == 1) "resultado" else "resultados"}",
                color = Color(0xFF168AC4),
                fontSize = 14.sp
            )
        }

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            thickness = 1.dp,
            color = Color(0xFFE5E5E5)
        )

        if (visibleArticles.isEmpty()) {
            EmptyResults()
        } else {
            visibleArticles.forEachIndexed { index, article ->
                val originalIndex = articles.indexOf(article)
                ArticleItem(
                    article = article,
                    avatarColor = avatarColors[originalIndex % avatarColors.size],
                    thumbnailColor = thumbnailColors[originalIndex % thumbnailColors.size]
                )
                if (index < visibleArticles.lastIndex) {
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        thickness = 1.dp,
                        color = Color(0xFFE5E5E5)
                    )
                }
            }
        }
    }
}

@Composable
private fun EmptyResults() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "No se encontraron artículos",
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4B5563)
        )
        Text(
            text = "Cambia la búsqueda o el filtro.",
            color = Color(0xFF6B7280),
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun FeedScreenPreview() {
    Lab5CarlosAltanTheme(dynamicColor = false) {
        FeedScreen(articles = ArticleRepository.technologyArticles)
    }
}

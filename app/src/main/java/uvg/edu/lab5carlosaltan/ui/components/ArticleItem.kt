package uvg.edu.lab5carlosaltan.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uvg.edu.lab5carlosaltan.model.Article
import uvg.edu.lab5carlosaltan.ui.theme.Lab5CarlosAltanTheme

@Composable
fun ArticleItem(
    article: Article,
    avatarColor: Color,
    thumbnailColor: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.Top
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(7.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(avatarColor)
                )
                Text(
                    text = article.author,
                    color = Color(0xFF666666),
                    fontFamily = FontFamily.Serif,
                    fontSize = 12.sp
                )
            }

            Text(
                text = article.title,
                color = Color(0xFF202124),
                fontFamily = FontFamily.Serif,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 22.sp
            )

            Text(
                text = article.excerpt,
                color = Color(0xFF656565),
                fontFamily = FontFamily.Serif,
                fontSize = 14.sp,
                lineHeight = 18.sp
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${article.readingMinutes} min de lectura · ${article.date}",
                    color = Color(0xFF777777),
                    fontSize = 12.sp
                )
            }
        }

        Box(
            modifier = Modifier
                .size(80.dp)
                .background(thumbnailColor)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ArticleItemPreview() {
    Lab5CarlosAltanTheme(dynamicColor = false) {
        ArticleItem(
            article = Article(
                author = "Douglas Barrios",
                title = "Ciencias de la computación",
                excerpt = "Las ciecnias de la computación y su relación con otras ciencias.",
                readingMinutes = 6,
                date = "18 ago"
            ),
            avatarColor = Color(0xFFFFA45B),
            thumbnailColor = Color(0xFFE2D4BB)
        )
    }
}

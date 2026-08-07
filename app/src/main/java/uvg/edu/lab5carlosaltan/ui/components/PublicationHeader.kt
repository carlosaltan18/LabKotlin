/*
 * Asistencia de IA: OpenAI ChatGPT consulta realizada el 6 de agosto de 2026.
 * Se utilizó como apoyo para estructurar este componente reutilizable de Jetpack Compose.
 * Referencia: https://openai.com/codex/
 */
package uvg.edu.lab5carlosaltan.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import uvg.edu.lab5carlosaltan.ui.theme.Lab5CarlosAltanTheme

@Composable
fun PublicationHeader(
    publicationName: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF17324D)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "C",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )
            }
            Text(
                text = publicationName,
                color = Color(0xFF202124),
                fontFamily = FontFamily.Serif,
                fontSize = 19.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Box(
            modifier = Modifier
                .size(28.dp)
                .clip(CircleShape)
                .background(Color(0xFFC2E6D4))
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PublicationHeaderPreview() {
    Lab5CarlosAltanTheme(dynamicColor = false) {
        PublicationHeader(publicationName = "Circuito Humano")
    }
}

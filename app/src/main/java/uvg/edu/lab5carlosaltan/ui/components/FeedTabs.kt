package uvg.edu.lab5carlosaltan.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uvg.edu.lab5carlosaltan.ui.theme.Lab5CarlosAltanTheme

@Composable
fun FeedTabs(
    tabs: List<String>,
    selectedTab: String,
    onTabSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        tabs.forEachIndexed { index, tab ->
            val isSelected = tab == selectedTab
            Text(
                text = tab,
                modifier = Modifier
                    .weight(1f)
                    .clickable { onTabSelected(tab) },
                color = if (isSelected) Color(0xFF17324D) else Color(0xFF6C6C6C),
                fontSize = 13.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                textAlign = TextAlign.Start
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun FeedTabsPreview() {
    Lab5CarlosAltanTheme(dynamicColor = false) {
        FeedTabs(
            tabs = listOf("Para ti", "Laboratorio", "Futuro"),
            selectedTab = "Para ti",
            onTabSelected = {}
        )
    }
}

package uvg.edu.lab5carlosaltan.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import uvg.edu.lab5carlosaltan.model.Article

// @Preview(showBackground = true, showSystemUi = true)
@Composable
fun MidiumArticle(article: Article, modifier: Modifier = Modifier){
   Row() {
       Column() {
           Row() {
               Box(){
               }
               Text(text = article.name,
                    color = Color.Gray)
           }
       }
   }
}
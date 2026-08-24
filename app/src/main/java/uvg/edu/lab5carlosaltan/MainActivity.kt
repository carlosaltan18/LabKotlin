/*
 * Asistencia de IA: OpenAI ChatGPT consulta realizada el 6 de agosto de 2026.
 * Se utilizó como apoyo para organizar la pantalla y aplicar la sintaxis de Jetpack Compose.
 * Referencia: https://openai.com/codex/
 */
package uvg.edu.lab5carlosaltan

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import uvg.edu.lab5carlosaltan.data.ArticleRepository
import uvg.edu.lab5carlosaltan.ui.screens.FeedScreen
import uvg.edu.lab5carlosaltan.ui.theme.Lab5CarlosAltanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LIFECYCLE_TAG, "onCreate")
        enableEdgeToEdge()
        setContent {
            Lab5CarlosAltanTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FeedScreen(
                        articles = ArticleRepository.technologyArticles,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(LIFECYCLE_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LIFECYCLE_TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LIFECYCLE_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LIFECYCLE_TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIFECYCLE_TAG, "onDestroy")
    }

    private companion object {
        const val LIFECYCLE_TAG = "LAB6_25772"
    }
}

package ankit.app.myrecipeapp

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

@Composable
fun RecipeScreen(
    viewstate: MainViewModel.RecipeState,
    navigateToDetail: (Category) -> Unit
){
    Box(modifier= Modifier.fillMaxSize()){
        when {
            viewstate.loading -> {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
            viewstate.error!= null -> {
                Text(text = "Error Occurred")
            }
            else ->{
                CategoryScreen(categories = viewstate.list, navigateToDetail)
            }
        }

    }
}


@Composable
fun CategoryScreen(categories: List<Category>, navigateToDetail:(Category)-> Unit){
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Text(text = "Recipe List",
                modifier = Modifier.paddingFromBaseline(top = 80.dp),
                fontFamily = FontFamily.Cursive,
                color = Color(0xFFEA4C2A),
                fontSize = 50.sp,
                fontWeight = FontWeight.ExtraBold
                )
        }
        LazyVerticalGrid(GridCells.Fixed(2)) {
            items(categories){
                    category -> CategoryItem(category = category,navigateToDetail)
            }
        }
    }

}

@Composable
fun CategoryItem(category: Category, navigateToDetail:(Category)-> Unit){
    Column(modifier = Modifier.padding(8.dp).fillMaxSize().clickable{ navigateToDetail(category)},
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier.fillMaxSize().aspectRatio(1f)
        )
        Text(text = category.strCategory,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 4.dp))
    }
}

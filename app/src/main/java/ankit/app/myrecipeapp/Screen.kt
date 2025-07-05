package ankit.app.myrecipeapp

sealed class Screen(val route:String) {
    object RecipeScreen: Screen("recipescreen")
    object DetailedScreen: Screen("detailedscreen")
}
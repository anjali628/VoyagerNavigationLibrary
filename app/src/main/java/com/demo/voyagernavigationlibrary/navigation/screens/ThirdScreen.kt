package com.demo.voyagernavigationlibrary.navigation.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

data class ThirdScreen (
    val name:String
        ):Screen{
    @Composable
    override fun Content() {
        Text(text = "Hey $name")
    }

}
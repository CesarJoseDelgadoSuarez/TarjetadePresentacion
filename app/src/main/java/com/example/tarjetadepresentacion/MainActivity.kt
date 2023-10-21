package com.example.tarjetadepresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjetadepresentacion.ui.theme.TarjetaDePresentacionTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarjetaDePresentacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    runApp()
                }
            }
        }
    }
}

@Composable
fun runApp(){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color(0xff41497e)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        ImageAndroidAndUserName(fullName="César José Delgado Suárez",title="Alumno de PAMN en la ULPGC")
        UserInfo(phoneInfo = "666 77 88 99", socialMediaInfo = "@CesarDEV", emailInfo = "cesardev@gmail.com")
    }
}

@Composable
fun ImageAndroidAndUserName(fullName: String,title: String, modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.android_logo)
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier,
    ){
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .size(150.dp)
        )
        Text(
            text = fullName,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            color = Color.White

        )
        Text(
            text = title,
            modifier = modifier,
            color = Color.White
        )    }
}



@Composable
fun iconAndInfo(icon: Painter, info: String, modifier: Modifier = Modifier ){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 40.dp, top = 10.dp),
        ){
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp),
        )
        Text(
            text = info,
            modifier = Modifier.padding(start = 25.dp),
            color = Color.White
        )
    }
}

@Composable
fun UserInfo(phoneInfo: String, socialMediaInfo: String, emailInfo: String, modifier: Modifier = Modifier){
    val phoneIcon: Painter = painterResource(id = R.drawable.phone_icon_telephone_icon_symbol_for_app_and_messenger_vector)
    val socialMediaIcon: Painter = painterResource(id = R.drawable.at_icon_icons_com_50456)
    val emailIcon: Painter = painterResource(id = R.drawable.correo)

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(10.dp)
        ){
        iconAndInfo(icon = phoneIcon, info = phoneInfo)
        iconAndInfo(icon = socialMediaIcon, info = socialMediaInfo)
        iconAndInfo(icon = emailIcon, info = emailInfo)
    }
}

@Preview(showBackground = false)
@Composable
fun NameAndTitle() {
    TarjetaDePresentacionTheme {
        runApp()
    }
}
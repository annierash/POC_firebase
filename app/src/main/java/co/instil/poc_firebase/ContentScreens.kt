package co.instil.poc_firebase


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.compose.ui.platform.LocalContext
import co.instil.poc_firebase.utils.*



class ContentScreens {

}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.purple_200))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Home View",
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.black),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Composable
fun AccountScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.purple_200))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Account View",
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.black),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
        Row(
            modifier = Modifier
                .align(CenterHorizontally)
        ) {
            IconButton(onClick = {
                buildShortLink(deepLink = "https://https://www.t-mobile.com/?&cmpid=MGPO_PB_P_EVGRNBHV_43700070651103760_593938944718&gclid=CjwKCAjwzuqgBhAcEiwAdj5dRlu7zw3kG3bBlQmY6AtWVGzCsQT2QTbku6h5RdrPIBVd8es3COWUUhoCJswQAvD_BwE&gclsrc=aw.ds".toUri(),0) {
                context.shareDeepLink(it)
                }
            }) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = Icons.Default.Share.name
                )
            }
        }
    }
}

@Composable
fun ShopScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.purple_200))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Shop View",
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.black),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
        Row(
            modifier = Modifier
                .align(CenterHorizontally)
        ) {
            IconButton(onClick = {
                val newDeepLink = buildDeepLink(deepLink = "https://pocfirebase1821.page.link/qL6j".toUri())
                context.shareDeepLink(newDeepLink.toString())
            }) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = Icons.Default.Share.name
                )
            }
        }
    }
}

@Composable
fun BillingScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.purple_200))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Billing View",
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.black),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
        Row(
            modifier = Modifier
                .align(CenterHorizontally)
        ) {
            IconButton(onClick = {
                buildShortLink(deepLink = "https://pocfirebase1821.page.link/qL6j".toUri(),0) {
                context.shareDeepLink(it)
                }
            }) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = Icons.Default.Share.name
                )
            }
        }
    }
}

@Composable
fun HelpScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.purple_200))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Help View",
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.black),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
        Row(
            modifier = Modifier
                .align(CenterHorizontally)
        ) {
            IconButton(onClick = {
                val newDeepLink = buildDeepLink(deepLink = "https://pocfirebase1821.page.link/qL6j".toUri())
                context.shareDeepLink(newDeepLink.toString())
            }) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = Icons.Default.Share.name
                )
            }
        }
    }
}



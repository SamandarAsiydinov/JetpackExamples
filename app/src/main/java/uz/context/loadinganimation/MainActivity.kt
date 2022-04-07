package uz.context.loadinganimation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox
import uz.context.loadinganimation.ui.theme.LoadingAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoadingAnimationTheme {
                SwipeItem()
            }
        }
    }
}

@Composable
fun SwipeItem() {

    val archive = SwipeAction(
        onSwipe = {
            log("Archive")
        },
        icon = {
            Icon(
                modifier = Modifier.padding(16.dp),
                painter = painterResource(id = R.drawable.ic_baseline_archive_24),
                contentDescription = "Icon",
                tint = Color.White
            )
        },
        background = Green,
    )

    val email = SwipeAction(
        onSwipe = {
            log("Email")
        },
        icon = {
            Icon(
                modifier = Modifier.padding(16.dp),
                imageVector = Icons.Default.Email,
                contentDescription = "Icon",
                tint = Color.White
            )
        },
        background = Blue,
    )

    SwipeableActionsBox(
        swipeThreshold = 100.dp,
        startActions = listOf(archive),
        endActions = listOf(email)
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.surface)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(size = 50.dp))
                    .background(MaterialTheme.colors.primary)
                    .size(50.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(7f)) {
                Text(
                    text = "Title", style = TextStyle(
                        fontSize = MaterialTheme.typography.h5.fontSize,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(text = "Lorem ipsum dolor sit amet")
            }
        }
    }
}

private fun log(msg: String) {
    Log.d("@@@@@", msg)
}

@Composable
fun Fun() {
    var selected by remember { mutableStateOf(false) }
    var selected2 by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(80.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SelectableItem(
            selected = selected,
            title = "Lorem Ipsum",
            onClick = {
                selected = !selected
            }
        )
        Spacer(modifier = Modifier.height(17.dp))
        SelectableItem(
            selected = selected2,
            title = "Lorem Ipsum",
            subtitle = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ullamcorper lobortis purus, vitae maximus leo",
            onClick = {
                selected2 = !selected2
            }
        )
    }
}

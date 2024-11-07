package com.example.quotesappcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


@Composable
fun QuotesDetailsScreen(
    quotesModel: QuotesModel,
    modifier: Modifier = Modifier,
    onNavigate:()->Unit
   
) {
    Box(
        modifier = modifier.fillMaxSize()
            .padding(20.dp)
            .background(
                brush = Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffff00),
                        Color(0xFFE3E3E3),
                    )
                )
            ),
        contentAlignment = Alignment.Center,

    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier.padding(8.dp),

            ) {
            Row(
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier
                        .size(40.dp)
                        .rotate(180F)
                        .background(Color.Black)
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = quotesModel.quotes,
                        color = Color.Black,
                        fontSize = 18.sp,
                    )
                    HorizontalDivider(thickness = 2.dp, modifier = Modifier.padding(vertical = 4.dp))
                    Text(
                        text = quotesModel.author,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }

}

@Serializable
data class QuotesDetailsScreen(
    val quotesModel: QuotesModel
)
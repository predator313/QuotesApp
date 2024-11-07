package com.example.quotesappcompose

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.serialization.Serializable

//one the most important stuff regarding navigation is pending
//just the sense of the brilliance

@Composable
fun QuotesScreen(
    data: Array<QuotesModel>,
    modifier: Modifier = Modifier,
    onClick: (QuotesModel) -> Unit
) {
    Column(
        modifier = modifier
            .background(color = Color.White)
            .padding( 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(
            text = "Quotes App",
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(Modifier.height(12.dp))
        LazyColumn {
            items(data) {
                Quote(it) {quote->
                    Log.e("hello","clicked ${quote.quotes}")
                    onClick(quote)
                }
            }
        }
    }

}

@Composable
fun Quote(
    quotesModel: QuotesModel,
    modifier: Modifier = Modifier,
    onClick: (QuotesModel)->Unit,
) {

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier.padding(8.dp)
            .clickable { onClick(quotesModel) }
        ,
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF7F2F9),
        )

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
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                HorizontalDivider(thickness = 2.dp, modifier = Modifier.padding(vertical = 4.dp))
                Text(
                    text = quotesModel.author,
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }
        }
    }
}

@Serializable
 object QuotesScreen
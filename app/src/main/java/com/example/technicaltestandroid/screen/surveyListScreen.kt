package com.example.technicaltestandroid.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.technicaltestandroid.R
import com.example.technicaltestandroid.models.Survey

@Composable
fun SurveyListScreen() {
    val surveys = listOf(
        Survey(
            title = "Favorite Color",
            backgroundDrawableRes = R.drawable.homesurvey,
            description = "What is your favorite color?"
        ),
        Survey(
            title = "Favorite Food",
            backgroundDrawableRes = R.drawable.careertraining,
            description = "What is your favorite food?"
        ),
        Survey(
            title = "Favorite Movies",
            backgroundDrawableRes = R.drawable.inclusion,
            description = "What are your favorite movies?"
        )
    )

    Column(modifier = Modifier.fillMaxSize()) {

        LazyColumn(modifier = Modifier.weight(1f)) {
            itemsIndexed(surveys) { index, survey ->
                SurveyItem(survey = survey)
            }
        }

        FloatingActionButton(
            onClick = { /* Handle button click to navigate to survey screen */ },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.End)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Navigate to survey screen"
            )
        }
    }
}
@Composable
fun SurveyItem(survey: Survey) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = survey.backgroundDrawableRes),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = survey.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = survey.description,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
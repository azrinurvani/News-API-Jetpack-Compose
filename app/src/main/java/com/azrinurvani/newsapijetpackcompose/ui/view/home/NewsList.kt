package com.azrinurvani.newsapijetpackcompose.ui.view.home


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.azrinurvani.newsapijetpackcompose.R
import com.azrinurvani.newsapijetpackcompose.domain.model.NewsUi

@Composable
fun NewsList(
    modifier: Modifier,
    newsUiModelList : List<NewsUi>?
){
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = modifier.fillMaxSize()
    ){
        LazyColumn {
            newsUiModelList?.size?.let {
                items(
                    count = it,
                    itemContent = { index ->
                        NewsCardItem(newsUiModel = newsUiModelList[index])
                    }
                )
            }
        }
    }
}

@Composable
fun NewsCardItem(
    newsUiModel : NewsUi
){
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            AsyncImage(
                model = newsUiModel.urlToImage,
                contentDescription = "article_image",
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )

            //Title
            Text(
                text = newsUiModel.title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(top = 16.dp)
            )

            //Author
            Text(
                text = stringResource(id = R.string.author_by,newsUiModel.author),
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .padding(top = 4.dp)
            )

            //Content
            Text(
                text = newsUiModel.content,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Justify,
                maxLines = 4,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
            )

            //Published At
            Text(
                text = newsUiModel.publishedAt,
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth()
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsCardItemPreview(){
    //Use fake data
    NewsCardItem(newsUiModel = NewsUi(
        id = "1",
        name = "Azri Nurvani",
        publishedAt = "17 August 2024",
        title = "Craig Wright Faces Perjury Investigation Over Claims He Created Bitcoin",
        author = "Azri Nurvani",
        url = "https://www.wired.com/story/craig-wright-perjury-bitcoin-trial/",
        urlToImage = "https://media.wired.com/photos/6696630a5d2d61e4805c3175/191:100/w_1280,c_limit/GettyImages-1979197796.jpg",
        content = "A judge in the UK High Court has directed prosecutors to consider bringing criminal charges against computer scientist Craig Wright, after ruling that he lied extensively and repeatedly and committed… [+2851 chars]",
        description = "By order of a UK judge, Craig Wright can no longer claim he is the creator of bitcoin and now faces the prospect of criminal charges."
    ))
}


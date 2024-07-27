package com.azrinurvani.newsapijetpackcompose

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.azrinurvani.newsapijetpackcompose.domain.model.NewsUi
import com.azrinurvani.newsapijetpackcompose.ui.theme.NewsApiJetpackComposeTheme
import com.azrinurvani.newsapijetpackcompose.ui.view.home.NewsList
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NewsInstrumentedTest {


    @get:Rule
    val composeTestRule = createComposeRule()
//
//    @Test
//    fun testHomeScreen() {
//        //When
//        composeTestRule.setContent {
//            NewsApiJetpackComposeTheme {
//                NewsList(modifier = Modifier, newsUiModelList = )
//            }
//        }
//    }

    @Test
    fun testNewsList(){
        //Given
        val newsUiList = listOf(
            NewsUi(
                id = "wired",
                name = "Wired",
                author = "Joel Khalili",
                title = "Craig Wright Faces Perjury Investigation Over Claims He Created Bitcoin",
                description = "By order of a UK judge, Craig Wright can no longer claim he is the creator of bitcoin and now faces the prospect of criminal charges.",
                url = "https://www.wired.com/story/craig-wright-perjury-bitcoin-trial/",
                urlToImage = "https://media.wired.com/photos/6696630a5d2d61e4805c3175/191:100/w_1280,c_limit/GettyImages-1979197796.jpg",
                publishedAt = "2024-07-16T12:58:12Z",
                content = "A judge in the UK High Court has directed prosecutors to consider bringing criminal charges against computer scientist Craig Wright, after ruling that he lied extensively and repeatedly and committed… [+2851 chars]"
            ),
            NewsUi(
                id = "wired",
                name = "Wired",
                author = "Joel Khalili",
                title = "A Tiny Texas Village Is About To Annex a Gigantic Bitcoin Mine",
                description = "In a roundabout bid to win public opinion (and a juicy tax abatement,) Riot Platforms is preparing for its prized bitcoin mine to be annexed by a miniscule village in rural Texas.",
                url = "https://www.wired.com/story/a-tiny-texas-hamlet-is-about-to-annex-an-industrial-scale-bitcoin-mine/",
                urlToImage = "https://media.wired.com/photos/66958525a54303f24cdd6052/191:100/w_1280,c_limit/Texas-Annex-Bitcoin-Business-1288216977.jpg",
                publishedAt = "2024-07-16T11:30:00Z",
                content = "In Oak Valley, a sleepy village in rural Navarro County, Texas, there is very little of anything. A potholed track runs through its two square miles of sun-beaten grassland, past a modest prefab comm… [+3234 chars]"
            )
        )

        //When
        composeTestRule.setContent {
            NewsApiJetpackComposeTheme {
                NewsList(modifier = Modifier, newsUiModelList = newsUiList)
            }
        }

        //Then
        composeTestRule.onNodeWithText("Craig Wright Faces Perjury Investigation Over Claims He Created Bitcoin").assertIsDisplayed()
//        composeTestRule.onNodeWithText("Author by: Joel Khalili").assertIsDisplayed() //error karena menemukan 2 text yang sama
        composeTestRule.onNodeWithText("In Oak Valley, a sleepy village in rural Navarro County, Texas, there is very little of anything. A potholed track runs through its two square miles of sun-beaten grassland, past a modest prefab comm… [+3234 chars]").assertIsDisplayed()
        composeTestRule.onNodeWithText("2024-07-16T11:30:00Z").assertIsDisplayed()
    }
}
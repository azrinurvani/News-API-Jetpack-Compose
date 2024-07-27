package com.azrinurvani.newsapijetpackcompose.domain.model

import com.azrinurvani.newsapijetpackcompose.data.source.network.remote_model.DataArticle
import com.azrinurvani.newsapijetpackcompose.data.source.network.remote_model.ResponseEverything
import com.azrinurvani.newsapijetpackcompose.data.source.network.remote_model.Source
import com.azrinurvani.newsapijetpackcompose.domain.model.convertor.newsResponseToNewsUi
import org.junit.Assert.assertEquals
import org.junit.Test


class NewsConvertorTest {

    @Test
    fun `should convert from ResponseEverything to NewsUiState`() {
        //Given
        val responseEverything = ResponseEverything(
            status = "ok",
            totalResults = 8391,
            articles = listOf(
                DataArticle(
                    source = Source(
                        id = "wired",
                        name = "Wired"
                    ),
                    author = "Joel Khalili",
                    title = "Craig Wright Faces Perjury Investigation Over Claims He Created Bitcoin",
                    description = "By order of a UK judge, Craig Wright can no longer claim he is the creator of bitcoin and now faces the prospect of criminal charges.",
                    url = "https://www.wired.com/story/craig-wright-perjury-bitcoin-trial/",
                    urlToImage = "https://media.wired.com/photos/6696630a5d2d61e4805c3175/191:100/w_1280,c_limit/GettyImages-1979197796.jpg",
                    publishedAt = "2024-07-16T12:58:12Z",
                    content = "A judge in the UK High Court has directed prosecutors to consider bringing criminal charges against computer scientist Craig Wright, after ruling that he lied extensively and repeatedly and committed… [+2851 chars]"
                ),
                DataArticle(
                    source = Source(
                        id = "wired",
                        name = "Wired"
                    ),
                    author = "Joel Khalili",
                    title = "A Tiny Texas Village Is About To Annex a Gigantic Bitcoin Mine",
                    description = "In a roundabout bid to win public opinion (and a juicy tax abatement,) Riot Platforms is preparing for its prized bitcoin mine to be annexed by a miniscule village in rural Texas.",
                    url = "https://www.wired.com/story/a-tiny-texas-hamlet-is-about-to-annex-an-industrial-scale-bitcoin-mine/",
                    urlToImage = "https://media.wired.com/photos/66958525a54303f24cdd6052/191:100/w_1280,c_limit/Texas-Annex-Bitcoin-Business-1288216977.jpg",
                    publishedAt = "2024-07-16T11:30:00Z",
                    content = "In Oak Valley, a sleepy village in rural Navarro County, Texas, there is very little of anything. A potholed track runs through its two square miles of sun-beaten grassland, past a modest prefab comm… [+3234 chars]"
                )
            )
        )

        //When
        val result = newsResponseToNewsUi(responseEverything)

        //Then
        val expectedResult = NewsUiState.Success(
            listOf(
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
        )
        assertEquals(expectedResult,result)
    }
}
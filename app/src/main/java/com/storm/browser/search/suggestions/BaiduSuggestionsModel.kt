package com.storm.browser.search.suggestions

import android.app.Application
import com.storm.browser.R
import com.storm.browser.constant.UTF8
import com.storm.browser.database.SearchSuggestion
import com.storm.browser.extensions.map
import com.storm.browser.extensions.preferredLocale
import com.storm.browser.log.Logger
import io.reactivex.Single
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import org.json.JSONArray

/**
 * The search suggestions provider for the Baidu search engine.
 */
class BaiduSuggestionsModel(
    okHttpClient: Single<OkHttpClient>,
    requestFactory: RequestFactory,
    application: Application,
    logger: Logger
) : BaseSuggestionsModel(okHttpClient, requestFactory, UTF8, application.preferredLocale, logger) {

    private val searchSubtitle = application.getString(R.string.suggestion)
    private val inputEncoding = "GBK"

    // see http://unionsug.baidu.com/su?wd={encodedQuery}
    // see http://suggestion.baidu.com/s?wd={encodedQuery}&action=opensearch
    override fun createQueryUrl(query: String, language: String): HttpUrl = HttpUrl.Builder()
        .scheme("http")
        .host("suggestion.baidu.com")
        .encodedPath("/s")
        .addEncodedQueryParameter("wd", query)
        .addQueryParameter("action", "opensearch")
        .build()


    @Throws(Exception::class)
    override fun parseResults(responseBody: ResponseBody): List<SearchSuggestion> {
        return JSONArray(responseBody.string())
            .getJSONArray(1)
            .map { it as String }
            .map { SearchSuggestion("$searchSubtitle \"$it\"", it) }
    }

}

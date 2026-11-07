package com.storm.browser.search.engine

import com.storm.browser.R

/**
 * A custom search engine.
 */
class CustomSearch(queryUrl: String) : BaseSearchEngine(
    "file:///android_asset/stormbrowser.webp",
    queryUrl,
    R.string.search_engine_custom
)

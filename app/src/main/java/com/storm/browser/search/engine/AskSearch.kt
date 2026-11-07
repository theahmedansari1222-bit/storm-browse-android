package com.storm.browser.search.engine

import com.storm.browser.R

/**
 * The Ask search engine.
 */
class AskSearch : BaseSearchEngine(
    "file:///android_asset/ask.webp",
    "http://www.ask.com/web?qsrc=0&o=0&l=dir&qo=Storm Browser&q=",
    R.string.search_engine_ask
)

package com.storm.browser.database

sealed class SettingsKeys(
        open val key: String,
        open val value: String
)
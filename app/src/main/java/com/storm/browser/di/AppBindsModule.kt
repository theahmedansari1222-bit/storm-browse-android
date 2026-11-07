package com.storm.browser.di

import com.storm.browser.adblock.allowlist.AllowListModel
import com.storm.browser.adblock.allowlist.SessionAllowListModel
import com.storm.browser.adblock.source.AssetsHostsDataSource
import com.storm.browser.adblock.source.HostsDataSource
import com.storm.browser.adblock.source.HostsDataSourceProvider
import com.storm.browser.adblock.source.PreferencesHostsDataSourceProvider
import com.storm.browser.database.adblock.HostsDatabase
import com.storm.browser.database.adblock.HostsRepository
import com.storm.browser.database.allowlist.AdBlockAllowListDatabase
import com.storm.browser.database.allowlist.AdBlockAllowListRepository
import com.storm.browser.database.bookmark.BookmarkDatabase
import com.storm.browser.database.bookmark.BookmarkRepository
import com.storm.browser.database.downloads.DownloadsDatabase
import com.storm.browser.database.downloads.DownloadsRepository
import com.storm.browser.database.history.HistoryDatabase
import com.storm.browser.database.history.HistoryRepository
import com.storm.browser.database.javascript.JavaScriptDatabase
import com.storm.browser.database.javascript.JavaScriptRepository
import com.storm.browser.ssl.SessionSslWarningPreferences
import com.storm.browser.ssl.SslWarningPreferences
import dagger.Binds
import dagger.Module

/**
 * Dependency injection module used to bind implementations to interfaces.
 */
@Module
abstract class AppBindsModule {

    @Binds
    abstract fun provideBookmarkModel(bookmarkDatabase: BookmarkDatabase): BookmarkRepository

    @Binds
    abstract fun provideDownloadsModel(downloadsDatabase: DownloadsDatabase): DownloadsRepository

    @Binds
    abstract fun providesHistoryModel(historyDatabase: HistoryDatabase): HistoryRepository

    @Binds
    abstract fun providesJavaScriptModel(javaScriptDatabase: JavaScriptDatabase): JavaScriptRepository

    @Binds
    abstract fun providesAdBlockAllowListModel(adBlockAllowListDatabase: AdBlockAllowListDatabase): AdBlockAllowListRepository

    @Binds
    abstract fun providesAllowListModel(sessionAllowListModel: SessionAllowListModel): AllowListModel

    @Binds
    abstract fun providesSslWarningPreferences(sessionSslWarningPreferences: SessionSslWarningPreferences): SslWarningPreferences

    @Binds
    abstract fun providesHostsDataSource(assetsHostsDataSource: AssetsHostsDataSource): HostsDataSource

    @Binds
    abstract fun providesHostsRepository(hostsDatabase: HostsDatabase): HostsRepository

    @Binds
    abstract fun providesHostsDataSourceProvider(preferencesHostsDataSourceProvider: PreferencesHostsDataSourceProvider): HostsDataSourceProvider
}

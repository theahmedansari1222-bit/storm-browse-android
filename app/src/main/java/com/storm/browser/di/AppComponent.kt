package com.storm.browser.di

import com.storm.browser.BrowserApp
import com.storm.browser.adblock.BloomFilterAdBlocker
import com.storm.browser.adblock.NoOpAdBlocker
import com.storm.browser.browser.SearchBoxModel
import com.storm.browser.browser.activity.BrowserActivity
import com.storm.browser.browser.activity.ThemableBrowserActivity
import com.storm.browser.browser.bookmarks.BookmarksDrawerView
import com.storm.browser.device.BuildInfo
import com.storm.browser.dialog.LightningDialogBuilder
import com.storm.browser.download.LightningDownloadListener
import com.storm.browser.reading.activity.ReadingActivity
import com.storm.browser.search.SuggestionsAdapter
import com.storm.browser.settings.activity.SettingsActivity
import com.storm.browser.settings.activity.ThemableSettingsActivity
import com.storm.browser.settings.fragment.*
import com.storm.browser.view.StormChromeClient
import com.storm.browser.view.StormView
import com.storm.browser.view.StormWebClient
import android.app.Application
import com.storm.browser.download.DownloadActivity
import com.storm.browser.history.HistoryActivity
import com.storm.browser.popup.PopUpClass
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (AppBindsModule::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun buildInfo(buildInfo: BuildInfo): Builder

        fun build(): AppComponent
    }

    fun inject(activity: BrowserActivity)

    fun inject(activity: DownloadActivity)

    fun inject(activity: HistoryActivity)

    fun inject(fragment: ExportSettingsFragment)

    fun inject(builder: LightningDialogBuilder)

    fun inject(smartCookieView: StormView)

    fun inject(activity: ThemableBrowserActivity)

    fun inject(advancedSettingsFragment: AdvancedSettingsFragment)

    fun inject(app: BrowserApp)

    fun inject(activity: ReadingActivity)

    fun inject(webClient: StormWebClient)

    fun inject(activity: SettingsActivity)

    fun inject(activity: ThemableSettingsActivity)

    fun inject(listener: LightningDownloadListener)

    fun inject(fragment: PrivacySettingsFragment)

    fun inject(fragment: DebugSettingsFragment)

    fun inject(fragment: ExtensionsSettingsFragment)

    fun inject(suggestionsAdapter: SuggestionsAdapter)

    fun inject(chromeClient: StormChromeClient)

    fun inject(searchBoxModel: SearchBoxModel)

    fun inject(generalSettingsFragment: GeneralSettingsFragment)

    fun inject(displaySettingsFragment: DisplaySettingsFragment)

    fun inject(adBlockSettingsFragment: AdBlockSettingsFragment)

    fun inject(drawerSettingsFragment: DrawerSettingsFragment)

    fun inject(homepageSettingsFragment: HomepageSettingsFragment)

    fun inject(themeSettingsFragment: ThemeSettingsFragment)

    fun inject(drawerOffsetFragment: DrawerOffsetFragment)

    fun inject(parentalSettingsFragment: ParentalControlSettingsFragment)

    fun inject(bookmarksView: BookmarksDrawerView)

    fun provideBloomFilterAdBlocker(): BloomFilterAdBlocker

    fun provideNoOpAdBlocker(): NoOpAdBlocker

    fun inject(popUpClass: PopUpClass)
}

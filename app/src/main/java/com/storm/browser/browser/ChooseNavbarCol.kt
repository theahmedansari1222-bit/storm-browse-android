package com.storm.browser.browser

import com.storm.browser.preference.IntEnum

/**
 * The available proxy choices.
 */
enum class ChooseNavbarCol(override val value: Int) : IntEnum {
    NONE(0),
    COLOR(1)
}

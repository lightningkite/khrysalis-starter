package com.lightningkite.khrysalis.starter

import com.lightningkite.khrysalis.android.KhrysalisActivity
import com.lightningkite.khrysalis.starter.vg.RootVG
import com.lightningkite.khrysalis.views.ViewGenerator

class MainActivity : KhrysalisActivity() {
    companion object {
        val mainVg = RootVG()
    }
    override val main: ViewGenerator
        get() = mainVg
}

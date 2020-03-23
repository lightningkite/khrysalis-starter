package com.tresit.khrysalis

import android.os.Bundle
import com.lightningkite.khrysalis.android.KhrysalisActivity
import com.lightningkite.khrysalis.views.ViewGenerator
import com.tresit.khrysalis.vg.RootVG

class MainActivity : KhrysalisActivity() {
    companion object {
        val mainVg = RootVG()
    }
    override val main: ViewGenerator
        get() = mainVg
}

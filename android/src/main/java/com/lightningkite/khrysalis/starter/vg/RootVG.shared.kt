//
// RootVG.swift
// Created by Khrysalis Prototype Generator
// Sections of this file can be replaces if the marker, '(overwritten on flow generation)', is left in place.
//
package com.lightningkite.khrysalis.starter.vg

//--- Imports

import android.widget.*
import android.view.*
import com.lightningkite.khrysalis.*
import com.lightningkite.khrysalis.views.*
import com.lightningkite.khrysalis.observables.*
import com.lightningkite.khrysalis.observables.binding.*
import com.lightningkite.khrysalis.starter.R
import com.lightningkite.khrysalis.starter.layouts.*

//--- Name (overwritten on flow generation)
@Suppress("NAME_SHADOWING")
class RootVG(
    //--- Dependencies (overwritten on flow generation)
    //--- Extends (overwritten on flow generation)
) : ViewGenerator() {
    
    //--- Provides dialog (overwritten on flow generation)
    val dialog: ObservableStack<ViewGenerator> = ObservableStack()
    //--- Provides root (overwritten on flow generation)
    val root: ObservableStack<ViewGenerator> = ObservableStack()
    
    //--- Title (overwritten on flow generation)
    override val title: String get() = "Root"
    
    //--- Generate Start (overwritten on flow generation)
    override fun generate(dependency: ViewDependency): View {
        val xml = RootXml()
        val view = xml.setup(dependency)
        
        //--- Set Up xml.content (overwritten on flow generation)
        xml.content.bindStack(dependency, root)
        
        //--- Set Up xml.dialog (overwritten on flow generation)
        xml.dialog.bindStack(dependency, dialog)
        
        //--- Generate End (overwritten on flow generation)
        
        return view
    }
    
    //--- Init
    
    init {
    //--- Init End
    }
    
    //--- Actions
    
    
    //--- Body End
}

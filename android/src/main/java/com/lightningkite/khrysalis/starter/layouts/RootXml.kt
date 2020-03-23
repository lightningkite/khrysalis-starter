//
// RootXml.swift
// Created by Khrysalis XML Android
//
package com.lightningkite.khrysalis.starter.layouts

import android.widget.*
import android.view.*
import com.lightningkite.khrysalis.views.*
import com.lightningkite.khrysalis.starter.R

class RootXml {

    lateinit var content: com.lightningkite.khrysalis.views.android.SwapView
    lateinit var dialog: com.lightningkite.khrysalis.views.android.SwapView
    
    
    lateinit var xmlRoot: View

    fun setup(dependency: ViewDependency): View {
        val view = LayoutInflater.from(dependency.context).inflate(R.layout.root, null, false)
        return setup(view)
    }
    fun setup(view: View): View {
        xmlRoot = view
        content = view.findViewById<com.lightningkite.khrysalis.views.android.SwapView>(R.id.content)
        dialog = view.findViewById<com.lightningkite.khrysalis.views.android.SwapView>(R.id.dialog)
        
        
        
        return view
    }
}
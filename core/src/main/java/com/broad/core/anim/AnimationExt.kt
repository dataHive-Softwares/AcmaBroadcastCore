package com.broad.core.anim

import android.view.animation.Animation

inline fun Animation.setAnimationListener(
    func: AnimationListenerImpl.() -> Unit
) {
    val listener = AnimationListenerImpl()
    listener.func()
    setAnimationListener(listener)
}
/*
 * This file is part of the Scandit Data Capture SDK
 *
 * Copyright (C) 2024- Scandit AG. All rights reserved.
 */

package com.scandit.datacapture.cordova.core.actions

import com.scandit.datacapture.cordova.core.utils.CordovaEventEmitter
import com.scandit.datacapture.cordova.core.utils.successAndKeepCallback
import com.scandit.datacapture.frameworks.core.CoreModule
import com.scandit.datacapture.frameworks.core.listeners.FrameworksFrameSourceListener
import org.apache.cordova.CallbackContext
import org.json.JSONArray

class ActionUnsubscribeFrameSource(
    private val coreModule: CoreModule,
    private val eventEmitter: CordovaEventEmitter
) : Action {
    override fun run(args: JSONArray, callbackContext: CallbackContext) {
        eventEmitter.unregisterCallback(
            FrameworksFrameSourceListener.TORCH_STATE_CHANGE_EVENT_NAME
        )
        eventEmitter.unregisterCallback(
            FrameworksFrameSourceListener.FRAME_STATE_CHANGE_EVENT_NAME
        )
        coreModule.unregisterFrameSourceListener()
        callbackContext.success()
    }
}
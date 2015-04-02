/*
 * Copyright (c) 2015 The CyanogenMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cyanogenmod.settings.device;

public class IrGestureVote {
    private final IrGestureManager mIrGestureManager;

    private boolean mLastWake;
    private int mLastFlags;

    public IrGestureVote(IrGestureManager irGestureManager) {
        mIrGestureManager = irGestureManager;
    }

    public void voteForState(boolean wake, int flags) {
        mIrGestureManager.updateState(mLastWake, mLastFlags, wake, flags);
        mLastWake = wake;
        mLastFlags = flags;
    }

    protected void finalize() {
        voteForState(false, 0);
    }
}
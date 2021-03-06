/*
 * Copyright (C) 2021 The Android Open Source Project
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

package com.android.settings.privacy;

import static android.os.UserManager.DISALLOW_MICROPHONE_TOGGLE;

import static com.android.settings.utils.SensorPrivacyManagerHelper.SENSOR_MICROPHONE;

import android.content.Context;

import com.android.settings.utils.SensorPrivacyManagerHelper;

/**
 * Controller for camera toggle
 */
public class MicToggleController extends SensorToggleController {
    public MicToggleController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    public MicToggleController(Context context, String preferenceKey,
            SensorPrivacyManagerHelper sensorPrivacyManagerHelper) {
        super(context, preferenceKey, sensorPrivacyManagerHelper, /* ignoreDeviceConfig */ true);
    }

    @Override
    public int getSensor() {
        return SENSOR_MICROPHONE;
    }

    @Override
    public String getDeviceConfigKey() {
        return "mic_toggle_enabled";
    }

    @Override
    protected String getRestriction() {
        return DISALLOW_MICROPHONE_TOGGLE;
    }
}

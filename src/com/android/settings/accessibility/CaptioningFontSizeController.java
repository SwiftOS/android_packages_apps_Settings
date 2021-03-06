/*
 * Copyright (C) 2022 The Android Open Source Project
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

package com.android.settings.accessibility;

import android.content.Context;
import android.provider.Settings;
import android.view.accessibility.CaptioningManager;

import androidx.preference.ListPreference;
import androidx.preference.Preference;

import com.android.settings.core.BasePreferenceController;

/** Preference controller for captioning font size. */
public class CaptioningFontSizeController extends BasePreferenceController
        implements Preference.OnPreferenceChangeListener {

    private final CaptioningManager mCaptioningManager;
    private final CaptionHelper mCaptionHelper;

    public CaptioningFontSizeController(Context context, String preferenceKey) {
        super(context, preferenceKey);
        mCaptioningManager = context.getSystemService(CaptioningManager.class);
        mCaptionHelper = new CaptionHelper(context);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public void updateState(Preference preference) {
        super.updateState(preference);
        final ListPreference listPreference = (ListPreference) preference;
        final float fontSize = mCaptioningManager.getFontScale();

        listPreference.setValue(Float.toString(fontSize));
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        Settings.Secure.putFloat(
                mContext.getContentResolver(), Settings.Secure.ACCESSIBILITY_CAPTIONING_FONT_SCALE,
                Float.parseFloat((String) newValue));
        mCaptionHelper.setEnabled(true);
        return true;
    }
}

/*
 * Copyright (C) 2018 The Android Open Source Project
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

package com.android.settings.wifi;

import static com.google.common.truth.Truth.assertThat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.view.View;

import androidx.test.core.app.ApplicationProvider;

import com.android.internal.logging.nano.MetricsProto.MetricsEvent;
import com.android.settings.testutils.shadow.ShadowConnectivityManager;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.androidx.fragment.FragmentController;

@RunWith(RobolectricTestRunner.class)
@Config(shadows = ShadowConnectivityManager.class)
public class AddNetworkFragmentTest {

    private AddNetworkFragment mAddNetworkFragment;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Context context = spy(ApplicationProvider.getApplicationContext());
        when(context.getSystemService(Context.WIFI_SERVICE)).thenReturn(mock(WifiManager.class));

        mAddNetworkFragment = spy(new AddNetworkFragment());
        when(mAddNetworkFragment.getContext()).thenReturn(context);
        FragmentController.setupFragment(mAddNetworkFragment);
    }

    @Ignore
    @Test
    public void getMetricsCategory_shouldReturnAddNetwork() {
        assertThat(mAddNetworkFragment.getMetricsCategory()).isEqualTo(
                MetricsEvent.SETTINGS_WIFI_ADD_NETWORK);
    }

    @Ignore
    @Test
    public void getMode_shouldBeModeConnected() {
        assertThat(mAddNetworkFragment.getMode()).isEqualTo(WifiConfigUiBase2.MODE_CONNECT);
    }

    @Ignore
    @Test
    public void launchFragment_shouldShowSubmitButton() {
        assertThat(mAddNetworkFragment.getSubmitButton()).isNotNull();
    }

    @Ignore
    @Test
    public void launchFragment_shouldShowCancelButton() {
        assertThat(mAddNetworkFragment.getCancelButton()).isNotNull();
    }

    @Ignore
    @Test
    public void onClickSubmitButton_shouldHandleSubmitAction() {
        View submitButton = mAddNetworkFragment.getView().findViewById(
                AddNetworkFragment.SUBMIT_BUTTON_ID);

        mAddNetworkFragment.onClick(submitButton);

        verify(mAddNetworkFragment).handleSubmitAction();
    }

    @Ignore
    @Test
    public void onClickCancelButton_shouldHandleCancelAction() {
        View cancelButton = mAddNetworkFragment.getView().findViewById(
                AddNetworkFragment.CANCEL_BUTTON_ID);

        mAddNetworkFragment.onClick(cancelButton);

        verify(mAddNetworkFragment).handleCancelAction();
    }

    @Ignore
    @Test
    public void dispatchSubmit_shouldHandleSubmitAction() {
        mAddNetworkFragment.dispatchSubmit();

        verify(mAddNetworkFragment).handleSubmitAction();
    }
}

/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.ui.exit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.netmera.netmerafintech.utils.AnalyticsUtil
import com.netmera.netmerafintech.utils.toast

class ExitFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        AnalyticsUtil.signOutEvent()
        toast("Sign out event was called")

        // splash screen needs to be opened when exit tab is pressed, finishing activity doesn't add any screen onto stack
        requireActivity().finish()

        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
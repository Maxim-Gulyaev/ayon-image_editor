package com.maxim.ui.util

import androidx.compose.ui.tooling.preview.Devices.PIXEL_3A_XL
import androidx.compose.ui.tooling.preview.Devices.PIXEL_7_PRO
import androidx.compose.ui.tooling.preview.Devices.PIXEL_FOLD
import androidx.compose.ui.tooling.preview.Preview

@Preview(device = PIXEL_7_PRO, name = "Phone preview")
annotation class PhonePreview

@Preview(device = PIXEL_3A_XL, name = "Phone small preview", heightDp = 300, widthDp = 500)
annotation class SmallPhonePreview

@Preview(device = PIXEL_FOLD, name = "Foldable preview")
annotation class FoldablePreview

@PhonePreview
@SmallPhonePreview
@FoldablePreview
annotation class AdaptivePreview
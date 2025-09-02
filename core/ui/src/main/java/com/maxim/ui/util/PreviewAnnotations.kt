package com.maxim.ui.util

import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "Middle phone",
    device = Devices.PHONE,
    showSystemUi = true
)
annotation class PhonePreview

@Preview(
    name = "Big phone",
    device = Devices.PIXEL_7_PRO,
    showSystemUi = true
)
annotation class BigPhonePreview

@Preview(
    name = "Small phone",
    device = Devices.PIXEL_3A_XL,
    showSystemUi = true
)
annotation class SmallPhonePreview

@Preview(
    name = "Foldable phone",
    device = Devices.PIXEL_FOLD,
    showSystemUi = true
)
annotation class FoldablePreview




@Preview(
    name = "Middle phone dark",
    device = Devices.PHONE,
    showSystemUi = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
annotation class PhoneDarkPreview

@Preview(
    name = "Big phone dark",
    device = Devices.PIXEL_7_PRO,
    showSystemUi = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
annotation class BigPhoneDarkPreview

@Preview(
    name = "Small phone dark",
    device = Devices.PIXEL_3A_XL,
    showSystemUi = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
annotation class SmallPhoneDarkPreview

@Preview(
    name = "Foldable phone dark",
    device = Devices.PIXEL_FOLD,
    showSystemUi = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
annotation class FoldableDarkPreview

@PhonePreview
@BigPhonePreview
@SmallPhonePreview
@FoldablePreview
annotation class AdaptivePreviewLight

@PhoneDarkPreview
@BigPhoneDarkPreview
@SmallPhoneDarkPreview
@FoldableDarkPreview
annotation class AdaptivePreviewDark


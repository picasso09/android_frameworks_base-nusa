package com.nusantara.systemui;

import android.content.Context;

import com.nusantara.systemui.dagger.NusantaraGlobalRootComponent;
import com.nusantara.systemui.dagger.DaggerNusantaraGlobalRootComponent;

import com.android.systemui.SystemUIFactory;
import com.android.systemui.dagger.GlobalRootComponent;

public class NusantaraSystemUIFactory extends SystemUIFactory {
    @Override
    protected GlobalRootComponent buildGlobalRootComponent(Context context) {
        return DaggerNusantaraGlobalRootComponent.builder()
                .context(context)
                .build();
    }
}

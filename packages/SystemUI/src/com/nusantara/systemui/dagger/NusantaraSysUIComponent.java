package com.nusantara.systemui.dagger;

import com.android.systemui.dagger.DefaultComponentBinder;
import com.android.systemui.dagger.DependencyProvider;
import com.android.systemui.dagger.SysUISingleton;
import com.android.systemui.dagger.SysUIComponent;
import com.android.systemui.dagger.SystemUIModule;

import com.nusantara.systemui.columbus.ColumbusModule;
import com.nusantara.systemui.elmyra.ElmyraModule;
import com.nusantara.systemui.keyguard.NusantaraKeyguardSliceProvider;
import com.nusantara.systemui.smartspace.KeyguardSmartspaceController;

import dagger.Subcomponent;

@SysUISingleton
@Subcomponent(modules = {
        ColumbusModule.class,
        DefaultComponentBinder.class,
        DependencyProvider.class,
        ElmyraModule.class,
        SystemUIModule.class,
        SystemUINusantaraBinder.class,
        NusantaraSystemUIModule.class})
public interface NusantaraSysUIComponent extends SysUIComponent {
    @SysUISingleton
    @Subcomponent.Builder
    interface Builder extends SysUIComponent.Builder {
        NusantaraSysUIComponent build();
    }

    /**
     * Member injection into the supplied argument.
     */
    void inject(NusantaraKeyguardSliceProvider keyguardSliceProvider);

    @SysUISingleton
    KeyguardSmartspaceController createKeyguardSmartspaceController();
}

package fr.madu59.fastershadowmapper.client.mixin.compat.beryl;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import fr.madu59.fastershadowmapper.client.compat.BerylCompat;
import net.beryl.render.ShadowMap;

@Pseudo 
@Mixin(ShadowMap.class)
public class ShadowMapMixin {
    @Inject(
        method = "renderShadowMap", at = @At("HEAD")
    )
    private void fastershadowmapper$beginRenderShadowMap(CallbackInfo ci) { 
        BerylCompat.startShadowPass();
    }

     @Inject(
        method = "renderShadowMap", at = @At("RETURN")
    )
    private void fastershadowmapper$endRenderShadowMap(CallbackInfo ci) { 
        BerylCompat.endShadowPass();
    }
}

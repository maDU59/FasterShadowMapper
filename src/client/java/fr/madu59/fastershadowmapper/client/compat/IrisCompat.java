package fr.madu59.fastershadowmapper.client.compat;

import net.irisshaders.iris.api.v0.IrisApi;

public class IrisCompat {

    private static IrisApi api = IrisApi.getInstance();

    public static boolean isShadowPass(){
        return api.isRenderingShadowPass();
    }
}

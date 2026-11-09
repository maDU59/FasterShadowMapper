package fr.madu59.fastershadowmapper.client.compat;

import java.lang.reflect.Field;

public class OptifineCompat {

    private static final Field SHADOW_PASS_FIELD;

    static {
        Field field = null;

        try {
            Class<?> shadersClass = Class.forName("net.optifine.shaders.Shaders");
            field = shadersClass.getDeclaredField("isShadowPass");
            field.setAccessible(true);
        } catch (Exception e) {
            field = null;
        }

        SHADOW_PASS_FIELD = field;
    }

    public static boolean isShadowPass() {
        if (SHADOW_PASS_FIELD == null) {
            return false;
        }

        try {
            return SHADOW_PASS_FIELD.getBoolean(null);
        } catch (IllegalAccessException e) {
            return false;
        }
    }
}

package fr.madu59.fastershadowmapper.client.compat;

import java.lang.reflect.Field;

public class OptifineCompat {
    public static boolean isShadowPass() {
        try {
            Class<?> shadersClass = Class.forName("net.optifine.shaders.Shaders");
            Field field = shadersClass.getDeclaredField("isShadowPass");
            field.setAccessible(true);
            
            return field.getBoolean(null);
        } catch (Exception e) {
            return false;
        }
    }
}

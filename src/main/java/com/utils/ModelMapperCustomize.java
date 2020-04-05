package com.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ModelMapperCustomize {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    static {
        MODEL_MAPPER.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public static <T> T toObject(Object obj, Class<T> type) {
        T t = null;
        if (obj != null) {
            try {
                t = MODEL_MAPPER.map(obj, type);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return t;
    }

    public static void map(Object sourceObj, Object desObj) {
        if (sourceObj != null && desObj != null) {
            try {
                MODEL_MAPPER.map(sourceObj, desObj);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}

package com.flower.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

public class SnowflakeUtil {

    private static final Snowflake SNOWFLAKE = IdUtil.getSnowflake(1, 1);

    private SnowflakeUtil() {}

    public static long nextId() {
        return SNOWFLAKE.nextId();
    }

    public static String nextIdStr() {
        return SNOWFLAKE.nextIdStr();
    }
}

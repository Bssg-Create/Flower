package com.flower.utils;

public class RequestHolder {

    private static final ThreadLocal<Long> USER_ID_HOLDER = new ThreadLocal<>();
    private static final ThreadLocal<String> USERNAME_HOLDER = new ThreadLocal<>();

    public static void setCurrentUserId(Long userId) {
        USER_ID_HOLDER.set(userId);
    }

    public static Long getCurrentUserId() {
        return USER_ID_HOLDER.get();
    }

    public static void setCurrentUsername(String username) {
        USERNAME_HOLDER.set(username);
    }

    public static String getCurrentUsername() {
        return USERNAME_HOLDER.get();
    }

    public static void clear() {
        USER_ID_HOLDER.remove();
        USERNAME_HOLDER.remove();
    }
}

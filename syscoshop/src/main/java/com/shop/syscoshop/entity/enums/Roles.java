package com.shop.syscoshop.entity.enums;

public enum Roles {
    ADMIN{
        @Override
        public String toString() {
            return "Admin";
        }
    },
    USER{
        @Override
        public String toString() {
            return "User";
        }
    }
}

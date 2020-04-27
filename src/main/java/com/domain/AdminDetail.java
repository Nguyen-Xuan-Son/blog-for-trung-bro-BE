package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = AdminDetail.COLLECTION)
public class AdminDetail extends BaseDomain {
    public static final String COLLECTION = "admin";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String BIRTHDAY = "birthday";
    public static final String ADDRESS = "address";
    public static final String NUMBER_PHONE = "number_phone";

    @Field(USERNAME)
    private String username;

    @Field(PASSWORD)
    private String password;

    @Field(BIRTHDAY)
    private Long birthday;

    @Field(ADDRESS)
    private String address;

    @Field(NUMBER_PHONE)
    private Long number_phone;
}

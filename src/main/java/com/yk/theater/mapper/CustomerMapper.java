package com.yk.theater.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    @Insert("INSERT INTO customer ("
                + "   TOTAL_CUSTOMER"
                + " , CUSTOMER_PHONE"
                + ")"
                + " VALUES ("
                + " #{people}"
                + " , #{tel}"
                + ");")
    int insertCustomer(String tel, long people);
}

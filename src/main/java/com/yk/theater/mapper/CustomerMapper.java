package com.yk.theater.mapper;

import com.yk.theater.dto.CustomerInput;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CustomerMapper {
    @Insert("INSERT INTO customer ("
                + "   TOTAL_CUSTOMER"
                + " , CUSTOMER_PHONE"
                + ")"
                + " VALUES ("
                + " #{people}"
                + " , #{tel}"
                + ")")
    @Options(useGeneratedKeys = true, keyColumn = "customer_id", keyProperty = "customerId")
    int insertCustomer(/*@Param("tel") String tel, @Param("people")long people*/ CustomerInput customer);

}

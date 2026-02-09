package com.bung.tdd.util;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ValidationUtilTest {

    @Test
    void isEmail_테스트(){
        //given
        String email = "test@test.com";
        //when
        boolean result = ValidationUtil.isEmail(email);
        //then
        assertThat(result).isTrue();
    }

    @Test
    void isEmail_테스트2(){
        //given
        String email = "test.com";
        //when
        boolean result = ValidationUtil.isEmail(email);
        //then
        assertThat(result).isFalse();
    }

}
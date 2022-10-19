package com.agile.psbackspringboot.message;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResponseMessageTests {

    @Test
    public void should_create_message() {
        ResponseMessage message = new ResponseMessage("Un super message");
        Assertions.assertNotNull(message);
    }

    @Test
    public void should_set_message(){
        ResponseMessage message = new ResponseMessage("Un super message");
        message.setMessage("Un autre message");
        Assertions.assertEquals("Un autre message", message.getMessage());
    }

}

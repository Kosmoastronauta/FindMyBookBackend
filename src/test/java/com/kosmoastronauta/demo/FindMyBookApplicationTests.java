package com.kosmoastronauta.demo;

import javafx.beans.binding.When;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FindMyBookApplicationTests
{

    @Test
    @Order(1)
    void getAllBooksWhileThereIsNoBookInDatabase()
    {
        given()
    }

}

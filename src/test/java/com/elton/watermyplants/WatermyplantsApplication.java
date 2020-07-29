package com.elton.watermyplants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
//@EnableJpaAuditing
public class WatermyplantsApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(WatermyplantsApplication.class, args);


    }


}

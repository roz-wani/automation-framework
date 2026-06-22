package utils;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec {

    public static ResponseSpecification getResponseSpec200() {

        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json; charset=utf-8")
                .build();
        }

        public static ResponseSpecification getResponseSpec201() {

        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectContentType("application/json")
                .build();
        }

        public static ResponseSpecification getResponseSpec404() {

        return new ResponseSpecBuilder()
                .expectStatusCode(404)
                .build();
        }

}

package com.example.badaro.aws_lambda;

public  class ResponseClass {
    String responseString;

    public String getResponseString() {
        return responseString;
    }

    public void setGreetings(String responseString) {
        this.responseString = responseString;
    }

    public ResponseClass(String responseString) {
        this.responseString = responseString;
    }

    public ResponseClass() {
    }

}

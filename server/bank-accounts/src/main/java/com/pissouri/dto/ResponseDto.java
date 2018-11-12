package com.pissouri.dto;

import java.util.Objects;

public class ResponseDto<T> {

    /**
     * Response status code, as per {@link ResponseStatusCode}
     */
    private int statusCode;

    /**
     * A more specific error message
     */
    private String statusText;

    /**
     * Actual response information
     */
    private T data;

    public int getStatusCode() {

        return statusCode;
    }

    public ResponseDto<T> setStatusCode(int statusCode) {

        this.statusCode = statusCode;
        return this;
    }

    public String getStatusText() {

        return statusText;
    }

    public ResponseDto<T> setStatusText(String statusText) {

        this.statusText = statusText;
        return this;
    }

    public T getData() {

        return data;
    }

    public ResponseDto<T> setData(T data) {

        this.data = data;
        return this;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseDto<?> that = (ResponseDto<?>) o;
        return statusCode == that.statusCode &&
                Objects.equals(statusText, that.statusText);
    }

    @Override
    public int hashCode() {

        return Objects.hash(statusCode, statusText);
    }

    @Override
    public String toString() {

        return "ResponseDto{" +
                "statusCode=" + statusCode +
                ", statusText='" + statusText + '\'' +
                ", data=" + data +
                '}';
    }

    public static <T> ResponseDto<T> ok(T data) {

        return new ResponseDto<T>()
                .setStatusCode(ResponseStatusCode.OK)
                .setStatusText("ok")
                .setData(data);
    }
}

package com.pw.elastic.job;

/**
 * @author pengwei
 * @date 2021/3/24
 */
import java.io.Serializable;

public final class Foo implements Serializable {


    private static final long serialVersionUID = 603093234768770449L;
    private final long id;

    private final String location;

    private Status status;

    public Foo(final long id, final String location, final Status status) {
        this.id = id;
        this.location = location;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("id: %s, location: %s, status: %s", id, location, status);
    }

    public enum Status {
        TODO,
        COMPLETED
    }
}
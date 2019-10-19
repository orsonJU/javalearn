package org.orson.util.ServiceLoader;

public class OrsonProvider implements Provider {
    @Override
    public String create() {
        return "orson";
    }
}

package test.java.util;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.orson.util.ServiceLoader.Provider;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ServiceLoaderSpec {


    @Test
    public void should_return_orson_insance_with_service_loader() {
        ServiceLoader<Provider> providers = ServiceLoader.load(Provider.class);
        Iterator<Provider> it = providers.iterator();
        //expect return at least 1 implementation
        assertThat(it.hasNext()).isTrue();
    }
}

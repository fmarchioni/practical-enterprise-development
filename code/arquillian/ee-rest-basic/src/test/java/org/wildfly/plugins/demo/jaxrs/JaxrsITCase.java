package org.wildfly.plugins.demo.jaxrs;

import java.net.URL;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 */
@RunWith(Arquillian.class)
@RunAsClient
public class JaxrsITCase {


    @Test
    public void testPlainText() throws Exception {
        String result = TestUtil.performCall(new URL("http://127.0.0.1:8080/rest/simple/text"));
        System.out.println("RESULT " + result);
        assertEquals(result, "hello world!", result);
    }

    @Test
    public void testJSON() throws Exception {
        String result = TestUtil.performCall(new URL("http://127.0.0.1:8080/rest/simple/json"));
        System.out.println("RESULT " + result);
        assertEquals(result, "{\"key\":\"A\",\"value\":\"B\"}", result);
    }

    @Test
    public void testXML() throws Exception {
        String result = TestUtil.performCall(new URL("http://127.0.0.1:8080/rest/simple/xml"));
        System.out.println("RESULT " + result);
        assertEquals(result, "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><simpleProperty><key>A</key><value>B</value></simpleProperty>", result);
    }
}

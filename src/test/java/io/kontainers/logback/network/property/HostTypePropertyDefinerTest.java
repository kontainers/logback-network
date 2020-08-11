package io.kontainers.logback.network.property;

import org.junit.Assert;
import org.junit.Test;

public class HostTypePropertyDefinerTest {
    @Test
    public void testSplit() {
        HostTypePropertyDefiner definer = new HostTypePropertyDefiner();
        Assert.assertEquals("trip", definer.splitHost("trip"));
        Assert.assertEquals("trip", definer.splitHost("trip-xyz"));
        Assert.assertEquals("trip", definer.splitHost("trip-xyz-123"));
        Assert.assertEquals("trip-ui", definer.splitHost("trip-ui-xyz-123"));
    }
}
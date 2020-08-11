package io.kontainers.logback.network.property;

import ch.qos.logback.core.PropertyDefinerBase;
import ch.qos.logback.core.util.NetworkAddressUtil;

// designed to be used to extract the service name from kubernetes deployed containers
// kubernetes typically append 2 random strings (delimited by dashes) to the service name when creating the host name
public class HostTypePropertyDefiner extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
         String host = new NetworkAddressUtil(getContext()).safelyGetCanonicalLocalHostName();
         return splitHost(host);
    }

    String splitHost(String host) {
        String[] parts = host.split("-");
        if (parts.length == 0) {
            return "";
        } else if (parts.length < 3) {
            return parts[0];
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < parts.length - 2; i++) {
                if (i > 0) {
                    sb.append('-');
                }
                sb.append(parts[i]);
            }
            return sb.toString();
        }
    }

}

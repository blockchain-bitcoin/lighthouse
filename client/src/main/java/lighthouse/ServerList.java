package lighthouse;

import com.google.common.collect.*;

import java.util.*;

/**
 * Hard-coded list of project servers so the app can randomly pick between them and load balance the work.
 */
public class ServerList {
    // This would be so much easier and less verbose with Kotlin ...

    public static class Entry {
        public final String hostName;
        public final String emailAddress;

        public Entry(String hostName, String emailAddress) {
            this.hostName = hostName;
            this.emailAddress = emailAddress;
        }
    }

    public static final List<Entry> servers = ImmutableList.of(
            new Entry("vinumeris.com", "project-hosting@vinumeris.com"),
            new Entry("lighthouse.onetapsw.com", "lighthouse-projects@onetapsw.com")
    );
    public static final Map<String, Entry> hostnameToServer;

    static {
        ImmutableMap.Builder<String, Entry> builder = ImmutableMap.builder();
        for (Entry server : servers) builder.put(server.hostName, server);
        hostnameToServer = builder.build();
    }

    public static Entry pickRandom() {
        return servers.get((int) (Math.random() * servers.size()));
    }
}

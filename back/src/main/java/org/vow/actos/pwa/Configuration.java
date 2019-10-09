package org.vow.actos.pwa;

import java.util.LinkedList;
import java.util.List;

public class Configuration {

    public static Builder configuration() {
        return new Builder();
    }

    static class Builder {
        public List<Route> routes = new LinkedList<>();

        public Builder with(Route route) {
            routes.add(route);
            return this;
        }
        public Configuration build() {
            return new Configuration(routes);
        }
    }

    ////
    public static Route route(String path) {
        return new Route(path);
    }

    static class Route {
        public final String path;
        public Route(String path) {
            this.path = path;
        }
    }

    ////
    public final List<Route> routes;

    public Configuration(List<Route> routes) {
        this.routes = routes;
    }
}

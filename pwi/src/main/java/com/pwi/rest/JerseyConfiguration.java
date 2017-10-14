package com.pwi.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.jsonp.JsonProcessingFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;



@ApplicationPath("pwi")
public class JerseyConfiguration extends ResourceConfig {
	
	public JerseyConfiguration() {
		
		packages("com.pwi.rest");
		property(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, false);
		register(org.glassfish.jersey.server.filter.UriConnegFilter.class);
        register(org.glassfish.jersey.server.spring.SpringComponentProvider.class);
        register(JsonProcessingFeature.class);
        register(org.glassfish.jersey.server.internal.scanning.PackageNamesScanner.class);
        register(JacksonFeature.class);
        register(MultiPartFeature.class);
        property(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, true);
    }

}

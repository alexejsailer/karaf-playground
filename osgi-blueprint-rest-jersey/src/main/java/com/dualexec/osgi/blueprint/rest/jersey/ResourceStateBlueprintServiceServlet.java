package com.dualexec.osgi.blueprint.rest.jersey;

import javax.inject.Singleton;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.WebConfig;
import org.ops4j.pax.cdi.api.OsgiServiceProvider;
import org.ops4j.pax.cdi.api.Properties;
import org.ops4j.pax.cdi.api.Property;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;

@Singleton
@OsgiServiceProvider(classes = { Servlet.class })
@Properties(value = {
		@Property(name = HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_INIT_PARAM_PREFIX
				+ ServerProperties.PROVIDER_PACKAGES, value = "com.dualexec.osgi.blueprint.rest.jersey"),
		@Property(name = "alias", value = "/jerseyblueprint/api") })
public class ResourceStateBlueprintServiceServlet extends ServletContainer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void init(WebConfig webConfig) throws ServletException {
		super.init(webConfig);
		ResourceConfig copyOfExistingConfig = new ResourceConfig(getConfiguration());
		reload(copyOfExistingConfig);
	}
}

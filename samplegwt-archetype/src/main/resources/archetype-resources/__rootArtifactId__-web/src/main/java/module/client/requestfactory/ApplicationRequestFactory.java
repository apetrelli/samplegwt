#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package ${package}.module.client.requestfactory;

import ${package}.module.client.requestfactory.request.PersonRequest;
import com.google.web.bindery.requestfactory.shared.LoggingRequest;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

/**
 * The main request factory.
 */
public interface ApplicationRequestFactory extends RequestFactory {
	
	/**
	 * @return a GWT logging request.
	 */
	LoggingRequest loggingRequest();
	
	PersonRequest personRequest();
}
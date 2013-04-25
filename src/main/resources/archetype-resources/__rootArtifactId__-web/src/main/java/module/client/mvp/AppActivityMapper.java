#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.mvp;

import ${package}.module.client.ClientFactory;
import ${package}.module.client.mvp.activity.ListPersonsActivity;
import ${package}.module.client.mvp.activity.PersonDetailActivity;
import ${package}.module.client.mvp.activity.WelcomeActivity;
import ${package}.module.client.mvp.place.ListPersonsPlace;
import ${package}.module.client.mvp.place.PersonDetailPlace;
import ${package}.module.client.mvp.place.WelcomePlace;
import ${package}.module.client.requestfactory.ApplicationRequestFactory;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

/**
 * Unique implementation of ActivityMapper.
 *
 */
public class AppActivityMapper implements ActivityMapper {
	
	private ClientFactory clientFactory;
	
	private ApplicationRequestFactory requestFactory;

	/**
	 * Constructor of class.
	 * @param clientFactory Factory to determinate view.
	 * @param requestFactory Factory to determinate service to call.
	 */
	public AppActivityMapper(ClientFactory clientFactory, ApplicationRequestFactory requestFactory) {
		this.clientFactory = clientFactory;
		this.requestFactory = requestFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof WelcomePlace) {
			return new WelcomeActivity((WelcomePlace) place, clientFactory);
		} else if (place instanceof ListPersonsPlace) {
			return new ListPersonsActivity(requestFactory, clientFactory);
		} else if (place instanceof PersonDetailPlace) {
			return new PersonDetailActivity((PersonDetailPlace) place, requestFactory, clientFactory);
		}
		return null;
	}

}

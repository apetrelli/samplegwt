#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client;

import ${package}.module.client.ui.ListPersonsView;
import ${package}.module.client.ui.PersonDetailView;
import ${package}.module.client.ui.WelcomeView;
import com.github.apetrelli.gwtintegration.web.client.ui.HasBody;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Container of client components.
 *
 */
public interface ClientFactory {
	
	EventBus getEventBus();
	
	PlaceController getPlaceController();
	
	HasBody getTemplate();

	WelcomeView getWelcomeView();
	
	ListPersonsView getListPersonsView();
	
	PersonDetailView getPersonDetailView();
}

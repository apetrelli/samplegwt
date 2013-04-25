package it.pkg.module.client;

import it.pkg.module.client.ui.ListPersonsView;
import it.pkg.module.client.ui.PersonDetailView;
import it.pkg.module.client.ui.WelcomeView;
import com.github.apetrelli.gwtintegration.mvp.client.ui.HasBody;
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

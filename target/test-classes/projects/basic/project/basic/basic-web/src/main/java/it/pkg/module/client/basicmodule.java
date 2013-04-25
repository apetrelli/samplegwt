package it.pkg.module.client;

import it.pkg.module.client.mvp.AppActivityMapper;
import it.pkg.module.client.mvp.AppPlaceHistoryMapper;
import it.pkg.module.client.mvp.place.WelcomePlace;
import it.pkg.module.client.requestfactory.ApplicationRequestFactory;
import com.github.apetrelli.gwtintegration.error.client.DialogBoxUncaughtExceptionHandler;
import com.github.apetrelli.gwtintegration.mvp.client.ui.HasBody;
import com.github.apetrelli.gwtintegration.requestfactory.client.EventSourceRequestTransport;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Entry point of front-office application.
 * 
 */
public class basicmodule implements EntryPoint {

	private Place defaultPlace = new WelcomePlace();

	@Override
	public void onModuleLoad() {
		GWT.setUncaughtExceptionHandler(new DialogBoxUncaughtExceptionHandler());

		ClientFactory clientFactory = GWT.create(ClientFactory.class);
		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();

		// Start ActivityManager for the main widget with our ActivityMapper
		ApplicationRequestFactory requestFactory = GWT
				.create(ApplicationRequestFactory.class);
		requestFactory.initialize(eventBus, new EventSourceRequestTransport(
				eventBus));
		ActivityMapper activityMapper = new AppActivityMapper(clientFactory,
				requestFactory);
		ActivityManager activityManager = new ActivityManager(activityMapper,
				eventBus);
		HasBody template = clientFactory.getTemplate();
		activityManager.setDisplay(template.getBody());

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		AppPlaceHistoryMapper historyMapper = GWT
				.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(
				historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);

		RootLayoutPanel.get().add(template);
		// Goes to the place represented on URL else default place
		historyHandler.handleCurrentHistory();
	}

}
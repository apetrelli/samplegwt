package it.pkg.module.client.mvp.activity;

import it.pkg.module.client.ClientFactory;
import it.pkg.module.client.mvp.place.WelcomePlace;
import it.pkg.module.client.ui.WelcomeView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Activity for Welcome.
 */
public class WelcomeActivity extends AbstractActivity implements WelcomeView.Presenter {

	private ClientFactory clientFactory;
		
	/**
	 * Constructor of class.
	 * @param place Current place.
	 * @param clientFactory Factory to determine view.
	 */
	public WelcomeActivity(WelcomePlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		final WelcomeView view = clientFactory.getWelcomeView();
		view.setPresenter(this);
		panel.setWidget(view);
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}

}

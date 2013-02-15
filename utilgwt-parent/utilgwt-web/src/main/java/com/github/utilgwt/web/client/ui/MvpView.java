package com.github.utilgwt.web.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface MvpView<T extends com.github.utilgwt.web.client.ui.MvpView.Presenter> extends IsWidget {

	void setPresenter(T presenter);
	
	public interface Presenter {
		void goTo(Place place);
	}
}

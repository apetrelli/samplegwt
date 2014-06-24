#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Interface view that describe the welcome web-page.
 *
 */
public interface WelcomeView extends IsWidget {

    /**
     * Set the associated activity.
     * @param presenter associated Activity.
     */
    void setPresenter(Presenter presenter);

    /**
     * Interface bridge to activity and view.
     *
     */
    public interface Presenter {
        /**
         * Redirect the user to the indicate  place.
         * @param place Place associated.
         */
        void goTo(Place place);
    }
}

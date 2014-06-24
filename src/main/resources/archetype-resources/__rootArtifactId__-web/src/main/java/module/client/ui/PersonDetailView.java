#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.ui;

import ${package}.module.client.ui.editor.PersonEditor;

import com.github.apetrelli.gwtintegration.editor.client.editor.ConstraintViolationDisplayer;
import com.github.apetrelli.gwtintegration.mvp.client.ui.MvpView;

public interface PersonDetailView extends MvpView<PersonDetailView.Presenter> {
	
	PersonEditor getEditor();
	
    ConstraintViolationDisplayer getGenericDisplayer();

	void canDelete(boolean canDelete);
	
	public interface Presenter extends MvpView.Presenter {
		void save();
		
		void delete();
	}
}

package it.pkg.module.client.ui;

import it.pkg.module.client.ui.editor.PersonEditor;
import com.github.apetrelli.gwtintegration.mvp.client.ui.MvpView;

public interface PersonDetailView extends MvpView<PersonDetailView.Presenter> {
	
	PersonEditor getEditor();
	
	void canDelete(boolean canDelete);
	
	public interface Presenter extends MvpView.Presenter {
		void save();
		
		void delete();
	}
}

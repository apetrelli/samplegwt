package com.github.utilgwt.web.server.gwt;

import com.github.utilgwt.model.jpa.Deletable;
import com.google.web.bindery.requestfactory.shared.Locator;

/**
 * A locator that manages {@link Deletable} elements.
 *
 * @param <T> The element type.
 * @param <I> The id type.
 */
public abstract class DeletableLocator<T extends Deletable, I> extends
		Locator<T, I> {

	@Override
	public boolean isLive(T domainObject) {
		return domainObject != null && !domainObject.isDeleted();
	}
}

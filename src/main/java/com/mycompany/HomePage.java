package com.mycompany;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new PanelA("a", Model.of("panel a")));
		add(new PortletLike("b", Model.of("panel b")));
    }
}

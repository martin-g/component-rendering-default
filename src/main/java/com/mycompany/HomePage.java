package com.mycompany;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.transformer.AbstractTransformerBehavior;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new PanelA("a", Model.of("panel a")));
		PanelB b = new PanelB("b", Model.of("panel b")) {
			@Override
			protected void onRender()
			{
				//super.onRender();
			}
		};
		b.add(new AbstractTransformerBehavior()
		{
			@Override
			public CharSequence transform(Component component, CharSequence output) throws Exception
			{
				try {
					component.internalRenderComponent();
				} catch (Exception x) {
					return "default content!";
				}
				return null;
			}
		});
		add(b);
    }
}

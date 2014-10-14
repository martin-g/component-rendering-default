package com.mycompany;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.transformer.AbstractTransformerBehavior;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.response.StringResponse;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new PanelA("a", Model.of("panel a")));
		PortletLike b = new PortletLike("b", Model.of("panel b")) {
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
				CharSequence result;
				StringResponse tempResponse = new StringResponse();
				Response oldResponse = component.getRequestCycle().setResponse(tempResponse);
				try
				{
					component.internalRenderComponent();
					result = tempResponse.toString();
				}
				catch (Exception x) {
					result = "default content!";
				} finally
				{
					component.getRequestCycle().setResponse(oldResponse);
				}
				return result;
			}
		});
		add(b);
    }
}

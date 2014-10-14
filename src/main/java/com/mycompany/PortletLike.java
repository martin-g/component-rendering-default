package com.mycompany;


import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;

/**
 *
 */
public class PortletLike extends Panel
{
	public PortletLike(String id, final IModel<String> model)
	{
		super(id);

		add(new Label("label", new AbstractReadOnlyModel<String>()
		{
			@Override
			public String getObject()
			{
				// simulate a problem in a child component
				throw new RuntimeException("Problem with rendering of PanelB's label");
//				return model.getObject();
			}
		}));
	}
}

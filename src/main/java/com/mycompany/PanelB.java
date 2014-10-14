package com.mycompany;


import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;

/**
 *
 */
public class PanelB extends Panel
{
	public PanelB(String id, IModel<String> model)
	{
		super(id);

		add(new Label("label", new AbstractReadOnlyModel<String>()
		{
			@Override
			public String getObject()
			{
				throw new RuntimeException("Problem with rendering of PanelB's label");
			}
		}));
	}
}

package com.mycompany;


import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 *
 */
public class PanelA extends Panel
{
	public PanelA(String id, IModel<String> model)
	{
		super(id);

		add(new Label("label", model));
	}
}

package com.mycompany;

import org.apache.wicket.Component;
import org.apache.wicket.markup.transformer.AbstractTransformerBehavior;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.Response;
import org.apache.wicket.response.StringResponse;
import org.apache.wicket.util.lang.Args;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A behavior that renders a component and returns a default content when
 * the rendering fails for any reason
 */
public class RenderSafeBehavior extends AbstractTransformerBehavior
{
	private static final Logger LOG = LoggerFactory.getLogger(RenderSafeBehavior.class);

	private final IModel<String> defaultContent;

	/**
	 * Constructor
	 *
	 * @param defaultContent
	 *              The content to use when the rendering of the component fails for any reason
	 */
	public RenderSafeBehavior(IModel<String> defaultContent)
	{
		this.defaultContent = Args.notNull(defaultContent, "defaultContent");
	}

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
		catch (Exception x)
		{
			LOG.error("An error occurred while rendering '{}' or some of its children components", x);
			result = defaultContent.getObject();
		}
		finally
		{
			component.getRequestCycle().setResponse(oldResponse);
		}
		return result;
	}
}

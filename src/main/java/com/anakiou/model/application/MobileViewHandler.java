package com.anakiou.model.application;

import javax.faces.application.ViewHandler;
import javax.faces.application.ViewHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class MobileViewHandler extends ViewHandlerWrapper {

	private final ViewHandler wrapped;

	public MobileViewHandler(ViewHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ViewHandler getWrapped() {
		return this.wrapped;
	}

	@Override
	public String calculateRenderKitId(FacesContext context) {

		HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
		String userAgent = req.getHeader("user-agent");
		String accept = req.getHeader("Accept");

		if (userAgent != null && accept != null) {
			UserAgentInfo agent = new UserAgentInfo(userAgent, accept);
			if (agent.isMobileDevice()) {
				System.out.println("this is a mobile device");
				return "PRIMEFACES_MOBILE";
			}
		}

		return this.wrapped.calculateRenderKitId(context);
	}
}

package com.anakiou.controller;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
@Qualifier("indexBean")
public class IndexBean {

	private String greeting = "NOT WORKING";

	@PostConstruct
	public void init() {
		String renderKitId = FacesContext.getCurrentInstance().getViewRoot().getRenderKitId();
		if (renderKitId.equalsIgnoreCase("PRIMEFACES_MOBILE")) {
			greeting = "THIS IS A MOBILE DEVICE";
		}
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

}

package com.dualexec.osgi.blueprint.rest.jersey;

public class ResourceState {

	private int state;

	public ResourceState() {
		this(0);
	}

	public ResourceState(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}

}

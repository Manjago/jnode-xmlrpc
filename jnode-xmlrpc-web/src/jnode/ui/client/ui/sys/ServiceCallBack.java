package jnode.ui.client.ui.sys;

import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class ServiceCallBack<E> implements AsyncCallback<E> {

	private Blocker blocker;
	private final String testStr;
	
	public ServiceCallBack(String testStr) {
		super();
		this.testStr = testStr;
	}
	
	public ServiceCallBack(Blocker blocker, String testStr) {
		super();
		this.blocker = blocker;
		this.testStr = testStr;
	}

	public void onFailure(Throwable caught) {
		stopBlocking();
		ExceptionHelper.showError(caught, testStr);
	}

	public abstract void onSuccess(E result);

	public Blocker getBlocker() {
		return blocker;
	}

	public void setBlocker(Blocker blocker) {
		this.blocker = blocker;
	}

	public String getTestStr() {
		return testStr;
	}

	protected void stopBlocking() {
		if (getBlocker() != null){
			getBlocker().stop();
		}
	}

}

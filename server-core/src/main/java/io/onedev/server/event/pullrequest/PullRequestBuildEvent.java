package io.onedev.server.event.pullrequest;

import java.util.Date;

import io.onedev.server.model.Build;
import io.onedev.server.persistence.dao.Dao;

public class PullRequestBuildEvent extends PullRequestEvent {

	private final Build build;
	
	public PullRequestBuildEvent(Build build) {
		super(null, new Date(), build.getRequest());
		this.build = build;
	}

	public Build getBuild() {
		return build;
	}

	@Override
	public String getActivity() {
		String activity = build.getJobName() + " ";
		if (build.getVersion() != null)
			activity = "build #" + build.getNumber() + " (" + build.getVersion() + ")";
		else
			activity = "build #" + build.getNumber();
		activity += " is " + build.getStatus();
		return activity;
	}

	@Override
	public PullRequestEvent cloneIn(Dao dao) {
		return new PullRequestBuildEvent(dao.load(Build.class, build.getId()));
	}

}

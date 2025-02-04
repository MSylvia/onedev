package io.onedev.server.plugin.notification.slack;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.onedev.server.web.editable.annotation.Editable;
import io.onedev.server.web.editable.annotation.OmitName;

@Editable
public class ChannelNotificationWrapper implements Serializable {

	private static final long serialVersionUID = 1L;

	private ChannelNotification channelNotification = new ChannelNotification();
	
	@Editable
	@OmitName
	@NotNull
	public ChannelNotification getChannelNotification() {
		return channelNotification;
	}

	public void setChannelNotification(ChannelNotification channelNotification) {
		this.channelNotification = channelNotification;
	}

}
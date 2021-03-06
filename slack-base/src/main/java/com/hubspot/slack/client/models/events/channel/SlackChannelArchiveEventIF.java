package com.hubspot.slack.client.models.events.channel;

import org.immutables.value.Value.Immutable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.hubspot.immutables.style.HubSpotStyle;
import com.hubspot.slack.client.models.events.SlackEvent;

@Immutable
@HubSpotStyle
@JsonNaming(SnakeCaseStrategy.class)
@JsonDeserialize(as = SlackChannelArchiveEvent.class)
public interface SlackChannelArchiveEventIF extends SlackEvent {
  @JsonProperty("channel")
  String getChannelId();

  @JsonProperty("user")
  String getUserId();

  //Channel archive events do not have a ts, so we manually set it as null
  @Override
  default String getTs() {
    return null;
  }
}

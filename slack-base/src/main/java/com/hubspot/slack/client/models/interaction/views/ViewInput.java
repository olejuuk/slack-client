package com.hubspot.slack.client.models.interaction.views;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonTypeInfo(
  use = Id.NAME,
  include = As.EXISTING_PROPERTY,
  property = "type",
  visible = true
)
@JsonNaming(SnakeCaseStrategy.class)
@JsonSubTypes(
  {
    @Type(value = ViewPlainTextInput.class, name = "plain_text_input"),
    @Type(value = UsersSelectInput.class, name = "users_select")
  }
)
public interface ViewInput {
  ViewInputType getType();
}

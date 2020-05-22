package dev.sample.jsf.data.dto;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import dev.sample.framework.core.message.MessageId;
import dev.sample.framework.core.util.MessageUtils;
import dev.sample.jsf.common.code.ButtonTypeVo;

/**
 * ダイアログDto.
 */
@Builder
@Data
public class DialogDto implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** ヘッダーメッセージ. */
  private MessageId headerMessageId;

  /** メッセージ. */
  private MessageId messageId;

  /** ボタンタイプ. */
  private ButtonTypeVo buttonType;

  /** okCallback. */
  private String okCallback;

  public String getHeaderMessage() {
    return MessageUtils.getMessage(headerMessageId);
  }

  public String getMessage() {
    return MessageUtils.getMessage(messageId);
  }

  public String getButtonType() {
    return buttonType.getCode();
  }

}

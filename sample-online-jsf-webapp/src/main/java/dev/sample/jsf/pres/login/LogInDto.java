package dev.sample.jsf.pres.login;

import dev.sample.framework.core.constant.Regexp;
import dev.sample.jsf.common.constant.ValidationMessageId;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * ログイン 画面DTO.
 */
@ViewScoped
@Named
@Data
public class LogInDto implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** Username. */
  @Size(max = 40, message = ValidationMessageId.V0001E)
  @Pattern(regexp = Regexp.HALF_NUM_ALPHA, message = ValidationMessageId.V0012E)
  private String username;

  /** Password. */
  @Size(max = 15, message = ValidationMessageId.V0001E)
  @Pattern(regexp = Regexp.PW, message = ValidationMessageId.V0021E)
  private String password;

}

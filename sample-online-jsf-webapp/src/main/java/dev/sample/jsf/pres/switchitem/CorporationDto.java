package dev.sample.jsf.pres.switchitem;

import dev.sample.jsf.common.constant.ValidationMessageId;
import java.io.Serializable;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * 法人DTO.
 */
@Data
public class CorporationDto implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** 法人番号. */
  @Size(max = 13, message = ValidationMessageId.V0001E)
  private String corporateNumber;

  /** 法人名. */
  @Size(max = 40, message = ValidationMessageId.V0001E)
  private String corporateName;

  /** 郵便番号. */
  @Size(max = 7, message = ValidationMessageId.V0001E)
  private String addressZip;

  /** 所在地. */
  @Size(max = 60, message = ValidationMessageId.V0001E)
  private String location;

}

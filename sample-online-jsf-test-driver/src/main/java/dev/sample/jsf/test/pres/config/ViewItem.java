package dev.sample.jsf.test.pres.config;

import dev.sample.framework.core.config.Configurable;
import java.util.List;
import lombok.Data;

/**
 * View Item.
 */
@Data
public class ViewItem implements Configurable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** view name. */
  private String viewName;

  /** url. */
  private String url;

  /** json files. */
  private List<String> jsonFiles;

}

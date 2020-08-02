package dev.sample.jsf.test.pres.menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Data;

/**
 * テスト・メニュー 画面DTO.
 */
@ViewScoped
@Named
@Data
public class TestMenuDto implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** url. */
  private String url;

  /** conf file name. */
  private String confFileName;

  /** conf value. */
  private String confValue;

  /** view items. */
  private List<ViewItem> viewItems;

  /** conf files. */
  private List<String> confFiles = new ArrayList<>();

}

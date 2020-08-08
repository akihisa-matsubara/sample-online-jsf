package dev.sample.jsf.test.pres.menu;

import dev.sample.jsf.test.pres.config.ViewItem;
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

  /** json file name. */
  private String jsonFileName;

  /** json value. */
  private String jsonValue;

  /** view items. */
  private List<ViewItem> viewItems;

  /** json files. */
  private List<String> jsonFiles = new ArrayList<>();

}

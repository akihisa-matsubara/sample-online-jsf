package jp.co.sample.jsf.pres.displayrulesample;

import jp.co.sample.framework.jsf.rule.ControlContent;
import jp.co.sample.framework.jsf.rule.RuleConditions;
import jp.co.sample.framework.jsf.rule.SpecNo;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 * <PRE>
 * 表示ルールサンプル ルール・条件.
 *
 * 制御仕様サンプル
 * 〇：活性表示
 * ●：非活性表示
 * ×：非表示
 * ※：設定+制御
 * -：制御無し
 * X：適用優先度
 * </PRE>
 * <table border="1">
 * <tr><th rowspan="3">画面項目</th><th colspan="12">制御仕様</th></tr>
 * <tr><th colspan="3">001</th><th colspan="3">002</th><th colspan="3">003</th><th colspan="3">004</th></tr>
 * <tr><th>01</th><th>02</th><th>03</th><th>01</th><th>02</th><th>03</th><th>01</th><th>02</th><th>03</th><th>01</th><th>02</th><th>03</th></tr>
 * <tr><td>item1</td><td>●3</td><td>-</td><td>-</td><td>×1</td><td>-</td><td>-</td><td>-</td><td>※2</td><td>-</td><td>-</td><td>-</td><td>-</td></tr>
 * <tr><td>item2</td><td>-</td><td>-</td><td>×1</td><td>-</td><td>-</td><td>-</td><td>×2</td><td>-</td><td>-</td><td>-</td><td>※3</td><td>-</td></tr>
 * <tr><td>item3</td><td>〇4</td><td>●3</td><td>-</td><td>〇2</td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td><td>×1</td><td>-</td><td>-</td></tr>
 * <tr><td>item4</td><td>-</td><td>-</td><td>-</td><td>-</td><td>〇1</td><td>-</td><td>-</td><td>×2</td><td>-</td><td>-</td><td>-</td><td>-</td></tr>
 * <tr><td>item5</td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td></tr>
 * </table>
 */
@ViewScoped
public class DisplayRuleSampleRule implements RuleConditions, Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** 表示ルールサンプル 画面DTO. */
  @Inject
  private DisplayRuleSampleDto dto;

  /**
   * {@inheritDoc}
   */
  @Override
  public String matchesNo001() {
    if (dto.getItem1() == null) {
      return null;
    }

    switch (dto.getItem1()) {
      case "1":
        return SpecNo.NO_001_01;
      case "2":
        return SpecNo.NO_001_02;
      case "3":
        return SpecNo.NO_001_03;
      default:
        break;
    }
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String matchesNo002() {
    if (dto.getItem2() == null) {
      return null;
    }

    switch (dto.getItem2()) {
      case "1":
        return SpecNo.NO_002_01;
      case "2":
        return SpecNo.NO_002_02;
      case "3":
        return SpecNo.NO_002_03;
      default:
        break;
    }
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String matchesNo003() {
    if (dto.getItem3() == null) {
      return null;
    }

    switch (dto.getItem3()) {
      case "1":
        return SpecNo.NO_003_01;
      case "2":
        return SpecNo.NO_003_02;
      case "3":
        return SpecNo.NO_003_03;
      default:
        break;
    }
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String matchesNo004() {
    if (dto.getItem4() == null) {
      return null;
    }

    switch (dto.getItem4()) {
      case "1":
        return SpecNo.NO_004_01;
      case "2":
        return SpecNo.NO_004_02;
      case "3":
        return SpecNo.NO_004_03;
      default:
        break;
    }
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ControlContent updateValue(String itemId, String displayRuleName) {
    switch (itemId) {
      case "item1":
        if (SpecNo.NO_003_02.equals(displayRuleName)) {
          dto.setItem5(SpecNo.NO_003_02);
          return ControlContent.DISABLED;
        }
        break;
      case "item2":
        if (SpecNo.NO_004_02.equals(displayRuleName)) {
          dto.setItem5(SpecNo.NO_004_02);
          return ControlContent.DISABLED;
        }
        break;
      default:
        break;
    }
    return null;
  }
}

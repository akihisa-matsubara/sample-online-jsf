package dev.sample.jsf.pres.ui.codesearch;

import dev.sample.common.code.GenericCodeVo;
import dev.sample.framework.core.interceptor.DebugLog;
import dev.sample.framework.core.interceptor.OutputTiming;
import dev.sample.jsf.common.code.NationalityVo;
import dev.sample.jsf.common.constant.ProcessName;
import dev.sample.jsf.pres.BackingBeanBase;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;

/**
 * コード検索 BackingBean.
 */
@ViewScoped
@Named
public class CodeSearchBean extends BackingBeanBase implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** コード検索 画面DTO. */
  @Inject
  private CodeSearchDto dto;

  /** コード検索パラメーターDTO. */
  @Inject
  private CodeSearchParameterDto parameterDto;

  /**
   * 初期化.
   *
   * @param callback コード検索 選択Callback
   */
  public void init(CodeSearchSelectedCallback callback) {
    // TODO 検索処理代わり（全件取得後に抽出することを前提とした実装）
    List<GenericCodeVo> codeVos = Arrays.stream(NationalityVo.values())
        .map(codeVo -> new GenericCodeVo(codeVo.getCode(), codeVo.getDecode()))
        .collect(Collectors.toList());

    // 指定コードあり
    if (StringUtils.isNotEmpty(parameterDto.getCodeVo().getCode())) {
      Optional<GenericCodeVo> findByCode = codeVos.stream()
          .filter(codeVo -> codeVo.getCode().equals(parameterDto.getCodeVo().getCode()))
          .findFirst();

      // 指定コードと一致
      if (findByCode.isPresent()) {
        parameterDto.setSearchResultCount(1);
        parameterDto.setCodeVo(findByCode.get());
        // 主画面Callback呼び出し
        callback.selectedCodeValues(parameterDto);

        // 指定コードと不一致
      } else {
        parameterDto.setSearchResultCount(0);

      }

      // 指定コードなし
    } else {
      dto.setCodeVos(codeVos);
      parameterDto.setSearchResultCount(codeVos.size());

    }

  }

  /**
   * コード選択のアクションメソッド.
   *
   * @param callback コード検索 選択Callback
   * @param codeVo 汎用コードVO
   */
  @DebugLog(outputTiming = OutputTiming.COMPLETE, processName = ProcessName.SELECTED, dtoClass = CodeSearchParameterDto.class)
  public void pushCodeValue(CodeSearchSelectedCallback callback, GenericCodeVo codeVo) {
    parameterDto.setCodeVo(codeVo);
    parameterDto.setSearchResultCount(1);
    // 主画面Callback呼び出し
    callback.selectedCodeValues(parameterDto);
  }

}

// Note: selector is not escape.
/* global M, sampleRoot */

/**
 * 初期処理
 */
$(() => {
  // Materialize初期化
  sampleRoot.materialize.init();
  sampleRoot.message.init();
  sampleRoot.radio.init();
  sampleRoot.dialog.modal.init();
});

/**
 * 定数
 */
sampleRoot.const = {
  key: {
    TAB_KEY: 9,
  },
  class: {
    VALID: 'valid',
    INVALID: 'invalid',
    MODAL: 'modal',
    MODAL_TRIGGER: 'modal-trigger',
    MODAL_CLOSE: 'modal-close',
    SIDE_AREA: 'sideArea',
    TABLE_OF_CONTENTS: 'table-of-contents',
    DATE_PICKER: 'datepicker',
  },
  attribute: {
    ATT_DATA_TARGET: 'data-target',
    ATT_DATA_ERR: 'data-error',
    ATT_DATA_LENGTH: 'data-length',
  },
  idSuffix: {
    JSF_ERR_MSG_ID_SUFFIX: 'ErrMsg',
    HELPER_TEXT_ID_SUFFIX: 'HelperText',
    INITIAL_VALUE_ID_SUFFIX: 'InitialValue',
    UPLOAD_FILE_ID_SUFFIX: '_file',
    UPLOAD_FILE_NAME_ID_SUFFIX: '_name',
    MODAL_HEADER_MESSAGE_ID_SUFFIX: '_headerMessage',
    MODAL_MESSAGE_ID_SUFFIX: '_message',
    SEARCH_RESULT_COUNT_ID_SUFFIX: '_searchResultCount',
  },
};

/**
 * メッセージ制御
 */
sampleRoot.message = (function () {
  const { VALID } = sampleRoot.const.class;
  const { INVALID } = sampleRoot.const.class;
  const { JSF_ERR_MSG_ID_SUFFIX } = sampleRoot.const.idSuffix;
  const { HELPER_TEXT_ID_SUFFIX } = sampleRoot.const.idSuffix;
  const { ATT_DATA_ERR } = sampleRoot.const.attribute;

  /**
   * Validationの結果メッセージを画面に表示する
   *
   * @param {string} targetId input tag id
   */
  const showErrMsg = (targetId) => {
    if (!targetId || !$(`#${targetId}`)[0] || !$(`#${targetId}${JSF_ERR_MSG_ID_SUFFIX}`)[0]) {
      return;
    }

    const msg = $(`#${targetId}${JSF_ERR_MSG_ID_SUFFIX}`).text();
    const $target = $(`#${targetId}`);

    if (msg) {
      // jsf error message is not empty -> invalid
      $target.removeClass(VALID).addClass(INVALID);
      $(`#${targetId}${HELPER_TEXT_ID_SUFFIX}`).attr(ATT_DATA_ERR, msg);
    } else if ($target.val()) {
      // value is not empty -> valid
      $target.removeClass(INVALID).addClass(VALID);
      $(`#${targetId}${HELPER_TEXT_ID_SUFFIX}`).removeAttr(ATT_DATA_ERR);
    } else {
      // value is empty -> validation status reset
      $target.removeClass(`${INVALID} ${VALID}`);
      $(`#${targetId}${HELPER_TEXT_ID_SUFFIX}`).removeAttr(ATT_DATA_ERR);
    }
  };

  /**
   * Validationの結果メッセージを画面に一括表示する
   */
  const init = () => {
    $(`span[id$=${JSF_ERR_MSG_ID_SUFFIX}]`).each((index, elem) => showErrMsg(elem.id.replace(JSF_ERR_MSG_ID_SUFFIX, '')));
  };

  return {
    init,
    showErrMsg,
  };
}());

/**
 * スクロール制御
 */
sampleRoot.scroll = (function () {
  /**
   * 指定位置にスクロールする
   *
   * @param {number} verticalPosition 縦位置
   */
  const scroll = (verticalPosition) => {
    $('html,body').animate({
      scrollTop: verticalPosition,
    });
  };

  /**
   * 先頭にスクロールする
   */
  const top = () => scroll(0);

  /**
   * 末尾にスクロールする
   */
  const bottom = () => scroll($(document).height() - $(window).height());

  return {
    top,
    bottom,
  };
}());

/**
 * ラジオボタン制御
 */
sampleRoot.radio = (function () {
  const { INITIAL_VALUE_ID_SUFFIX } = sampleRoot.const.idSuffix;

  /**
   * 初期化
   */
  const init = () => {
    $('input[type="radio"][id$="radio"]').each((index, elem) => {
      const target = $(elem).prop('name') + INITIAL_VALUE_ID_SUFFIX;
      const value = $(elem).val();
      const selectedValue = $(`#${target}`).text();
      if (value === selectedValue) {
        $(elem).prop('checked', true);
      }
    });
  };

  return {
    init,
  };
}());

/**
 * ファイル アップロード制御
 */
sampleRoot.fileUpload = (function () {
  const { UPLOAD_FILE_ID_SUFFIX } = sampleRoot.const.idSuffix;
  const { UPLOAD_FILE_NAME_ID_SUFFIX } = sampleRoot.const.idSuffix;

  /**
   * クリア
   *
   * @param {string} id file upload component id
   */
  const clear = (id) => {
    $(`#${id}${UPLOAD_FILE_ID_SUFFIX}`).val('');
    $(`#${id}${UPLOAD_FILE_NAME_ID_SUFFIX}`).val('').removeClass('valid invalid');
  };

  return {
    clear,
  };
}());

/**
 * ダイアログ制御
 */
sampleRoot.dialog = (function () {
  const { VALID } = sampleRoot.const.class;
  const { INVALID } = sampleRoot.const.class;
  const GENERIC_DIALOG_ID = 'genericDialog';
  const { MODAL_HEADER_MESSAGE_ID_SUFFIX } = sampleRoot.const.idSuffix;
  const { MODAL_MESSAGE_ID_SUFFIX } = sampleRoot.const.idSuffix;

  /**
   * フォーカス移動をダイアログ内に設定する
   *
   * @param {string} dialogId dialog id
   */
  const focusOnDialog = (dialogId) => {
    const { TAB_KEY } = sampleRoot.const.key;
    let $focusableEls;
    let targetIndex;
    let $nextFocusEl;

    $(`#${dialogId}`).focus();

    $(document).off('keydown.focusOnDialog');
    $(document).on('keydown.focusOnDialog', { dialogId }, (e) => {
      if (e.keyCode !== TAB_KEY) {
        return;
      }
      $focusableEls = $(`#${dialogId}`)
        .find('a[href], area[href], input, select, textarea, button, iframe, object, embed, *[tabindex], *[contenteditable]')
        .not('[tabindex=-1], [disabled], :hidden');
      targetIndex = $focusableEls.index(e.target);

      if (targetIndex < 0) {
        $nextFocusEl = e.shiftKey ? $focusableEls.last() : $focusableEls.first();
        setTimeout(() => $nextFocusEl.focus(), 0);
      } else if (targetIndex === 0 && e.shiftKey) {
        $focusableEls.last().focus();
        e.preventDefault();
      } else if (targetIndex === ($focusableEls.length - 1) && !e.shiftKey) {
        $focusableEls.first().focus();
        e.preventDefault();
      }
    });
  };

  /**
   * エラーダイアログを表示する
   *
   * @param {string} message error message
   */
  const showErrDialog = (message) => {
    $(`#${GENERIC_DIALOG_ID}${MODAL_HEADER_MESSAGE_ID_SUFFIX}`).text('エラー');
    $(`#${GENERIC_DIALOG_ID}${MODAL_MESSAGE_ID_SUFFIX}`).text(message);

    sampleRoot.dialog.modal.open(GENERIC_DIALOG_ID);
  };

  /**
   * メッセージが存在する場合、エラーダイアログを表示する
   *
   * @param {Object} e AjaxEvent
   * @param {string} errMsgId error message id(span tag)
   * @param {string} targetId input tag id
   */
  const isExistShowErrDialog = (e, errMsgId, targetId) => {
    if (e.status !== 'success' || !errMsgId || !$(`#${errMsgId}`) || !$(`#${errMsgId}`).text()) {
      return;
    }

    const msg = $(`#${errMsgId}`).text();
    if (targetId) {
      const $target = $(`#${targetId}`);
      if (msg) {
        // jsf error message is not empty -> invalid
        $target.removeClass(VALID).addClass(INVALID);
      } else if ($target.val()) {
        // value is not empty -> valid
        $target.removeClass(INVALID).addClass(VALID);
      } else {
        // value is empty -> validation status reset
        $target.removeClass(`${INVALID} ${VALID}`);
      }
    }
    showErrDialog(msg);
  };

  return {
    focusOnDialog,
    showErrDialog,
    isExistShowErrDialog,
  };
}());

/**
 * Modal制御
 */
sampleRoot.dialog.modal = (function () {
  const { MODAL } = sampleRoot.const.class;
  const { MODAL_TRIGGER } = sampleRoot.const.class;
  const { MODAL_CLOSE } = sampleRoot.const.class;
  const { ATT_DATA_TARGET } = sampleRoot.const.attribute;
  const { SEARCH_RESULT_COUNT_ID_SUFFIX } = sampleRoot.const.idSuffix;

  /**
   * 初期化
   *
   * @param {Object} elem modal element
   */
  const initBy = (elem) => {
    // ModalのOverlayクリック時にModalを閉じないように設定
    M.Modal.init(elem, {
      dismissible: false,
    });
  };

  /**
   * 初期化
   */
  const init = () => {
    const elems = document.querySelectorAll(`.${MODAL}`);
    elems.forEach((elem) => initBy(elem));

    $(document).off('click.modalTrigger');
    $(document).on('click.modalTrigger', `.${MODAL_TRIGGER}`, (e) => {
      const { currentTarget } = e;
      let modalId;
      if (currentTarget.tagName === 'A') {
        modalId = $(currentTarget).attr('href').replace('#', '');
        sampleRoot.dialog.focusOnDialog(modalId);
      } else if (currentTarget.tagName === 'BUTTON') {
        modalId = $(currentTarget).attr(ATT_DATA_TARGET);
        sampleRoot.dialog.focusOnDialog(modalId);
      }
    });

    $(document).off('click.modalClose');
    $(document).on('click.modalClose', `.${MODAL_CLOSE}`, () => $(document).off('keydown.focusOnDialog'));
  };

  /**
   * モーダルを開く
   * ※Materializeをラップ
   *
   * @param {string} modalId modal id
   */
  const open = (modalId) => {
    $(`#${modalId}`).modal('open');
    sampleRoot.dialog.focusOnDialog(modalId);
  };

  /**
   * 検索結果モーダルを開く
   * 0件:     エラーメッセージ表示
   * 1件:     何もしない
   * 2件以上: モーダルを開く
   *
   * @param {Object} e AjaxEvent
   */
  const openSearchResult = (e) => {
    if (e.status !== 'success') {
      return;
    }

    let $targetModal;
    const modalId = $(`#${e.source.id}`).attr(ATT_DATA_TARGET);
    const searchResultCount = $(`#${modalId}${SEARCH_RESULT_COUNT_ID_SUFFIX}`).text();

    if (searchResultCount === '0') {
      sampleRoot.dialog.showErrDialog('該当のコードは存在しません');
    } else if (Number(searchResultCount) > 1) {
      $targetModal = $(`#${modalId}`);
      initBy($targetModal);
      open(modalId);
    }
  };

  return {
    init,
    initBy,
    open,
    openSearchResult,
  };
}());

/**
 * Materialize制御
 */
sampleRoot.materialize = (function () {
  const { SIDE_AREA } = sampleRoot.const.class;
  const { TABLE_OF_CONTENTS } = sampleRoot.const.class;
  const { DATE_PICKER } = sampleRoot.const.class;
  const { ATT_DATA_LENGTH } = sampleRoot.const.attribute;

  /**
   * 初期化
   */
  const init = () => {
    let footerOffset;
    let tocHeight;
    let bottomOffset;

    // initialize all of the Materialize Components
    M.AutoInit();

    // 文字カウンターはAutoInitの対象外なので個別に初期化
    $(`input[${ATT_DATA_LENGTH}], textarea[${ATT_DATA_LENGTH}]`).characterCounter();

    // 目次(table-of-contents)初期化
    if ($(`.${SIDE_AREA}`).length) {
      footerOffset = $('form > footer').first().length ? $('form > footer').first().offset().top : 0;
      tocHeight = $(`.${SIDE_AREA} .${TABLE_OF_CONTENTS}`).length ? $(`.${SIDE_AREA} .${TABLE_OF_CONTENTS}`).height() : 0;
      bottomOffset = footerOffset - tocHeight;

      if ($('nav').length) {
        $(`.${SIDE_AREA}`).pushpin({
          top: $(`.${SIDE_AREA}`).offset().top,
          bottom: bottomOffset,
        });
      } else {
        $(`.${SIDE_AREA}`).pushpin({
          top: 0,
          bottom: bottomOffset,
        });
      }
    }

    // ModalのOverlayクリック時にModalを閉じないように設定
    sampleRoot.dialog.modal.init();

    // Pickers 設定変更
    const elems = document.querySelectorAll(`.${DATE_PICKER}`);
    elems.forEach((elem) => {
      M.Datepicker.init(elem, {
        autoClose: true,
        format: 'yyyy-mm-dd',
      });
    });
  };

  /**
   * Ajaxなど動的にDOM更新後に初期化する
   */
  const dynamicInit = () => {
    // textarea, select初期化
    $('textarea').each((index, elem) => {
      M.textareaAutoResize($(elem));
    });
    $('select').formSelect();
    // ラベル初期化
    M.updateTextFields();
  };

  return {
    init,
    dynamicInit,
  };
}());

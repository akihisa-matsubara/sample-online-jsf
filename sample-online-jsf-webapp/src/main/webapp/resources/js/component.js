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
 * メッセージ制御
 */
sampleRoot.message = (function () {
  const VALID = 'valid';
  const INVALID = 'invalid';
  const JSF_ERR_MSG_ID_SUFFIX = 'ErrMsg';
  const HELPER_TEXT_ID_SUFFIX = 'HelperText';
  const ATT_DATA_ERR = 'data-error';

  /**
   * Validationの結果メッセージを画面に表示する
   *
   * @param {String} targetId id
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
  const INITIAL_VALUE_ID_SUFFIX = 'InitialValue';

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
 * ダイアログ制御
 */
sampleRoot.dialog = (function () {
  /**
   * フォーカス移動をダイアログ内に設定する
   *
   * @param {String} dialogId dialog id
   */
  const focusOnDialog = (dialogId) => {
    const TAB_KEY = 9;
    let $focusableEls;
    let targetIndex;
    let $nextFocusEl;

    $(`#${dialogId}`).focus();

    $(document).off('keydown.focusOnDialog');
    $(document).on('keydown.focusOnDialog', { dialogId }, (e) => {
      if (e.keyCode === TAB_KEY) {
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
      }
    });
  };

  /**
   * エラーダイアログを表示する
   *
   * @param {String} message error message
   */
  const showErrDialog = (message) => {
    $('#genericDialog_headerMessage').text('エラー');
    $('#genericDialog_message').text(message);

    sampleRoot.dialog.modal.open('genericDialog');
  };

  return {
    focusOnDialog,
    showErrDialog,
  };
}());

/**
 * Modal制御
 */
sampleRoot.dialog.modal = (function () {
  const ATT_DATA_TARGET = 'data-target';
  const SEARCH_RESULT_COUNT_ID_SUFFIX = '_searchResultCount';

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
    const elems = document.querySelectorAll('.modal');
    elems.forEach((elem) => initBy(elem));

    $(document).off('click.modalTrigger');
    $(document).on('click.modalTrigger', '.modal-trigger', (e) => {
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
    $(document).on('click.modalClose', '.modal-close', (e) => $(document).off('keydown.focusOnDialog'));
  };

  /**
   * モーダルを開く
   * ※Materializeをラップ
   *
   * @param {String} modalId modal id
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
    if (e.status === 'success') {
      let $targetModal;
      const modalId = $(`#${e.source.id}`).attr(ATT_DATA_TARGET);
      const searchResultCount = $(`#${modalId}${SEARCH_RESULT_COUNT_ID_SUFFIX}`).text();

      if (searchResultCount === '0') {
        sampleRoot.dialog.showErrDialog('該当のコードは存在しません');
      } else if (searchResultCount > 1) {
        $targetModal = $(`#${modalId}`);
        initBy($targetModal);
        open(modalId);
      }
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
    $('input[data-length], textarea[data-length]').characterCounter();

    // 目次(table-of-contents)初期化
    if ($('.sideArea').length) {
      footerOffset = $('form > footer').first().length ? $('form > footer').first().offset().top : 0;
      tocHeight = $('.sideArea .table-of-contents').length ? $('.sideArea .table-of-contents').height() : 0;
      bottomOffset = footerOffset - tocHeight;

      if ($('nav').length) {
        $('.sideArea').pushpin({
          top: $('.sideArea').offset().top,
          bottom: bottomOffset,
        });
      } else {
        $('.sideArea').pushpin({
          top: 0,
          bottom: bottomOffset,
        });
      }
    }

    // ModalのOverlayクリック時にModalを閉じないように設定
    sampleRoot.dialog.modal.init();

    // Pickers 設定変更
    const elems = document.querySelectorAll('.datepicker');
    elems.forEach((elem) => {
      M.Datepicker.init(elem, {
        autoClose: true,
        format: 'yyyy-mm-dd',
      });
    });
  };

  return {
    init,
  };
}());

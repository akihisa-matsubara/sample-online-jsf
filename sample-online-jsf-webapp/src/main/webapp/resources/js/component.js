;
'use strict';

// Note: selector is not escqpe.

/**
 * 初期処理
 */
$(function() {
  // Materialize初期化
  sampleRoot.materialize.init();

  sampleRoot.message.initErrMsg();
  sampleRoot.radio.init();
  sampleRoot.dialog.modal.init();
});

/**
 * メッセージ制御
 */
sampleRoot.message = function() {
  const VALID = 'valid', INVALID = 'invalid', JSF_ERR_MSG_ID_SUFFIX = 'ErrMsg', HELPER_TEXT_ID_SUFFIX = 'HelperText', ATT_DATA_ERR = 'data-error';
  let initErrMsg, showErrMsg;

  /**
   * Validationの結果メッセージを画面に一括表示する
   */
  initErrMsg = function() {
    $('span[id$=' + JSF_ERR_MSG_ID_SUFFIX + ']').each(function(index, elem) {
      showErrMsg(elem.id.replace(JSF_ERR_MSG_ID_SUFFIX, ''));
    });
  };

  /**
   * Validationの結果メッセージを画面に表示する
   *
   * @param {String} targetId id
   */
  showErrMsg = function(targetId) {
    let msg, $target;

    if (!targetId || !$('#' + targetId)[0] || !$('#' + targetId + JSF_ERR_MSG_ID_SUFFIX)[0]) {
      return;
    }

    msg = $('#' + targetId + JSF_ERR_MSG_ID_SUFFIX).text();
    $target = $('#' + targetId);

    if (msg) {
      // jsf error message is not empty -> invalid
      $target.removeClass(VALID).addClass(INVALID);
      $('#' + targetId + HELPER_TEXT_ID_SUFFIX).attr(ATT_DATA_ERR, msg);

    } else if ($target.val()) {
      // value is not empty -> valid
      $target.removeClass(INVALID).addClass(VALID);
      $('#' + targetId + HELPER_TEXT_ID_SUFFIX).removeAttr(ATT_DATA_ERR);

    } else {
      // value is empty -> validation status reset
      $target.removeClass(INVALID + ' ' + VALID);
      $('#' + targetId + HELPER_TEXT_ID_SUFFIX).removeAttr(ATT_DATA_ERR);

    }
  };

  return {
    initErrMsg : initErrMsg,
    showErrMsg : showErrMsg
  };
}();

/**
 * スクロール制御
 */
sampleRoot.scroll = function() {
  let top, bottom, scroll;

  /**
   * 先頭にスクロールする
   */
  top = function() {
    scroll(0);
  };

  /**
   * 末尾にスクロールする
   */
  bottom = function() {
    scroll($(document).height() - $(window).height());
  };

  /**
   * 指定位置にスクロールする
   *
   * @param {number} verticalPosition 縦位置
   */
  scroll = function(verticalPosition) {
    $('html,body').animate({
      scrollTop : verticalPosition
    });

  };

  return {
    top : top,
    bottom : bottom
  };
}();

/**
 * ラジオボタン制御
 */
sampleRoot.radio = function() {
  let init;
  const INITIAL_VALUE_ID_SUFFIX = 'InitialValue';

  /**
   * 初期化
   */
  init = function() {
    $('input[type="radio"][id$="radio"]').each(function(index, elem) {
      let target, value, selectedValue;
      target = $(elem).prop('name') + INITIAL_VALUE_ID_SUFFIX;
      value = $(elem).val();
      selectedValue = $('#' + target).text();
      if (value === selectedValue) {
        $(elem).prop('checked', true);
      }
    });
  };

  return {
    init : init
  };
}();

/**
 * ダイアログ制御
 */
sampleRoot.dialog = function() {
  let focusOnDialog, showErrDialog;

  /**
   * フォーカス移動をダイアログ内に設定する
   *
   * @param {String} dialogId dialog id
   */
  focusOnDialog = function(dialogId) {
    const TAB_KEY = 9;
    let $focusableEls, targetIndex, $nextFocusEl;

    $('#' + dialogId).focus();

    $(document).off('keydown.focusOnDialog');
    $(document).on('keydown.focusOnDialog', {dialogId : dialogId}, function(e) {
      if (e.keyCode === TAB_KEY) {
        $focusableEls = $('#' + dialogId)
            .find('a[href], area[href], input, select, textarea, button, iframe, object, embed, *[tabindex], *[contenteditable]')
            .not('[tabindex=-1], [disabled], :hidden');
        targetIndex = $focusableEls.index(e.target);

        if (targetIndex < 0) {
          $nextFocusEl = e.shiftKey ? $focusableEls.last() : $focusableEls.first();
          setTimeout(function() {
            $nextFocusEl.focus();
          }, 0);
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
  showErrDialog = function(message) {
    $('#genericDialog_headerMessage').text('エラー');
    $('#genericDialog_message').text(message);

    sampleRoot.dialog.modal.open('genericDialog');
  };

  return {
    focusOnDialog : focusOnDialog,
    showErrDialog : showErrDialog
  };
}();

/**
 * Modal制御
 */
sampleRoot.dialog.modal = function() {
  let init, initBy, open, openConditionally;
  const ATT_DATA_TARGET = 'data-target', SEARCH_RESULT_COUNT_ID_SUFFIX = '_searchResultCount';

  /**
   * 初期化
   */
  init = function() {
    let elems = document.querySelectorAll('.modal');
    elems.forEach(function(elem) {
      initBy(elem);
    });

    $(document).off('click.modalTrigger');
    $(document).on('click.modalTrigger', '.modal-trigger', function (e) {
      let modalId;
      if (this.tagName === 'A') {
        modalId = $(this).attr('href').replace('#', '');
        sampleRoot.dialog.focusOnDialog(modalId);
      } else if (this.tagName === 'BUTTON') {
        modalId = $(this).attr(ATT_DATA_TARGET);
        sampleRoot.dialog.focusOnDialog(modalId);
      }

    });

    $(document).off('click.modalClose');
    $(document).on('click.modalClose', '.modal-close', function (e) {
      $(document).off('keydown.focusOnDialog');
    });
  };

  /**
   * 初期化
   *
   * @param {Object} elem modal element
   */
  initBy = function(elem) {
    // ModalのOverlayクリック時にModalを閉じないように設定
    M.Modal.init(elem, {
      'dismissible' : false
    });
  };

  /**
   * モーダルを開く
   * ※Materializeをラップ
   *
   * @param {String} modalId modal id
   */
  open = function(modalId) {
    $('#' + modalId).modal('open');
    sampleRoot.dialog.focusOnDialog(modalId);
  };

  /**
   * 条件付きでモーダルを開く
   * 0件:     エラーメッセージ表示
   * 1件:     何もしない
   * 2件以上: モーダルを開く
   *
   * @param {Object} e AjaxEvent
   */
  openConditionally = function(e) {
    if (e.status === 'success') {
      let modalId, searchResultCount, $targetModal;
      modalId = $('#' + e.source.id).attr(ATT_DATA_TARGET);
      searchResultCount = $('#' + modalId + SEARCH_RESULT_COUNT_ID_SUFFIX).text();

      if (searchResultCount === '0') {
        sampleRoot.dialog.showErrDialog('該当のコードは存在しません');

      } else if (1 < searchResultCount) {
        $targetModal = $('#' + modalId);
        initBy($targetModal);
        open(modalId);
      }
    }
  };

  return {
    init : init,
    initBy : initBy,
    open : open,
    openConditionally : openConditionally
  };
}();

/**
 * Materialize制御
 */
sampleRoot.materialize = function() {
  let init;

  /**
   * 初期化
   */
  init = function() {
    let footerOffset, tocHeight, bottomOffset, elems;

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
        console.log('Nav pushpin', $('nav').height());
        $('.sideArea').pushpin({
          top : $('.sideArea').offset().top,
          bottom : bottomOffset
        });
      } else {
        $('.sideArea').pushpin({
          top : 0,
          bottom : bottomOffset
        });
      }
    }

    // ModalのOverlayクリック時にModalを閉じないように設定
    sampleRoot.dialog.modal.init();

    // Pickers 設定変更
    elems = document.querySelectorAll('.datepicker');
    elems.forEach(function(elem) {
      M.Datepicker.init(elem, {
        'autoClose' : true,
        'format' : 'yyyy-mm-dd'
      });
    });
  };

  return {
    init : init
  };
}();

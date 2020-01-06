;
'use strict';
sampleRoot.ajax = sampleRoot.ajax || {};

/**
 * 初期処理
 */
$(function() {
  // Materialize初期化
  sampleRoot.materialize.init();

  sampleRoot.message.initErrMsg();
  sampleRoot.radio.init();
});

/**
 * Ajax制御
 */
sampleRoot.ajax = function() {
  /**
   * Validation FWの結果メッセージを画面に表示する
   *
   * @param {Object} e AjaxEvent
   */
  let showErrMsg = function(e) {
    if (e.status === 'success') {
      sampleRoot.message.showErrMsg(e.source.id);
    }
  };

  return {
    showErrMsg : showErrMsg
  };
}();

/**
 * メッセージ制御
 */
sampleRoot.message = function() {
  const VALID = 'valid', INVALID = 'invalid', JSF_ERR_MSG_ID_SUFFIX = 'ErrMsg', HELPER_TEXT_ID_SUFFIX = 'HelperText', ATT_DATA_ERR = 'data-error';
  let initErrMsg, showErrMsg;

  /**
   * Validation FWの結果メッセージを画面に一括表示する
   */
  initErrMsg = function() {
    $('span[id$=' + JSF_ERR_MSG_ID_SUFFIX + ']').each(function(index, elem) {
      showErrMsg(elem.id.replace(JSF_ERR_MSG_ID_SUFFIX, ''));
    });
  };

  /**
   * Validation FWの結果メッセージを画面に表示する
   *
   * @param {String} targetId id
   */
  showErrMsg = function(targetId) {
    let msg, $target;
    msg = $('#' + targetId + JSF_ERR_MSG_ID_SUFFIX).text();
    $target = $('#' + targetId);

    if (msg) {
      // jsf error message is not empty -> invalid
      $target.removeClass(VALID).addClass(INVALID);
      $('#' + targetId + HELPER_TEXT_ID_SUFFIX).attr(ATT_DATA_ERR, msg);

    } else if ($target.val()) {
      // value is not empty -> valid
      $target.removeClass(INVALID).addClass(VALID);

    } else {
      // value is empty -> validation status reset
      $target.removeClass(INVALID + ' ' + VALID);

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

  /**
   * 初期化
   */
  init = function() {
    $('input[type="radio"][id$="radio"]').each(function(index, elem) {
      let target, value, selectedValue;
      target = $(elem).prop('name') + 'InitialValue';
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
    elems = document.querySelectorAll('.modal');
    elems.forEach(function(elem) {
      M.Modal.init(elem, {
        'dismissible' : false
      });
    });

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

/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 * Created by Storm Browser Project 17/12/2020 */

function translate(value, elem){
    // Translation endpoint removed during rebranding.
    return;
}
    
    function findGetParameter(parameterName) {
        var result = null,
            tmp = [];
        location.search
            .substr(1)
            .split("&")
            .forEach(function (item) {
              tmp = item.split("=");
              if (tmp[0] === parameterName) result = decodeURIComponent(tmp[1]);
            });
        return result;
    }
    
    $(document).ready(function() {
       
    $('h1, h2, h3, h4, label, p, div, span, button, a, li, ul, td').each(function(){
        console.log(encodeURIComponent($(this).text()))
        if(findGetParameter("lang") == "fr" && $(this).children().length == 0 || findGetParameter("lang") == "fr" && $(this).children('br')[0] != null && $(this).children().length == 1 || findGetParameter("lang") == "fr" && $(this).children('b')[0] != null && $(this).children().length == 1){
            $(this).text(translate($(this).text(), this));
        }
    })
});
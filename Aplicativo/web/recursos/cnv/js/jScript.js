/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*document.getElementById("uploadBtn").onchange = function () {
 document.getElementById("uploadFile").value = this.value;
 };*/
$(".upinput").change(function () {
    $(".uplabel").val(this.value);
});


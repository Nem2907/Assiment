/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function toggleResetPswd(e) {
    e.preventDefault();
    $('#logreg-forms .form-signin').toggle(); // display:block or none
    $('#logreg-forms .form-reset').toggle(); // display:block or none
}

function toggleSignUp(e) {
    e.preventDefault();
    $('#logreg-forms .form-signin').toggle(); // display:block or none
    $('#logreg-forms .form-signup').toggle(); // display:block or none
}

$(() => {
    // Login Register Form
    $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
    $('#logreg-forms #cancel_reset').click(toggleResetPswd);
    $('#logreg-forms #btn-signup').click(toggleSignUp);
    $('#logreg-forms #cancel_signup').click(toggleSignUp);
});

$(document).ready(function () {
    // Activate tooltip
    $('[data-toggle="tooltip"]').tooltip();

    // Select/Deselect checkboxes
    var checkbox = $('table tbody input[type="checkbox"]');
    $("#selectAll").click(function () {
        if (this.checked) {
            checkbox.each(function () {
                this.checked = true;
            });
        } else {
            checkbox.each(function () {
                this.checked = false;
            });
        }
    });
    checkbox.click(function () {
        if (!this.checked) {
            $("#selectAll").prop("checked", false);
        }
    });
});

function actionProduct(event, element, actionType, productId) {
    event.preventDefault(); // Ngăn form submit mặc định

    let form = element.closest('form'); // Lấy form chứa nút bấm
    let url = new URL(form.action, window.location.origin);

    url.searchParams.set("action", actionType);
    form.action = url.toString(); // Cập nhật action mới

    // Kiểm tra xem input đã tồn tại chưa, tránh thêm nhiều lần
    let inputProductId = form.querySelector('input[name="productId"]');
    if (!inputProductId) {
        inputProductId = document.createElement('input');
        inputProductId.type = 'hidden';
        inputProductId.name = 'productId';
        form.appendChild(inputProductId);
    }
    inputProductId.value = productId;

    form.submit(); // Gửi form
}


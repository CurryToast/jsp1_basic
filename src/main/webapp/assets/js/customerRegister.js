// 작성자 : 임현범
const nameRegex = /^[a-zA-Z가-힣]*$/;
const idRegex =  /^([a-zA-Z0-9])*$/;

function fieldCheck(isValid, dom, msg) {
    if (!isValid) {
        dom.setAttribute('class', 'error');
        dom.setAttribute('data-msg', msg);
    } else {
        dom.removeAttribute('class');
        dom.removeAttribute('data-msg');
    }
}

document.forms[0].custom_id.addEventListener('change', (e) => {
    fieldCheck(
        idRegex.test(e.target.value),
        document.getElementById('custom_id-cap'),
        '영문과 숫자만 입력하세요.'
    );
});
document.forms[0].name.addEventListener('change', (e) => {
    fieldCheck(
        nameRegex.test(e.target.value),
        document.getElementById('name-cap'),
        '한글과 영문만 입력하세요.'
    );
});

document.getElementById('join').addEventListener('click', function() {
    let isValid = true;
    let inputs = document.querySelectorAll('form > input');
    inputs.forEach(el => {
        if (isValid && !el.value.length) {
            isValid = false;
            el.focus();
        }
    });

    inputs = document.querySelectorAll('form > p.error > input');
    if (isValid && inputs.length > 0) {
        isValid = false;
        inputs[0].focus();
    }

    if (isValid) {
        document.forms[0].submit();
    }
});
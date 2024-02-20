// 작성자 : 임현범
const nameRegex = /^[a-zA-Z가-힣]*$/;
const idRegex =  /^(?=.*[a-zA-Z])(?=.*[0-9]).{5,20}$/;
const pwRegex =  /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*?_]).{6,999}$/;
const birthRegex = /(19|20)\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])/;
const phoneRegex =  /^(\d{2,3})-(\d{3,4})-(\d{4})$/;

function fieldCheck(el, isValid, dom, msg) {
    if (!isValid) {
        dom.setAttribute('class', 'error');
        dom.setAttribute('data-msg', msg);
    } else {
        dom.removeAttribute('class');
        dom.removeAttribute('data-msg');
    }
}

document.forms[0].id.addEventListener('change', (e) => {
    fieldCheck(
        e.target,
        idRegex.test(e.target.value),
        document.getElementById('id-cap'),
        '영문과 숫자로 5~20자로 입력하세요.'
    );
});
document.forms[0].password.addEventListener('change', (e) => {
    fieldCheck(
        e.target,
        pwRegex.test(e.target.value),
        document.getElementById('password-cap'),
        '영문과 숫자, 특수문자(!@#$%^&*?_)로 6자 이상으로 입력하세요.'
    );
});
document.getElementById('password-check').addEventListener('change', (e) => {
    fieldCheck(
        e.target,
        e.target.value == document.forms[0].password.value,
        document.getElementById('password-check-cap'),
        '비밀번호와 일치하지 않습니다.'
    );
});
document.forms[0].name.addEventListener('change', (e) => {
    fieldCheck(
        e.target,
        nameRegex.test(e.target.value),
        document.getElementById('name-cap'),
        '영문과 숫자로 입력하세요.'
    );
});
document.forms[0].birth.addEventListener('change', (e) => {
    fieldCheck(
        e.target,
        birthRegex.test(e.target.value),
        document.getElementById('birth-cap'),
        '"yyyy-mm-dd" 패턴으로 입력하세요.'
    );
});
document.forms[0].phoneNumber.addEventListener('change', (e) => {
    fieldCheck(
        e.target,
        phoneRegex.test(e.target.value),
        document.getElementById('phone-cap'),
        '000-0000-0000 형식으로 입력하세요.'
    );
});

document.getElementById('join').addEventListener('click', function() {
    let isValid = true;
    let inputs = document.querySelectorAll('form input[required');
    inputs.forEach(el => {
        if (isValid && !el.value) {
            isValid = false;
            el.focus();
        }
    });

    inputs = document.querySelectorAll('form input.error');
    if (isValid && inputs.length > 0) {
        isValid = false;
        inputs[0].focus();
    }

    const gender = document.forms[0].gender;
    if (isValid && !gender.value) {
        isValid = false;
        gender[0].focus();
    }

    if (isValid) {
        document.forms[0].submit();
    }
});
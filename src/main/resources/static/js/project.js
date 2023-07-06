// agree

let agree1 = document.querySelector("#agree1");
let agree2 = document.querySelector("#agree2");
let okagree = document.querySelector("#okagree");
let disagree = document.querySelector("#disagree");


okagree?.addEventListener('click', () => {
    if(!agree1.checked) alert('이용약관에 동의하세요^^');
    else if(!agree2.checked) alert('개인정보수집 및 이용약관 동의 ㄴ?');
    else location.href="/join/checkme";
});
disagree?.addEventListener('click', () => {
    location.href="/join/agree";

});


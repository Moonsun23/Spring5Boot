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

// checkme

let frm=document.forms.agreefrm2;
let checkbtn2 = document.querySelector("#checkbtn2");
let cancelbtn2 = document.querySelector("#cancelbtn2");

checkbtn2?.addEventListener('click', () => {
    if(frm.name.value === "") alert('이름을 입력하세요');
    else if(frm.jumin1.value === "") alert('주민번호를 입력하세요');
    else if(frm.jumin2.value === "") alert('주민번호 뒷자리를 입력하세요');
    else if(!frm.infoagree.checked) alert('주민번호 처리에 동의하세요');
    else {
       frm.method= 'post';
       frm.submit();
    }
});
cancelbtn2?.addEventListener('click', () => {
    location.href="/";

});

// joinme
let fzipbtn= document.querySelector("#findzipbtn");
let zipbtn= document.querySelector("#zipbtn");
let dong = document.querySelector("#dong");
let zipmodal = document.querySelector("#zipmodal");

let addrlist = document.querySelector("#addrlist");
let sendzip = document.querySelector("#sendzip");
let modal = null;           // 우편번호 모달


let email3 = document.querySelector("#email3");

zipbtn?.addEventListener('click', () => {                   // showzipaddr 보다 먼저 실행되어야 해서 앞에 써줌// 우편번호찾기에서 '선택하고 닫기' 누르면 기존 선택한것이 지워지도록 해주는 코드
    while(addrlist.lastChild){
        addrlist.removeChild(addrlist.lastChild);           //removechild 를 써서 자식요소만 지우도록..
        // while 문으로.. 남아있는 주소리스트가 있으면 모두 지우도록 addrlist의 removeChild..

    }   // 이전 검색 결과 지움
    dong.value = '';    // 이전 검색 키워드도 지우고

    // 다시 새창을 띄울수있도록 아래코드

    //let mymodal = null;
    try {
        modal = new bootstrap.Modal(zipmodal, {});
       // modal = mymodal;
    } catch (e) { }

    modal.show();     // 모달창 띄우기


});

const showzipaddr = (jsons) => {
    jsons = JSON.parse(jsons);
    // 문자열을 객체로 변환해주는 JSON.parse
    let addr = '';
    jsons.forEach(function (data, idx){ // json 반복처리
        addr += `<option>${data['zipcode']} ${data['sido']} 
                        ${data['gugun']} ${data['dong']} ${data['ri']} ${data['bunji']}</option>`;                     // `(백틱): 문자열 템플릿 쓸때

    });
    addrlist.innerHTML = addr;
};
fzipbtn?.addEventListener('click', () => {
    if (dong.value === '') {
        alert('동이름을 입력하세요!!');
        return;
    }
    const url= '/join/zipcode?dong=' + dong.value;
    fetch(url).then(response => response.text())
        .then(text => showzipaddr(text));
});

sendzip?.addEventListener('click', () =>{
    let frm = document.forms.joinfrm;
    let addr= addrlist.value;               // 선택한 주소 항목
    if (addr !== '') {
            // 빈값이 아니라면 선택한 항목을 처리
        // 123-456 서울 관악구 신림동(각 값을 주소항목 칸별로 넣어줘야 함)
        let zip = addr.split(' ')[0];               // 우편번호 추출
        let addrs = addr.split(' ');
        let vaddr = `${addrs[1]} ${addrs[2]} ${addrs[3]}`; // 주소추출
            // 공백으로 나눠서 문자열을 나누고.. 나뉜건 배열에 담기고..
        frm.zip1.value = zip.split('-')[0];
        frm.zip2.value = zip.split('-')[1];
        frm.addr1.value = vaddr;


        modal.hide(); // modal창 닫기 코드





    } else {
        alert ('주소를 선택하세요!');
    }
});

email3?.addEventListener('click', () => {
    let frm = document.forms.joinfrm;
    if(email3.value === '직접입력하기'){
        frm.email2.readOnly = false;
        frm.email2.value = '';
    } else if (email3.value !== '계정 선택'){
        frm.email2.readOnly = true;
        frm.email2.value = email3.value;

    }
});
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

// 우편번호 검색 모달 창 띄우기
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


// 검색한 우편번호 출력하기
const showzipaddr = (jsons) => {
    jsons = JSON.parse(jsons);
    // 문자열을 객체로 변환해주는 JSON.parse
    let addr = '';
    jsons.forEach(function (data, idx){ // json 반복처리
        // 주소의 번지가 null인 경우 처리
        let bunji = (data['bunji'] !== null) ? data['bunji'] : '';
        // bunji가 비어있는 주소도 있어서 null이 아니라면 번지 값을 써주고 아니라면 공백으로...

        addr += `<option>${data['zipcode']} ${data['sido']} 
                        ${data['gugun']} ${data['dong']} ${data['ri']} ${[bunji]}</option>`;                     // `(백틱): 문자열 템플릿 쓸때

    });
    addrlist.innerHTML = addr;
};

//우편번호 검색
fzipbtn?.addEventListener('click', () => {
    if (dong.value === '') {
        alert('동이름을 입력하세요!!');
        return;
    }
    const url= '/join/zipcode?dong=' + dong.value;
    fetch(url).then(response => response.text())
        .then(text => showzipaddr(text));
});

// 주소 선택하고 닫기(sendzip)
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

// 전자우편 주소 선택(email3)
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


// 우편번호 검색 엔터키 입력 차단

dong?.addEventListener('keydown', (e) =>{
    if(e.keyCode === 13)            // 엔터키(13)가 입력되면
        e.preventDefault();             // 이벤트 전파 방지
});

// 비밀번호 확인

let pwd = document.querySelector("#pwd");
let repwd = document.querySelector("#repasswd");
let pwdmsg = document.querySelector("#pwdmsg");
repwd?.addEventListener('blur', ()=>{
    let pmsg  = '비밀번호가 서로 일치하지 않습니다!';
    pwdmsg.className = 'text-danger';

    if (pwd.value === repwd.value) {
        pmsg = '비밀번호가 서로 일치합니다!';
        pwdmsg.className = 'text-primary';
    }

    pwdmsg.innerText = pmsg;

});

// 아이디 중복 검사
let userid = document.querySelector("#uid");
let checkuid = document.querySelector("#checkuid");
let uidmsg = document.querySelector("#uidmsg");

const styleCheckuid = (chkuid) => {
    let umsg  = '사용 불가능한 아이디입니다';
    uidmsg.className = 'text-danger';
    checkuid.value = 'no';

    if (chkuid === '0') {
        umsg = '사용가능한 아이디입니다!';
        uidmsg.className = 'text-primary';
        checkuid.value = 'yes';
    }

    uidmsg.innerText = umsg;
};

// 아이디 중복 검사
userid?.addEventListener('blur', ()=> {
    if (userid.value === '') {
        uidmsg.innerText = '6~16자의 영문 소문자, 숫자와 특수기호(_)만 사용가능'
        uidmsg.className= 'text-warning';
        checkuid.value = 'no';
        return;
    }
    const url= '/join/checkuid/' +userid.value;
    fetch(url).then(response => response.text())
        .then(text => styleCheckuid(text));
});

// 회원정보 저장
let joinbtn = document.querySelector('#joinbtn');
joinbtn?.addEventListener('click', () => {
    let frm= document.forms.joinfrm;
    if(frm.userid.value === '') alert('아이디를 입력하세요!!!!!!');
    else if(frm.passwd.value === '') alert('비번을 입력하세요!!!');
    else if(frm.repasswd.value === '') alert('비번 확인을 입력하세요!!!');
    else if(frm.zip1.value === '' || frm.zip2.value === '') alert('우편번호를 입력하세요!!!');
    else if(frm.addr1.value === '' || frm.addr2.value === '') alert('우편번호를 입력하세요!!!');
    else if(frm.email1.value === '' || frm.email2.value === '') alert('이메일을 입력하세요!!!');
    else if(frm.phone2.value === '' || frm.phone3.value === '') alert('전화번호를 입력하세요!!!');
    else if(grecaptcha.getResponse() === '') alert('자동가입방지를 클릭하세욥!!');
    else if(checkuid.value === 'no') alert('아이디 중복검사를 하세요!');
    else {
        frm.jumin.value = frm.jumin1.value + '-' +frm.jumin2.value;
        frm.zipcode.value = frm.zip1.value + '-' +frm.zip2.value;
        frm.email.value = frm.email1.value + '@' +frm.email2.value;
        frm.phone.value = frm.phone1.value + '-' +frm.phone2.value+ '-' +frm.phone3.value+ '-' +frm.phone4.value;

        frm.method = 'post';
        frm.submit();

    }


});


// joinok
let go2idx = document.querySelector("#go2idx");
go2idx?.addEventListener('click', () => {
    location.href="/";
});


// login
let loginbtn = document.querySelector("#loginbtn");
let lguid = document.querySelector("#userid");
let lgpwd = document.querySelector("#passwd");
let lgfrm = document.querySelector("#lgnfrm")

loginbtn?.addEventListener('click', ()=>{
    if(lguid.value === '') alert('아이디를 입력하세요!!!!!!');
        else if(lgpwd.value === '') alert('비번을 입력하세요!!!');

        else {
            lgfrm.method = 'post';
            lgfrm.action='/join/login';
            lgfrm.submit();

    }

});

//logout

let lgoutbtn = document.querySelector("#lgoutbtn");

lgoutbtn?.addEventListener('click', () =>{
    location.href = '/join/logout';
});









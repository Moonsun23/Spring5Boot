// board view (각 버튼의 id 값을 가져옴)


// 새글쓰기
let newbdbtn = document.querySelector("#newbdbtn");
newbdbtn?.addEventListener('click', ()=>{
    location.href= '/board/write';
});

// 수정하기
let modbdbtn = document.querySelector("#modbdbtn");
modbdbtn?.addEventListener('click', ()=>{
    if(confirm("정말 수정하실?")) {
        alert('아직 미지원 기능입니다');
    }
});

// 삭제하기
let rmvbdbtn = document.querySelector("#rmvbdbtn");
rmvbdbtn?.addEventListener('click', ()=>{
    if(confirm("정말 삭제하실?")) {
        alert('아직 미지원 기능입니다');
    }
    // location.href= '/board/delete';
});

// 목록으로 돌아가기
let lstbdbtn = document.querySelector("#lstbdbtn");
lstbdbtn?.addEventListener('click', ()=>{
    location.href= '/board/list/1';
});

// board write

let wrtbdbtn = document.querySelector("#wrtbdbtn");
wrtbdbtn?.addEventListener('click', () => {
    let bfrm= document.forms.bdfrm;
    if(bfrm.title.value === '') alert('제목을 입력하세요!!!!!!');
    else if(bfrm.contents.value === '') alert('본문 내용을 입력하세요!!!');
    else if(grecaptcha.getResponse() === '') alert('자동가입방지를 체크하세욥!!');
    else {
        bfrm.method = 'post';
        //   bfrm.action='/board/list';
        bfrm.submit();

    }

});

// board find

// 검색하기 버튼
let findbtn = document.querySelector("#findbtn");
// 검색타입
let findtype = document.querySelector("#findtype");
// 검색창
let findkey = document.querySelector("#findkey");

findbtn?.addEventListener('click', ()=> {
    if(findkey.value === '') alert('검색어를 입력하세요');
    else {
        location.href = `/board/find/${findtype.value}/${findkey.value}/1`;
        // 검색창 내용: /board/find/1/title/비가와
    }
});




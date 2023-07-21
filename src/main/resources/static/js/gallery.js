// gallery view (각 버튼의 id 값을 가져옴)


// 새글쓰기
let newgalbtn = document.querySelector("#newgalbtn");
newgalbtn?.addEventListener('click', ()=>{
    location.href= '/gallery/write';
});

// 수정하기
let modgalbtn = document.querySelector("#modgalbtn");
modgalbtn?.addEventListener('click', ()=>{
    if(confirm("정말 수정하실?")) {
        alert('아직 미지원 기능입니다');
    }
});

// 삭제하기
let rmvgalbtn = document.querySelector("#rmvgalbtn");
rmvgalbtn?.addEventListener('click', ()=>{
    if(confirm("정말 삭제하실?")) {
        alert('아직 미지원 기능입니다');
    }
    // location.href= '/pds/delete';
});

// 목록으로 돌아가기
let lstgalbtn = document.querySelector("#lstgalbtn");
lstgalbtn?.addEventListener('click', ()=>{
    location.href= '/gallery/list/1';
});

// pds write

let wrtgalbtn = document.querySelector("#wrtgalbtn");
wrtgalbtn?.addEventListener('click', () => {
    let frm= document.forms.galfrm;
    if(frm.title.value === '') alert('제목을 입력하세요!!!!!!');
    else if(frm.contents.value === '') alert('본문 내용을 입력하세요!!!');
    else if(grecaptcha.getResponse() === '') alert('자동가입방지를 체크하세욥!!');
    else {
        frm.method = 'post';
        frm.enctype= 'multipart/form-data';
        // 파일을 첨부하려면 이 코드가 꼭 있어야 한다.
        frm.submit();

    }

});

// gallery find

// 검색하기 버튼
let findbtn = document.querySelector("#findbtn");
// 검색타입
let findtype = document.querySelector("#findtype");
// 검색창
let findkey = document.querySelector("#findkey");

findbtn?.addEventListener('click', ()=> {
    if(findkey.value === '') alert('검색어를 입력하세요');
    else {
        location.href = `/gallery/find/${findtype.value}/${findkey.value}/1`;
        // 검색창 내용: /pds/find/1/title/비가와
    }
});

//gallery comment
//
// let newcmtbtn = document.querySelector("#newcmtbtn");
// newcmtbtn?.addEventListener('click', () =>{
//     let frm=document.forms.cmtfrm;
//
//     if(frm.userid.value === '') alert('로그인 하세요!');
//     else if(frm.pno.value === '') alert('pno 확인하세여!');
//     else if(frm.comments.value === '') alert('댓글입력하세여!');
//     else{
//         frm.method = 'post';
//         frm.action = '/pds/cmt/write';
//         // PdsController의 post 에 설정한 링크를 가져온다.
//         frm.submit();
//
//     }
// });
//
// // pds reply
// let modal =null;
// const refno= document.querySelector("#ref");
// const showReply = (ref) => {
//     refno.value = ref;    // 대댓글을 작성할 댓글의 댓글번호 cno를 알아냄
//
//
//     modal = new bootstrap.Modal(replyModal, {});
//
//     modal.show();
// };
//
// const replybtn= document.querySelector("#replybtn");
// const frm = document.forms.replyfrm;
// replybtn?.addEventListener('click', ()=>{
//     if(frm.comments.value === '') alert('대댓글을 작성하세요.......');
//     else if(frm.ref.value === '') alert('댓글번호가 없는 비정상적인 요청입니다.....');
//     else if(frm.pno.value === '') alert('본문글이 없는 비정상적인 요청입니다.....');
//     else {
//         frm.method = 'post';
//         frm.action = '/pds/reply/write';
//         frm.submit();
//
//     }



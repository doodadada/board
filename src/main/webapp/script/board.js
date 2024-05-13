function idcheck(){
	//최초로 입력된 아이디가 없으면 "아이디를 먼저 입력하세요"라는 메세지와 함께 팝업창없이 되돌아갑니다
	if( document.join.userid.value==''){
		alert("아이디를 먼저 입력하세요");
		document.join.userid.focus();
		return;
	}
	var inputid = document.join.userid.value;
	var opt="toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=200";
	// inputid 에 저장된 아이디에 사용불가능/가능 을 조회해서 결과와 함께 페이지에 보여줄 예정
	window.open("board.do?command=idcheck&userid="+inputid , 'idcheck', opt);
}


function joinCheck(){
	if( document.join.userid.value==""){
		alert("아이디를 입력하세요");
		document.join.userid.focus();
		return false;
	}else if( document.join.pwd.value==""){
		alert("비밀번호를 입력하세요");
		document.join.pwd.focus();
		return false;
	}else if( document.join.pwd_check.value!=document.join.pwd.value){
		alert("입력한 비밀번호와 일치하지 않습니다");
		document.join.pwd_check.focus();
		return false;
	}else if( document.join.name.value==""){
		alert("이름을 입력하세요");
		document.join.name.focus();
		return false;
	}else if( document.join.email.value==""){
		alert("이메일을 입력하세요");
		document.join.email.focus();
		return false;
	}else if( document.join.phone.value==""){
		alert("전화번호를 입력하세요");
		document.join.phone.focus();
		return false;
	}else if( document.join.userid.value != document.join.reid.value){
		alert("아이디 중복체크를 진행하세요");
		document.join.pwd_check.focus();
		return false;
	}else{
		return true;
	}
}
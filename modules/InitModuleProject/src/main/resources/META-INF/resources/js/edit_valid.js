function inputChk(){


	 //제목 필수입력 
    var subject = $("#subject").val();
	if(subject.length == 0){
		alert("제목을 입력해주세요!");
		editForm.subject.focus();
		return;
	}


	 //제목 필수입력(정규식) 
	var subjectVaild = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|\s]+$/;
	if(subjectVaild.test(editForm.subject.value) == false){
		alert("제목 입력에는 (영문+한글+숫자)의 조합으로만 작성이 가능합니다. ");
		editForm.subject.focus();
		return false;
	}
	
	 //내용 필수입력 
	var contents = CKEDITOR.instances.editor4.getData()
	if(contents.length < 1){
		alert("내용을 입력해주세요!");
		
		return;
	}
	
	
	document.editForm.submit();

	
	
}
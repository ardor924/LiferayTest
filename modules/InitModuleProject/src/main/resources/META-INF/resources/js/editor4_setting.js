/*<![CDATA[*/
$(function() {

    CKEDITOR.replace('editor4',{
        filebrowserUploadUrl: '/common/ckeditor/fileUpload',
        font_names : "맑은 고딕/Malgun Gothic;굴림/Gulim;돋움/Dotum;바탕/Batang;궁서/Gungsuh;Arial/Arial;Comic Sans MS/Comic Sans MS;Courier New/Courier New;Georgia/Georgia;Lucida Sans Unicode/Lucida Sans Unicode;Tahoma/Tahoma;Times New Roman/Times New Roman;MS Mincho/MS Mincho;Trebuchet MS/Trebuchet MS;Verdana/Verdana",
        font_defaultLabel : "맑은 고딕/Malgun Gothic",
        fontSize_defaultLabel : "20",
        height: 400,
        width : 1280,
        language : "ko",
        uiColor: '#FFFFFF',
    });

    // ...
});

// ...

function saveGallery() {

    if (!confirm("저장하시겠습니까?")) {
        return;
    }

     var formData = new FormData($("form")[0]);

    formData.append("deleteFiles", deleteFileList);
    formData.set("contents", CKEDITOR.instances.contents.getData());

    for (var i = 0; i < inputFileList.length; i++) {
        if(!inputFileList[i].is_delete){
             formData.append("files", inputFileList[i]);
        }
    }

    for (var pair of formData.entries()) {
        console.log(pair[0]+ ', ' + pair[1]);
    }

    $.ajax({
        type : "POST",
        enctype : "multipart/form-data",
        url : "/gallery",
        data : formData,
        dataType:"json",
        processData : false,
        contentType : false,
        success : function(result) {
            if (result.response == "OK") {
                if ($("#id").val() == undefined) {
                    alert("저장되었습니다.");
                } else {
                    alert("수정되었습니다.");
                }

                location.href = "/gallery/" + result.galleryId;
            } else {
                alert(result.errorMsg);
            }
        },
    });
}
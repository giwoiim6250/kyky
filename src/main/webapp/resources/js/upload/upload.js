/**
 * Author:   张卫明
 * Date:  2016.08.09
 */
(function(){
    var imgSrc,
        imgNum = 5,
        imgnumed = $('#imgnumed');

    // 实例化
    uploader = WebUploader.create({
        pick: {
            id: '#filePicker',
            label: '+',
            multiple:false
        },
        formData: {
        },
        paste: '#uploader',
        auto: true,
        duplicate: true,
        chunked: false,
        compress: false,
        chunkSize: 512 * 1024,
        fileSingleSizeLimit: 5*1024*1024,
        server: '/upload/submit.htm',
        accept : {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,png',
            mimeTypes: 'image/*'
        }
    });

    //上传出错时
    uploader.onError = function( code ) {

        var errorText = '';
        switch(code)
        {
            case 'Q_TYPE_DENIED':
              errorText = '您上传的文件类型不匹配，请上传gif,jpg,jpeg,png的图片文件';
              break;
            case 'F_EXCEED_SIZE':
              errorText = '上传的单个文件大小不能大于5M';
              break;
            default :
              errorText = code;
              break;
        }

        ECar.dialogPrompt({text:errorText,clickClose:true});

    };

    //当文件上传出错时就停止上传
    uploader.onUploadError = function( file , reason) {
        errorState = true;
    };



    //把上传成功的图片路径填充到隐藏域中
    uploader.onUploadSuccess = function( file , response ) {


        //$('#uploader').prepend('<div class="comment-uploader"><img src="' + upload_imgurl + response['result']['imgUrl']+'"/><i class="remove-img" imgurl="'+response['result']['imgUrl']+'">&times;</i></div>');

        imgSrc= response._raw;
        $('#filePicker').hide();
        $('#js_imgurl').val(imgSrc);
        $('img','#fileShow').attr('src',imgSrc);
        $('#fileShow').show();

        /*imgArr.push(response['result']['imgUrl']);

        imgNum = imgNum -1;
        imgnumed.html(5-imgNum);

        if(imgNum<=0){
            $('#filePicker').hide();
        } else {
            $('#filePicker').show();
        }

        //删除图片
        $('.remove-img').off('click',removeImg);
        $('.remove-img').on('click',removeImg);
        */
    };

    /*function removeImg(){
        for(var i=0;i<imgArr.length;i++){
            if(imgArr[i] == $(this).attr('imgurl')){
                imgArr.splice(i, 1);
                $(this).parents('.comment-uploader').remove();
                imgNum = imgNum +1;
                imgnumed.html(5-imgNum);

                if(imgNum>0){
                    $('#filePicker').show();
                } else {
                    $('#filePicker').hide();
                }

            }
        }
    }*/

    //提交表单
    var    commentSubmit = $('#js_submit'),
            storyEle = $('#js_story');
/*
    starNode.on('click',function(){

        var starIndex = $(this).index(),
            i=0;

        if($(this).hasClass('star-solid')){
            starIndex = starIndex-1;
        }

        for(i;i<starNode.length;i++){
            if(i<=starIndex){
                starNode.eq(i).attr('class','star star-solid');
            } else {
                starNode.eq(i).attr('class','star star-hollow');
            }
        }

    });
*/
    commentSubmit.on('click',function(){

        var storyTxt = $.trim(storyEle.val()),
            imgUrl =$.trim(imgSrc);

        if(!imgUrl){
            ECar.dialogPrompt({text:'请上传图片',clickClose:true});
            return false;
        }

        if(!storyTxt){

            ECar.dialogPrompt({text:'请填写故事',clickClose:true});
            return false;
        }

        if(storyTxt.length < 10){

            ECar.dialogPrompt({text:'请输入10-150个字的故事',clickClose:true});
            return false;
        }

        $('#js_upload_form').submit();
    });
})();

var main ={
    init : function(){
        var _this = this;
        console.log(this);
        $('#btn-save').on('click', function () {
            _this.save();
        })
    },
    save : function(){
        var data ={
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val()
        };

        $.ajax({
            type : 'POST',
            url : '/api/v1/posts',
            dataType : 'json', // 받을 데이터
            contentType : 'application/json; charset=urf-8',
            data : JSON.stringify(data) // 보내는 데이터
        }).done(function(){
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
};

main.init();
function requestAnswer(answer) {
    $.ajax({
        type: 'get',
        url: 'http://localhost:8081/api/question/' + answer + '/',
        dataType: 'text',
        success: function(result) {
            console.log(result);
        }
    });
}
